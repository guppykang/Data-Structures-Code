package Account;
/**
 * 
 * @author Joshua Kang
 * @version 1.0
 * Program Name: Bank 
 * Program Description: An object of type bank has an array of accounts. Bank is able to manage this accounts
 * Class Invariant:n/a
 *
 */
public class Bank 
{
	//instance variables
	private Account[] accounts;
	
	//full constructor 
	public Bank()
	{
		accounts = new Account[100];
	}
	
	//copy/full  constructor
	public Bank(Account[] other)
	{
		if(this.accounts.length < other.length)
		{
			this.reallocate();
		}
		for(int i = 0; i < 100; i++)
		{
			this.accounts[i] = other[i]; 
		}
	}
	

	/**
	 * 
	 * Description: adds an account to the array of accounts
	 * @param newAccount
	 * @return void
	 */
	public void addAccount(Account newAccount)
	{
		//checks if the array is too full
		if(accounts[(accounts.length)-1] != null)
		{
			this.reallocate();
		}
		
		//append the new account at the nearest open index in the array
		for(int i = 0; i < accounts.length; i++)
		{
			if(accounts[i] == null)
			{
				accounts[i]= newAccount;
			}
		}
	}
	
	/**
	 * 
	 * Description: finds the account that is secified, and withdraws a certian amount of money
	 * pre-condition: amount is greater than 0
	 * @param account
	 * @param amount
	 * @return void
	 */
	public void makeWithdrawal(Account account, double amount)
	{
		for(int i = 0; i < this.accounts.length; i++)
		{
			if(account.equals(this.accounts[i]))
			{
				this.accounts[i].withdraw(amount);
			}
		}
	}
	
	/**
	 * 
	 * Description: finds an account in the array, and returns it
	 * @param account 
	 * @return Account
	 */
	public Account getAccount(Account account)
	{
		for(int i = 0; i < accounts.length; i++)
		{
			if(account.equals(accounts[i]))
			{
				return accounts[i];
			}
			
		}
		return null;
	}
	
	/**
	 * 
	 * Description: finds an account in the array, and deposits an amoutn of money into it
	 * @param account
	 * @param amount
	 * @return void
	 */
	public void makeDeposit(Account account, double amount)
	{
		for(int i = 0; i < this.accounts.length; i++)
		{
			if(account.equals(this.accounts[i]))
			{
				this.accounts[i].deposit(amount);
			}
		}
	}
	
	public Account[] getAccounts()
	{
		return this.accounts;
	}
	/**
	 * 
	 * Description: return the size of the array of accounts
	 * @return int
	 */
	public int getSize()
	{
		return this.accounts.length;
	}
	
	/**
	 * 
	 * Description: allocates the full array to a new array that is double the size
	 * @return void
	 */
	public void reallocate()
	{
		Account[] newTransactions = new Account[accounts.length];
		for(int i = 0; i < accounts.length; i++)
		{
			newTransactions[i] = this.accounts[i];
		}
		this.accounts = newTransactions;
	}
	
}
