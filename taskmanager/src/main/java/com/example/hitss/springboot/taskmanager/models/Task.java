package com.example.hitss.springboot.taskmanager.models;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "tasks")
@Getter
@Setter
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @NotBlank(message = "El nombre es obligatorio")
    @Column(length=50,nullable = false)
    @Size(min = 3, max = 50)
    private String name;
    
    @NotBlank(message = "La descripción es obligatoria")
    private String description;
    
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate date;
    
}
