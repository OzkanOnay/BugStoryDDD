package com.ddd.bug.BugStory.project.domain.valueObject;

import lombok.*;

import java.util.Objects;
import java.util.Optional;

@Data
@EqualsAndHashCode
@NoArgsConstructor
public class SprintStatus {

    @Getter
    @Setter
    private String status;

    public SprintStatus(String status) {
        this.status = status;
    }

    public static SprintStatus NOT_STARTED = new SprintStatus("NOT_STARTED");
    public static SprintStatus STARTED = new SprintStatus("STARTED");
    public static SprintStatus COMPLETED = new SprintStatus("COMPLETED");

    public static SprintStatus valueOf(String status) {
        if(!status.equals( "NOT_STARTED") && !status.equals( "STARTED") && !status.equals( "COMPLETED"))
            throw new IllegalArgumentException("Wrong status code");
        return new SprintStatus(status);
    }

    @Override
    public String toString() {
        return status;
    }
}
