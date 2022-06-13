package com.ddd.bug.BugStory.project.application.service;

import com.ddd.bug.BugStory.project.application.port.in.NewIssueCommand;
import com.ddd.bug.BugStory.project.application.port.in.SprintScheduleCommand;
import com.ddd.bug.BugStory.project.application.port.out.BacklogPort;
import com.ddd.bug.BugStory.project.application.port.out.SprintPort;
import com.ddd.bug.BugStory.project.domain.exception.IssueAlreadyExist;
import com.ddd.bug.BugStory.project.domain.model.Backlog;
import com.ddd.bug.BugStory.project.domain.model.Issue;
import com.ddd.bug.BugStory.project.domain.model.Sprint;
import com.ddd.bug.BugStory.project.domain.valueObject.IssueStatu;
import com.ddd.bug.BugStory.project.domain.valueObject.SprintStatus;

public class SprintApplicationService  {

    private SprintPort sprintPort;
    private BacklogPort backlogPort;

    public SprintApplicationService(SprintPort sprintRepository,
                                    BacklogPort backlogRepository) {
        this.sprintPort = sprintRepository;
        this.backlogPort = backlogRepository;
    }

    public Sprint createSprint(int projectId, String description) {
        Sprint sprint = Sprint
                            .builder()
                            .ProjectId(projectId)
                            .description(description)
                            .sprintStatus(SprintStatus.NOT_STARTED)
                            .build();
        sprint = sprintPort.save(sprint);

        //TODO raise event

        return sprint;
    }

    public void commitBacklogToSprint(int sprintId, int backlogId) {
        Sprint sprint = sprintPort.findById(sprintId);
        Backlog backlog = backlogPort.findById(backlogId);

        if(backlog == null) {
            throw new IllegalArgumentException("Wrong backlog id");
        }

        backlogPort.deleteBacklog(backlogId);

        sprint.addIssue(Issue
                .builder()
                .description(backlog.getDescription())
                .issueStatu(IssueStatu.OPEN)
                .build());

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


    public void schedule(SprintScheduleCommand scheduleCommand) {
        Sprint sprint = sprintPort.findById(scheduleCommand.getSprintId());
        sprint.schedule(scheduleCommand.getStart(), scheduleCommand.getEnd());
        //TODO raise event
        sprintPort.save(sprint);
    }

}
