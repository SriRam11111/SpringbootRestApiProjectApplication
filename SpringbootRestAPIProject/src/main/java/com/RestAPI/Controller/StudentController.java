package com.RestAPI.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.DeleteMapping;

import org.springframework.web.bind.annotation.ResponseStatus;
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
		List<Student> students= repo.findAll(); 
		return students;
	}
	
	@GetMapping("/student/{id}")
	public Student getStudents(@PathVariable int id){
		//use spring JPA to get all students from DB through APIs
		Student Student = repo.findById(id).get();
		return Student ;
	}
	
	@PostMapping("/student/add")
	@ResponseStatus(code = HttpStatus.CREATED)
	public void createStudent(@RequestBody Student student) {
		repo.save(student); // can only send one by one not a list of students
	}
	
	@PutMapping("/student/update/{id}")
	public Student UpdateStudents(@PathVariable int id,@RequestBody Student studentDetails) {
		Student student = repo.findById(id).get();
		student.setName(studentDetails.getName());
		student.setPercentage(studentDetails.getPercentage());
		repo.save(student);
		return student;
	}
	
	@DeleteMapping("/student/delete/{id}")
//	@ResponseStatus(HttpStatus.NO_CONTENT)
	public ResponseEntity<String> removeStudent(@PathVariable int id) {
		Optional<Student> Student = repo.findById(id);
		if (Student.isPresent()) {
	        Student student = Student.get();
	        repo.delete(student);
	        return ResponseEntity.status(HttpStatus.OK).body("Student with ID " + id + " deleted successfully.");
	    } else {
	        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No student found with ID " + id);
	    }

		
	}
	
}