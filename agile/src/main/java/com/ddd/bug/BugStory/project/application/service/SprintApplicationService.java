package com.ddd.bug.BugStory.project.application.service;

import com.ddd.bug.BugStory.project.application.port.in.NewIssueCommand;
import com.ddd.bug.BugStory.project.application.port.in.SprintScheduleCommand;
import com.ddd.bug.BugStory.project.application.port.out.IssuePort;
import com.ddd.bug.BugStory.project.application.port.out.SprintPort;
import com.ddd.bug.BugStory.project.domain.exception.IssueAlreadyExist;
import com.ddd.bug.BugStory.project.domain.model.Backlog;
import com.ddd.bug.BugStory.project.domain.model.Issue;
import com.ddd.bug.BugStory.project.domain.model.Sprint;
import com.ddd.bug.BugStory.project.domain.valueObject.IssueStatu;
import com.ddd.bug.BugStory.project.domain.valueObject.SprintStatus;

public class SprintApplicationService  {

    private SprintPort sprintPort;
    private IssuePort issuePort;

    public SprintApplicationService(SprintPort sprintRepository, IssuePort issuePort) {
        this.sprintPort = sprintRepository;
        this.issuePort = issuePort;
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

    public void commitBacklogToSprint(int sprintId, int issueId) {
        Sprint sprint = sprintPort.findById(sprintId);
        Issue issue = issuePort.findById(issueId);

        if(issue == null) {
            throw new IllegalArgumentException("Wrong issue id");
        }

        issue.commitToSprint(sprintId);
        sprint.addIssue(issue);

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
