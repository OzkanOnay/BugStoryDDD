package com.ddd.bug.BugStory.project.domain.model;

import com.ddd.bug.BugStory.project.domain.valueObject.IssueStatu;
import com.ddd.bug.BugStory.project.domain.valueObject.SprintStatus;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;



@Builder
@EqualsAndHashCode
@Data
public class Sprint {

    @Getter
    private Integer id;
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

    @JsonIgnore
    public void addIssue(Issue issue) {
        issues.add(issue);
    }

    @JsonIgnore
    public void addIssues(List<Issue> issues) {
        this.issues.addAll(issues);
    }


    @JsonIgnore
    public void changeStatus(SprintStatus statu) {
        sprintStatus = statu;
    }

    @JsonIgnore
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

    @JsonIgnore
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
