package bootcamp.game;

import java.io.File;
import java.util.Scanner;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

public class GameTestReader {

	public static void main(String[] args) throws Exception {
//Scanner for Questions
		//System.out.println(new File(".").getAbsolutePath()); to get a file path
		String fileName = "./bootcamp/game/Questions.txt";
		Path path = Paths.get(fileName);
		Scanner scanner = new Scanner(path);
		scanner.useDelimiter("/");

//Scanner for explanations 
		String fileNameExpl = "./bootcamp/game/Explanations.txt";
		Path path2 = Paths.get(fileNameExpl);
		Scanner scannerExpl = new Scanner(path2);
		scannerExpl.useDelimiter("/");

//Scanner for answers 
		String fileNameAnsw = "./bootcamp/game/Answers.txt";
		Path path3 = Paths.get(fileNameAnsw);
		Scanner scannerAnsw = new Scanner(path3);
		scannerAnsw.useDelimiter(System.getProperty("line.separator"));
		

		ArrayList<Question> questions = new ArrayList<>();
		for (int i = 0; scanner.hasNext() && scannerExpl.hasNext() && scannerAnsw.hasNext(); i++) {
			questions.add(new Question(scanner.next(), scannerAnsw.next(), scannerExpl.next()));
		}

		// Game start
		// Greeting
		Scanner inputHello = new Scanner(System.in);
		System.out.println("Hi! Do you want to play Java Trivia? (Answer Y/N)");
		String answerYN = inputHello.nextLine();
		if (answerYN.equalsIgnoreCase("Y")) {
			System.out.println("Great! Let's play!");
			// Asks questions
			GameTestReader test = new GameTestReader();
			test.askQuestion(questions);
		}

		else {
			System.out.println("Have a nice day!");

		}
		scanner.close();
	}
	//a method to ask questions 
	public void askQuestion(ArrayList<Question> questions) {
		int score = 0;
		for (int i = 0; i < questions.size(); i++) {
			System.out.println(questions.get(i).prompt);
			Scanner inputuserInput = new Scanner(System.in);
			String userAnswer = inputuserInput.nextLine();
			if (userAnswer.equalsIgnoreCase(questions.get(i).answer)) {
				++score;
				System.out.println("Great job! You earned one point, your score is: " + score);
			} else {
				System.out.println(
						"Sorry, correct answer is:  " + questions.get(i).answer + " " + questions.get(i).explanation);
			}
		}
		printScore(score);
	}

	//a method to announce total score 
	public void printScore(int score) {
		if (score <= 3) {
			System.out.println("Total: "+score + " points."+"You’re just a Java beginner. Time to hit the books and do a bit more studying.");
		} else if (score > 3 && score <= 5) {
			System.out.println(
					"Total: "+score + " points."+"You’re pretty solid in your Java history, but it might behoove you to pay a little more attention to the details.");
		} else if (score > 5 && score <= 7) {
			System.out.println("Total: "+score + " points."+"Nice! You know your stuff!");

		} else if (score > 7) {
			System.out.println("Total: "+score + " points."+"You are a Java master!");
		}
	}
}