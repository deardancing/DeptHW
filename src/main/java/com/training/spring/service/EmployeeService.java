package com.training.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Service;

import com.hibernate.annotation.entity.Department;
import com.hibernate.annotation.entity.Employee;
import com.training.spring.dao.EmployeeDao;

@Service
public class EmployeeService {

	@Autowired
	private EmployeeDao employeeDao;
    private Employee employee;
   


	public Employee findEmployee(Integer id){
	
		//Calling EmployeeDao
		return employeeDao.findEmployeeById(id);
		
	}
	
	public List<Employee> findAllEmployee(){
		
		return employeeDao.findEmployee();
	}
	
    
	public void saveEmployee(Employee em){
		
		
		employeeDao.saveEmployee(em);
		
	}
	
		
	public void updateEmployee(Employee em){	
			employeeDao.updateEmployee(em);	
	}
	
	
	
	public void deleteEmployee(Employee em){	
			employeeDao.deleteEmployee(em);	
	}
	
	
	
	
}



