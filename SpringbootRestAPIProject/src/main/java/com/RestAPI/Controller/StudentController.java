package com.RestAPI.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.RestAPI.demo.entity.Student;
import com.RestAPI.repository.StudentRepository;

@RestController
public class StudentController {
	
	@Autowired
	 StudentRepository repo;
	
	//get all students
	@GetMapping("/students")
	public List<Student> getAllStudents(){
		//use spring JPA to get all students from DB through APIs
		return repo.findAll(); 
	}
	
	@GetMapping("/students/{id}")
	public Student getStudents(@PathVariable int id){
		//use spring JPA to get all students from DB through APIs
		Student Student = repo.findById(id).get();
		return Student ;
	}
}