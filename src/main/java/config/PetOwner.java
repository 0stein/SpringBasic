package config;

import org.springframework.beans.factory.annotation.Autowired;

public class PetOwner {

	public Animaltype animal;
	
	public PetOwner(Animaltype animal) {
		this.animal = animal;
	}
	
	public void play() {
		animal.sound();
	}
}
