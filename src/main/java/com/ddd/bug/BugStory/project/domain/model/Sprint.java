package com.ddd.bug.BugStory.project.domain.model;

import com.ddd.bug.BugStory.project.domain.exception.IssueAlreadyExist;
import com.ddd.bug.BugStory.project.domain.valueObject.SprintStatus;
import lombok.*;

import java.util.Date;
import java.util.List;


@Builder
@EqualsAndHashCode
public class Sprint {

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

    public void addIssue(Issue issue) throws IssueAlreadyExist {
        if(issues.contains(issue)) {
            throw new IssueAlreadyExist();
        }

        issues.add(issue);
    }

    public void commitBacklogToSprint(Backlog backlog) {
        //todo have to convert backlog to issue
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

    private void setEnd(Date end) {
        this.end = end;
    }

    private void setStart(Date start) {
        this.start = start;
    }
}
