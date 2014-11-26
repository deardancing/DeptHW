import java.util.List;



import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;


import com.hibernate.annotation.entity.Department;
import com.hibernate.annotation.entity.Employee;



@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:hibernate.xml"})
public class EmployeeHibernateTemplateTest {

	@Autowired
	//เป็น class ที่ Spring provide ให้
	private HibernateTemplate hibernateTemplate;
	
	
	@Test
	public void testGetEmployeeByPK(){
		System.out.println(hibernateTemplate);
		
		//Get the employee using Spring 
		Employee em = hibernateTemplate.get(Employee.class,1);
		System.out.println(em.getName());
	}
	

	@Test
	public void testFindHSQL(){	
	List<Employee> eList =	hibernateTemplate.find("from Employee");
		
		for(Employee em:eList){
			System.out.println(em.getName());
			//System.out.println(em.getLastname());
		}
	}
	
	
	@Test
	@Transactional
	public void testFindHSQLDepartment(){	
	List<Department> dList =	hibernateTemplate.find("from Department");
		for(Department de:dList){
			System.out.println(de);
			//System.out.println(em.getLastname());
			//เป็นเรื่องของ transaction transaction มัน closed ไปแล้วถึง err
			 for(Employee em:de.getEmployeeList()){
				 System.out.println(em.getName());
			  }
 			}	
		}

	
	

	@Test
	public void testFindHSQLDepartmentEmployee(){	
		List<Employee> eList =	hibernateTemplate.find("from Employee");
		
		for(Employee em:eList){
			
			//System.out.println(em.getDepartment());
			System.out.println(em.getName());
			System.out.println(em.getDepartment().getDepartmentname());
			
		}
	}
	
	@Test
	public void testFindEmployeeWithHSQLByParameter() {
		// TODO Auto-generated method stub
		
		List<Employee> employees = hibernateTemplate.find("from Employee where id=?",new Integer[] {1});
		
		for(Employee em:employees){
			System.out.println("name "+em.getName());
		}

	}
	
	
	@Test
	public void testFindEmployeeWithNameQuery(){	
	List<Employee> eList =	hibernateTemplate.findByNamedQuery("findAllEmployee");
		for(Employee em : eList){
			System.out.println(em);
		}
	}

	
	
	@Test
	public void testFindEmployeeWithCriteria(){	
	
	DetachedCriteria criteria = DetachedCriteria.forClass(Employee.class);
	criteria.add(Restrictions.eq("name","Kik"));
	List<Employee> emList = hibernateTemplate.findByCriteria(criteria);
	for(Employee em : emList){
		System.out.println(em.getName());
	}
	
	}
	
	
	@Test
	public void testSaveEmployee(){	
	
	Department department = hibernateTemplate.get(Department.class, 1);
	System.out.println(department);
	
	Employee em = new Employee();
	em.setName("Test1");
	em.setDepartment(department);
	hibernateTemplate.save(em);
	
	}
	
	
	@Test
	public void testUpdateEmployee(){	
	
	Employee em = hibernateTemplate.get(Employee.class,14);
	em.setLastname("testttt");
	hibernateTemplate.update(em);;
	
	}
	
	

	@Test
	public void testDeleteEmployee(){	
	
	Employee em = hibernateTemplate.get(Employee.class,14);
	hibernateTemplate.delete(em);
	
	}
}
