package com.ddd.bug.BugStory.project.domain.model;

import com.ddd.bug.BugStory.project.domain.valueObject.IssueStatu;
import com.ddd.bug.BugStory.project.domain.valueObject.IssueType;
import lombok.*;

import java.util.List;

@EqualsAndHashCode
@Builder
public class Issue {
    @Getter
    private Integer id;

    @Getter
    private String description;

    @Getter
    private IssueType issueType;

    @Getter
    private int orderNumber;

    @Getter
    private IssueStatu issueStatu;

    @Getter
    private String assignedUser;

    @Getter
    private List<Comment> comments;

    @Getter
    private int sprint_id;

    public void addComment(Comment comment) {
        //validation
        comments.add(comment);
    }

    public void uncommitFromSprint() {
        this.sprint_id = 0;
    }


    public void commitToSprint(int sprintId) {
        this.sprint_id = sprintId;
    }

    public void changeStatus(IssueStatu issueStatu) {
        this.issueStatu = issueStatu;
    }

    public void changeType(IssueType issueType) {
        this.issueType = issueType;
    }

}
