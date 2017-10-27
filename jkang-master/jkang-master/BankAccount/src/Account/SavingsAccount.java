package Account;
/**
 * 
 * @author Joshua Kang
 * @version 1.0
 * Program Name: Savings Account (Subclass of Account)
 * Program Description: Savings account is basically the same as Account, but includes methods such as withdraw,
 * deposit, and addInterest.
 * Class Invariant: n/a 
 *
 */
public class SavingsAccount extends Account
{

	//Full Constructor
	public SavingsAccount(Customer customer, double balance, int accountNumber)
	{
		super(customer, balance, accountNumber);
	}
	
	//copy Constructor
	public SavingsAccount(Account other)
	{
		super(other);
	}
	
	//technicalliy don't need the next three methods
	//details in super class
	public void deposit(double amount)
	{
		this.setBalance(this.getBalance() + amount);
	}
	
	//details in super class
	public void withdraw(double amount)
	{
		this.setBalance(this.getBalance() - amount);
	}
	
	//details in super class
	public void addInterest(double interestPercentage)
	{
		interestPercentage += 100;
		this.setBalance(this.getBalance()*interestPercentage);
	}
	
	//equals
	public boolean equals(Account other)
	{
		if(this.getClass().equals(other.getClass()) && this.getCustomer().equals(other.getCustomer()) && 
				this.getBalance() == other.getBalance() && this.getAccountNumber() == other.getAccountNumber() && 
				this.getTransactions() == other.getTransactions())
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	//toString
	public String toString()
	{
		return "Customer : " + getCustomer() + "\nBalance : " + getBalance() + "\nAccount Number : " + getAccountNumber() + 
				"\nTransactions : " + getTransactions();
	}
}
