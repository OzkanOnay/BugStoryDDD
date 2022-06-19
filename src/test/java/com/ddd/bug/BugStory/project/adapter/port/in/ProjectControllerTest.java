package com.ddd.bug.BugStory.project.adapter.port.in;

import com.ddd.bug.BugStory.project.adapter.port.out.persistence.jpa.entity.ProjectEntity;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ProjectControllerTest {
    @Autowired
    TestRestTemplate template;

    @Test
    public void testGetProject() {
        ResponseEntity<ProjectEntity> response = template.getForEntity("/api/v1/project/1", ProjectEntity.class);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        ProjectEntity project = response.getBody();
        if(project != null) {
            assertEquals(1, project.getId());
        }
    }

    @Test
    public void testCreateProject() {

    }

}
