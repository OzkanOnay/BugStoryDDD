package com.ddd.bug.BugStory.project.application.port.out;

import com.ddd.bug.BugStory.project.domain.model.Sprint;

//delete
public interface SprintPort {
    void save(Sprint sprint);
    void delete(int sprintId);
    Sprint findById(int sprintId);
    Sprint findActiveSprint();
}
