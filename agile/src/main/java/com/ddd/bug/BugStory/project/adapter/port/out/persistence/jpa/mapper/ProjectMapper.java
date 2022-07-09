package com.ddd.bug.BugStory.project.adapter.port.out.persistence.jpa.mapper;

import com.ddd.bug.BugStory.project.adapter.port.out.persistence.jpa.entity.ProjectEntity;
import com.ddd.bug.BugStory.project.domain.model.Project;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ProjectMapper {

    ProjectMapper INSTANCE = Mappers.getMapper(ProjectMapper.class);

    @Mapping(target = "sprints", ignore = true)
    ProjectEntity domainToEntity(Project project);

    Project entityToDomain(ProjectEntity projectEntity);



}
