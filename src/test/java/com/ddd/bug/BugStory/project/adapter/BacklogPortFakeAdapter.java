package com.ddd.bug.BugStory.project.adapter;

import com.ddd.bug.BugStory.project.application.port.out.BacklogPort;
import com.ddd.bug.BugStory.project.domain.model.Backlog;

public class BacklogPortFakeAdapter implements BacklogPort {
    @Override
    public Backlog findById(int backlogId) {
        return null;
    }

    @Override
    public Backlog create(Backlog backlog) {
        return null;
    }

    @Override
    public void deleteBacklog(int backlogId) {

    }
}
