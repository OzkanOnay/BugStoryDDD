package com.ddd.bug.BugStory.project.domain.exception;

public class IssueAlreadyExist extends Exception{
    public IssueAlreadyExist() {
        super("Issue already exist");
    }
}
