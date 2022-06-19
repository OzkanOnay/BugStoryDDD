package com.ddd.bug.BugStory.project.adapter.port.out.persistence.jpa.mapper;

import com.ddd.bug.BugStory.project.adapter.port.out.persistence.jpa.entity.SprintEntity;
import com.ddd.bug.BugStory.project.domain.model.Sprint;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface SprintMapper {
    SprintMapper INSTANCE = Mappers.getMapper(SprintMapper.class);

    SprintEntity domaintToEntity(Sprint sprint);
    Sprint entityToDomain(SprintEntity sprintEntity);

}
