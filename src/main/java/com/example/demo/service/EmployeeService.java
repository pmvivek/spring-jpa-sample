package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.Employee;

public interface EmployeeService {

	public List<Employee> getAllEmployees();
	public Employee getEmployeeById(int employeeId) throws Exception;
    public void save(Employee theEmployee); 
    public void delete(int employeeId);

}
