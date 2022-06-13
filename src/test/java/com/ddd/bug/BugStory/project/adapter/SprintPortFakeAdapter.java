package com.ddd.bug.BugStory.project.adapter;

import com.ddd.bug.BugStory.project.application.port.out.SprintPort;
import com.ddd.bug.BugStory.project.domain.model.Sprint;
import com.ddd.bug.BugStory.project.domain.valueObject.SprintStatus;
import lombok.Getter;

import java.util.ArrayList;
import java.util.Date;

public class SprintPortFakeAdapter implements SprintPort {
    public final static int FIND_ACTIVE_SPRINT = 1;
    public final static int NOT_FIND_ACTIVE_SPRINT = 1;

    private Sprint sprint;

    public void setActiveSprint(int activeSprint) {
        this.activeSprint = activeSprint;
    }

    private int activeSprint;


    @Override
    public Sprint save(Sprint sprint) {
        this.sprint = Sprint.builder()
                .sprintStatus(sprint.getSprintStatus())
                .issues(sprint.getIssues())
                .start(sprint.getStart())
                .end(sprint.getEnd())
                .ProjectId(1)
                .Id(1)
                .description(sprint.getDescription())
                .build();
        return this.sprint;
    }

    @Override
    public void delete(int sprintId) {

    }

    @Override
    public Sprint findById(int sprintId) {

        if(sprint == null ) {
            sprint = Sprint.builder()
                    .sprintStatus(SprintStatus.NOT_STARTED)
                    .issues(new ArrayList<>())
                    .start(new Date())
                    .end(new Date())
                    .ProjectId(1)
                    .Id(sprintId)
                    .description("Demo")
                    .build();
        }

        return this.sprint;
    }

    @Override
    public Sprint findActiveSprint() {
        if(this.activeSprint == SprintPortFakeAdapter.FIND_ACTIVE_SPRINT)
            return Sprint.builder()
                    .sprintStatus(SprintStatus.STARTED)
                    .issues(null)
                    .start(new Date())
                    .end(new Date())
                    .ProjectId(1)
                    .Id(1)
                    .description("Demo")
                    .build();
        else
            return null;
    }
}
