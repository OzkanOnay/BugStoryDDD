package com.ddd.bug.BugStory.project.adapter.port.out.persistence.jpa.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
public class ProjectEntity {
    @Id
    @GeneratedValue(generator = "increment")
    private Integer id;

    private String projectName;
    private String description;
    private String projectOwner;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "project_id")
    List<SprintEntity> sprints;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }


    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getProjectOwner() {
        return projectOwner;
    }

    public void setProjectOwner(String projectOwner) {
        this.projectOwner = projectOwner;
    }

    public List<SprintEntity> getSprints() {
        return sprints;
    }

    public void setSprints(List<SprintEntity> sprints) {
        this.sprints = sprints;
    }
}
