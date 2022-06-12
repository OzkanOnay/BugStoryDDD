package com.ddd.bug.BugStory.project.application.port.out;

import com.ddd.bug.BugStory.project.domain.model.Project;

public interface ProjectPort {
    Project create(Project project);
}
