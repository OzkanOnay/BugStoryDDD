package com.ddd.bug.BugStory.project.application.port.out;

import com.ddd.bug.BugStory.project.application.port.in.NewIssueCommand;
import com.ddd.bug.BugStory.project.domain.model.Issue;

public interface IssuePort {
    Issue createIssue(NewIssueCommand newIssueCommand);
}
