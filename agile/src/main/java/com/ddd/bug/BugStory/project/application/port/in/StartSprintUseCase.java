package com.ddd.bug.BugStory.project.application.port.in;

import com.ddd.bug.BugStory.project.application.port.out.SprintPort;
import com.ddd.bug.BugStory.project.domain.exception.ActiveSprintException;
import com.ddd.bug.BugStory.project.domain.model.Sprint;
import com.ddd.bug.BugStory.project.domain.valueObject.SprintStatus;

public class StartSprintUseCase {
    private SprintPort sprintPort;

    public StartSprintUseCase(SprintPort sprintPort) {
        this.sprintPort = sprintPort;
    }

    public Sprint startSprint(int sprintId) throws ActiveSprintException {
        if(sprintId == 0)
            throw new IllegalArgumentException("Sprint ID is mandatory");

        if( sprintPort.findActiveSprint() != null)
            throw new ActiveSprintException("There is an active sprint");

        Sprint sprint = sprintPort.findById(sprintId);
        if(sprint == null)
            throw new IllegalArgumentException("Wrong sprint ID");

        sprint.changeStatus(SprintStatus.STARTED);
        sprintPort.save(sprint);

        return sprint;
    };
}
