package com.luv2code.springdemo.rest;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.luv2code.springdemo.entity.Student;

@RestController
@RequestMapping("/api")
public class StudentRestController {
	
	//adding the students here because if we add it inside the method then
	//every time the page is loaded the data is added.
	//use @PostConstruct to load student data.(ONLY ONCE)
	
	private List<Student> theStu;
	
	@PostConstruct
	public void addStu() {
		theStu=new ArrayList<>();
		
		theStu.add(new Student("Vatsal","Bhatnagar"));
		theStu.add(new Student("Vasu","Bhatnagar"));
		theStu.add(new Student("Abc","Xyz"));
		
	}
	//endpoint for retrieving all students
	
	@GetMapping("/students")
	public List<Student> getStudents(){
				
		return theStu;
		
	}
	
	//endpoint for retrieving a single student using studentId
	@GetMapping("/students/{studentId}")
	public Student getStudent(@PathVariable int studentId) {
		
		//check if studentId is in valid range.
		//if not throw the exception we created.
		if((studentId>theStu.size()) || (studentId<0)) {
			throw new StudentNotFoundException("No student found id => "+studentId);
		}
		
		return theStu.get(studentId);
	}
	
	

}
