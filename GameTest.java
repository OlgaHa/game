package bootcamp.game;

import java.util.Scanner;

public class GameTest {

	public static void main(String[] args) {

		String q1 = "What was Java originally called?\r\n" + "a.) Oak\r\n" + "b.) Spruce\r\n" + "c.) Latte\r\n"
				+ "d.) Chai\r\n";

		String q2 = "How many platforms does Java have?\r\n" + "a.) One\r\n" + "b.) Three\r\n" + "c.) Four\r\n"
				+ "d.) Seven\r\n";

		String q3 = "Choose the best definition for a Class: \n" + "A. An action for a program. \n"
				+ "B. An object definition, containing the data and function elements necessary to create an object. \n"
				+ "C. A group of students in a class. \r\n";

		String q4 = "Given the declaration: int [ ] arr = {1,2,3,4,5}; What is the value of arr[3]? \n" + "A. 3 \n"
				+ "B. 4 \n" + "C. 5 \r\n";

		String q5 = "Choose the best definition of an object. \n" + "A. A thing. \n" + "B. Something you wear. \n"
				+ "C. An instance of a class. \r\n";

		String q6 = "What is the proper way to declare a variable? \n" + "A. VariableName; \n"
				+ "B. VariableType variableName; \n" + "C. VariableName variableType; \r\n";

		String q7 = "What is a loop?  \n" + "A. A segment of code to be run infinite times. \n"
				+ "B. A segment of code to be run once.  \n"
				+ "C. A segment of code to be run a specified amount of times. \r\n";

		String q8 = "If classes Student, Staff and Faculty extend class Person, which one makes sense:  \n"
				+ "A. Person[] persons={new Faculty(), new Staff(), new Student()};  \n"
				+ "B. Faculty[] faculties={new Person(), new Faculty(), new Student()};  \n"
				+ "C. Staff[] staff={new Person(), new Staff(), new Student()};  \n";

		String q9 = "Which one needs a web page to run?  \n" + "A. A Java Application  \n"
				+ "B. A Java Stand-Alone Application  \n" + "C. A Java Applet  \n";

		String q10 = "What is the main function of any variable ?  \n"
				+ "A. To keep track of data in the memory of the computer  \n" + "B. To print words on the screen  \n"
				+ "C. To add numbers together  \n";

		//// Explanations
		String exp1 = "The earliest version of Java was known as Oak. This was inspired by a big oak tree that \r\n"
				+ "grew outside the window of the lead creator of Java, "
				+ "James Gosling. It was later changed to Java by Sun’s marketing department when Sun lawyers found that there was already "
				+ "a computer company registered as Oak.";

		String exp2 = "Java has 4 platforms: JavaStandard Edition, JavaEnterprise Edition, JavaMicro Edition, and JavaFX.";

		Questions[] question = { new Questions(q1, "a", exp1), new Questions(q2, "c", exp2),
				new Questions(q3, "b", null), new Questions(q4, "b", null), new Questions(q5, "c", null),
				new Questions(q6, "b", null), new Questions(q7, "c", null), new Questions(q8, "a", null),
				new Questions(q9, "c", null), new Questions(q10, "a", null), };

		// Game test
		Scanner inputHello = new Scanner(System.in);
		System.out.println("Hi! Do you want to play Java Trivia? (Answer Y/N)");
		String answerYN = inputHello.nextLine();

		if (answerYN.equalsIgnoreCase("Y")) {
			System.out.println("Great! Let's play!");

		} else if (answerYN.equalsIgnoreCase("N")) {
			System.out.println("Have a nice day!");

		} else {
			System.out.println("Please, answe with Y or N.");
		}
		boolean wantsToPlay;
		while (wantsToPlay = true) {
			playGame(question);
			wantsToPlay = ifWantsToRepeat();
		}
	}

	// My Methods
	public static void playGame(Questions[] question) {
		int i = 0;
		int score = 0;
		Scanner userInput = new Scanner(System.in);
		while (i < question.length) {
			System.out.println(question[i].prompt);
			String answer = userInput.nextLine();

			if (isInputValid(answer)) {

				if (answer.equalsIgnoreCase(question[i].answer)) {
					score++;
					System.out.println("Great job! You earned 1 point");
					System.out.println(question[i].explanation + " \r\n");
					toQuitGame();

				}

				else {
					System.out.println(
							"Sorry, the answer is: " + question[i].answer + ".  " + question[i].explanation + " \r\n");
					toQuitGame();
				}
				i++;
			}

		}
		System.out.println("Your score is:  " + score);
		countScore(score);
	}

	public static void toQuitGame() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Do you want to continue? Y/N");
		String userDecision = sc.nextLine();
		if (userDecision.equalsIgnoreCase("n")) {
			System.out.println("Thank you! Have a nice day!");
		}

	}

	public static boolean isInputValid(String inp) {
		if (!inp.equalsIgnoreCase("a") && !inp.equalsIgnoreCase("b") && !inp.equalsIgnoreCase("c")
				&& !inp.equalsIgnoreCase("d") && !inp.equalsIgnoreCase("e")) {
			System.out.println("Sorry, a wrong input. Please, try again");
			return false;
		} else
			return true;
	}

	public static boolean ifWantsToRepeat() {
		System.out.println("Do you want to try again? Y/N");
		Scanner sc = new Scanner(System.in);
		String userinp2 = sc.nextLine();
		if (userinp2.equalsIgnoreCase("y")) {
			return true;
		} else {
			System.out.println("Thank you! Have a nice day!");
			return false;
		}
	}

	public static void countScore(int score) {
		if (score <= 3) {
			System.out.println("You’re just a Java beginner. Time to hit the books and do a bit more studying.");
		} else if (score > 3 && score <= 5) {
			System.out.println(
					"You’re pretty solid in your Java history, but it might behoove you to pay a little more attention to the details.");
		}

		else if (score > 5 && score <= 7) {
			System.out.println("Nice! You know your stuff!");

		} else if (score > 7) {
			System.out.println("You are a Java master.");
		}
	}

}
