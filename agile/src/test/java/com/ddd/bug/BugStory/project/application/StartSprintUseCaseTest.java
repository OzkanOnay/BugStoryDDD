package com.ddd.bug.BugStory.project.application;

import com.ddd.bug.BugStory.project.adapter.port.out.fake.SprintPortFakeAdapter;
import com.ddd.bug.BugStory.project.application.port.in.StartSprintUseCase;
import com.ddd.bug.BugStory.project.domain.exception.ActiveSprintException;
import com.ddd.bug.BugStory.project.domain.model.Sprint;
import com.ddd.bug.BugStory.project.domain.valueObject.SprintStatus;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class StartSprintUseCaseTest {
    private SprintPortFakeAdapter sprintPort;
    private StartSprintUseCase startSprintUseCase;

    @BeforeEach
    public void setup() {
        this.sprintPort = new SprintPortFakeAdapter();
        this.startSprintUseCase = new StartSprintUseCase(this.sprintPort);
    }

    @Test
    public void testStartSprint() {
        try {
            startSprintUseCase.startSprint(1);
            Sprint sprint = sprintPort.findById(1);
            Assertions.assertEquals(SprintStatus.STARTED, sprint.getSprintStatus());
        } catch (ActiveSprintException e) {
            e.printStackTrace();
        }
    }


    @Test
    public void testStartSprintWhenThereIsActiveSprint() {
        sprintPort.setActiveSprint(SprintPortFakeAdapter.NOT_FIND_ACTIVE_SPRINT);
        ActiveSprintException exception = Assertions.assertThrows(ActiveSprintException.class, () -> {
            startSprintUseCase.startSprint(1);
        });

        Assertions.assertTrue(exception != null);
    }
}
