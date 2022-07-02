package com.ddd.bug.BugStory.project.adapter.port.out.persistence.jpa.repository;

import com.ddd.bug.BugStory.project.adapter.port.out.persistence.jpa.entity.SprintEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface SprintRepository extends CrudRepository<SprintEntity, Integer> {
    Optional<SprintEntity> findBySprintStatus(String status);
}
