package com.ddd.bug.BugStory.project.application.port.in;

import com.ddd.bug.BugStory.project.domain.valueObject.IssueStatu;
import com.ddd.bug.BugStory.project.domain.valueObject.IssueType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
public class NewIssueCommand {
    @Getter
    private int sprintId;
    @Getter
    private String description;
    @Getter
    private String assignedUser;
    @Getter
    private int orderNumber;
    @Getter
    private IssueType issueType;
    @Getter
    private IssueStatu issueStatu;
}
