package com.ddd.bug.BugStory.project.application.port.in;


import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public class CloseSprintCommand {
    @Getter
    private int sprintId;
    @Getter
    private int sprintIdToAssignOpenIssues;
}
