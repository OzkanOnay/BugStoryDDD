package com.ddd.bug.BugStory.project.adapter.port.out.real;

import com.ddd.bug.BugStory.BugStoryApplication;
import com.ddd.bug.BugStory.project.adapter.port.out.persistence.ProjectDataAdapter;
import com.ddd.bug.BugStory.project.adapter.port.out.persistence.jpa.repository.ProjectRepository;
import com.ddd.bug.BugStory.project.domain.model.Project;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest(classes= BugStoryApplication.class)
public class ProjectDataAdapterTest {

    @Autowired
    ProjectDataAdapter projectDataAdapter;

    @Autowired
    ProjectRepository projectRepository;


    @Test
    @DirtiesContext
    public void testProjectSave() {

        Project projectDb = projectDataAdapter.save(Project.builder()
                .projectName("deneme")
                .projectOwner("ozkan")
                .description("deneme")
                .build());

        assertTrue(projectDb.getId() > 0);

        Project project = projectDataAdapter.findById(projectDb.getId());
        assertTrue(project != null);

        assertTrue(project.getProjectName().equals(projectDb.getProjectName()));
    }
}
