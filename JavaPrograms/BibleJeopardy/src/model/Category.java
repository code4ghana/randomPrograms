package model;
import java.util.ArrayList;

public class Category {
	String name;
	ArrayList<Question> quesitons;

	public Category(String name, ArrayList<Question> questions) {
		this.name = name;
		this.quesitons = questions;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ArrayList<Question> getQuesitons() {
		return quesitons;
	}

	public void setQuesitons(ArrayList<Question> quesitons) {
		this.quesitons = quesitons;
	}

}
