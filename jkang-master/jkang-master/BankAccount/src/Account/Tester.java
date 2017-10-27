package Account;
import java.util.Scanner;
/**
 * 
 * @author Joshua Kang
 * @version 1.0
 * Program Name: Bank Accounts
 * Program Description: The bank keeps track of its account's transactions and customers.
 * Algorithm: 
 * Initialize a chase account
 * Initialize a wells fargo account
 *Initialize a bank of america account
 *Initialize a Navy Federal account
 *Initialize a union account
 *add these accounts to the bank
 *DO
 *{
 *	ask the user for their information for a transaction
 *	add the new transaction to the specified customer's number in the array of Accounts in the bank
 *	print the new edition of the account
 *	ask the user if they want to add another transaction
 *}WHILE(again is y)
 *
 *DO
 *{
 *	ask the user for the account number
 *	ask the user to deposit or withdraw
 *	ask the user the amount
 *	make the deposit or withdrawal
 *	print the new account information
 *	ask the user if they would like to make another deposit or withdrawal
 *}WHILE(again is y)
 *
 *DO
 *{
 *	ask the user for the account number of the account they would like to view
 *	find the account
 *}
 */
public class Tester 
{

	public static void main(String[] args)
	{
		//declarations
		Scanner keyboard = new Scanner(System.in);
		String temp, typeOfPurchase, date, fees, again, command;
		int customerNumber, accountNumber;
		double amount;
		
		//initialization of accounts
		Account chase = new Account(new Adult(), 100, 123456789);
		Account wellsFargo = new CheckingAccount(new Student(),50, 987654321);
		Account bankOfAmerica = new Account(new Senior("Josh Kang", "12345 1st Street", 65, 123456789, 99999), 
											500, 10000);
		Account navyFederal = new SavingsAccount(wellsFargo);
		Account union = new Account(chase);
		
		//adding the accounts to the bank
		Bank bank = new Bank();
		bank.addAccount(chase);
		bank.addAccount(wellsFargo);
		bank.addAccount(bankOfAmerica);
		bank.addAccount(navyFederal);
		bank.addAccount(union);
		
		//adding a transaction
		do
		{
			System.out.println("Adding a transaction");
			System.out.print("Enter your Customer Number : ");
			temp = keyboard.nextLine();
			customerNumber = Integer.parseInt(temp);
			
			System.out.print("Enter the type of purchase : ");
			typeOfPurchase = keyboard.nextLine();
			
			System.out.print("Enter the amount : ");
			temp = keyboard.nextLine();
			amount = Integer.parseInt(temp);
			
			System.out.print("Enter the date of transaction: ");
			date = keyboard.nextLine();
			
			System.out.print("Enter description of extra fees : ");
			fees = keyboard.nextLine();
			
			
			
			Transaction newTransaction = new Transaction(customerNumber, typeOfPurchase , amount, date, fees);
			
			for(int i = 0; i < bank.getSize(); i++)
			{
				if(bank.getAccounts()[i].getCustomer().getCustomerNumber() == customerNumber)
				{
					bank.getAccounts()[i].addTransaction(newTransaction);
					System.out.println(bank.getAccount(bank.getAccounts()[i]));
					break;
				}
				if(i == bank.getSize()-1)
				{
					System.out.println("The customer number was not found.");
				}
			}
			
			
			System.out.println("Add another transaction (y, n): ");
			again = keyboard.nextLine();
		}
		while(again.equalsIgnoreCase("y"));
		
		//testing methods 
		Transaction navyFederalTransaction = new Transaction(987654321, "return", 15.99 , "December 25", "none");
		
		chase.addTransaction(navyFederalTransaction);
		wellsFargo.addTransaction(new Transaction());
		bankOfAmerica.addInterest(5);
		union.addTransaction(new Transaction(navyFederalTransaction));
		
		//deposit or withdraw
		do
		{
			System.out.print("Enter your account number to make a deposit or withdraw: ");
			temp = keyboard.nextLine();
			accountNumber = Integer.parseInt(temp);
			
			System.out.print("Enter D for deposit, W for withdraw : ");
			command = keyboard.nextLine();
			
			System.out.print("Enter amount : ");
			temp = keyboard.nextLine();
			amount = Double.parseDouble(temp);
			
			if(command.equalsIgnoreCase("d"))
			{
				for(int i = 0; i < bank.getSize(); i++)
				{
					if(bank.getAccounts()[i].getAccountNumber() == accountNumber)
					{
						bank.getAccounts()[i].deposit(amount);
						System.out.println(bank.getAccount(bank.getAccounts()[i]));
						break;
					}
					if(i == bank.getSize()-1)
					{
						System.out.println("Cannot find account number in the bank.");
					}
				}
			}
			else if(command.equalsIgnoreCase("w"))
			{
				for(int i = 0; i < bank.getSize(); i++)
				{
					if(bank.getAccounts()[i].getAccountNumber() == accountNumber)
					{
						bank.getAccounts()[i].withdraw(amount);
						System.out.println(bank.getAccount(bank.getAccounts()[i]));
						break;
					}
					if(i == bank.getSize()-1)
					{
						System.out.println("Cannot find account number in the bank.");
					}
				}
			}
			else
			{
				System.out.println("Please enter a valid command");
			}
			System.out.print("Would you like to withdraw or deposit again (y,n) : ");
			again = keyboard.nextLine();
			
		}
		while(again.equalsIgnoreCase("y"));
		
		//testing methods
				bank.makeDeposit(chase, 50);
				bank.makeWithdrawal(wellsFargo, 5);
				
				
		//print account
		//allow the user to view the changes that they made
		do
		{
			System.out.print("Enter an account's account number to view : ");
			temp = keyboard.nextLine();
			accountNumber = Integer.parseInt(temp);
			
			for(int i = 0; i < bank.getSize(); i++)
			{
				if(bank.getAccounts()[i].getAccountNumber() == accountNumber)
				{
					System.out.println(bank.getAccounts()[i]);
					break;
				}
				if(i == bank.getSize()-1)
				{
					System.out.println("Account number not found in bank");
				}
			}
			System.out.println("View another account (y,n) : ");
			again = keyboard.nextLine();
		}
		while(again.equalsIgnoreCase("y"));
		
		

	}
}
