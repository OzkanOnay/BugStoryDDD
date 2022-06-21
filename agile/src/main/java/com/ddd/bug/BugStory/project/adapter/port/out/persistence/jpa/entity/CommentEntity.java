package com.ddd.bug.BugStory.project.adapter.port.out.persistence.jpa.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class CommentEntity {
    @javax.persistence.Id
    @GeneratedValue
    private Integer Id;
}
