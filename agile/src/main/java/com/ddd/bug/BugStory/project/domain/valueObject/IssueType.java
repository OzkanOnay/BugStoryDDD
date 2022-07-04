package com.ddd.bug.BugStory.project.domain.valueObject;

public enum IssueType {
    TASK("TASK"),
    ERROR("ERROR");

    private String issueCode;

    IssueType(String issueCode) {
        this.issueCode = issueCode;
    }

    public String getCode() {
        return issueCode;
    }
}
