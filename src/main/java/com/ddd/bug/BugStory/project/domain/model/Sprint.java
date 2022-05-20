package com.ddd.bug.BugStory.project.domain.model;

import com.ddd.bug.BugStory.project.domain.valueObject.SprintStatu;
import lombok.*;

import java.util.List;


@NoArgsConstructor
@RequiredArgsConstructor
@EqualsAndHashCode
public class Sprint {
    private int Id;
    @NonNull
    private int ProjectId;
    @NonNull
    private String description;
    @NonNull
    private SprintStatu sprintStatu;
    @Getter
    private List<Issue> issues;
}
