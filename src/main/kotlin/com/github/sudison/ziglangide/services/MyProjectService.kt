package com.github.sudison.ziglangide.services

import com.github.sudison.ziglangide.MyBundle
import com.intellij.openapi.project.Project

class MyProjectService(project: Project) {

    init {
        println(MyBundle.message("projectService", project.name))
    }
}
