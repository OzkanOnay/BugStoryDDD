package com.ddd.bug.BugStory.project.domain.model;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class Comment {
    private int id;

    @Getter
    private int issueId;

    @Getter
    private String comment;

}
