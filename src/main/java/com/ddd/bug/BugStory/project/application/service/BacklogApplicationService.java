package com.ddd.bug.BugStory.project.application.service;

import com.ddd.bug.BugStory.project.application.port.in.NewBacklogCommand;
import com.ddd.bug.BugStory.project.application.port.out.BacklogPort;
import com.ddd.bug.BugStory.project.domain.model.Backlog;

public class BacklogApplicationService {

    private BacklogPort backlogPort;

    public BacklogApplicationService(BacklogPort backlogPort) {
        this.backlogPort = backlogPort;
    }

    public Backlog createBacklog(NewBacklogCommand newBacklogCommand) {
        Backlog backlog = Backlog.builder().build();
        return backlogPort.create(backlog);
    }

    public void commitSprintIssueToBacklog(int sprintId, int backlogId) {

    }
}
