package com.ddd.bug.BugStory.project.adapter.port.in.web;

import com.ddd.bug.BugStory.project.application.port.in.NewProjectCommand;
import com.ddd.bug.BugStory.project.application.service.ProjectApplicationService;
import com.ddd.bug.BugStory.project.domain.model.Project;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/project")
public class ProjectController {

    @Autowired
    ProjectApplicationService projectApplicationService;

    //Create
    @PostMapping(consumes = "application/json")
    public Project createProject(@RequestBody NewProjectCommand newProjectCommand) {
        return projectApplicationService.createProject(newProjectCommand);
    }

    //Get
    @GetMapping("/{id}")
    public Project getProject(@PathVariable("id") int id) {
        return projectApplicationService.getProject(id);
    }
}
