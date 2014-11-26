package com.training.spring.service;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.DetachedCriteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hibernate.annotation.entity.Department;
import com.training.spring.dao.DepartmentDao;

@Service
public class DepartmentService {

@Autowired
DepartmentDao departmentDao;
		
		public Department findDepartment(Integer id){
				
			
			return departmentDao.findDepartmentById(id);
				
		}
	
	
		public List<Department> findAllDepartment(){
			
			
			return departmentDao.findAllDepartment();
			
		}
		
		
		public List<Department> findDepartmentByCriteria(DetachedCriteria criteria){
			
		
			return departmentDao.findDepartmentByCriteria(criteria);
			
		}
		
		
		public void insertDepartment(Department department){
			
		
			departmentDao.insertDepartment(department);
			
		}
		
		
		public void updateDepartment(Department department){
			
			departmentDao.upadateDepartment(department);
			
		}
		
		
		public void deleteDepartment(Department department){
			
			departmentDao.deleteDepartment(department);
			
		}
		
		
		
}
