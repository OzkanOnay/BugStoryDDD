package com.ddd.bug.BugStory.project.domain.valueObject;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;

import java.util.Objects;
import java.util.Optional;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
@EqualsAndHashCode
public class SprintStatus {

    @Getter
    private String status;

    public static SprintStatus NOT_STARTED = new SprintStatus("NOT_STARTED");
    public static SprintStatus STARTED = new SprintStatus("STARTED");
    public static SprintStatus COMPLETED = new SprintStatus("COMPLETED");

    public static SprintStatus valueOf(String status) {
        if(status != "NOT_STARTED" && status != "STARTED" && status != "COMPLETED")
            throw new IllegalArgumentException("Wrong status code");
        return new SprintStatus(status);
    }

    @Override
    public String toString() {
        return status;
    }
}
