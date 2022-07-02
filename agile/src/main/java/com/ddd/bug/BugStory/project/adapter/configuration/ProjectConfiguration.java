package com.ddd.bug.BugStory.project.adapter.configuration;

import com.ddd.bug.BugStory.project.application.port.out.IssuePort;
import com.ddd.bug.BugStory.project.application.port.out.ProjectPort;
import com.ddd.bug.BugStory.project.application.port.out.SprintPort;
import com.ddd.bug.BugStory.project.application.service.ProjectApplicationService;
import com.ddd.bug.BugStory.project.application.service.SprintApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ProjectConfiguration {

    @Autowired
    ProjectPort projectPort;

    @Autowired
    SprintPort sprintPort;

    @Autowired
    IssuePort issuePort;

    @Bean
    public ProjectApplicationService projectApplicationService() {
        return new ProjectApplicationService(projectPort);
    }

    @Bean
    public SprintApplicationService sprintApplicationService() {
        return new SprintApplicationService(sprintPort, issuePort);
    }


}
