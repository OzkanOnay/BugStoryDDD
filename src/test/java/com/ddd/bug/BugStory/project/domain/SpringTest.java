package com.ddd.bug.BugStory.project.domain;

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
import java.util.List;

public class SpringTest {
    Sprint sprint;

    @BeforeEach
    public void buildSprint() {
        Calendar dateStart = Calendar.getInstance();
        Calendar dateEnd = Calendar.getInstance();

        dateStart.set(2022,0,1);
        dateEnd.set(2022,0,2);


        List<Issue> issues = new ArrayList<>();
        issues.add(Issue.builder().description("deneme 1").Id(1).issueStatu(IssueStatu.OPEN).build());
        issues.add(Issue.builder().description("deneme 2").Id(2).issueStatu(IssueStatu.STARTED).build());
        issues.add(Issue.builder().description("deneme 3").Id(3).issueStatu(IssueStatu.STARTED).build());
        issues.add(Issue.builder().description("deneme 4").Id(4).issueStatu(IssueStatu.OPEN).build());

        sprint = Sprint.builder()
                .sprintStatus(SprintStatus.NOT_STARTED)
                .ProjectId(1)
                .start(dateStart.getTime())
                .end(dateEnd.getTime())
                .issues(issues)
                .build();

    }

    @Test
    public void testAddIssue() {
        Issue newIssue = Issue.builder()
                                .description("Deneme")
                                .assignedUser("Deneme")
                                .Id(1000)
                                .build();

        sprint.addIssue(newIssue);
        assertTrue(sprint.getIssues().contains(newIssue));

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

    @Test
    public void testOpenIssues() {
        List<Issue> openIssues = sprint.getOpenIssues();
        assertEquals(openIssues.stream().count(), 2);
        assertTrue(openIssues.stream().anyMatch(issue -> issue.getId() == 1));
        assertTrue( openIssues.stream().anyMatch(issue -> issue.getId() == 4));
    }



}
