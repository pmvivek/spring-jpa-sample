package com.example.demo.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.entity.Employee;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO {
	
	@Autowired
	private EntityManager entityManager;


	@Override
	public List<Employee> findAll() {
		// TODO Auto-generated method stub
		Session session = entityManager.unwrap(Session.class);
		Query query = session.createQuery("from Employee", Employee.class);
		List<Employee> employeesList = query.getResultList();
		for(int i=0;i<employeesList.size();i++)
			System.out.println(employeesList.get(i));
		return employeesList; 
	}


	@Override
	public Employee findEmployeeById(int employeeId) throws Exception {
		Session session = entityManager.unwrap(Session.class);
		Employee employee = session.get( Employee.class,employeeId);
		if(employee== null)
			throw new Exception("Employee not available !! ");
		return employee;
	}


	@Override
	@Transactional
	public void save(Employee theEmployee) {
		Session session = entityManager.unwrap(Session.class);
		session.saveOrUpdate(theEmployee);
	}
	
	@Override
	@Transactional
	public void delete(int employeeId) {
		Session session = entityManager.unwrap(Session.class);
		Query deleteQuery = session.createQuery(" delete from Employee where id=:employeeId");
		deleteQuery.setParameter("employeeId", employeeId);
		deleteQuery.executeUpdate();
	}
	

}
