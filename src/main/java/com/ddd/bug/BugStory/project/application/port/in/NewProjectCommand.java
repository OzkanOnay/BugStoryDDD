package com.ddd.bug.BugStory.project.application.port.in;

import lombok.Data;
import lombok.Getter;

@Data
public class NewProjectCommand {
    private String name;
    private String description;
    private String owner;
}
