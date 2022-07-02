package com.ddd.bug.BugStory.project.adapter.port.out.persistence;

import com.ddd.bug.BugStory.project.application.port.out.IssuePort;
import com.ddd.bug.BugStory.project.domain.model.Issue;
import org.springframework.stereotype.Component;

@Component
public class IssueDataAdapter implements IssuePort {
    @Override
    public Issue save(Issue issue) {
        return null;
    }

    @Override
    public Issue findById(int issueId) {
        return null;
    }
}

