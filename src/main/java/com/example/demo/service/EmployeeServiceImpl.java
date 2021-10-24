package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.EmployeeDAO;
import com.example.demo.entity.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService{

	private EmployeeDAO employeeDAO;
 	
 	@Autowired
	public EmployeeServiceImpl(EmployeeDAO theEmployeeDAO) {
		employeeDAO = theEmployeeDAO;
	}
	
 	
 	public List<Employee> getAllEmployees(){
 		List<Employee> employees= employeeDAO.findAll();
		return employees;
 		
 	}


	@Override
	public Employee getEmployeeById(int employeeId) throws Exception  {
		Employee employee =null;
		try {
			employee= employeeDAO.findEmployeeById(employeeId);
		}catch (Exception e) {
		  throw new Exception(" Service class throws exception!!! " + e.getLocalizedMessage());
		}
          		
		return employee;
	}


	@Override
	public void save(Employee theEmployee) {
		// TODO Auto-generated method stub
		employeeDAO.save(theEmployee);
		
	}


	@Override
	public void delete(int employeeId) {
		employeeDAO.delete(employeeId);
		
	}
	
	
 	
 	

}
