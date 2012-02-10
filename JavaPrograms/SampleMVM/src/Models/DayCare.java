package Models;
import java.util.ArrayList;


public class DayCare {
	String name;
	int SIZE = 20;
	ArrayList<Animal> animals;

	public DayCare(String name) {
		this.name = name;
		animals = new ArrayList<Animal>();
	}

	public String getName() {
		return name;
	}
	
	public boolean addAnmial(Animal animal) {
		if (animals.size() >= SIZE) {
			return false;
		}
		return animals.add(animal);
	}

	public boolean getAnimal(String name) {
		for (Animal ani : animals) {
			if (ani.getName().equals(name))
				return true;
		}
		return false;
	}

	public boolean getAnimal(Animal animal) {
		return animals.contains(animal);
	}
	public ArrayList<Animal> getAnimals(){
		return animals;
	}

}
