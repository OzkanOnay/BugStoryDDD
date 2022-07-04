package com.ddd.bug.BugStory.project.adapter.port.out.real;

import com.ddd.bug.BugStory.BugStoryApplication;
import com.ddd.bug.BugStory.project.adapter.port.out.persistence.IssueDataAdapter;
import com.ddd.bug.BugStory.project.adapter.port.out.persistence.SprintDataAdapter;
import com.ddd.bug.BugStory.project.domain.model.Issue;
import com.ddd.bug.BugStory.project.domain.model.Sprint;
import com.ddd.bug.BugStory.project.domain.valueObject.IssueStatu;
import com.ddd.bug.BugStory.project.domain.valueObject.IssueType;
import com.ddd.bug.BugStory.project.domain.valueObject.SprintStatus;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.*;
import java.util.Date;

@SpringBootTest(classes = BugStoryApplication.class)
public class IssueDataAdapterTest {

    @Autowired
    IssueDataAdapter issueDataAdapter;

    @Autowired
    SprintDataAdapter sprintDataAdapter;


    @Test
    public void saveAndFindIssue() {
        Sprint sprint = sprintDataAdapter.save(
                Sprint
                        .builder()
                        .description("deneme")
                        .sprintStatus(SprintStatus.NOT_STARTED)
                        .ProjectId(1)
                        .start(new Date())
                        .end(new Date())
                        .build());

        Issue issue = Issue.builder()
                .issueStatu(IssueStatu.OPEN)
                .assignedUser("deneme")
                .description("deneme")
                .sprint_id(sprint.getId())
                .issueType(IssueType.TASK)
                .orderNumber(1)
                .build();

        issue = issueDataAdapter.save(issue);

        assertTrue(issue.getId() > 0);

        assertTrue(issueDataAdapter.findById(issue.getId()) != null);

    }
}
