package com.ddd.bug.BugStory.project.application;

import com.ddd.bug.BugStory.project.adapter.BacklogPortFakeAdapter;
import com.ddd.bug.BugStory.project.adapter.SprintPortFakeAdapter;
import com.ddd.bug.BugStory.project.application.port.out.BacklogPort;
import com.ddd.bug.BugStory.project.application.port.out.SprintPort;
import com.ddd.bug.BugStory.project.application.service.SprintApplicationService;
import org.junit.jupiter.api.Test;

public class SprintApplicationServiceTest {

    private SprintApplicationService sprintApplicationService;

    public SprintApplicationServiceTest() {
        sprintApplicationService = new SprintApplicationService(
                new SprintPortFakeAdapter(),
                new BacklogPortFakeAdapter());
    }

    @Test
    public void saveSprintTest() {

    }

    @Test
    public void commitBacklogToSprintTest() {

    }

    @Test
    public void addIssueToSprintTest() {

    }

    @Test
    public void startSprintTest() {

    }

    @Test
    public void closeSprintTest() {

    }

    @Test
    public void scheduleSprintTest() {

    }
}
