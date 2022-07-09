package com.ddd.bug.BugStory.project.adapter.port.out.persistence.jpa.entity;

import lombok.Data;
import lombok.Getter;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
public class SprintEntity {
    @Id
    @GeneratedValue
    private Integer id;

    private String description;

    private String sprintStatus;

    private Date startDate;

    private Date endDate;

    private Integer project_id;

    @OneToMany( cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinColumn(name = "sprint_id")
    private List<IssueEntity> issues;

    public Integer getProject_id() {
        return project_id;
    }

    public void setProject_id(Integer project_id) {
        this.project_id = project_id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getSprintStatus() {
        return sprintStatus;
    }

    public void setSprintStatus(String sprintStatus) {
        this.sprintStatus = sprintStatus;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public List<IssueEntity> getIssues() {
        return issues;
    }

    public void setIssues(List<IssueEntity> issues) {
        this.issues = issues;
    }

}
