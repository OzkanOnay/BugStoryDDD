package com.ddd.bug.BugStory.project.adapter.port.out.persistence.jpa.entity;

import javax.persistence.*;

@Entity
public class IssueEntity {
    @Id
    @GeneratedValue
    private Integer id;

    private Integer sprint_id;
    private String description;
    private String issueStatu;
    private String assignedUser;
    private String issueType;
    private int orderNumber;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getSprint_id() {
        return sprint_id;
    }

    public void setSprint_id(Integer sprint_id) {
        this.sprint_id = sprint_id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getIssueStatu() {
        return issueStatu;
    }

    public void setIssueStatu(String issueStatu) {
        this.issueStatu = issueStatu;
    }

    public String getAssignedUser() {
        return assignedUser;
    }

    public void setAssignedUser(String assignedUser) {
        this.assignedUser = assignedUser;
    }

    public String getIssueType() {
        return issueType;
    }

    public void setIssueType(String issueType) {
        this.issueType = issueType;
    }

    public int getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(int orderNumber) {
        this.orderNumber = orderNumber;
    }
}
