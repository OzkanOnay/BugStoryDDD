package com.ddd.bug.BugStory.project.adapter.port.in;

import com.ddd.bug.BugStory.BugStoryApplication;
import com.ddd.bug.BugStory.project.adapter.port.out.persistence.jpa.entity.ProjectEntity;
import com.ddd.bug.BugStory.project.application.port.in.CloseSprintCommand;
import com.ddd.bug.BugStory.project.application.port.in.NewProjectCommand;
import com.ddd.bug.BugStory.project.application.port.in.SprintScheduleCommand;
import com.ddd.bug.BugStory.project.domain.exception.ActiveSprintException;
import com.ddd.bug.BugStory.project.domain.model.Sprint;
import com.ddd.bug.BugStory.project.domain.valueObject.SprintStatus;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;

import java.util.Calendar;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(classes= BugStoryApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class SprintControllerTest {

    @Autowired
    TestRestTemplate template;

    @Test
    @Order(1)
    public void should_start_sprint() {
        Sprint sprint = template.postForObject("/api/v1/sprint/start/10",null, Sprint.class);
        assertEquals(sprint.getSprintStatus(), SprintStatus.STARTED);
    }

    @Test
    @Order(3)
    public void should_close_sprint_and_move_open_issues() {
        CloseSprintCommand closeSprintCommand = new CloseSprintCommand(10, 11);
        HttpEntity<CloseSprintCommand> request = new HttpEntity<>(closeSprintCommand);

        Sprint sprint = template.postForObject("/api/v1/sprint/close/10",request, Sprint.class);
        assertEquals(sprint.getSprintStatus(), SprintStatus.COMPLETED);
    }

    @Test
    @Order(4)
    public void should_reschedule_sprint() {
        Date start = Calendar.getInstance().getTime();

        Calendar endCalendar =  Calendar.getInstance();
        endCalendar.add(Calendar.DATE, 7);
        Date end = endCalendar.getTime();

        SprintScheduleCommand sprintScheduleCommand =
                new SprintScheduleCommand(10,start, end);

        HttpEntity<SprintScheduleCommand> request = new HttpEntity<>(sprintScheduleCommand);


        Sprint sprint = template.postForObject("/api/v1/sprint/reschedule",request, Sprint.class);
        assertEquals(sprint.getStart().getTime(), start.getTime());
        assertEquals(sprint.getEnd().getTime(), end.getTime());
    }


}
