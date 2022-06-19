package com.ddd.bug.BugStory.project.adapter.port.out;

import com.ddd.bug.BugStory.project.adapter.port.out.persistence.jpa.entity.ProjectEntity;
import com.ddd.bug.BugStory.project.application.port.out.BacklogPort;
import com.ddd.bug.BugStory.project.domain.model.Backlog;
import com.ddd.bug.BugStory.project.domain.model.Project;

import java.util.ArrayList;
import java.util.List;

public class BacklogPortFakeAdapter implements BacklogPort {
    public final static int CORRECT_BACKLOG_ID = 1;
    private List<Backlog> backlogs;

    public BacklogPortFakeAdapter() {
        backlogs = new ArrayList<>();
        Project project = Project.builder().Id(1).build();
        backlogs.add(
                Backlog.builder()
                        .Id(1)
                        .description("backlog_test")
                        .project(project)
                        .build()
        );
        backlogs.add(
                Backlog.builder()
                        .Id(2)
                        .description("backlog_test")
                        .project(project)
                        .build()
        );
    }

    @Override
    public Backlog findById(int backlogId) {
        return backlogs.stream()
                .filter(backlog -> backlog.getId() == backlogId)
                .findFirst()
                .orElse(null);

    }

    @Override
    public Backlog create(Backlog backlog) {
        Backlog createdBacklog = Backlog.builder()
                .Id(1)
                .description(backlog.getDescription())
                .project(backlog.getProject())
                .build();

        backlogs.add(createdBacklog);

        return createdBacklog;
    }

    @Override
    public List<Backlog> listAll(int projectId) {
        return this.backlogs;
    }

    @Override
    public void deleteBacklog(int backlogId) {
    }
}
