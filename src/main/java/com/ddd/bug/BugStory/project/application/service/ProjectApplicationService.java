package com.ddd.bug.BugStory.project.application.service;

import com.ddd.bug.BugStory.project.application.port.out.ProjectPort;

public class ProjectApplicationService {
    private ProjectPort projectPort;

    public ProjectApplicationService(ProjectPort projectPort) {
        this.projectPort = projectPort;
    }
}
