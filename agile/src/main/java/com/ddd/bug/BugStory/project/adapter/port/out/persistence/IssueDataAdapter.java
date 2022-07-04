package com.ddd.bug.BugStory.project.adapter.port.out.persistence;

import com.ddd.bug.BugStory.project.adapter.port.out.persistence.jpa.entity.IssueEntity;
import com.ddd.bug.BugStory.project.adapter.port.out.persistence.jpa.mapper.IssueMapper;
import com.ddd.bug.BugStory.project.adapter.port.out.persistence.jpa.repository.IssueRepository;
import com.ddd.bug.BugStory.project.application.port.out.IssuePort;
import com.ddd.bug.BugStory.project.domain.model.Issue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class IssueDataAdapter implements IssuePort {

    @Autowired
    IssueRepository issueRepository;

    @Override
    public Issue save(Issue issue) {
        IssueMapper issueMapper = IssueMapper.INSTANCE;

        IssueEntity issueEntity = issueMapper.domainToEntity(issue);
        issueEntity = issueRepository.save(issueEntity);
        return issueMapper.entityToDomain( issueEntity );
    }

    @Override
    public Issue findById(int issueId) {
        Optional<IssueEntity> issueEntity = issueRepository.findById(issueId);

        if(issueEntity.isPresent())
            return IssueMapper.INSTANCE.entityToDomain(issueEntity.get());

        return null;
    }
}

