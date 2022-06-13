package com.ddd.bug.BugStory.project.application;

import com.ddd.bug.BugStory.project.adapter.BacklogPortFakeAdapter;
import com.ddd.bug.BugStory.project.adapter.SprintPortFakeAdapter;
import com.ddd.bug.BugStory.project.application.port.in.NewIssueCommand;
import com.ddd.bug.BugStory.project.application.port.in.SprintScheduleCommand;
import com.ddd.bug.BugStory.project.application.port.out.BacklogPort;
import com.ddd.bug.BugStory.project.application.port.out.SprintPort;
import com.ddd.bug.BugStory.project.application.service.SprintApplicationService;
import com.ddd.bug.BugStory.project.domain.exception.IssueAlreadyExist;
import com.ddd.bug.BugStory.project.domain.model.Sprint;
import com.ddd.bug.BugStory.project.domain.valueObject.SprintStatus;
import org.junit.jupiter.api.Test;

import java.util.Calendar;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

public class SprintApplicationServiceTest {

    private SprintApplicationService sprintApplicationService;
    private SprintPort sprintPort;
    private BacklogPort backlogPort;

    public SprintApplicationServiceTest() {
        this.sprintPort = new SprintPortFakeAdapter();
        this.backlogPort = new BacklogPortFakeAdapter();

        sprintApplicationService = new SprintApplicationService(
                this.sprintPort,
                this.backlogPort);
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
        NewIssueCommand newIssueCommand = new NewIssueCommand(1, "issue_test");

        try {
            sprintApplicationService.addIssueToSprint(newIssueCommand);
            Sprint sprint = sprintPort.findById(1);
            assertTrue(sprint.getIssues().stream().anyMatch(issue -> issue.getDescription().equals("issue_test")));
        } catch (IssueAlreadyExist e) {
            e.printStackTrace();
        }
    }

    @Test
    public void startSprintTest() {
        sprintApplicationService.startSprint(1);
        Sprint sprint = sprintPort.findById(1);
        assertEquals(sprint.getSprintStatus(), SprintStatus.STARTED);
    }

    @Test
    public void closeSprintTest() {
        sprintApplicationService.closeSprint(1);
        Sprint sprint = sprintPort.findById(1);
        assertEquals(sprint.getSprintStatus(), SprintStatus.COMPLETED);
    }

    @Test
    public void scheduleSprintTest() {
        Date start = Calendar.getInstance().getTime();

        Calendar endCalendar =  Calendar.getInstance();
        endCalendar.add(Calendar.DATE, 7);
        Date end = endCalendar.getTime();

        SprintScheduleCommand sprintScheduleCommand = new SprintScheduleCommand(1, start, end);
        sprintApplicationService.schedule(sprintScheduleCommand);

        Sprint sprint = sprintPort.findById(1);
        assertEquals(0, sprint.getStart().compareTo(start));
        assertEquals(0, sprint.getEnd().compareTo(end));

    }

}
