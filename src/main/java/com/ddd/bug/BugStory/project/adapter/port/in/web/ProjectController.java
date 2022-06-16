package com.ddd.bug.BugStory.project.adapter.port.in.web;

import com.ddd.bug.BugStory.project.application.service.ProjectApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/api/v1/project")
public class ProjectController {

    @Autowired
    ProjectApplicationService projectApplicationService;


}
