package config;

public class Dog implements Animaltype{

	private String myName;

	
	public String getMyName() {
		return myName;
	}


	public void setMyName(String myName) {
		this.myName = myName;
	}


	public void sound() {
		// TODO Auto-generated method stub
		System.out.println("Dog: "+myName+"-Woof");
	}

	
}
