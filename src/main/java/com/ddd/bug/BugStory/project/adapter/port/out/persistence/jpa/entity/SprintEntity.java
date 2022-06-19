package com.ddd.bug.BugStory.project.adapter.port.out.persistence.jpa.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class SprintEntity {
    @Id
    @GeneratedValue
    private Integer Id;

    @OneToMany
    private List<IssueEntity> issues;

    @ManyToOne
    private ProjectEntity project;
}
