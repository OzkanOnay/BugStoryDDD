package com.ddd.bug.BugStory.project.application.port.in;

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
}
