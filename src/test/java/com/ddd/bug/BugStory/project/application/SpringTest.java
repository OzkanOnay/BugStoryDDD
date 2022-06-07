package com.ddd.bug.BugStory.project.application;

import com.ddd.bug.BugStory.project.domain.exception.IssueAlreadyExist;
import com.ddd.bug.BugStory.project.domain.model.Backlog;
import com.ddd.bug.BugStory.project.domain.model.Issue;
import com.ddd.bug.BugStory.project.domain.model.Sprint;
import com.ddd.bug.BugStory.project.domain.valueObject.IssueStatu;
import com.ddd.bug.BugStory.project.domain.valueObject.SprintStatus;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class SpringTest {
    Sprint sprint;

    @BeforeEach
    public void buildSprint() {
        Calendar dateStart = Calendar.getInstance();
        Calendar dateEnd = Calendar.getInstance();

        dateStart.set(2022,0,1);
        dateEnd.set(2022,0,2);

        sprint = Sprint.builder()
                .sprintStatus(SprintStatus.NOT_STARTED)
                .ProjectId(1)
                .start(dateStart.getTime())
                .end(dateEnd.getTime())
                .issues(new ArrayList<>())
                .build();

    }

    @Test
    public void testAddIssue() {
        Issue newIssue = Issue.builder()
                                .description("Deneme")
                                .assignedUser("Deneme")
                                .Id(1)
                                .build();
        try {
            sprint.addIssue(newIssue);
            assertTrue(sprint.getIssues().contains(newIssue));
        } catch (IssueAlreadyExist e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testSameIssue() {
        Issue newIssue = Issue.builder()
                .description("Deneme")
                .assignedUser("Deneme")
                .Id(1)
                .build();

        try {
            sprint.addIssue(newIssue);
        } catch (IssueAlreadyExist e) {
            e.printStackTrace();
        }

        Exception exception = assertThrows(IssueAlreadyExist.class,() -> {
                sprint.addIssue(newIssue);
            });
        assertEquals("Issue already exist", exception.getMessage());
    }


    @Test
    public void testCommitBacklogToSprint() {
        Backlog backlog = Backlog.builder()
                .Id(1)
                .description("Backlog issue")
                .projectId(1)
                .build();

        sprint.commitBacklogToSprint(backlog);

        assertTrue(sprint.getIssues().stream()
                .anyMatch(issue -> issue.getDescription().equals(backlog.getDescription()))
        );
    }


    @Test
    public void testSchedule() {
        Calendar dateStart = Calendar.getInstance();
        Calendar dateEnd = Calendar.getInstance();

        dateStart.set(2022,0,10);
        dateEnd.set(2022,0,15);

        sprint.schedule(dateStart.getTime(), dateEnd.getTime());

        assertEquals(dateStart.getTime(), sprint.getStart());
        assertEquals(dateEnd.getTime(), sprint.getEnd());
    }


    @Test
    public void testScheduleWrongDates() {
        Calendar dateStart = Calendar.getInstance();
        Calendar dateEnd = Calendar.getInstance();

        dateStart.set(2022,0,15);
        dateEnd.set(2022,0,10);

        Exception exception = assertThrows(IllegalArgumentException.class,() -> {
            sprint.schedule(dateStart.getTime(), dateEnd.getTime());
        });

        assertEquals("start date cannot be after from end date", exception.getMessage());
    }



}
