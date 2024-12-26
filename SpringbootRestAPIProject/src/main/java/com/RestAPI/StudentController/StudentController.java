package com.RestAPI.StudentController;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.RestAPI.demo.entity.Student;

@RestController
public class StudentController {
	
	//get all students
	@GetMapping("/students")
	public List<Student> getAllStudents(){
		//use spring JPA to get all students from DB through APIs
		return null ;
	}
}
