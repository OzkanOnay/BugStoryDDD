package com.ddd.bug.BugStory.project.adapter.port.out.persistence.jpa.mapper;

import com.ddd.bug.BugStory.project.adapter.port.out.persistence.jpa.entity.IssueEntity;
import com.ddd.bug.BugStory.project.domain.model.Issue;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface IssueMapper {

    IssueMapper INSTANCE = Mappers.getMapper(IssueMapper.class);

    IssueEntity domainToEntity(Issue issue);
    Issue entityToDomain(IssueEntity issue);

}
