package com.training.spring.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.DetachedCriteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.hibernate.annotation.entity.Department;

@Repository
public class DepartmentDao {

	
	@Autowired
	private HibernateTemplate hibernateTemplate;
	
	 public Department findDepartmentById(Integer id){
		 
		return  hibernateTemplate.get(Department.class, id);
			 
	 }
	 
	 
	 public List<Department> findAllDepartment(){
		 
		return  hibernateTemplate.find("From Department");
			 
	}
	 

	 public List<Department> findDepartmentByCriteria(DetachedCriteria criteria){
		 
		return  hibernateTemplate.findByCriteria(criteria);
			 
	}
	 
	 
	 
	 public void insertDepartment(Department department){
		 
			  hibernateTemplate.save(department);
				 
	}
	 

	 public void upadateDepartment(Department department){
		 
			  hibernateTemplate.update(department);		 
	}
	 
	 
	 
	 public void deleteDepartment(Department department){
		 
		  hibernateTemplate.delete(department);
			 
	}
}
