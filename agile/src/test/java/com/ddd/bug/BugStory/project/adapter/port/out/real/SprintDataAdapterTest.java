package com.ddd.bug.BugStory.project.adapter.port.out.real;

import com.ddd.bug.BugStory.BugStoryApplication;
import com.ddd.bug.BugStory.project.adapter.port.out.persistence.SprintDataAdapter;
import com.ddd.bug.BugStory.project.domain.model.Sprint;
import com.ddd.bug.BugStory.project.domain.valueObject.SprintStatus;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(classes= BugStoryApplication.class)
public class SprintDataAdapterTest {

    @Autowired
    SprintDataAdapter sprintDataAdapter;

    @Test
    @Transactional
    public void testSave_Find_Delete() {

        Sprint sprint = sprintDataAdapter.save(
                    Sprint
                        .builder()
                        .description("deneme")
                        .sprintStatus(SprintStatus.NOT_STARTED)
                        .ProjectId(1)
                        .start(new Date())
                        .end(new Date())
                        .build());

        assertTrue(sprint.getId() > 0);

        Sprint foundSprint = sprintDataAdapter.findById(sprint.getId());

        assertTrue(foundSprint != null);
        assertTrue(foundSprint.getSprintStatus().equals(SprintStatus.NOT_STARTED));

        sprintDataAdapter.delete(1);
        assertTrue(sprintDataAdapter.findById(1) == null);

    }

    @Test
    @Transactional
    public void testActiveSprint() {
        Sprint sprint = sprintDataAdapter.save(
                Sprint
                        .builder()
                        .description("deneme")
                        .sprintStatus(SprintStatus.STARTED)
                        .ProjectId(1)
                        .start(new Date())
                        .end(new Date())
                        .build());

        assertEquals(sprintDataAdapter.findActiveSprint().getId(),sprint.getId());
    }


}
