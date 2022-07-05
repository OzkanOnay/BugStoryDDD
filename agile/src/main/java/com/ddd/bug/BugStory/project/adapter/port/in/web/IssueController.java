package com.ddd.bug.BugStory.project.adapter.port.in.web;

import com.ddd.bug.BugStory.project.application.port.in.NewIssueCommand;
import com.ddd.bug.BugStory.project.application.port.in.NewIssueUseCase;
import com.ddd.bug.BugStory.project.application.service.SprintApplicationService;
import com.ddd.bug.BugStory.project.domain.exception.IssueAlreadyExist;
import com.ddd.bug.BugStory.project.domain.model.Issue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/issue")
public class IssueController {
    @Autowired
    NewIssueUseCase newIssueUseCase;

    @PostMapping
    public Issue createIssue(@RequestBody NewIssueCommand newIssueCommand) {
        return newIssueUseCase.newIssue(newIssueCommand);
    }

}
