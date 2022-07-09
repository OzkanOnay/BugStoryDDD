package com.ddd.bug.BugStory.project.application.port.in;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.util.Date;

@AllArgsConstructor
public class SprintScheduleCommand {
    @Getter
    private int sprintId;
    @Getter
    private Date start;
    @Getter
    private Date end;

}
