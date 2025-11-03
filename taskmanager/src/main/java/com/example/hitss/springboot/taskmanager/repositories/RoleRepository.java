package com.example.hitss.springboot.taskmanager.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.hitss.springboot.taskmanager.models.Role;


public interface RoleRepository extends JpaRepository<Role, Long>{
    Optional<Role> findByName(String name);
}
