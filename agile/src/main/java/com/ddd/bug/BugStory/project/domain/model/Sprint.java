package com.ddd.bug.BugStory.project.domain.model;

import com.ddd.bug.BugStory.project.domain.valueObject.IssueStatu;
import com.ddd.bug.BugStory.project.domain.valueObject.SprintStatus;
import lombok.*;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;


@Builder
@EqualsAndHashCode
public class Sprint {

    @Getter
    private int Id;
    @Getter
    private int ProjectId;
    @Getter
    private String description;
    @Getter
    private SprintStatus sprintStatus;
    @Getter
    private List<Issue> issues;
    @Getter
    private Date start;
    @Getter
    private Date end;

    public void addIssue(Issue issue) {
        issues.add(issue);
    }

    public void addIssues(List<Issue> issues) {
        this.issues.addAll(issues);
    }


    public void changeStatus(SprintStatus statu) {
        sprintStatus = statu;
    }

    public void schedule(Date start, Date end) {
        if(start == null)
            throw new IllegalArgumentException("start date cannot be null");
        if(end == null)
            throw new IllegalArgumentException("end date cannot be null");
        if(start.after(end))
            throw new IllegalArgumentException("start date cannot be after from end date");

        this.setStart(start);
        this.setEnd(end);
    }

    public List<Issue> getOpenIssues() {
        return getIssues()
                .stream()
                .filter(issue -> !issue.getIssueStatu().equals(IssueStatu.COMPLETED))
                .collect(Collectors.toList());

    }

    private void setEnd(Date end) {
        this.end = end;
    }

    private void setStart(Date start) {
        this.start = start;
    }
}
