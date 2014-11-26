import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.training.spring.bean.ExampleComponent;
import com.training.spring.bean.Hello;
import com.training.spring.bean.Humen;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:applicationContext.xml"})
public class BeanTest {

	@Autowired
	private Hello hello;
	@Autowired
	private Humen humen;
	@Autowired
	private ExampleComponent example;
	
	@Test
	public void testBean(){
		
		
			System.out.println("test");
			ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
	        Hello hello = (Hello) context.getBean("hello");
	        System.out.println("############### Hello ###################");
	        System.out.println("hello : " + hello);
	        System.out.println("hello.humen : " + hello.getHumen());

	}
	
	
	@Test
	public void testAutowiredBean(){
        System.out.println(hello);
	}
	
	

	@Test
	public void testAutowiredHumenBean(){
        System.out.println(hello);
	}
	
	
	
	
	@Test
	public void testExampleComponent(){
		System.out.println("show message: "+example);
		System.out.println("show message: "+example.getHello());
		System.out.println("show message: "+example.getHumen());
		System.out.println("show message: "+example.getMessage());
		System.out.println("show message: "+example.getAdd());
	}
}
