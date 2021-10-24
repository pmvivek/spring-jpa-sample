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

import com.example.demo.entity.Employee;
import com.example.demo.service.EmployeeService;

@RestController
@RequestMapping("/api/employee")
public class EmployeeController {
	
	
	private EmployeeService employeeService;
	
	@Autowired
	public EmployeeController(EmployeeService theEmployeeService) {
		employeeService = theEmployeeService;
	}
	
	
	@GetMapping("employees")
	public List<Employee> getAllEmployees() throws Exception{
		List<Employee> employeesList = new ArrayList<>();
		employeesList = employeeService.getAllEmployees();
		System.out.println(employeesList);
		
		if(employeesList==null || employeesList.isEmpty()) {
			throw new Exception("Employee list is empty");
		}
			
		return employeesList;
		
	}
	
   @GetMapping("employees/{employeeId}")
   public Employee getEmployeeById(@PathVariable int employeeId) throws Exception{
	Employee employee = null;
	try {
		employee = employeeService.getEmployeeById(employeeId);
	} catch (Exception e) {
		// TODO Auto-generated catch block
		throw new Exception("Employee not found" + e.getLocalizedMessage());
	}
	
	return employee;
	   
   }
   
   @PostMapping("employees") 
   public void saveEmployee (@RequestBody Employee employee ){
	   employeeService.save(employee);
	  
	   
   }
   
   @DeleteMapping("employees/{employeeId}") 
   public String deleteEmployee (@PathVariable int employeeId ){
	Employee tempEmployee = null;
	try {
		tempEmployee = employeeService.getEmployeeById(employeeId);
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		
		// throw exception if null
		
		if (tempEmployee == null) {
			throw new RuntimeException("Employee id not found - " + employeeId);
		}
		
		employeeService.delete(employeeId);
		
		return "Deleted employee id - " + employeeId;
	}
	  
	   
   }


