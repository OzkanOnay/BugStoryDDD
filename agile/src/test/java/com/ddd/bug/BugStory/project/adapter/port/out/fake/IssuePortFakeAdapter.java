package com.ddd.bug.BugStory.project.adapter.port.out.fake;

import com.ddd.bug.BugStory.project.application.port.out.IssuePort;
import com.ddd.bug.BugStory.project.domain.model.Issue;

public class IssuePortFakeAdapter implements IssuePort {
    @Override
    public Issue save(Issue issue) {
        return null;
    }

    @Override
    public Issue findById(int issueId) {
        return null;
    }
}
