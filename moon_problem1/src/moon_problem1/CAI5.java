package moon_problem1;

import java.util.Scanner;
import java.security.SecureRandom;

public class CAI5 {
	
	
	public static void main(String[] args) 
	{
		// runs the program by only calling the quiz method
		quiz();	
	}
	 
	public static int SecureRandomNumber(int difficulty) 
	{
		SecureRandom secureRandomGenerator = new SecureRandom();
	    int difficultyLevel = difficulty;
		// Get 128 random bytes
		byte[] randomBytes = new byte[128];
		secureRandomGenerator.nextBytes(randomBytes);
	    
		// difficulty level 1 (range 0-9 inclusive)
		if (difficultyLevel == 1)
		{
			// Get random integer in range
			int randInRange = secureRandomGenerator.nextInt(10);
			
			return randInRange;
		}
		
		// difficulty level 2 (range 0-99 inclusive)
		if (difficultyLevel == 2)
		{
			// Get random integer in range
			int randInRange = secureRandomGenerator.nextInt(100);
			
			return randInRange;
		}
		
		// difficulty level 3 (range 0-999 inclusive)
		if (difficultyLevel == 3)
		{
			// Get random integer in range
			int randInRange = secureRandomGenerator.nextInt(1000);
			
			return randInRange;
		}
		
		// difficulty level 4 (range 0-9999 inclusive)
		if (difficultyLevel == 4)
		{
			// Get random integer in range
			int randInRange = secureRandomGenerator.nextInt(10000);
			
			return randInRange;
		}
		
		return 0;

	}	
	
	public static int SecureRandomNumber2() 
	{
		
		SecureRandom secureRandomGenerator = new SecureRandom();
	         
		// Get 128 random bytes
		byte[] randomBytes = new byte[128];
		secureRandomGenerator.nextBytes(randomBytes);
	         
		//Get 1st random integer in range
		int randInRange = ( secureRandomGenerator.nextInt(4) ) + 1;
		
		return randInRange;
	}	
	
	public static int SecureRandomNumber3() 
	{
		SecureRandom secureRandomGenerator = new SecureRandom();
	         
		// Get 128 random bytes
		byte[] randomBytes = new byte[128];
		secureRandomGenerator.nextBytes(randomBytes);
	         
		//Get 1st random integer in range
		int randInRange = ( secureRandomGenerator.nextInt(5) ) + 1;
		
		return randInRange;
	}
	
	public static void quiz()
	{
		int correctAnswerCounter = 0;
		System.out.println("\nWelcome to the math quiz program!\n");
		int difficulty = readDifficulty();
		int problemType = readProblemType();
		
		
		
		// contains the program logic
		for (int i = 1; i <= 10; i++)
		{
			
			// gets random integer 1
			int randomInteger1 = generateQuestionArgument(difficulty);
			
			// gets random integer 2
			int randomInteger2 = generateQuestionArgument(difficulty);
			System.out.printf("Question %d:\n", i);
			
			// ask user a question
			correctAnswerCounter += askQuestion(randomInteger1, randomInteger2, problemType);
		}
		
		displayCompletionMessage(correctAnswerCounter);

	}
	
	public static int readProblemType()
	{
		
		System.out.println("Please enter 1 for addition problems, 2 for multiplication problems, "
				+ "3 for subtraction problems, 4 for division problems, "
				+ "or 5 for a random selection of addition, multiplication, subtraction, and division problems:");
		
		Scanner scanner = new Scanner(System.in);
		
		int problemType = scanner.nextInt();
		
		if (problemType == 1)
		{
			System.out.println("You selected 1 for addition problems.\n");
		}
		if (problemType == 2)
		{
			System.out.println("You selected 2 for multiplication problems.\n");
		}
		if (problemType == 3)
		{
			System.out.println("You selected 3 for subtraction problems.\n");
		}
		if (problemType == 4)
		{
			System.out.println("You selected 4 for division problems.\n");
		}
		if (problemType == 5)
		{
			System.out.println("You selected 5 for a random selection of addition, multiplication, subtraction, and division problems.\n");
		}
		
		return problemType;
		
	}
	
	public static int generateQuestionArgument(int difficulty)
	{
		int randomNumber = SecureRandomNumber(difficulty);
		return randomNumber;
	}
	
	public static int readDifficulty()
	{
		System.out.println("Please select difficulty level. Enter 1 for easy, 2 for medium, 3 for challenging, 4 for extremely difficult:");
		Scanner scanner = new Scanner(System.in);
		
		int difficulty = scanner.nextInt();
		System.out.printf("You selected level %d difficulty.\n\n", difficulty);
		return difficulty;
	}
	
