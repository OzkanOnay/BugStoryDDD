package com.ddd.bug.BugStory.project.adapter.port.out.persistence.jpa.mapper;

import com.ddd.bug.BugStory.project.adapter.port.out.persistence.jpa.entity.SprintEntity;
import com.ddd.bug.BugStory.project.domain.model.Sprint;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(uses = {IssueMapper.class })
//@DecoratedWith(PersonMapperDecorator.class)
public interface SprintMapper {
    SprintMapper INSTANCE = Mappers.getMapper(SprintMapper.class);



    @Mapping(target = "sprintStatus", expression = "java( String.valueOf(sprint.getSprintStatus().toString()) )")
    @Mapping(source = "start",target = "startDate")
    @Mapping(source = "end",target = "endDate")
    @Mapping(source = "projectId",target = "project_id")
    SprintEntity domaintToEntity(Sprint sprint);

    @Mapping(target = "sprintStatus", expression = "java( com.ddd.bug.BugStory.project.domain.valueObject.SprintStatus.valueOf(sprintEntity.getSprintStatus()) )")
    @Mapping(source = "startDate",target = "start")
    @Mapping(source = "endDate",target = "end")
    @Mapping(source = "project_id",target = "ProjectId")
    Sprint entityToDomain(SprintEntity sprintEntity);

}
/*
*
*
public abstract class PersonMapperDecorator implements PersonMapper {

    private final PersonMapper delegate;

    public PersonMapperDecorator(PersonMapper delegate) {
        this.delegate = delegate;
    }

    @Override
    public PersonDto personToPersonDto(Person person) {
        PersonDto dto = delegate.personToPersonDto( person );
        dto.setFullName( person.getFirstName() + " " + person.getLastName() );
        return dto;
    }
}
*
* */