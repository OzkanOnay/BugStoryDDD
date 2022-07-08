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
    public void reSchedule(@RequestBody SprintScheduleCommand scheduleCommand) {
        sprintApplicationService.schedule(scheduleCommand);
    }

    @GetMapping("/start/{id}")
    public void startSprint(@PathVariable("id") int sprintId) {
        try {
            startSprintUseCase.startSprint(sprintId);
        } catch (ActiveSprintException e) {
            //loglayıp
            //hata fırlat
        }
    }

    @PostMapping("/close/{id}")
    public void closeSprint(@RequestBody CloseSprintCommand closeSprintCommand) {
        closeSprintUseCase.closeSprint(closeSprintCommand);
    }

}
