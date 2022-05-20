package com.ddd.bug.BugStory.project.domain.model;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.util.List;

@NoArgsConstructor
@RequiredArgsConstructor
public class Backlog {
    private int Id;

    @NonNull
    private int ProjectId;

    @Getter
    private List<Issue> issues;
}
