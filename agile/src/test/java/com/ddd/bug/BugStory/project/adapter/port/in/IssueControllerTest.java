package com.ddd.bug.BugStory.project.adapter.port.in;

import com.ddd.bug.BugStory.BugStoryApplication;
import com.ddd.bug.BugStory.project.application.port.in.CloseSprintCommand;
import com.ddd.bug.BugStory.project.application.port.in.NewIssueCommand;
import com.ddd.bug.BugStory.project.domain.model.Issue;
import com.ddd.bug.BugStory.project.domain.valueObject.IssueStatu;
import com.ddd.bug.BugStory.project.domain.valueObject.IssueType;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(classes= BugStoryApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class IssueControllerTest {

    @Autowired
    TestRestTemplate restTemplate;

    @Test
    public void should_create_issue() {
        HttpEntity<NewIssueCommand> request = new HttpEntity<>(NewIssueCommand.builder()
                                                                    .issueType(IssueType.TASK)
                                                                    .description("deneme")
                                                                    .orderNumber(1)
                                                                    .issueStatu(IssueStatu.OPEN)
                                                                    .assignedUser("ozkan")
                                                                    .sprintId(10)
                                                                    .build());

        Issue issue = restTemplate.postForObject("/api/v1/issue",request, Issue.class);
        assertTrue(issue.getId() > 0);
    }

}
