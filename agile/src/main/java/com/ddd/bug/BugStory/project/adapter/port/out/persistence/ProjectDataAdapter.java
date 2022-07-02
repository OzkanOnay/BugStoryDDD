package com.ddd.bug.BugStory.project.adapter.port.out.persistence;

import com.ddd.bug.BugStory.project.adapter.port.out.persistence.jpa.entity.ProjectEntity;
import com.ddd.bug.BugStory.project.adapter.port.out.persistence.jpa.mapper.ProjectMapper;
import com.ddd.bug.BugStory.project.adapter.port.out.persistence.jpa.repository.ProjectRepository;
import com.ddd.bug.BugStory.project.application.port.out.ProjectPort;
import com.ddd.bug.BugStory.project.domain.model.Project;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProjectDataAdapter implements ProjectPort {

    @Autowired
    ProjectRepository projectRepository;

    @Override
    public Project save(Project project) {

        ProjectEntity projectEntity = ProjectMapper.INSTANCE.domainToEntity(project);

        projectEntity = projectRepository.save(projectEntity);

        project.setId(projectEntity.getId());
        return project;
    }

    @Override
    public Project findById(int projectId) {
        ProjectEntity projectEntity = projectRepository.findById(projectId).orElse(null);
        return ProjectMapper.INSTANCE.entityToDomain(projectEntity);
    }
}
