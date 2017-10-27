package edu.miracosta.CS113;
/**
 * 
 * @author Joshua Kang
 * @version 1.0
 * Program Name: Lab 1
 * 
 * Program Description: prints the numbers from 1 to 100, but for multiples of 3 print “Fizz”
instead of the number and for multiples of 5 print “Buzz”. For numbers that are multiples of
both three and five print “Fizzbuzz”.

 * Class Invariant: N/A
 * 
 * Algorithm: 
 * create three booelan variables : isDivisibleByThree, isDivisibleByFive, isDivisibleByBoth, neither
 * create a for loop (int i = 0; i < 101; i++)
 * instantiate all four boolean variables to false
 * check if (i%3 == 0)
 * check if if(i%5 == 0)
 * if(isDivisibleByThree == true && isDivisibleByFive == true)
 * 		set isDivisibleByBoth = true
 * if(isDivisibleByThree == false && isDivisibleByFive == false)
 * 		set neither to true
 * 		print the number i 
 * only if neither == false run the algorithm below
 * if(isDivisibleByBoth == true)
 * 		print Fizzbuzz
 * else 
 * 		if(isDivisibleByThree == true)
 * 			print Fizz
 * 		else if(isDivisibleByFive == true)
 * 			print Buzz
 * 		
 * 		
 * 
 *
 */
public class Lab1 {

	
	public static void main(String[] args) 
	{
		boolean isDivisibleByThree, isDivisibleByFive, isDivisibleByBoth, neither;
		
		for(int i = 1; i < 101; i++)
		{
			//bc neither does not necessarily mean when isDivisibleByBoth = false.
			neither = false;
			isDivisibleByThree = false;
			isDivisibleByFive = false;
			isDivisibleByBoth = false;
			//sees if the number is either divisible by 3, by 5, or both.
			if(i%3 == 0)
			{
				isDivisibleByThree = true;
			}
			if(i%5 == 0)
			{
				isDivisibleByFive = true;
			}
			//determine if both are true
			if(isDivisibleByThree == true && isDivisibleByFive == true)
			{
				isDivisibleByBoth = true;
			}
			
			
			if(isDivisibleByThree == false && isDivisibleByFive == false)
			{
				neither = true;
				System.out.println(i);
			}
			
			if (neither == false)
			{
				//print out
				if (isDivisibleByBoth == true)
				{
					System.out.println("Fizzbuzz");
				}
				//determine to print a "non Divisible" number
				
				else
				{
					if(isDivisibleByThree == true)
					{
						System.out.println("Fizz");
					}
					else if(isDivisibleByFive == true)
					{
						System.out.println("Buzz");
					}
				}
			}
			
		}
		
	}
	
}
