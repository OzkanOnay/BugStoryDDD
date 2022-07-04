package com.ddd.bug.BugStory.project.adapter.port.out.persistence.jpa.mapper;

import com.ddd.bug.BugStory.project.adapter.port.out.persistence.jpa.entity.IssueEntity;
import com.ddd.bug.BugStory.project.domain.model.Issue;
import com.ddd.bug.BugStory.project.domain.valueObject.IssueStatu;
import com.ddd.bug.BugStory.project.domain.valueObject.IssueType;

public abstract class IssueMapperDecorator implements IssueMapper{
    private IssueMapper delegate;

    public IssueMapperDecorator(IssueMapper issueMapper) {
        this.delegate = issueMapper;
    }

    @Override
    public IssueEntity domainToEntity(Issue issue) {
        IssueEntity entity = delegate.domainToEntity(issue);
        if(issue.getIssueStatu() != null)
            entity.setIssueStatu(issue.getIssueStatu().getCode());
        if(issue.getIssueType() != null)
            entity.setIssueType(issue.getIssueType().getCode());
        return entity;
    }

    @Override
    public Issue entityToDomain(IssueEntity issueEntity) {
        Issue issue = delegate.entityToDomain(issueEntity);
        if(issueEntity.getIssueType() != null)
            issue.changeType(IssueType.valueOf(issueEntity.getIssueType()));
        if(issueEntity.getIssueStatu() != null)
            issue.changeStatus(IssueStatu.valueOf(issueEntity.getIssueStatu()));
        return issue;
    }
}
