package polymorphism;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class TvUser {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		

		
		// BeanFactory fac = new BeanFactory();
		// TV tv = fac.getBean("lg");
		

	
		
		AbstractApplicationContext factory = new GenericXmlApplicationContext("applicationContext.xml");
		
		TV tv1 = (TV) factory.getBean("samsung");

		
		tv1.powerOn();
		tv1.volumeUp();
		tv1.volumeDown();
		tv1.powerOff();
		
		TV tv2 = (TV) factory.getBean("lg");

		
		tv2.powerOn();
		tv2.volumeUp();
		tv2.volumeDown();
		tv2.powerOff();

		factory.close();
	}

}
