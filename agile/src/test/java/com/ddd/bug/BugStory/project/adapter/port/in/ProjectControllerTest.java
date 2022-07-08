package com.ddd.bug.BugStory.project.adapter.port.in;

import com.ddd.bug.BugStory.BugStoryApplication;
import com.ddd.bug.BugStory.project.adapter.port.out.persistence.jpa.entity.ProjectEntity;
import static org.junit.jupiter.api.Assertions.*;

import com.ddd.bug.BugStory.project.application.port.in.NewProjectCommand;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@SpringBootTest(classes= BugStoryApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ProjectControllerTest {
    @Autowired
    TestRestTemplate template;

    @Test
    public void testCreateProject() {
        NewProjectCommand newProjectCommand =
                new NewProjectCommand("Bugstory", "Bugstory project", "özkan");

        HttpEntity<NewProjectCommand> request = new HttpEntity<>(newProjectCommand);

        ProjectEntity response = template.postForObject("/api/v1/project",request, ProjectEntity.class);

        assertTrue(response != null);
        assertTrue(response.getId() > 0 );
    }

    @Test
    public void testGetProject() {
        ResponseEntity<ProjectEntity> response = template.getForEntity("/api/v1/project/1", ProjectEntity.class);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        ProjectEntity project = response.getBody();
        if(project != null) {
            assertEquals(1, project.getId());
        }
    }

}