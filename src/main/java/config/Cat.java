package config;

public class Cat implements Animaltype{

	private String myName;
	

	public String getMyName() {
		return myName;
	}



	public void setMyName(String myName) {
		this.myName = myName;
	}



	public void sound() {
		// TODO Auto-generated method stub
		System.out.println("Cat : "+myName +"-Meow");
	}
	
}
