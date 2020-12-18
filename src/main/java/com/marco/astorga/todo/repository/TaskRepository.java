package com.marco.astorga.todo.repository;

import com.marco.astorga.todo.entity.Task;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {
    public abstract Page<Task> findAllByuser_id(Pageable pageable, Long id);
}