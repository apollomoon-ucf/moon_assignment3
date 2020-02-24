package moon_problem1;

import java.util.Scanner;
import java.security.SecureRandom;

public class CAI2 {
	
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
		// contains the program logic
		System.out.println("\nWelcome to the math quiz program!\n");
		
		// gets random integer 1
		int randomInteger1 = SecureRandomNumber();
		
		// gets random integer 2
		int randomInteger2 = SecureRandomNumber();
		
		// ask user a question
		askQuestion(randomInteger1, randomInteger2);
	}
	
	public static void askQuestion(int genNum1, int genNum2)
	{
		// prints the problem to the screen
		System.out.printf("How much is %d times %d?\n", genNum1, genNum2);
		readResponse(genNum1, genNum2);
	}
	
	public static void readResponse(int genNum1, int genNum2)
	{	
		// reads the answer from the student
		Scanner scanner = new Scanner(System.in);
		int userAnswer = scanner.nextInt();
		
		isAnswerCorrect(genNum1, genNum2, userAnswer);
	}
	
	public static void isAnswerCorrect(int genNum1, int genNum2, int userAnswer)
	{
		// checks to see if the student's answer matches the correct answer to the problem
		
		int correctAnswer = genNum1 * genNum2;
		int usersAnswer = userAnswer;
		// set to 0 if incorrect set to 1 if correct
		int isCorrect = 1;
		
		if (usersAnswer != correctAnswer)
		{
			isCorrect = 0;
			displayIncorrectResponse(genNum1, genNum2);
		}
		
		displayCorrectResponse();
	}
	
	public static void displayCorrectResponse()
	{
		// prints out the response when a student enters a correct answer
		int randomInteger = SecureRandomNumber2();
//		System.out.printf("%d\n", randomInteger);
		
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
		
		System.exit(0);
	}
	
	public static void displayIncorrectResponse(int genNum1, int genNum2)
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
		
		askQuestion(genNum1, genNum2);
	}

}
