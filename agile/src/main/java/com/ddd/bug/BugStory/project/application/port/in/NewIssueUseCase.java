package com.ddd.bug.BugStory.project.application.port.in;

import com.ddd.bug.BugStory.project.domain.model.Issue;

public interface NewIssueUseCase {
    public Issue newIssue(NewIssueCommand newIssueCommand);
}
