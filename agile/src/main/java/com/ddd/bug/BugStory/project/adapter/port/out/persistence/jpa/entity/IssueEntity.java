package com.ddd.bug.BugStory.project.adapter.port.out.persistence.jpa.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
public class IssueEntity {
    @Id
    @GeneratedValue
    private Integer id;

    @ManyToOne
    private SprintEntity sprint;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public SprintEntity getSprint() {
        return sprint;
    }

    public void setSprint(SprintEntity sprint) {
        this.sprint = sprint;
    }

}
