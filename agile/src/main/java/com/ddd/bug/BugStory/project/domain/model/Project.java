package com.ddd.bug.BugStory.project.domain.model;

import lombok.*;

import java.util.ArrayList;
import java.util.List;

@EqualsAndHashCode
@Builder
public class Project {
    @Getter
    @Setter
    private Integer id;

    @Getter
    private String projectName;

    @Getter
    private String description;

    @Getter
    private String projectOwner;
/*
    @Getter
    private List<Backlog> backlogs;

    public void addBacklog(Backlog backlog) {
        this.getBacklogs().add(backlog);
    }

    public Backlog commitIssue(Issue issue) {
        Backlog newBacklog = Backlog.builder()
                .description(issue.getDescription())
                .project(this)
                .comments(issue.getComments())
                .assignedUser(issue.getAssignedUser())
                .build();

        this.addBacklog(newBacklog);

        return newBacklog;
    }

    public List<Backlog> commitIssues(List<Issue> issues) {
        List<Backlog> backlogList = new ArrayList<>();
        issues.forEach(issue -> {
            issue.uncommitFromSprint();
        });

        this.getBacklogs().addAll(backlogList);

        return backlogList;
    }*/

}
