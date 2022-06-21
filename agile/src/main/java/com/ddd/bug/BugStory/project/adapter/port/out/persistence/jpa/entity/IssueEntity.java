package com.ddd.bug.BugStory.project.adapter.port.out.persistence.jpa.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.ManyToOne;

@Entity
public class IssueEntity {
    @javax.persistence.Id
    @GeneratedValue
    private Integer Id;

    @ManyToOne
    private SprintEntity sprint;
}
