package com.ddd.bug.BugStory.project.adapter.port.out.persistence.jpa.mapper;

import com.ddd.bug.BugStory.project.adapter.port.out.persistence.jpa.entity.IssueEntity;
import com.ddd.bug.BugStory.project.domain.model.Issue;
import org.mapstruct.DecoratedWith;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
@DecoratedWith(IssueMapperDecorator.class)
public interface IssueMapper {

    IssueMapper INSTANCE = Mappers.getMapper(IssueMapper.class);

    @Mapping(target = "issueStatu",ignore = true)
    @Mapping(target = "issueType",ignore = true)
    IssueEntity domainToEntity(Issue issue);

    @Mapping(target = "issueStatu",ignore = true)
    @Mapping(target = "issueType",ignore = true)
    @Mapping(target = "comments",ignore = true)
    Issue entityToDomain(IssueEntity issue);

}
