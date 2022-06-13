package com.ddd.bug.BugStory.project.application;

import com.ddd.bug.BugStory.project.adapter.SprintPortFakeAdapter;
import com.ddd.bug.BugStory.project.application.port.in.CloseSprintCommand;
import com.ddd.bug.BugStory.project.application.port.in.CloseSprintUseCase;
import com.ddd.bug.BugStory.project.application.port.out.SprintPort;
import com.ddd.bug.BugStory.project.domain.model.Sprint;
import com.ddd.bug.BugStory.project.domain.valueObject.SprintStatus;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CloseSprintUseCaseTest {
    private SprintPort sprintPort;
    private CloseSprintUseCase closeSprintUseCase;

    public CloseSprintUseCaseTest() {
        this.sprintPort = new SprintPortFakeAdapter();
        this.closeSprintUseCase = new CloseSprintUseCase(this.sprintPort);
    }

    @Test
    public void testClosingSprintAndMovingOpenIssues() {
        CloseSprintCommand closeSprintCommand = new CloseSprintCommand(1, 2);
        this.closeSprintUseCase.closeSprint(closeSprintCommand);
        Sprint closedSprint = sprintPort.findById(1);
        Sprint sprintThatIssuesAssigned = sprintPort.findById(2);


        Assertions.assertEquals(SprintStatus.COMPLETED,closedSprint.getSprintStatus());
        Assertions.assertEquals(2, sprintThatIssuesAssigned.getIssues().stream().count());
    }
}
