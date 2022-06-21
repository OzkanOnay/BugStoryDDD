package com.ddd.bug.BugStory.project.application.port.in;

import com.ddd.bug.BugStory.project.application.port.out.BacklogPort;
import com.ddd.bug.BugStory.project.application.port.out.ProjectPort;
import com.ddd.bug.BugStory.project.application.port.out.SprintPort;
import com.ddd.bug.BugStory.project.domain.model.Issue;
import com.ddd.bug.BugStory.project.domain.model.Project;
import com.ddd.bug.BugStory.project.domain.model.Sprint;
import com.ddd.bug.BugStory.project.domain.valueObject.SprintStatus;

import java.util.List;

public class CloseSprintUseCase {
    private SprintPort sprintPort;
    private BacklogPort backlogPort;
    private ProjectPort projectPort;

    public CloseSprintUseCase(SprintPort sprintPort, BacklogPort backlogPort, ProjectPort projectPort) {
        this.sprintPort = sprintPort;
        this.backlogPort = backlogPort;
        this.projectPort = projectPort;
    }

    public void closeSprint(CloseSprintCommand closeSprintCommand) {
        Sprint currentSprint = sprintPort.findById(closeSprintCommand.getSprintId());

        if(currentSprint == null)
            throw new IllegalArgumentException("wrong sprint id");

        List<Issue> openIssues = currentSprint.getOpenIssues();

        if(closeSprintCommand.getSprintIdToAssignOpenIssues() != 0) {
            Sprint sprintToAssignIssues = sprintPort.findById(closeSprintCommand.getSprintIdToAssignOpenIssues());
            sprintToAssignIssues.addIssues(openIssues);
            sprintPort.save(sprintToAssignIssues);
        } else {
            Project project = projectPort.findById(currentSprint.getProjectId());
            project.commitIssues(openIssues);
            projectPort.save(project);
        }

        currentSprint.changeStatus(SprintStatus.COMPLETED);
        sprintPort.save(currentSprint);
    }
}
