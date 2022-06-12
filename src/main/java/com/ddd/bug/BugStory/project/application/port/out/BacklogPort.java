package com.ddd.bug.BugStory.project.application.port.out;

import com.ddd.bug.BugStory.project.application.port.in.NewBacklogCommand;
import com.ddd.bug.BugStory.project.domain.model.Backlog;

public interface BacklogPort {
    Backlog findById(int backlogId);
    Backlog create(Backlog backlog);
    void deleteBacklog(int backlogId);
}
