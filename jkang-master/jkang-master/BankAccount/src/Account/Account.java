package Account;
/**
 * 
 * @author Joshua Kang
 * @version 1.0
 * Program Name: Account  
 * Program Description: Account class keeps track of the Customer, balance, account number, and its transactions.
 * Class Invariant:n/a
 *
 */
public class Account 
{
	//instance variables
	private Customer customer;
	private double balance;
	private int accountNumber;
	private Transaction[] transactions = new Transaction[20];
	
	//full constructor only bc Account cannot instantiate a Customer (AC)
	public Account(Customer customer, double balance, int accountNumber)
	{
		this.customer = customer;
		this.balance = balance; 
		this.accountNumber = accountNumber;
	}
	
	//copy constructor
	public Account(Account other)
	{
		this.customer = other.customer;
		this.balance = other.balance;
		this.accountNumber = other.accountNumber;
		this.transactions = other.transactions;
	}
	
	//getters and setters
	public Customer getCustomer()
	{
		return customer;
	}
	public void setCustomer(Customer customer)
	{
		this.customer = customer;
	}
	public double getBalance() 
	{
		return balance;
	}
	
	public int getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(int accountNumber) {
		this.accountNumber = accountNumber;
	}
	public Transaction[] getTransactions() {
		return transactions;
	}
	public void setTransactions(Transaction[] transactions) {
		this.transactions = transactions;
	}
	
	public void setBalance(double balance) {
		this.balance = balance;
	}
	
	/**
	 * 
	 * Description: deposits an amount of money to the account balance
	 * pre-condition: amount is greater than 0
	 * @param amount
	 * @return void
	 */
	public void deposit(double amount)
	{
		this.setBalance(this.getBalance() + amount);
	}
	
	/**
	 * 
	 * Description: Withdraws an amount of money from the account balance
	 * pre-condition: amount is greater than 0
	 * @param amount
	 * @return void
	 */
	public void withdraw(double amount)
	{
		this.setBalance(this.getBalance() - amount);
	}
	
	/**
	 * 
	 * Description: 
	 * @param interestPercentage
	 * pre-condition: amount is greater than 0, and interestPercentage is less than 1
	 * @return void
	 */
	public void addInterest(double interestPercentage)
	{
		interestPercentage += 100;
		this.setBalance(this.getBalance()*interestPercentage);
	}
	
	//toString
	public String toString()
	{
		String transactionStrings = "";
		for(int i = 0; i < transactions.length; i++)
		{
			if(transactions[i] == null)
			{
				break;
			}
			transactionStrings += transactions[i].toString() + "\n\n";
		}
		return "\nCustomer : " + customer + "\nBalance : " + balance + "\nAccount Number : " + accountNumber + 
				"\n\nTransactions : \n" + transactionStrings;
	}
	
	//equals
	public boolean equals(Account other)
	{
		if(this.getClass().equals(other.getClass()) && this.customer.equals(other.customer) && 
				this.balance == other.balance && this.accountNumber == other.accountNumber && 
				this.transactions == other.transactions)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	public void addTransaction(Transaction newTransaction)
	{
		//checks if the array is too full
			if(transactions[(transactions.length)-1] != null)
			{
				reallocate();
			}
			
			//append the new account at the nearest open index in the array
			for(int i = 0; i < transactions.length; i++)
			{
				if(transactions[i] == null)
				{
					transactions[i]= newTransaction;
					break;
				}
			}
	}
	/**
	 * 
	 * Description: Allocates the current transactions array to a new one with double the length
	 * @return void
	 */
	public void reallocate()
	{
		Transaction[] newTransactions = new Transaction[transactions.length];
		for(int i = 0; i < transactions.length; i++)
		{
			newTransactions[i] = this.transactions[i];
		}
		this.transactions = newTransactions;
	}
	
	
}
