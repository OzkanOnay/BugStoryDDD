package com.ddd.bug.BugStory.project.adapter.port.out;

import com.ddd.bug.BugStory.project.application.port.out.SprintPort;
import com.ddd.bug.BugStory.project.domain.model.Issue;
import com.ddd.bug.BugStory.project.domain.model.Sprint;
import com.ddd.bug.BugStory.project.domain.valueObject.IssueStatu;
import com.ddd.bug.BugStory.project.domain.valueObject.SprintStatus;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SprintPortFakeAdapter implements SprintPort {
    public final static int FIND_ACTIVE_SPRINT = 1;
    public final static int NOT_FIND_ACTIVE_SPRINT = 1;

    private Sprint sprint;
    private List<Sprint> sprints;
    public void setActiveSprint(int activeSprint) {
        this.activeSprint = activeSprint;
    }

    private int activeSprint;

    public SprintPortFakeAdapter() {
        sprints = new ArrayList<>();
        List<Issue> issues = new ArrayList<>();
        issues.add(Issue.builder().description("issue 1").issueStatu(IssueStatu.OPEN).Id(1).build());
        issues.add(Issue.builder().description("issue 2").issueStatu(IssueStatu.STARTED).Id(2).build());
        issues.add(Issue.builder().description("issue 3").issueStatu(IssueStatu.COMPLETED).Id(3).build());

        sprints.add(Sprint.builder()
                .sprintStatus(SprintStatus.STARTED)
                .issues(issues)
                .start(new Date())
                .end(new Date())
                .ProjectId(1)
                .Id(1)
                .ProjectId(1)
                .description("Demo")
                .build());

        sprints.add(Sprint.builder()
                .sprintStatus(SprintStatus.NOT_STARTED)
                .issues(new ArrayList<>())
                .start(new Date())
                .end(new Date())
                .ProjectId(1)
                .Id(2)
                .ProjectId(1)
                .description("Demo")
                .build());
    }

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
        sprint = sprints.stream().filter(o -> o.getId() == sprintId)
                .findFirst()
                .orElse(Sprint.builder()
                .sprintStatus(SprintStatus.NOT_STARTED)
                .issues(new ArrayList<>())
                .start(new Date())
                .end(new Date())
                .ProjectId(1)
                .Id(sprintId)
                .description("Demo")
                .build());

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
