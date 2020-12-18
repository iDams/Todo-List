package com.marco.astorga.todo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Table(name = "task")
@EntityListeners(AuditingEntityListener.class)
public class Task {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "ID")
    private User user;

    @Column(name = "task_name", nullable = false)
    private String name;

    @Column(name = "task_status", nullable = false)
    private Boolean status;

    @Column(name = "task_description", nullable = false)
    private String description;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Task() {
    }

    public Task(User user, String name, Boolean status, String description) {
        this.user = user;
        this.name = name;
        this.status = status;
        this.description = description;
    }

    @Override
    public String toString() {
        return "Task [description=" + description + ", id=" + id + ", name=" + name + ", status=" + status + ", user="
                + user + "]";
    }

  
    


}