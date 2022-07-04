package com.ddd.bug.BugStory.project.domain.valueObject;

public enum IssueStatu {
    OPEN("OPEN"),
    STARTED("STARTED"),
    COMPLETED("COMPLETED");

    private String statuCode;

    IssueStatu(String statuCode)  {
        this.statuCode = statuCode;
    }

    public String getCode() {
        return statuCode;
    }

}
