package com.ddd.bug.BugStory.project.adapter.port.out.persistence;

import com.ddd.bug.BugStory.project.application.port.out.SprintPort;
import com.ddd.bug.BugStory.project.domain.model.Sprint;
import org.springframework.stereotype.Component;

@Component
public class SprintDataAdapter implements SprintPort {
    @Override
    public Sprint save(Sprint sprint) {
        return null;
    }

    @Override
    public void delete(int sprintId) {

    }

    @Override
    public Sprint findById(int sprintId) {
        return null;
    }

    @Override
    public Sprint findActiveSprint() {
        return null;
    }
}
