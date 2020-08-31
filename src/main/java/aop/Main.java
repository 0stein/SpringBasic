package aop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

	public static void main(String[] args) {
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("aop/setting.xml");
		
		DemoService demoService = applicationContext.getBean(DemoService.class);
		
		Member member1 = new Member(1, "park");
		Member member2 = new Member(2, "park");
		Member member3 = new Member(3, "park");
		Member member4 = new Member(4, "park");
		
		demoService.store(member1);
		demoService.store(member2);
		demoService.store(member3);
		demoService.store(member4);
		
		for(int i=0; i<4; i++) {
			System.out.println(demoService.getMemberById(i+1));			
		}
	}

}
