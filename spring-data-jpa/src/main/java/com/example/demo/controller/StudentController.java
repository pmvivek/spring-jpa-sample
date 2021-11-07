package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Student;
import com.example.demo.repo.StudentRepository;

@RestController
@RequestMapping("/api/student")
public class StudentController {
	
	
	
	
	@Autowired
	private StudentRepository studentRepo;
	
	
	
	@GetMapping("students")
	public List<Student> getAllStudents() throws Exception{
		List<Student> StudentsList = new ArrayList<>();
		StudentsList = studentRepo.findAll();
		System.out.println(StudentsList);
		
		if(StudentsList==null || StudentsList.isEmpty()) {
			throw new Exception("Student list is empty");
		}
			
		return StudentsList;
		
	}
	
   @GetMapping("students/{studentId}")
   public Student getStudentById(@PathVariable int studentId) throws Exception{
	Student Student = null;
	try {
		Student = studentRepo.getById(studentId);
	} catch (Exception e) {
		// TODO Auto-generated catch block
		throw new Exception("Student not found" + e.getLocalizedMessage());
	}
	
	return Student;
	   
   }
   
   @PostMapping("students") 
   public void saveStudent (@RequestBody Student student ){
	   studentRepo.save(student);
	  
	   
   }
   
   @DeleteMapping("students/{studentId}") 
   public String deleteStudent (@PathVariable int studentId ){
	Student tempStudent = null;
	try {
		tempStudent = studentRepo.getById(studentId);
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		
		// throw exception if null
		
		if (tempStudent == null) {
			throw new RuntimeException("Student id not found - " + studentId);
		}
		
		studentRepo.deleteById(studentId);
		
		return "Deleted Student id - " + studentId;
	}
	  
	   
   }


