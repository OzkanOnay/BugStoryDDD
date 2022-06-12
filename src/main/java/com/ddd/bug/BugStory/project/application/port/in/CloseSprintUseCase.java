package com.ddd.bug.BugStory.project.application.port.in;

import com.ddd.bug.BugStory.project.application.port.out.SprintPort;
import com.ddd.bug.BugStory.project.domain.model.Issue;
import com.ddd.bug.BugStory.project.domain.model.Sprint;
import com.ddd.bug.BugStory.project.domain.valueObject.SprintStatus;

import java.util.List;

public class CloseSprintUseCase {
    private SprintPort sprintPort;

    public void closeSprint(CloseSprintCommand closeSprintCommand) {
        Sprint currentSprint = sprintPort.findById(closeSprintCommand.getSprintId());

        if(currentSprint == null)
            throw new IllegalArgumentException("wrong sprint id");

        if(closeSprintCommand.getSprintIdToAssignOpenIssues() != 0) {

            List<Issue> openIssues = currentSprint.getOpenIssues();

            if(!openIssues.isEmpty()) {
                Sprint sprintToAssignIssues = sprintPort.findById(closeSprintCommand.getSprintIdToAssignOpenIssues());
                sprintToAssignIssues.addIssues(openIssues);
                sprintPort.save(sprintToAssignIssues);
            }

        }

        currentSprint.changeStatus(SprintStatus.COMPLETED);
        sprintPort.save(currentSprint);
    }
}
