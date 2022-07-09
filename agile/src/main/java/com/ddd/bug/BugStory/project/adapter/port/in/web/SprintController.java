package com.ddd.bug.BugStory.project.adapter.port.in.web;

import com.ddd.bug.BugStory.project.application.port.in.*;
import com.ddd.bug.BugStory.project.application.service.SprintApplicationService;
import com.ddd.bug.BugStory.project.domain.exception.ActiveSprintException;
import com.ddd.bug.BugStory.project.domain.model.Sprint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/sprint")
public class SprintController {

    @Autowired
    SprintApplicationService sprintApplicationService;

    @Autowired
    StartSprintUseCase startSprintUseCase;

    @Autowired
    CloseSprintUseCase closeSprintUseCase;

    @PostMapping
    public Sprint createSprint(@RequestBody NewSprintCommand sprintCommand) {
        return sprintApplicationService.createSprint(sprintCommand.getProjectId(), sprintCommand.getDescription());
    }

    @PostMapping("/reschedule")
    public Sprint reSchedule(@RequestBody SprintScheduleCommand scheduleCommand) {
        return sprintApplicationService.schedule(scheduleCommand);
    }

    @PostMapping("/start/{id}")
    public Sprint startSprint(@PathVariable("id") int sprintId) throws ActiveSprintException {
        return startSprintUseCase.startSprint(sprintId);
    }

    @PostMapping("/close/{id}")
    public Sprint closeSprint(@RequestBody CloseSprintCommand closeSprintCommand) {
        return closeSprintUseCase.closeSprint(closeSprintCommand);
    }

}
