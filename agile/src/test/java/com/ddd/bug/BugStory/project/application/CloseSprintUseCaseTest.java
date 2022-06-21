package com.ddd.bug.BugStory.project.application;

import com.ddd.bug.BugStory.project.adapter.port.out.BacklogPortFakeAdapter;
import com.ddd.bug.BugStory.project.adapter.port.out.ProjectFakeAdapter;
import com.ddd.bug.BugStory.project.adapter.port.out.SprintPortFakeAdapter;
import com.ddd.bug.BugStory.project.application.port.in.CloseSprintCommand;
import com.ddd.bug.BugStory.project.application.port.in.CloseSprintUseCase;
import com.ddd.bug.BugStory.project.application.port.out.BacklogPort;
import com.ddd.bug.BugStory.project.application.port.out.ProjectPort;
import com.ddd.bug.BugStory.project.application.port.out.SprintPort;
import com.ddd.bug.BugStory.project.domain.model.Project;
import com.ddd.bug.BugStory.project.domain.model.Sprint;
import com.ddd.bug.BugStory.project.domain.valueObject.SprintStatus;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CloseSprintUseCaseTest {
    private SprintPort sprintPort;
    private BacklogPort backlogPort;
    private ProjectPort projectPort;
    private CloseSprintUseCase closeSprintUseCase;

    public CloseSprintUseCaseTest() {
        this.sprintPort = new SprintPortFakeAdapter();
        this.backlogPort = new BacklogPortFakeAdapter();
        this.projectPort = new ProjectFakeAdapter();

        this.closeSprintUseCase = new CloseSprintUseCase(this.sprintPort, this.backlogPort, this.projectPort);
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


    @Test
    public void testClosingSprintAndMovingOpenIssuesToBacklog() {
        CloseSprintCommand closeSprintCommand = new CloseSprintCommand(1, 0);

        Sprint closedSprint = sprintPort.findById(1);

        Project project = projectPort.findById(closedSprint.getProjectId());

        long beforeNewIssues = project.getBacklogs().stream().count();

        this.closeSprintUseCase.closeSprint(closeSprintCommand);

        project = projectPort.findById(closedSprint.getProjectId());

        Assertions.assertEquals(SprintStatus.COMPLETED,closedSprint.getSprintStatus());
        Assertions.assertEquals(beforeNewIssues + 2, project.getBacklogs().stream().count());
    }
}
