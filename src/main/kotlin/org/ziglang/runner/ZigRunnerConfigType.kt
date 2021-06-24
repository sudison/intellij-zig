package org.ziglang.runner

import com.intellij.execution.Executor
import com.intellij.execution.configurations.*
import com.intellij.execution.filters.Filter
import com.intellij.execution.filters.OpenFileHyperlinkInfo
import com.intellij.execution.process.AnsiEscapeDecoder
import com.intellij.execution.process.KillableProcessHandler
import com.intellij.execution.process.ProcessHandler
import com.intellij.execution.process.ProcessTerminatedListener
import com.intellij.execution.runners.ExecutionEnvironment
import com.intellij.openapi.fileTypes.PlainTextLanguage
import com.intellij.openapi.options.SettingsEditor
import com.intellij.openapi.project.DumbAware
import com.intellij.openapi.project.Project
import com.intellij.openapi.util.Key
import com.intellij.ui.LanguageTextField
import com.intellij.ui.TextAccessor
import com.intellij.ui.components.Label
import com.intellij.ui.layout.CCFlags
import com.intellij.ui.layout.panel
import org.ziglang.ZigIcons
import java.awt.BorderLayout
import javax.swing.JComponent
import javax.swing.JPanel
import kotlin.math.max

class ZigRunnerConfigType : ConfigurationTypeBase(
  "ZigRunnerConfiguration",
  "Zig",
  "Zig command run configuration",
  ZigIcons.icon
) {
  init {
    addFactory(ZigConfigurationFactory(this))
  }
}

class ZigProcessHandler(
  commandLine: GeneralCommandLine
) : KillableProcessHandler(commandLine), AnsiEscapeDecoder.ColoredTextAcceptor {
  override fun coloredTextAvailable(text: String, attributes: Key<*>) {
    super.notifyTextAvailable(text, attributes)
  }

}

open class ZigCompilerOutputFilter(
  private val environment: ExecutionEnvironment
) : Filter, DumbAware {
  private val lineRegx = "^(.*.zig):(\\d*):(\\d*):.*\n".toRegex()
  override fun applyFilter(line: String, entireLength: Int): Filter.Result? {
    val matchResult = lineRegx.matchEntire(line) ?: return null
    val filePath = matchResult.groups[1]!!.value
    val lineNumber = max(0, matchResult.groups[2]!!.value.toInt() - 1)
    val columnNumber = max(0, matchResult.groups[3]!!.value.toInt() - 1)

    val file = environment.project.baseDir?.findFileByRelativePath(filePath) ?: return null
    val link = OpenFileHyperlinkInfo(environment.project, file, lineNumber, columnNumber)
    val lineStart = entireLength - line.length

    val end = matchResult.groups[1]!!.range.last
    return Filter.Result(
      lineStart + matchResult.groups[1]!!.range.first,
      lineStart + end + 1,
      link,
      false
    )
  }

}

class ZigRunState(
  environment: ExecutionEnvironment,
  private val config: ZigCommandConfiguration
) : CommandLineState(environment) {

  init {
    addConsoleFilters(ZigCompilerOutputFilter(environment))
  }

  override fun startProcess(): ProcessHandler {
    val cmdLine =
      GeneralCommandLine(config.command, "build-exe", "hello.zig").withWorkDirectory(environment.project.basePath)

    val handler = ZigProcessHandler(cmdLine)
    ProcessTerminatedListener.attach(handler)
    return handler
  }

}

class ZigCommandLineEditor(
  private val project: Project
) : JPanel(BorderLayout()), TextAccessor {
  private val textField = createTextField("")

  init {
    add(textField, BorderLayout.CENTER)
  }

  override fun setText(text: String?) {
    textField.setText(text)
  }

  override fun getText(): String = textField.text

  private fun createTextField(value: String): LanguageTextField =
    LanguageTextField(
      PlainTextLanguage.INSTANCE,
      project,
      value
    )
}

class ZigRunnerConfigurationEditor(
  project: Project
) : SettingsEditor<ZigCommandConfiguration>() {

  private val command = ZigCommandLineEditor(project)
  override fun resetEditorFrom(s: ZigCommandConfiguration) {
    command.text = s.command
  }

  override fun applyEditorTo(s: ZigCommandConfiguration) {
    s.command = command.text
  }

  override fun createEditor(): JComponent = panel {
    val label = Label("&Command:")
    label.labelFor = command
    row(label) {
      command(CCFlags.pushX, CCFlags.growX)
    }
  }
}

class ZigCommandConfiguration(
  project: Project,
  name: String,
  factory: ConfigurationFactory
) : LocatableConfigurationBase<RunProfileState>(project, factory, name),
  RunConfigurationWithSuppressedDefaultDebugAction {
  var command: String = "/Volumes/external/dev/zig-macos-x86_64-0.8.0-dev.2676+c0aa9292b/zig"
  override fun getState(executor: Executor, environment: ExecutionEnvironment): RunProfileState? {
    return ZigRunState(environment, this)
  }

  override fun getConfigurationEditor(): SettingsEditor<out RunConfiguration> {
    return ZigRunnerConfigurationEditor(project)
  }

}

class ZigConfigurationFactory(type: ZigRunnerConfigType) : ConfigurationFactory(type) {

  override fun getId(): String = ID

  override fun createTemplateConfiguration(project: Project): RunConfiguration {
    return ZigCommandConfiguration(project, "Zig", this)
  }

  companion object {
    const val ID: String = "Zig Command"
  }
}