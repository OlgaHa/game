package bootcamp.game;

import java.util.Scanner;

public class TestGame {
	

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

	Question[] questions = { new Question(q1, "a", exp1), new Question(q2, "c", exp2), new Question(q3, "b", null),
			new Question(q4, "b", null), new Question(q5, "c", null), new Question(q6, "b", null),
			new Question(q7, "c", null), new Question(q8, "a", null), new Question(q9, "c", null),
			new Question(q10, "a", null), };


	public static void main(String[] args) {

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
		
		TestGame game = new TestGame();
		game.wantsToRepeat();

	}

	public void askQuestion(String question) {
		System.out.println(question);

	}

	public boolean checkAnswer(String userAnswer, String correctAnswer) {
		if (userAnswer.equalsIgnoreCase(correctAnswer)) {
			System.out.println("Great job!");
			return true;
		} else {
			System.out.println("Sorry, the answer is: " + correctAnswer);
			return false;
		}
	}

	public int countScore(int score) {
		 score++;
		 return score;
	}

	public boolean doesWantToQuit(int score) {
		System.out.println("Do you want to quit game? Y/N");
		Scanner ifwantsQuitInp = new Scanner(System.in);
		String ifwantsQuit = ifwantsQuitInp.nextLine();
		if (ifwantsQuit.equalsIgnoreCase("y")) {
			System.out.println("Thank you! Game is over" + " your score is " + score);
			return true;
		} else {
			return false;
		}
	}

	public boolean doesWantToRepeat() {
		System.out.println("Do you want to repeat game? Y/N");
		Scanner ifwantsRepeatInp = new Scanner(System.in);
		String ifwantsRepeat = ifwantsRepeatInp.nextLine();
		if (ifwantsRepeat.equalsIgnoreCase("y")) {
			return true;
		} else {
			return false;
		}
	}

	public void askNextQuestion(Question[] questions) {
		int score = 0;
		for (int i = 0; i < questions.length; i++) {
			askQuestion(questions[i].prompt);
			Scanner inputuserInput = new Scanner(System.in);
			String userAnswer = inputuserInput.nextLine();
			if (!userAnswer.equalsIgnoreCase("a") && !userAnswer.equalsIgnoreCase("b") && !userAnswer.equalsIgnoreCase("c") && !userAnswer.equalsIgnoreCase("d") && !userAnswer.equalsIgnoreCase("e")) {
				System.out.println("Please, check your answer");
				i--;
			} 
			else {
				if (checkAnswer(userAnswer, questions[i].answer) == true) {
					score = countScore(score);
				}
				if (doesWantToQuit(score) == true) {
					break;
				}

			}
			
		}

	}
   public void wantsToRepeat() {
	   boolean wantstoRpeat = true;
	  while(wantstoRpeat == true) {
		   askNextQuestion(questions);
		  wantstoRpeat = doesWantToRepeat();
	  }
   }
}

