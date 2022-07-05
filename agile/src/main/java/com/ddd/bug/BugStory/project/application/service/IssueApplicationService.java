package com.ddd.bug.BugStory.project.application.service;

import com.ddd.bug.BugStory.project.application.port.in.NewIssueCommand;
import com.ddd.bug.BugStory.project.application.port.in.NewIssueUseCase;
import com.ddd.bug.BugStory.project.application.port.out.IssuePort;
import com.ddd.bug.BugStory.project.application.port.out.SprintPort;
import com.ddd.bug.BugStory.project.domain.model.Issue;
import com.ddd.bug.BugStory.project.domain.model.Sprint;
import com.ddd.bug.BugStory.project.domain.valueObject.IssueStatu;
import com.ddd.bug.BugStory.project.domain.valueObject.IssueType;

import java.util.Objects;
import java.util.Optional;


public class IssueApplicationService implements NewIssueUseCase {

    private SprintPort sprintPort;
    private IssuePort issuePort;

    public IssueApplicationService(SprintPort sprintRepository, IssuePort issuePort) {
        this.sprintPort = sprintRepository;
        this.issuePort = issuePort;
    }

    @Override
    public Issue newIssue(NewIssueCommand newIssueCommand) {
        Objects.requireNonNull(this.sprintPort.findById(newIssueCommand.getSprintId()),"Sprint bulunamadı");

        Issue issue = Issue.builder()
                .description(newIssueCommand.getDescription())
                .issueStatu(IssueStatu.OPEN)
                .orderNumber(newIssueCommand.getOrderNumber())
                .assignedUser(newIssueCommand.getAssignedUser())
                .sprint_id(newIssueCommand.getSprintId())
                .issueType(Objects.nonNull(newIssueCommand.getIssueType()) ? IssueType.TASK : newIssueCommand.getIssueType())
                .build();

        return this.issuePort.save(issue);
    }
}
