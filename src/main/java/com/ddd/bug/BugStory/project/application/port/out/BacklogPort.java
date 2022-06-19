package com.ddd.bug.BugStory.project.application.port.out;

import com.ddd.bug.BugStory.project.domain.model.Backlog;

import java.util.List;

public interface BacklogPort {
    Backlog findById(int backlogId);
    Backlog create(Backlog backlog);
    List<Backlog> listAll(int projectId);
    void deleteBacklog(int backlogId);
}
