package com.ddd.bug.BugStory.project.adapter.port.out.persistence.jpa.repository;

import com.ddd.bug.BugStory.project.adapter.port.out.persistence.jpa.entity.BacklogEntity;
import org.springframework.data.repository.CrudRepository;

public interface BacklogRepository extends CrudRepository<BacklogEntity, Integer> {
}
