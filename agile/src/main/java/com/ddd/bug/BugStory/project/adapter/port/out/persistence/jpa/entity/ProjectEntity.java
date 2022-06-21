package com.ddd.bug.BugStory.project.adapter.port.out.persistence.jpa.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
public class ProjectEntity {
    @Id
    @GeneratedValue
    private Integer Id;
    private String name;
    private String description;
    private String owner;

    @OneToMany(fetch = FetchType.EAGER)
    private List<BacklogEntity> backlogs;

    @OneToMany
    private List<SprintEntity> sprints;
}
