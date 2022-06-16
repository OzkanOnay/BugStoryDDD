package com.ddd.bug.BugStory.project.adapter;

import com.ddd.bug.BugStory.project.application.port.out.BacklogPort;
import com.ddd.bug.BugStory.project.domain.model.Backlog;

import java.util.ArrayList;
import java.util.List;

public class BacklogPortFakeAdapter implements BacklogPort {
    public final static int CORRECT_BACKLOG_ID = 1;
    private List<Backlog> backlogs;

    public BacklogPortFakeAdapter() {
        backlogs = new ArrayList<>();
        backlogs.add(
                Backlog.builder()
                        .Id(1)
                        .description("backlog_test")
                        .projectId(1)
                        .build()
        );
        backlogs.add(
                Backlog.builder()
                        .Id(2)
                        .description("backlog_test")
                        .projectId(2)
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
                .projectId(backlog.getProjectId())
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
