package com.ddd.bug.BugStory.project.domain.model;

import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.util.List;

@NoArgsConstructor
@RequiredArgsConstructor
@EqualsAndHashCode
public class Project {
    private int Id;
    @NonNull
    private String projectName;
    @NonNull
    private String description;
    @NonNull
    private String projectOwner;
    private List<Backlog> backlogs;
    private List<Sprint> sprints;
}
