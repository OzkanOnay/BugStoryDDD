package com.ddd.bug.BugStory.project.application.port.in;

import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.util.Date;

@RequiredArgsConstructor
public class SprintScheduleCommand {

    @Getter
    private int sprintId;
    @NonNull
    @Getter
    private Date start;
    @NonNull
    @Getter
    private Date end;

}
