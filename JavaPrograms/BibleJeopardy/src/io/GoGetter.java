package io;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import model.Category;
import model.Question;

public class GoGetter {
	public static Category getFromFile(File f) {
		Scanner scan;
		try {
			scan = new Scanner(f);

			ArrayList<Question> questions = new ArrayList<Question>();
			while (scan.hasNextLine()) {
				ArrayList<String> choices=new ArrayList<String>();
				String question = scan.nextLine();
				String answer = "";
				String[] letters={"A) ", "B) ","C) ","D) "};
				for(int i=0;i<4;i++){
					String choice=scan.nextLine();
					if(choice.startsWith("*")){
						choice=choice.substring(1);
						choice=letters[i]+choice;
						answer=choice.trim();
						choices.add(choice.trim());
						continue;
					}
					choice=letters[i]+choice;
					choices.add(choice.trim());
				}
				questions.add(new Question(question, choices, answer, (questions.size()+1)*100));
				if (scan.hasNextLine()) {
					scan.nextLine();
				}

			}
			return new Category(f.getName().substring(0,
					f.getName().indexOf(".txt")), questions);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("error reading file " + f.getName());
			return null;

		}

	}

	public static ArrayList<Category> getQuestions() {
		String[] catFiles = { "verses.txt", "places.txt", "prophets.txt","people.txt","ChurchHistory.txt" };
//		String[] catFiles={"people.txt","places.txt"};
		ArrayList<Category> categories = new ArrayList<Category>();
		for (int i = 0; i < catFiles.length; i++) {
			categories.add(getFromFile(new File(catFiles[i])));
		}
		return categories;
	}
}
