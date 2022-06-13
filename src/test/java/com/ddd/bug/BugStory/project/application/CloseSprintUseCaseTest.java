package com.ddd.bug.BugStory.project.application;

import com.ddd.bug.BugStory.project.adapter.SprintPortFakeAdapter;
import com.ddd.bug.BugStory.project.application.port.in.CloseSprintUseCase;
import com.ddd.bug.BugStory.project.application.port.out.SprintPort;
import org.junit.jupiter.api.Test;

public class CloseSprintUseCaseTest {
    private SprintPort sprintPort;
    private CloseSprintUseCase closeSprintUseCase;

    public CloseSprintUseCaseTest() {
        this.sprintPort = new SprintPortFakeAdapter();
        this.closeSprintUseCase = new CloseSprintUseCase(this.sprintPort);
    }

    @Test
    public void testClosingSprintAndMovingOpenIssues() {

    }
}
