package moon_problem2;

public class SavingsAccount {

	private double annualInterestRate;
	double savingsBalance;
	
	public SavingsAccount(double d) 
	{
		this.savingsBalance = d;
	}

	public void calculateMonthlyInterest()
	{
		// calculate the monthly interest by multiplying the savingsBalance by annualInterestRate divided by 12
		// the interest should be added to savingsBalance
		double monthlyInterest = (savingsBalance * annualInterestRate) / 12;
		savingsBalance = savingsBalance + monthlyInterest;
//		System.out.printf("Savings balance is %f\n", savingsBalance);
	}
	
	public void modifyInterestRate(double rate)
	{
		// sets the annualInterestRate to a new value
		this.annualInterestRate = rate;
	}
	
}
