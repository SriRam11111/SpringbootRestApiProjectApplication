package com.RestAPI.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.RestAPI.demo.entity.Student;

public interface StudentRepository extends JpaRepository<Student,Integer>{

}
