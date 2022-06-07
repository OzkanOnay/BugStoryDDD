package com.ddd.bug.BugStory.project.application.service;

import com.ddd.bug.BugStory.project.application.port.in.NewIssueCommand;
import com.ddd.bug.BugStory.project.application.port.in.SprintScheduleCommand;
import com.ddd.bug.BugStory.project.application.port.out.BacklogPort;
import com.ddd.bug.BugStory.project.application.port.out.SprintPort;
import com.ddd.bug.BugStory.project.domain.exception.IssueAlreadyExist;
import com.ddd.bug.BugStory.project.domain.model.Backlog;
import com.ddd.bug.BugStory.project.domain.model.Issue;
import com.ddd.bug.BugStory.project.domain.model.Sprint;
import com.ddd.bug.BugStory.project.domain.valueObject.SprintStatus;

public class SprintApplicationService  {

    private SprintPort sprintPort;
    private BacklogPort backlogPort;

    public SprintApplicationService(SprintPort sprintRepository,
                                    BacklogPort backlogRepository) {
        this.sprintPort = sprintRepository;
        this.backlogPort = backlogRepository;
    }

    public Sprint createSprint(int projectId) {
        Sprint sprint = Sprint
                            .builder()
                            .ProjectId(projectId)
                            .sprintStatus(SprintStatus.NOT_STARTED)
                            .build();
        sprintPort.save(sprint);

        return sprint;
    }

    public void commitBacklogToSprint(int sprintId, int backlogId) {
        Sprint sprint = sprintPort.findById(sprintId);
        Backlog backlog = backlogPort.findById(backlogId);

        sprint.commitBacklogToSprint(backlog);

        sprintPort.save(sprint);
    }

    public void addIssueToSprint(NewIssueCommand newIssueCommand) throws IssueAlreadyExist {

        Sprint sprint = sprintPort.findById(newIssueCommand.getSprintId());

        //todo create issue
        Issue issue = Issue.builder()
                            .description(newIssueCommand.getDescription())
                            .build();

        sprint.addIssue(issue);

        sprintPort.save(sprint);
    }

    public void closeSprint(int sprintId) {
        Sprint sprint = sprintPort.findById(sprintId);
        sprint.changeStatus(SprintStatus.COMPLETED);
        sprintPort.save(sprint);
    }

    public void startSprint(int sprintId) {
        Sprint sprint = sprintPort.findById(sprintId);
        sprint.changeStatus(SprintStatus.STARTED);
        sprintPort.save(sprint);
    }

    public void schedule(SprintScheduleCommand scheduleCommand) {
        Sprint sprint = sprintPort.findById(scheduleCommand.getSprintId());
        sprint.schedule(scheduleCommand.getStart(), scheduleCommand.getEnd());
        sprintPort.save(sprint);
    }

}
