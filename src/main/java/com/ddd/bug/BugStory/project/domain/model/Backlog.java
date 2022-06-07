package com.ddd.bug.BugStory.project.domain.model;


import lombok.*;


@Builder
public class Backlog {
    @Getter
    private int Id;

    @Getter
    private int projectId;

    @Getter
    private String description;
}
