package com.ddd.bug.BugStory.project.application.port.in;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class NewProjectCommand {
    private String name;
    private String description;
    private String owner;
}
