import java.util.List;




import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.hibernate.annotation.entity.Employee;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:hibernate.xml"})
public class EmployeeSessionFactoryTest {

	
	
	
	@Autowired
	private SessionFactory sessionFactory;

	
	
	
	@Test
	public void testGetSessionFromSessionFactory() {
	Session session = sessionFactory.openSession();
		Employee em = (Employee) session.get(Employee.class, 1);
		System.out.println(em);
		session.close();
	}
	
	
	@Test
	public void testFindHQLByFirstName(){
		 
		Session session = sessionFactory.openSession();
		List<Employee> employeeList = session.createQuery("from Employee where name='Kik'").list();
		System.out.println(employeeList);
	}
	
	
	@Test
	public void testFindCriteriaByFirstName(){
		 
		Session session = sessionFactory.openSession();
		Criteria criteria =  session.createCriteria(Employee.class);
		criteria.add(Restrictions.eq("name","Kik"));
		List<Employee> em = criteria.list();
		System.out.println(em);
		
	}
	
	

	

	@Value("Kik")
	String namee;
	
	@Test
	public void testFindByNameQuery(){
		 
		Session session = sessionFactory.openSession();
		Query query = session.getNamedQuery("findByFirstName");
	
		query.setParameter("A_FIRST_NAME",namee);
		List<Employee> emList = query.list();
		System.out.println(emList);
		session.close();
	}
	
}
