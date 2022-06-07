package com.ddd.bug.BugStory.project.domain.model;

import lombok.*;

import java.util.List;

@EqualsAndHashCode
@Builder
public class Project {
    @Getter
    private int Id;

    @Getter
    private String projectName;

    @Getter
    private String description;

    @Getter
    private String projectOwner;

    @Getter
    private List<Backlog> backlogs;

    @Getter
    private List<Sprint> sprints;
}
