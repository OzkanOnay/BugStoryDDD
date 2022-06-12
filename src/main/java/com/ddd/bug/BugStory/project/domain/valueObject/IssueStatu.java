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

    public static IssueStatu OPEN = new IssueStatu("OPEN");
    public static IssueStatu STARTED = new IssueStatu("STARTED");
    public static IssueStatu COMPLETED = new IssueStatu("COMPLETED");

}
