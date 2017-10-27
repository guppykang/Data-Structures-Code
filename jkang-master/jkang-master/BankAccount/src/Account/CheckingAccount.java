package Account;
/**
 * 
 * @author Joshua Kang
 * @version 1.0
 * Program Name: Checking Account (Subclass of Account) 
 * Program Description: The Checking account is essentially the same as account, but includes methods such as
 * deposit, withdraw and add interest. 
 * Class Invariant: n/a
 *
 */
//sublcass of Account
public class CheckingAccount extends Account 
{
	//full constructor
	public CheckingAccount(Customer customer, double balance, int accountNumber)
	{
		super(customer, balance, accountNumber);
	}
	
	//copy constructor
	public CheckingAccount(Account other)
	{
		super(other);
	}
	
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
