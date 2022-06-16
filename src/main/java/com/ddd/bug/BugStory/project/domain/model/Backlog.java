package com.ddd.bug.BugStory.project.domain.model;


import lombok.*;

import java.util.List;


@Builder
public class Backlog {
    @Getter
    private int Id;

    @Getter
    private int projectId;

    @Getter
    private String description;

    @Getter
    private List<Comment> comments;

    @Getter
    private String assignedUser;


}
