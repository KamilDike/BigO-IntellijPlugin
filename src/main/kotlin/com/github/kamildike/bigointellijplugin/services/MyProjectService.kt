package com.github.kamildike.bigointellijplugin.services

import com.github.kamildike.bigointellijplugin.MyBundle
import com.intellij.openapi.project.Project

class MyProjectService(project: Project) {

    init {
        println(MyBundle.message("projectService", project.name))
    }
}
