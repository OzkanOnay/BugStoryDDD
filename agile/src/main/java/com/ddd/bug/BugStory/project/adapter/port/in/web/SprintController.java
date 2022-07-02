package com.ddd.bug.BugStory.project.adapter.port.in.web;

import com.ddd.bug.BugStory.project.application.port.in.CloseSprintUseCase;
import com.ddd.bug.BugStory.project.application.port.in.StartSprintUseCase;
import com.ddd.bug.BugStory.project.domain.exception.ActiveSprintException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/sprint")
public class SprintController {
/*
    @Autowired
    StartSprintUseCase startSprintUseCase;

    @GetMapping("/{id}")
    public void startSprint(@PathVariable("id") int sprintId) {
        try {
            startSprintUseCase.startSprint(sprintId);
        } catch (ActiveSprintException e) {
            //loglayıp
            //hata fırlat
        }
    }

    @Autowired
    CloseSprintUseCase closeSprintUseCase;

 */
}
