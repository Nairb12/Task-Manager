package com.example.hitss.springboot.taskmanager.services;

import java.util.List;
import java.util.Optional;

import com.example.hitss.springboot.taskmanager.models.Task;

public interface TaskService {
     //Métodos crud -> listar,, ,  y 
    List<Task> findAll();
    //  buscar por id
    Optional<Task> findById(Long id);
    // crear
    Task save(Task task);
   // actualizar
    Optional<Task> update(Long id, Task task);
    // eliminar por id
    Optional<Task> delete(Long id);
}
