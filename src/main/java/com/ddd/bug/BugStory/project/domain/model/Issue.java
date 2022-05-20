package com.ddd.bug.BugStory.project.domain.model;

import com.ddd.bug.BugStory.project.domain.valueObject.IssuePriorities;
import com.ddd.bug.BugStory.project.domain.valueObject.IssueStatu;
import com.ddd.bug.BugStory.project.domain.valueObject.IssueType;
import lombok.*;

import java.util.List;

@NoArgsConstructor
@RequiredArgsConstructor
@EqualsAndHashCode
public class Issue {
    private int Id;

    @NonNull
    private String description;

    @NonNull
    private IssueType type;

    private IssuePriorities priority;

    @NonNull
    private IssueStatu issueStatu;

    @Getter
    private String assignedUser;

    @Getter
    private List<Comment> comments;
}
