package com.ddd.bug.BugStory.project.domain.valueObject;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
@EqualsAndHashCode
public class IssueStatu {
    @Getter
    private String status;

    public final static IssueStatu OPEN = new IssueStatu("OPEN");
    public final static IssueStatu STARTED = new IssueStatu("STARTED");
    public final static IssueStatu COMPLETED = new IssueStatu("COMPLETED");

}
