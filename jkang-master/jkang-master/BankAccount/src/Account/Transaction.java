package Account;
/**
 * 
 * @author Joshua Kang
 * @version 1.0
 * Program Name: Transaction
 * Program Description: When a Transaction object is created, the object keeps track of the customer Number,
 * transaction Type, amount in the transaction, the date, and fees of the transaction. 
 * Class Invariant: n/a
 *
 */
public class Transaction 
{
	
	//instance variables
	private int customerNumber;
	private String transactionType;
	private double amount;
	private String date;
	private String fees;
	
	//default constructor
	public Transaction()
	{
		customerNumber = 1234567890;
		transactionType = "purchase";
		amount = 100;
		date = "January 1st 2017";
		fees = "none";
	}
	//full constructor
	public Transaction(int customerNumber, String transactionType, double amount, String date, String fees)
	{
		this.customerNumber = customerNumber;
		this.transactionType = transactionType;
		this.amount = amount;
		this.date = date;
		this.fees = fees;
	}
	
	//copy constructor
	public Transaction(Transaction other)
	{
		this.customerNumber = other.customerNumber;
		this.transactionType = other.transactionType;
		this.amount = other.amount;
		this.date = other.date;
		this.fees = other.fees;
	}


	//getters and setters
	public int getCustomerNumber() 
	{
		return customerNumber;
	}


	public void setCustomerNumber(int customerNumber)
	{
		this.customerNumber = customerNumber;
	}


	public String getTransactionType() 
	{
		return transactionType;
	}


	public void setTransactionType(String transactionType) 
	{
		this.transactionType = transactionType;
	}


	public double getAmount() 
	{
		return amount;
	}


	public void setAmount(double amount) 
	{
		this.amount = amount;
	}


	public String getDate() 
	{
		return date;
	}


	public void setDate(String date) 
	{
		this.date = date;
	}


	public String getFees() 
	{
		return fees;
	}


	public void setFees(String fees)
	{
		this.fees = fees;
	}

	//process the transaction. Basically does the same tasks as a toString.
	public String toString()
	{
		return "Customer Number : " + customerNumber + "\nTransaction Type : " + transactionType + 
				"\nAmount : " + amount + "\nDate : " + date + "\nFees : " + fees ;
	}
	
}