	public static int askQuestion(int genNum1, int genNum2, int questionType)
	{
		int correctAnswerCounter = 0;
		
		// ask the correct question type
		
		// addition
		if (questionType == 1)
		{
			// prints the problem to the screen
			System.out.printf("How much is %d plus %d?\n", genNum1, genNum2);
			correctAnswerCounter = readResponse(genNum1, genNum2, questionType);
			return correctAnswerCounter;
		}
		
		// multiplication
		if (questionType == 2)
		{
			// prints the problem to the screen
			System.out.printf("How much is %d times %d?\n", genNum1, genNum2);
			correctAnswerCounter = readResponse(genNum1, genNum2, questionType);
			return correctAnswerCounter;
		}		

		// subtraction
		if (questionType == 3)
		{
			// prints the problem to the screen
			System.out.printf("How much is %d minus %d?\n", genNum1, genNum2);
			correctAnswerCounter = readResponse(genNum1, genNum2, questionType);
			return correctAnswerCounter;
		}		
		
		// division
		if (questionType == 4)
		{
			// prints the problem to the screen
			System.out.printf("How much is %d divided by %d?\n", genNum1, genNum2);
			correctAnswerCounter = readResponse(genNum1, genNum2, questionType);
			return correctAnswerCounter;
		}	

		// random assortment
		if (questionType == 5)
		{
			// calls this function using random number between 1-4 to select from random add, sub, mult, div problems
			questionType = SecureRandomNumber3();
			askQuestion(genNum1, genNum2, questionType);
		}	
		
		return 0;
	}
	
	public static int readResponse(int genNum1, int genNum2, int questionType)
	{	
		int correctAnswerCounter = 0;
		// reads the answer from the student
		Scanner scanner = new Scanner(System.in);
		int userAnswer = scanner.nextInt();
		
		correctAnswerCounter = isAnswerCorrect(genNum1, genNum2, userAnswer, questionType);
		return correctAnswerCounter;
	}
	
	public static int isAnswerCorrect(int genNum1, int genNum2, int userAnswer, int questionType)
	{
		// checks to see if the student's answer matches the correct answer to the problem
		int usersAnswer = userAnswer;
		int correctAnswer = 0;
		// addition
		if (questionType == 1)
		{
			correctAnswer = genNum1 + genNum2;
		}
		
		// multiplication
		if (questionType == 2)
		{
			correctAnswer = genNum1 * genNum2;
			
		}		

		// subtraction
		if (questionType == 3)
		{
			correctAnswer = genNum1 - genNum2;
		}		
		
		// division
		if (questionType == 4)
		{
			correctAnswer = genNum1 / genNum2;
		}		
				
		
		// set to 0 if incorrect set to 1 if correct
		int isCorrect = 1;
		int correctAnswerCounter = 0;
		
		if (usersAnswer != correctAnswer)
		{
			isCorrect = 0;
			correctAnswerCounter = displayIncorrectResponse(genNum1, genNum2);
			return correctAnswerCounter;
		}
		
		correctAnswerCounter = displayCorrectResponse();
		return correctAnswerCounter;
	}
	
	public static int displayCorrectResponse()
	{
		// prints out the response when a student enters a correct answer
		int randomInteger = SecureRandomNumber2();
		
		switch(randomInteger)
		{
			case 1:
				System.out.println("Very good!");
				break;
			case 2:
				System.out.println("Excellent!");
				break;
			case 3:
				System.out.println("Nice Work!");
				break;
			case 4:
				System.out.println("Keep up the good work!");
				break;
		}
		
		return 1;
	}
	
	
	public static int displayIncorrectResponse(int genNum1, int genNum2)
	{
		// prints out the response when a student enter an incorrect answer
		int randomInteger = SecureRandomNumber2();
		
		switch(randomInteger)
		{
			case 1:
				System.out.println("No. Please try again.");
				break;
			case 2:
				System.out.println("Wrong. Try once more.");
				break;
			case 3:
				System.out.println("Don't give up!");
				break;
			case 4:
				System.out.println("No. Keep trying.");
				break;
		}
		
		return 0;

	}
	
	public static void displayCompletionMessage(int correctAnswerCounter)
	{
		double totalProblems = 10.0;
		double testPercentage = 0;
		double correctAnswers = (double)correctAnswerCounter;
		Scanner scanner = new Scanner(System.in);
		
		testPercentage = correctAnswers / totalProblems;
		
		if (testPercentage >= 0.75)
		{
			System.out.println("\nCongratulations, you are ready to go to the next level!\n");
		}
		else
		{
			System.out.println("\nPlease ask your teacher for extra help.\n");
		}
		
		System.out.println("Do you want to solve another problem set?");
		System.out.println("Press 1 for yes, 2 for no.");
		int userSelection = scanner.nextInt();
		if (userSelection == 1)
		{
			quiz();
		}
		else
		{
			System.out.println("\nYou selected to exit the program. Goodbye!");
			System.exit(0);
		}
		
	}

}
