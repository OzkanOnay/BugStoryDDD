package com.ddd.bug.BugStory.project.adapter.port.out;

import com.ddd.bug.BugStory.project.application.port.out.ProjectPort;
import com.ddd.bug.BugStory.project.domain.model.Project;

import java.util.ArrayList;
import java.util.List;

public class ProjectFakeAdapter implements ProjectPort {
    final List<Project> projects;

    public ProjectFakeAdapter() {
        projects = new ArrayList<>();
        projects.add(Project.builder()
                .projectName("Deneme")
                .Id(1)
                .projectOwner("Ozkan")
                .backlogs(new ArrayList<>())
                .build());
        projects.add(Project.builder()
                .projectName("Deneme 2")
                .Id(2)
                .projectOwner("Ozkan")
                .backlogs(new ArrayList<>())
                .build());
    }

    @Override
    public Project save(Project project) {
        Project myProject;
        myProject = Project.builder()
                .projectName(project.getProjectName())
                .Id(project.getId() == 0 ? 3 : project.getId())
                .projectOwner(project.getProjectOwner())
                .backlogs(project.getBacklogs())
                .build();

        if(projects.stream().anyMatch(p -> p.getId() == myProject.getId())) {
            projects.removeIf(p -> p.getId() == myProject.getId());
        }
        projects.add(myProject);

        return myProject;
    }

    @Override
    public Project findById(int projectId) {
        return projects.stream().filter(project -> project.getId() == projectId)
                .findFirst()
                .orElse(null);
    }
}
