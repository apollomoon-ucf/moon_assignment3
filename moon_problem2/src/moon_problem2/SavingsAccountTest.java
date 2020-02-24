package moon_problem2;

public class SavingsAccountTest {

	public static void main(String[] args) 
	{
		SavingsAccount saver1 = new SavingsAccount(2000.0);
		SavingsAccount saver2 = new SavingsAccount(3000.0);
		
		saver1.modifyInterestRate(0.04);
		saver2.modifyInterestRate(0.04);

		
		System.out.println("\nMonthly Savings Balances at 4% interest rate:\n");
		System.out.println("\t\t      Saver 1: \t      Saver 2:");
		System.out.printf("Initial Deposit:      $%.2f \t      $%.2f\n", saver1.savingsBalance, saver2.savingsBalance);
		for (int i = 1; i <= 12; i++)
		{
			saver1.calculateMonthlyInterest();
			saver2.calculateMonthlyInterest();
			System.out.printf("Month %d: \t      $%.2f \t      $%.2f\n", i, saver1.savingsBalance, saver2.savingsBalance);
		}
		
		saver1.modifyInterestRate(0.05);
		saver2.modifyInterestRate(0.05);

		
		System.out.println("\nNext Month Balances at 5% interest rate:\n");
		System.out.println("\t\t      Saver 1: \t      Saver 2:");
//		System.out.printf("Initial Deposit:      $%.2f \t      $%.2f\n", saver1.savingsBalance, saver2.savingsBalance);
		for (int i = 1; i < 2; i++)
		{
			saver1.calculateMonthlyInterest();
			saver2.calculateMonthlyInterest();
			System.out.printf("Next Month: \t      $%.2f \t      $%.2f\n", saver1.savingsBalance, saver2.savingsBalance);
		}		

	}

	
	
}
