package com.RestAPI.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.RestAPI.demo.entity.Student;


@Repository
public interface StudentRepository extends JpaRepository<Student,Integer>{

}
