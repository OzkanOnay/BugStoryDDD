package com.ddd.bug.BugStory.project.adapter.port.out.persistence.jpa.mapper;

import com.ddd.bug.BugStory.project.adapter.port.out.persistence.jpa.entity.BacklogEntity;
import com.ddd.bug.BugStory.project.domain.model.Backlog;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface BacklogMapper {

    BacklogMapper instance = Mappers.getMapper(BacklogMapper.class);


    BacklogEntity domainToEntity(Backlog backlog);
    Backlog entityToDomain(Backlog backlog);

}
