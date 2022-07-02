package com.ddd.bug.BugStory.project.adapter.port.out.persistence;

import com.ddd.bug.BugStory.project.adapter.port.out.persistence.jpa.entity.SprintEntity;
import com.ddd.bug.BugStory.project.adapter.port.out.persistence.jpa.mapper.SprintMapper;
import com.ddd.bug.BugStory.project.adapter.port.out.persistence.jpa.repository.SprintRepository;
import com.ddd.bug.BugStory.project.application.port.out.SprintPort;
import com.ddd.bug.BugStory.project.domain.model.Sprint;
import com.ddd.bug.BugStory.project.domain.valueObject.SprintStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class SprintDataAdapter implements SprintPort {

    @Autowired
    private SprintRepository sprintRepository;

    @Override
    public Sprint save(Sprint sprint) {
        SprintMapper mapper = SprintMapper.INSTANCE;

        SprintEntity sprintEntity = mapper.domaintToEntity(sprint);
        sprintEntity = sprintRepository.save(sprintEntity);
        return mapper.entityToDomain(sprintEntity);
    }

    @Override
    public void delete(int sprintId) {
        Optional<SprintEntity> sprint = sprintRepository.findById(sprintId);
        if(sprint.isPresent())
            sprintRepository.delete(sprint.get());
    }

    @Override
    public Sprint findById(int sprintId) {
        SprintMapper mapper = SprintMapper.INSTANCE;
        Optional<SprintEntity> sprintEntity = sprintRepository.findById(sprintId);

        if(sprintEntity.isPresent()) {
            return mapper.entityToDomain(sprintEntity.get());
        }

        return null;
    }

    @Override
    public Sprint findActiveSprint() {
        Optional<SprintEntity> optionalSprint = sprintRepository.findBySprintStatus(SprintStatus.STARTED.getStatus());

        if(optionalSprint.isPresent())
            return SprintMapper.INSTANCE.entityToDomain(optionalSprint.get());
        else
            return null;
    }
}
