package com.ddd.bug.BugStory.project.application.service;

import com.ddd.bug.BugStory.project.application.port.in.NewProjectCommand;
import com.ddd.bug.BugStory.project.application.port.out.ProjectPort;
import com.ddd.bug.BugStory.project.domain.model.Project;

public class ProjectApplicationService {
    private ProjectPort projectPort;

    public ProjectApplicationService(ProjectPort projectPort) {
        this.projectPort = projectPort;
    }

    public Project createProject(NewProjectCommand newProjectCommand) {
        Project createdProject = projectPort.create(Project.builder()
                .projectName(newProjectCommand.getName())
                .projectOwner(newProjectCommand.getOwner())
                .description(newProjectCommand.getDescription())
                .build()
        );

        return createdProject;
    }
}
