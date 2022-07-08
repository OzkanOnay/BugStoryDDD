package com.ddd.bug.BugStory.project.application;

import com.ddd.bug.BugStory.project.adapter.port.out.fake.IssuePortFakeAdapter;
import com.ddd.bug.BugStory.project.adapter.port.out.fake.SprintPortFakeAdapter;
import com.ddd.bug.BugStory.project.application.port.in.NewIssueCommand;
import com.ddd.bug.BugStory.project.application.port.in.SprintScheduleCommand;
import com.ddd.bug.BugStory.project.application.port.out.IssuePort;
import com.ddd.bug.BugStory.project.application.port.out.SprintPort;
import com.ddd.bug.BugStory.project.application.service.SprintApplicationService;
import com.ddd.bug.BugStory.project.domain.exception.IssueAlreadyExist;
import com.ddd.bug.BugStory.project.domain.model.Sprint;
import com.ddd.bug.BugStory.project.domain.valueObject.IssueStatu;
import com.ddd.bug.BugStory.project.domain.valueObject.IssueType;
import com.ddd.bug.BugStory.project.domain.valueObject.SprintStatus;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Calendar;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

public class SprintApplicationServiceTest {

    private SprintApplicationService sprintApplicationService;
    private SprintPort sprintPort;
    private IssuePort issuePort;

    @BeforeEach
    public void setup() {
        this.sprintPort = new SprintPortFakeAdapter();
        this.issuePort = new IssuePortFakeAdapter();

        sprintApplicationService = new SprintApplicationService(
                this.sprintPort,
                this.issuePort);
    }

    @Test
    public void saveSprintTest() {
        Sprint sprint = sprintApplicationService
                            .createSprint(1, "deneme");

        assertEquals(1, sprint.getId());
        assertEquals(SprintStatus.NOT_STARTED, sprint.getSprintStatus());
    }

    @Test
    public void commitWithWrongBacklogToSprintTest() {
        Exception exception = assertThrows(IllegalArgumentException.class,() -> {
            sprintApplicationService.commitBacklogToSprint(1,2);
        });

        assertEquals("Wrong backlog id",exception.getMessage());
    }


    @Test
    public void commitBacklogToSprintTest() {
        sprintApplicationService.commitBacklogToSprint(1,1);
        Sprint sprint = sprintPort.findById(1);
        assertTrue(sprint.getIssues().stream()
                .anyMatch(issue -> issue.getDescription().equals("backlog_test"))
        );
    }

    @Test
    public void addIssueToSprintTest() {

        NewIssueCommand newIssueCommand = NewIssueCommand
                .builder()
                .issueType(IssueType.TASK)
                .description("issue test")
                .sprintId(1)
                .assignedUser("özkan")
                .issueStatu(IssueStatu.OPEN)
                .orderNumber(1)
                .build();

        sprintApplicationService.addIssueToSprint(newIssueCommand);
        Sprint sprint = sprintPort.findById(1);
        assertTrue(sprint.getIssues().stream().anyMatch(issue -> issue.getDescription().equals("issue_test")));

    }


    @Test
    public void scheduleSprintTest() {
        Date start = Calendar.getInstance().getTime();

        Calendar endCalendar =  Calendar.getInstance();
        endCalendar.add(Calendar.DATE, 7);
        Date end = endCalendar.getTime();

        SprintScheduleCommand sprintScheduleCommand = new SprintScheduleCommand(start, end);
        sprintApplicationService.schedule(sprintScheduleCommand);

        Sprint sprint = sprintPort.findById(1);
        assertEquals(0, sprint.getStart().compareTo(start));
        assertEquals(0, sprint.getEnd().compareTo(end));

    }

}
