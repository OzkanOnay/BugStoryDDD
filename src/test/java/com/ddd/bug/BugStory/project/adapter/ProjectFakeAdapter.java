package com.ddd.bug.BugStory.project.adapter;

import com.ddd.bug.BugStory.project.application.port.out.ProjectPort;
import com.ddd.bug.BugStory.project.domain.model.Project;

public class ProjectFakeAdapter implements ProjectPort {

    @Override
    public Project create(Project project) {
        return null;
    }
}
