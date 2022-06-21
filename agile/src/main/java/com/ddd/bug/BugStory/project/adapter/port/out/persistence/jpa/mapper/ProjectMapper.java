package com.ddd.bug.BugStory.project.adapter.port.out.persistence.jpa.mapper;

import com.ddd.bug.BugStory.project.adapter.port.out.persistence.jpa.entity.ProjectEntity;
import com.ddd.bug.BugStory.project.domain.model.Project;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ProjectMapper {

    ProjectMapper INSTANCE = Mappers.getMapper(ProjectMapper.class);

    @Mapping(source = "projectName",target = "name")
    @Mapping(source = "projectOwner",target = "owner")
    ProjectEntity domainToEntity(Project project);

    @Mapping(source = "name",target = "projectName")
    @Mapping(source = "owner",target = "projectOwner")
    Project entityToDomain(ProjectEntity projectEntity);

}
