package com.ddd.bug.BugStory.project.domain.valueObject;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class SprintStatus {

    @Getter
    private String status;

    public static SprintStatus NOT_STARTED = new SprintStatus("NOT_STARTED");
    public static SprintStatus STARTED = new SprintStatus("STARTED");
    public static SprintStatus COMPLETED = new SprintStatus("COMPLETED");

}
