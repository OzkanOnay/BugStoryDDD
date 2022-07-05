package com.ddd.bug.BugStory.project.application.port.in;

import lombok.Data;


@Data
public class NewSprintCommand {
    private int projectId;
    private String description;
}
