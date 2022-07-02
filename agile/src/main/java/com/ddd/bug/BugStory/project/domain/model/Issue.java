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
    private Integer Id;

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

    @Getter
    private int sprintId;

    public void addComment(Comment comment) {
        //validation

        comments.add(comment);
    }

    public void uncommitFromSprint() {
        this.sprintId = 0;
    }


    public void commitToSprint(int sprintId) {
        this.sprintId = sprintId;
    }

}
