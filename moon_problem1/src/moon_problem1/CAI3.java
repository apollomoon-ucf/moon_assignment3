package moon_problem1;

import java.util.Scanner;
import java.security.SecureRandom;

public class CAI3 {
	
	
	public static void main(String[] args) 
	{
		// runs the program by only calling the quiz method
		quiz();	
	}
	 
	public static int SecureRandomNumber() 
	{
		SecureRandom secureRandomGenerator = new SecureRandom();
	         
		// Get 128 random bytes
		byte[] randomBytes = new byte[128];
		secureRandomGenerator.nextBytes(randomBytes);
	         
		//Get 1st random integer in range
		int randInRange = secureRandomGenerator.nextInt(10);
		
		return randInRange;
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
	
	public static void quiz()
	{
		int correctAnswerCounter = 0;
		
		System.out.println("\nWelcome to the math quiz program!\n");
		
		// contains the program logic
		for (int i = 1; i <= 10; i++)
		{
			System.out.printf("Question %d:\n", i);
			// gets random integer 1
			int randomInteger1 = SecureRandomNumber();
			// gets random integer 2
			int randomInteger2 = SecureRandomNumber();
			// ask user a question
			correctAnswerCounter += askQuestion(randomInteger1, randomInteger2);
		}
		
		displayCompletionMessage(correctAnswerCounter);

	}
	
	public static int askQuestion(int genNum1, int genNum2)
	{
		int correctAnswerCounter = 0;
		// prints the problem to the screen
		System.out.printf("How much is %d times %d?\n", genNum1, genNum2);
		correctAnswerCounter = readResponse(genNum1, genNum2);
		return correctAnswerCounter;
	}
	
	public static int readResponse(int genNum1, int genNum2)
	{	
		int correctAnswerCounter = 0;
		// reads the answer from the student
		Scanner scanner = new Scanner(System.in);
		int userAnswer = scanner.nextInt();
		
		correctAnswerCounter = isAnswerCorrect(genNum1, genNum2, userAnswer);
		return correctAnswerCounter;
	}
	
	public static int isAnswerCorrect(int genNum1, int genNum2, int userAnswer)
	{
		// checks to see if the student's answer matches the correct answer to the problem
		
		int correctAnswer = genNum1 * genNum2;
		int usersAnswer = userAnswer;
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
