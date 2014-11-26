import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.hibernate.annotation.entity.Department;
import com.hibernate.annotation.entity.Employee;
import com.training.spring.service.DepartmentService;
import com.training.spring.service.EmployeeService;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:hibernate.xml"})
public class TestService {
	
	@Autowired
	private EmployeeService employeeService;
	@Autowired
	private DepartmentService departmentService;
	
	Employee em;
	
	
	@Test
	public void testFindEmployeeByIdShouldFoundData() throws Exception{
		
		Employee em = employeeService.findEmployee(1);
		System.out.println(em);
		
	}
	
	
	@Test
	public void testFindAllEmployee() throws Exception{
		
		List<Employee> em = employeeService.findAllEmployee();
		for(Employee e:em){
		System.out.println(e.getName());
		}
		
	}
	
	
	
	@Test
	public void testSaveEmployee() throws Exception{
    	Department department = departmentService.findDepartment(1);
    	Employee em = new Employee();
    	em.setName("apiva1123465");
    	em.setDepartment(department);
		employeeService.saveEmployee(em);
		
	}
	
	@Test
	public void testUpadteEmployee() throws Exception{
		
		 Employee em  = employeeService.findEmployee(20);
		 em.setAge(23);
		 employeeService.updateEmployee(em);
		
	}
	
	
	@Test
	public void testDeleteEmployee() throws Exception{
		
		Employee em  = employeeService.findEmployee(20);
		 em.setAge(23);
		employeeService.deleteEmployee(em);
		
	}
	
	
	@Test
	public void testFindAllDepartment() throws Exception{
		
		List<Department> department  = departmentService.findAllDepartment();
		for(Department depart:department)
		System.out.println(depart.getDepartmentname());
		
	}
	
	

	@Test
	public void testFindDepartmentById() throws Exception{
		
		Department department  = departmentService.findDepartment(1);
		System.out.println(department.getDepartmentname());
		
	}
	
	@Test
	@Transactional
	public void testFindEmployeeBlindDepartment() throws Exception{
		
		Department department  = departmentService.findDepartment(1);
		List<Employee>Em = department.getEmployeeList();
		for(Employee e:Em){
			System.out.println(e.getName());
		}
		
	}
	
	
	@Test
	public void testFindDepartmentByCriteria() throws Exception{
		
		DetachedCriteria criteria = DetachedCriteria.forClass(Department.class);
		criteria.add(Restrictions.eq("departmentname", "IT"));
			
		List<Department> department = departmentService.findDepartmentByCriteria(criteria);
		for(Department de:department){
			System.out.println(de.getDepartmentname());
		}
			
	}
	
	
	
	@Test
	public void testInsertDepartment() throws Exception{
		
		Department deSUP = new Department();
		deSUP.setDepartmentname("Support");
		Department deHR = new Department();
		deHR.setDepartmentname("HR");
		departmentService.insertDepartment(deSUP);
		departmentService.insertDepartment(deHR);
	}
	
	
	@Test
	public void testUpdateDepartment() throws Exception{
		Department depart = departmentService.findDepartment(3);
		depart.setDepartmentname("Technical");
		departmentService.updateDepartment(depart);
		
		
	}
	
	
	@Test
	public void testDeleteDepartment() throws Exception{
		Department department = departmentService.findDepartment(3);
		departmentService.deleteDepartment(department);
		
		
	}

}
