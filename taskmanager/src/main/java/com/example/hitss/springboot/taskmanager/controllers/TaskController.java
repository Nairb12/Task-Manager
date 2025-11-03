package com.example.hitss.springboot.taskmanager.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;


import com.example.hitss.springboot.taskmanager.models.Task;
import com.example.hitss.springboot.taskmanager.services.TaskService;
import com.example.hitss.springboot.taskmanager.utils.UtilCrud;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/tasks")
@Tag(
    name = "TasksManager",
    description = "Realiza el CRUD de Tasks Manager"
)
public class TaskController {
    private TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @Operation(summary = "Get all", description = "Retorna o muestra todos las tareas")
    @GetMapping
    public List<Task> list(){
        return taskService.findAll();
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get by Id", description = "Retorna o muestra la tarea con el id")
    public ResponseEntity<?> view(@PathVariable Long id){
        Optional<Task> taskOptional = taskService.findById(id);
        if (taskOptional.isPresent()) {
            return ResponseEntity.ok(taskOptional.orElseThrow());
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    @Operation(summary = "Create Task", description = "Crea una tarea")
    public ResponseEntity<?> create(@Valid @RequestBody Task task, 
            BindingResult result){
        if (result.hasFieldErrors()) {
            return UtilCrud.validation(result);
        }
        return ResponseEntity.status(HttpStatus.CREATED)
                             .body(taskService.save(task));
    }

   

    @PutMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    @Operation(summary = "Update Task", description = "actualiza una tarea por su id")
    public ResponseEntity<?> update(@Valid @RequestBody Task task, 
                                            BindingResult result, 
                                            @PathVariable Long id){
        if (result.hasFieldErrors()) {
            return UtilCrud.validation(result);
        }
        Optional<Task> optional = taskService.update(id, task);
        if (optional.isPresent()) {
            return ResponseEntity.status(HttpStatus.CREATED).body(optional.orElseThrow());
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    @Operation(summary = "Delete Task", description = "Elimina una tarea")
    public ResponseEntity<?> delete(@PathVariable Long id){
        Optional<Task> taskoptional = taskService.delete(id);
        if (taskoptional.isPresent()) {
            return ResponseEntity.ok(taskoptional.orElseThrow());
        }
        return ResponseEntity.notFound().build();
    }


}
