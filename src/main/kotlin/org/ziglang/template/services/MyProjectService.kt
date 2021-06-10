package org.ziglang.template.services

import com.intellij.openapi.project.Project
import org.ziglang.template.MyBundle

class MyProjectService(project: Project) {

    init {
        println(MyBundle.message("projectService", project.name))
    }
}
