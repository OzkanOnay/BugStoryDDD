package com.ddd.bug.BugStory.project.adapter.port.out.persistence;

import com.ddd.bug.BugStory.project.application.port.out.ProjectPort;
import com.ddd.bug.BugStory.project.domain.model.Project;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
public class ProjectDataAdapter implements ProjectPort {
    @Override
    public Project save(Project project) {
        return null;
    }

    @Override
    public Project findById(int projectId) {
        return null;
    }
}
