package com.example.hitss.springboot.taskmanager.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.hitss.springboot.taskmanager.models.Task;
import com.example.hitss.springboot.taskmanager.repositories.TaskRepository;
import com.example.hitss.springboot.taskmanager.services.TaskService;

@Service
public class TaskServiceImpl implements TaskService{
    private TaskRepository taskRepository;

    public TaskServiceImpl(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }
    // Lisatar/Mostrar todas las tareas
    @Transactional(readOnly = true)  
    @Override
    public List<Task> findAll() {
        return taskRepository.findAll();
    }
     
    // Buscar por Id
    @Transactional(readOnly = true)  
    @Override
    public Optional<Task> findById(Long id) {
        return taskRepository.findById(id);
    }
    // Crear o guardar en BD
    @Transactional
    @Override
    public Task save(Task task) {
        return taskRepository.save(task);
    }
    // Actualizar
    @Transactional
    @Override
    public Optional<Task> update(Long id, Task task) {
        Optional<Task> taskOptional = taskRepository.findById(id);
        if (taskOptional.isPresent()) {
            Task taskBD = taskOptional.orElseThrow();

            taskBD.setName(task.getName());
            taskBD.setDescription(task.getDescription());
            taskBD.setDate(task.getDate());

            return Optional.of(taskRepository.save(taskBD));
        }
        return taskOptional;
    }
    // Eliminar
    @Transactional
    @Override
    public Optional<Task> delete(Long id) {
        Optional<Task> task= taskRepository.findById(id);
        task.ifPresent(p-> taskRepository.delete(p));
        return task;
    }
    
    
}
