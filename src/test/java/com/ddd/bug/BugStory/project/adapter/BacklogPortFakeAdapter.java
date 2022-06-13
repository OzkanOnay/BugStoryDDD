package com.ddd.bug.BugStory.project.adapter;

import com.ddd.bug.BugStory.project.application.port.out.BacklogPort;
import com.ddd.bug.BugStory.project.domain.model.Backlog;

public class BacklogPortFakeAdapter implements BacklogPort {
    public final static int CORRECT_BACKLOG_ID = 1;

    @Override
    public Backlog findById(int backlogId) {
        if(backlogId == BacklogPortFakeAdapter.CORRECT_BACKLOG_ID) {
            return Backlog.builder()
                    .Id(1)
                    .description("backlog_test")
                    .projectId(1)
                    .build();
        } else {
            return null;
        }
    }

    @Override
    public Backlog create(Backlog backlog) {

        return Backlog.builder()
                .Id(1)
                .description(backlog.getDescription())
                .projectId(backlog.getProjectId())
                .build();
    }

    @Override
    public void deleteBacklog(int backlogId) {
    }
}
