package org.ziglang.runner

import com.intellij.execution.Executor
import com.intellij.execution.configurations.*
import com.intellij.execution.process.AnsiEscapeDecoder
import com.intellij.execution.process.KillableProcessHandler
import com.intellij.execution.process.ProcessHandler
import com.intellij.execution.process.ProcessTerminatedListener
import com.intellij.execution.runners.ExecutionEnvironment
import com.intellij.openapi.fileTypes.PlainTextLanguage
import com.intellij.openapi.options.SettingsEditor
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

class ZigRunState(
  environment: ExecutionEnvironment,
  private val config: ZigCommandConfiguration
) : CommandLineState(environment) {
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