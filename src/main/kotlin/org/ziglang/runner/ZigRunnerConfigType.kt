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
import com.intellij.openapi.Disposable
import com.intellij.openapi.fileChooser.FileChooserDescriptor
import com.intellij.openapi.fileChooser.FileChooserDescriptorFactory
import com.intellij.openapi.options.SettingsEditor
import com.intellij.openapi.project.DumbAware
import com.intellij.openapi.project.Project
import com.intellij.openapi.ui.TextComponentAccessor
import com.intellij.openapi.ui.TextFieldWithBrowseButton
import com.intellij.openapi.util.Key
import com.intellij.ui.DocumentAdapter
import com.intellij.ui.EditorTextField
import com.intellij.ui.components.Label
import com.intellij.ui.layout.CCFlags
import com.intellij.ui.layout.panel
import org.ziglang.ZigIcons
import javax.swing.JComponent
import javax.swing.event.DocumentEvent
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

fun pathTextField(
  fileChooserDescriptor: FileChooserDescriptor,
  disposable: Disposable,
  title: String,
  onTextChanged: () -> Unit = {}
): TextFieldWithBrowseButton {

  val component = TextFieldWithBrowseButton(null, disposable)
  component.addBrowseFolderListener(
    title, null, null,
    fileChooserDescriptor,
    TextComponentAccessor.TEXT_FIELD_WHOLE_TEXT
  )
  component.childComponent.document.addDocumentListener(object : DocumentAdapter() {
    override fun textChanged(e: DocumentEvent) {
      onTextChanged()
    }
  })

  return component
}

class ZigRunnerConfigurationEditor(
) : SettingsEditor<ZigCommandConfiguration>() {

  private val command: TextFieldWithBrowseButton =
    pathTextField(FileChooserDescriptorFactory.createSingleFileDescriptor(), this, "Path of zig compiler")
      .apply { isEnabled = true }

  private val args = EditorTextField("")
  override fun resetEditorFrom(s: ZigCommandConfiguration) {
    command.text = s.command
    args.text = s.args
  }

  override fun applyEditorTo(s: ZigCommandConfiguration) {
    s.command = command.text
    s.args = args.text
  }

  override fun createEditor(): JComponent = panel {
    val label = Label("&Zig:")
    label.labelFor = command
    row(label) {
      command(CCFlags.pushX, CCFlags.growX)
    }

    val label2 = Label("&Args:")
    label.labelFor = args
    row(label2) {
      args(CCFlags.pushX, CCFlags.growX)
    }
  }
}

class ZigCommandConfiguration(
  project: Project,
  name: String,
  factory: ConfigurationFactory
) : LocatableConfigurationBase<RunProfileState>(project, factory, name),
  RunConfigurationWithSuppressedDefaultDebugAction {
  var command: String = ""
  var args: String = ""
  override fun getState(executor: Executor, environment: ExecutionEnvironment): RunProfileState? {
    return ZigRunState(environment, this)
  }

  override fun getConfigurationEditor(): SettingsEditor<out RunConfiguration> {
    return ZigRunnerConfigurationEditor()
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