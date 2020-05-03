package com.luv2code.springdemo.rest;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.luv2code.springdemo.entity.Student;

@RestController
@RequestMapping("/api")
public class StudentRestController {
	
	@GetMapping("/students")
	public List<Student> getStudents(){
		List<Student> theStu=new ArrayList<>();
		
		theStu.add(new Student("Vatsal","Bhatnagar"));
		theStu.add(new Student("Vasu","Bhatnagar"));
		theStu.add(new Student("Abc","Xyz"));
		
		return theStu;
		
	}

}
