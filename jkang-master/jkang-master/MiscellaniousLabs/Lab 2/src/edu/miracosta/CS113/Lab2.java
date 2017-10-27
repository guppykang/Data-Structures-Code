package edu.miracosta.CS113;

import java.util.Scanner;

/**
 * @author Joshua Kang
 * @version 1.0
 * Program Name: Power of two calculator
 * Program Description: finds out if a number is a power of 2
 * Class Invariant: N/A, handles numbers that are negative. 
 * Algorithm: 
 * declare variables:	
 * 		Scanner keyboard
		String temp
		String again
		int num
		int isPowerOfTwo
	instantiate keyboard
	while(true)
		Ask the user for a number
		call method filter to filter out numbers less than 2
		if(num > 2)using the filter method
			call method isPowerOfTwo to find if the number is a power of two
		Ask the user if they want to enter another number
			if('n')
				break
		
	
 */
public class Lab2 
{
	public static void main(String[] args)
	{
		Scanner keyboard;
		String temp;
		String again;
		int num;
		int isPowerOfTwo;
		
		keyboard = new Scanner(System.in);
		
		System.out.println("I will see if your number is a power of two");
		while(true)
		{
			System.out.print("Please enter a number:");
			temp = keyboard.nextLine();
			num = Integer.parseInt(temp);
			isPowerOfTwo = filter(num);
			if(isPowerOfTwo == 0)
			{
				isPowerOfTwo = isPowerOfTwo(num);
				if(isPowerOfTwo == 0)
				{
					System.out.println("Your number IS a power of two");
					
				}
				else
				{
					System.out.println("Your number IS NOT a power of two");
				}
			}
			else
			{
				System.out.println("Your number is not a power of two");
			}
			
			System.out.print("Would you like to enter another number? (Y/N) ");
			again = keyboard.nextLine();
			if(again.equalsIgnoreCase("n"))
			{
				break;
			}
			/*do
			{	
				System.out.print("Would you like to enter another number? (Y/N) ");
				again = keyboard.nextLine();
				try
				{
					if(!(again.equalsIgnoreCase("y") || again.equalsIgnoreCase("n")))
					{
						throw new WrongAnswerException();
					}
				}
				catch(WrongAnswerException e)
				{
					
				}
			}
			while(!(again.equalsIgnoreCase("y") || again.equalsIgnoreCase("n")))
			{
				
			}*/
				
		}
	}
	/**
	 * 
	 * Description: finds out if the number in the paramter is a power of two through recursion.
	 * The program keeps dividing by two. If the remainder is not divisible by two, it's not a 
	 * power of two. 
	 * @param num
	 * @return if the number returned is 0, the number is a power of 2. If the number returned is -1,
	 * the number is not a power of 2.
	 * 
	 */
	public static int isPowerOfTwo(int num)
	{
		
		if(num == 1)
		{
			//if it ends up getting two 1 it is a power of two
			return 0;
		}
		else
		{
			//if the number is not divisible by 2, the number is not a power of 2
			if(num%2 != 0)
			{
				return -1;
			}
			else
			{
				return isPowerOfTwo(num/2);
			}
		}
	}
	/**
	 * 
	 * Description: if the number provided by the user is less than 2, it is automatically not a 
	 * power of two.
	 * @param num
	 * @return if it returns -1, it is not a power of two. If it returns zero, it has a chance.
	 */
	public static int filter(int num)
	{
		if(num < 2)
		{
			return -1;
		}
		else
		{
			return 0;
		}
	}
}
