package com.example.demo.dao;

import java.util.List;

import com.example.demo.entity.Employee;

public interface EmployeeDAO {
	
	public List<Employee> findAll();
    public Employee findEmployeeById(int employeeId) throws Exception;
    
    public void save(Employee theEmployee); 
    public void delete(int employeeId);
}
