package com.ddd.bug.BugStory.project.adapter.port.out.persistence;

import com.ddd.bug.BugStory.project.application.port.out.BacklogPort;
import com.ddd.bug.BugStory.project.domain.model.Backlog;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Component
public class BacklogDataAdapter implements BacklogPort {
    @Override
    public Backlog findById(int backlogId) {
        return null;
    }

    @Override
    public Backlog create(Backlog backlog) {
        return null;
    }

    @Override
    public List<Backlog> listAll(int projectId) {
        return null;
    }

    @Override
    public void deleteBacklog(int backlogId) {

    }
}
