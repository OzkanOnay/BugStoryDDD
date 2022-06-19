package com.ddd.bug.BugStory.project.adapter.port.out.persistence.jpa.entity;

import lombok.Data;
import lombok.Getter;

import javax.persistence.*;

@Data
@Entity
public class BacklogEntity {
    @Id
    @GeneratedValue
    private Integer Id;

    private String description;

    private String assignedUser;

    @ManyToOne
    private ProjectEntity project;

    @OneToMany
    private CommentEntity comments;

}
