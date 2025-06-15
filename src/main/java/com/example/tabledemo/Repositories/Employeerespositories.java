package com.example.tabledemo.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.tabledemo.model.Employee;

public interface Employeerespositories extends JpaRepository<Employee,Integer>{}

