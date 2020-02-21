package bootcamp.game;

import java.util.Scanner;

public class TestGame {
	
	String q1 = "What was Java originally called?\r\n" + 
			"a.) Oak\r\n" + 
			"b.) Spruce\r\n" + 
			"c.) Latte\r\n" + 
			"d.) Chai\r\n"; 
	
	String q2 = "How many platforms does Java have?\r\n" + 
			"a.) One\r\n" + 
			"b.) Three\r\n" + 
			"c.) Four\r\n" + 
			"d.) Seven\r\n";
	
	String q3 = "Choose the best definition for a Class: \n"
			+ "A. An action for a program. \n"
			+ "B. An object definition, containing the data and function elements necessary to create an object. \n"
			+ "C. A group of students in a class. \r\n";
			
	String q4 = "Given the declaration: int [ ] arr = {1,2,3,4,5}; What is the value of arr[3]? \n"
			+ "A. 3 \n"
			+ "B. 4 \n"
			+ "C. 5 \r\n";
	
	String q5 = "Choose the best definition of an object. \n"
			+ "A. A thing. \n"
			+ "B. Something you wear. \n"
			+ "C. An instance of a class. \r\n";
	
	String q6 = "What is the proper way to declare a variable? \n"
			+ "A. VariableName; \n"
			+ "B. VariableType variableName; \n"
			+ "C. VariableName variableType; \r\n";
			
	String q7 = "What is a loop?  \n"
			+ "A. A segment of code to be run infinite times. \n"
			+ "B. A segment of code to be run once.  \n"
			+ "C. A segment of code to be run a specified amount of times. \r\n";
	
	String q8 = "What is the size of a Char in Java? \n"
			+ " A.  16 bits \n"
		    + " B.  7 bits \n"
		    + " C.  8 bits \n"
		    + " D.  4 bits.";
	
	String q9 = "What is the keyword used in java to create an object? \n"
			+ " A.  This \n"
			+ " B.  Sync \n"
		    + " C.  New \n"
			+ " D.  New() ";
	
	String q10 = "If you want your condition to depend upon two conditions BOTH being true. \n" 
			+ "What is the propper notation to put between the two Boolean statements?\n "
			+ " A. 	&& \n"
			+ " B.  ! \n"
		    + " C.  == \n"
			+ " D.  ||  ";
			
			

	////Explanations 
	String exp1 = "The earliest version of Java was known as Oak. This was inspired by a big oak tree that \r\n"
			+ "grew outside the window of the lead creator of Java, "
			+ "James Gosling. It was later changed to Java by Sun’s marketing department when Sun lawyers found that there was already "
			+ "a computer company registered as Oak.";
	
	String exp2 = "Java has 4 platforms: JavaStandard Edition, JavaEnterprise Edition, JavaMicro Edition, and JavaFX.";
	
	String exp3 = "Classes and Objects are basic concepts of Object Oriented Programming which revolve around the real life entities.\n"
			+ "A class is a user defined blueprint or prototype from which objects are created. \n"
			+ "It represents the set of properties or methods that are common to all objects of one type.";
	
	String exp4 = "Because in Java elements start counting from 0. Element [0] is \"1\", so element [3] is \"4\".";
	
	String exp5 = "It is a basic unit of Object Oriented Programming and represents the real life entities. \n"
			+ "A typical Java program creates many objects, which as you know, interact by invoking methods.";
	
	String exp6 = "We can declare variables in java as follows: type: Type of data that can be stored in this variable.\n"
			+ " name: Name given to the variable.";
	
	String exp7 = "Looping in programming languages is a feature which facilitates the execution of a set of instructions/functions repeatedly \n"
			+ " while some condition evaluates to true. Java provides three ways for executing the loops. \n"
			+ "While all the ways provide similar basic functionality, they differ in their syntax and condition checking time. ";
	
	String exp8 = "Char size is 16 bit i.e 2 byte. ";
	
	String exp9 = "Using new keyword is the most basic way to create an object. This is the most common way to create an object in java. \n"
				+ " Almost 99% of objects are created in this way. ";
	
	String exp10 = "&& Conects two boolean expresions into one. Both expresions must be true for the overall expresion to be true";
	
	
	
	Question [] questions = { 
			new Question (q1, "a", exp1), 
			new Question (q2, "c", exp2), 
			new Question (q3, "b", exp3), 
			new Question (q4, "b", exp4),
			new Question (q5, "c", exp5),
			new Question (q6, "b", exp6),
			new Question (q7, "c", exp7),
			new Question (q8, "a", exp8),
			new Question (q9, "c", exp9),
			new Question (q10, "a", exp10),
	}; 
	
	
		public static void main(String[] args) {
			
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

		public boolean checkAnswer(String userAnswer, String correctAnswer, String explanation) {
			
			if (userAnswer.equalsIgnoreCase(correctAnswer)) {
				System.out.println("Great job! You earned 1 point");
				return true;
			} else {
				System.out.println("Sorry, the answer is: " + correctAnswer + " " + explanation);
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
					if (checkAnswer(userAnswer, questions[i].answer, questions[i].explanation) == true) {
						score = countScore(score);
					}
					if (doesWantToQuit(score) == true) {
						break;
					}

				}
				
			}
			printScore(score);

		}
	   public void wantsToRepeat() {
		   boolean wantstoRpeat = true;
		  while(wantstoRpeat == true) {
			   askNextQuestion(questions);
			  wantstoRpeat = doesWantToRepeat();
		  }
	   }
	   
	   public void printScore(int score) {
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
	   
	   public void printExplanation(String explanation) {
			 System.out.println(explanation);
			}
	  
	   
}