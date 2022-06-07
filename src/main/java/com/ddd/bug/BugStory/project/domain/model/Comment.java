package com.ddd.bug.BugStory.project.domain.model;

import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@NoArgsConstructor
@RequiredArgsConstructor
@EqualsAndHashCode
public class Comment {
    private int Id;

    @NonNull
    private int issueId;

    @NonNull
    private String comment;

}
