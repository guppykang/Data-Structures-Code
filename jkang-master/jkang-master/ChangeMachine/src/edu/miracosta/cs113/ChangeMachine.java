package edu.miracosta.cs113;
import java.util.Scanner;
import java.util.ArrayList;

/**
 * 
 * @author Joshua Kang
 * @version millionth or something
 * Program Name: Change Machine
 * Program Description: for a given amount of cents, the recursive method getCombos() will store all the possible
 * combinations of quarters, dimes, nickels, and pennies of that amount in the ArrayList.
 * Class Invariant: The amount should be greater than or equal to 0, but values less than 0 are handled appropriately.
 * Algorithm: 
 * Create the instance variables combos which holds all of the combinations of the given amount
 * Create the instance variable topCombo which is the single combination of the largest coin value of the given amount
 * Clear the arraylist everytime a new set of combinations are calculated
 * call getTopCombo(amount) that returns the top Combo that we start the recursive method on
 * then call getCombos(topCombo)
 * call printArrayList(amount) to print out the Arraylist for the given amount
 * Test values from five to 30 in increments of five
 * Test 75... The total possible should be 121
 * Allow the user to add an amount through keyboard input
 * 
 */
public class ChangeMachine 
{

	private static ArrayList<int[]> combos = new ArrayList<int[]>();;
	private static int[] topCombo;
	
	public static void main(String[] args)
	{
		Scanner keyboard = new Scanner(System.in);
		int cents; 
		String temp, again;
		
		//testing values between 5 and 30 in increments of 5
		for(int i = 5; i <= 30; i += 5)
		{
			topCombo = getTopCombo(i);
			getCombos(topCombo);
			
			printArrayList(i);
		}
		
		//testing 75, and the expected number of values should be 121, and is!
		topCombo = getTopCombo(75);
		getCombos(topCombo);
		printArrayList(75);
		
		
		//user input a value and print out all the combinations out 
		do
		{
			System.out.print("Please enter a number of cents that you would like to convert to change : ");
			temp = keyboard.nextLine();
			cents = Integer.parseInt(temp);
			
			if(cents < 0)
			{
				System.out.println("Please enter a valid number of cents that is greater than -1 cents... Exiting");
			}
			else
			{
				topCombo = getTopCombo(cents);
				getCombos(topCombo);
			}
			
			printArrayList(cents);
			
			System.out.print("Would you like to enter another value in? (y, n): ");
			again = keyboard.nextLine();
		}//end do while
		while(again.equalsIgnoreCase("y"));
		
		keyboard.close();
		
	}//end main
	
	
	/**
	 * 
	 * Description: returns an array of the combination with of cents with the highest valued coins possible.
	 * @param cents
	 * @return int[]
	 */
	public static int[] getTopCombo(int cents)
	{
		int[] combo = new int[4];
		combo[0] = cents/25;
		cents = cents%25;
		combo[1] = cents/10;
		cents = cents%10;
		combo[2] = cents/5;
		cents = cents%5;
		combo[3] = cents;
		
		return combo;
	}
	
	/**
	 * 
	 * Description: stores in the static ArrayList all the combinations of the amount given in quarters, dimes,
	 * nickels, and pennies
	 * @param combo
	 */
	public static void getCombos(int[] combo)
	{
		//whether or not it is the final case, we always add it to the arraylist as a combo of the amount
		combos.add(combo);
		
		//base case
		if(combo[0] == 0 && combo[1] == 0 && combo[2] == 0)
		{
			return; 
		}
		
		//when decrementing the quarter, which equals 2 dimes and a nickel
		//pre-warning: if in the case that there are enough dimes and nickels to carry over to create another
		//quarter, it should not carry. Since we just decremented the quarter, it would counter productive, and would repeat
		//some combinations previously added.
		if(combo[1] == 0 && combo[2] == 0)
		{
			//if combo[3] is 0 it will work fine...
			//if there are more than or equal to 5 pennies, you can carry at least one nickel over.
			if(combo[3] >= 5)
			{
				//for carrying over twice (on the pennies, and the nickels)
				//if the extra nickel from the 5 pennies creates at least 2 with the one additional nickel, carry over another dime
				if((1 + combo[3]/5) >= 2)
				{
					getCombos(new int[]{combo[0]-1, 2 + (combo[3]/5 + 1)/2, (combo[3]/5 + 1) % 2, combo[3] % 5});

				}
				
				//only carrying over once from a multiple of 5 pennies to n/5 nickels
				else
				{
					getCombos(new int[]{combo[0]-1, 2, 1 + combo[3]/5, combo[3]%5});
				}
			}
			//there will never be an instance where the number of pennies is < 5 and the number of nickels
			//being greater than 2. So we don't have to account for that case. This is because we are assuming
			//that the the number of nickels is 0. If so, if we add 1 from the quarter, but there is no carry
			//from the pennies, there is no way that there can be a carry for another dime from 2 or more nickels. 
			
			else
			{
				getCombos(new int[]{combo[0]-1, 2, 1, combo[3]});
			}
			
		}
		
		//when we have decrement the number of dimes, we have to check for a carry from the pennies or not
		else if(combo[2] == 0)
		{
			//even if the number of pennies is 0, and it goes in this if statement, it will have the same effect
			//for instances where there is a multiple of five pennies, and you can carry it over to get a nickel
			if(combo[3] >= 5)
			{
				getCombos(new int[]{combo[0], combo[1]-1, 2 + (combo[3]/5), combo[3]%5});
			}
			//if the number of pennies is not a mu
			else
			{
				getCombos(new int[]{combo[0], combo[1]-1, 2, combo[3]});
			}
		}
		
		//decrementing the number of nickels in the combination...
		//should not carry over, defeats the purpose, and will repeat combinations
		else
		{
			getCombos(new int[]{combo[0], combo[1], combo[2]-1, combo[3] + 5});
		}
	}
	
	
	/**
	 * 
	 * Description: prints the current initialization of the ArrayList combos, then clears it after for another future use
	 * @param cents
	 */
	public static void printArrayList(int cents)
	{
		System.out.println("There are " + combos.size() + " combinations that quarters, dimes, nickels"
				+ " or pennies can be given for " + cents + " cents");
		for(int j = 0; j < combos.size(); j++)
		{
			
			int[] aCombo = combos.get(j);
			for(int k = 0; k < 4;k++)
			{
				System.out.print(aCombo[k]);
				if(k == 0)
				{
					System.out.print(" quarters, ");
				}
				else if(k == 1)
				{
					System.out.print(" dimes, ");
				}
				else if(k == 2)
				{
					System.out.print( " nickels, ");
				}
				else
				{
					System.out.print( " pennies");
				}
			}
			System.out.println("");
		}
		
		//clear, so that previous values are not included in the combinations for future values
		combos.clear();
	}
	
	
	
}

