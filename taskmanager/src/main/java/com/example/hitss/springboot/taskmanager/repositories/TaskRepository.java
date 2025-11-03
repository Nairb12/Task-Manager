package com.example.hitss.springboot.taskmanager.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.hitss.springboot.taskmanager.models.Task;

public interface TaskRepository extends JpaRepository<Task, Long> {

}
