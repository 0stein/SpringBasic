package config;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("config/Animal.xml");
		PetOwner petOwmer = applicationContext.getBean("petOwner",PetOwner.class);
		petOwmer.play();
	}

}
