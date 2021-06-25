package org.zig.runner

import com.intellij.execution.ExecutionManager
import com.intellij.execution.configurations.RunProfile
import com.intellij.execution.configurations.RunProfileState
import com.intellij.execution.configurations.RunnerSettings
import com.intellij.execution.runners.ExecutionEnvironment
import com.intellij.execution.runners.ProgramRunner
import com.intellij.execution.runners.executeState
import com.intellij.execution.ui.RunContentDescriptor
import org.jetbrains.concurrency.resolvedPromise

open class ZigRunner : ProgramRunner<RunnerSettings>{

  override fun getRunnerId(): String {
    return RUNNER_ID
  }

  override fun canRun(executorId: String, profile: RunProfile): Boolean {
    return true
  }

  override fun execute(environment: ExecutionEnvironment) {
    val state = environment.state ?: return
    @Suppress("UnstableApiUsage")
    ExecutionManager.getInstance(environment.project).startRunProfile(environment) {
      resolvedPromise(doExecute(state, environment))
    }
  }

  protected open fun doExecute(state: RunProfileState, environment: ExecutionEnvironment): RunContentDescriptor? {
    return executeState(state, environment, this)
  }

  companion object {
    const val RUNNER_ID: String = "Zig"
  }
}