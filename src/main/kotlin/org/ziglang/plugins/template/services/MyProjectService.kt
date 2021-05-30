package org.ziglang.plugins.template.services

import com.intellij.openapi.project.Project
import org.ziglang.plugins.template.MyBundle

class MyProjectService(project: Project) {

    init {
        println(MyBundle.message("projectService", project.name))
    }
}
