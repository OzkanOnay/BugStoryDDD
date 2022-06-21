package com.ddd.bug.BugStory.project.domain.model;

import com.ddd.bug.BugStory.project.domain.valueObject.IssuePriorities;
import com.ddd.bug.BugStory.project.domain.valueObject.IssueStatu;
import com.ddd.bug.BugStory.project.domain.valueObject.IssueType;
import lombok.*;

import java.util.List;

@EqualsAndHashCode
@Builder
public class Issue {
    @Getter
    private int Id;

    @Getter
    private String description;

    @Getter
    private IssueType type;

    private IssuePriorities priority;

    @Getter
    private IssueStatu issueStatu;

    @Getter
    private String assignedUser;

    @Getter
    private List<Comment> comments;

    public void addComment(Comment comment) {
        //validation

        comments.add(comment);
    }

}
