package com.ddd.bug.BugStory.project.adapter.port.out.persistence.jpa.repository;

import com.ddd.bug.BugStory.project.adapter.port.out.persistence.jpa.entity.IssueEntity;
import org.springframework.data.repository.CrudRepository;

public interface IssueRepository extends CrudRepository<IssueEntity, Integer> {
}
