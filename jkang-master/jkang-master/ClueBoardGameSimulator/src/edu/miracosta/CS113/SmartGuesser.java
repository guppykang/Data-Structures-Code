package edu.miracosta.CS113;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

/**
 * hi mom
 * @author Joshua Kang
 * @version 1.0
 * Program Name: Homework 1: Smart Guesser (Smart, because it using deduction instead of pure guessing)
 * Program Description: Will guess the murderer, location, and weapon 
 * Class Invariant:
 * Algorithm: 
 * Create a 3 array list that keep track of each category
 * 		one length 6, one length 10, and one length 6
 * populate each ArrayList respectively
 * For(int i = 0; i < 20; i++)
 * 		pick a random index in the array
 * 		get the specific item at the index chosen (Do this for all three categories)
 * 		Create a Theory object with the specific chosen items 
 * 		Find the incorrect item (always guaranteed one wrong, unless the guess is = solution set.)
 * 		Throw out the INDEX (not the item number) in the respective ArrayList.
 * 		Break if you have the correct guess
 * PRINT the total checks, correct solution, and congratulate Jill. 
 *OVERVIEW:
 *Because the assistant jack guarantees that he will give you one item in your guess that is wrong, unless
 *your guess is correct, within the 19 turns, you are guaranteed that 19 items of the total 22 items will be
 *eliminated. This leaves you with 22-19 = 3 items left at the end (the final answer). We basically
 *found the answer purely through elimination. yay...
 */
public class SmartGuesser 
{
	public static void main(String[] args)
	{
		//Declarations/initialization
		Random random = new Random();
		ArrayList<Integer>  weapon = new ArrayList<Integer>();
		ArrayList<Integer> location = new ArrayList<Integer>();
		ArrayList<Integer> murderer = new ArrayList<Integer>();
		int weaponSize, locationSize, murdererSize, solution, answerSet;
		int weaponGuess, locationGuess, murdererGuess;
		int weaponIndex, locationIndex, murdererIndex;
		AssistantJack jack;
		Scanner keyboard = new Scanner(System.in);
		Theory guess = null;
		
		//user input
		System.out.print("Which theory would like you like to test? (1, 2, 3[random], 4[create]): ");
		answerSet = keyboard.nextInt();
		//keyboard.close();
		jack = new AssistantJack(answerSet);
		
		//populating ArrayList
		for(int i = 1; i < 7; i++)
		{
			murderer.add(i);
		}
		for(int i = 1; i < 11; i++)
		{
			location.add(i);
		}
		for(int i = 1; i < 7; i++)
		{
			weapon.add(i);
		}
		
		//Guessing answer sets
		//for some reason, the program has to have one more iteration to get the right answer.
		for(int i = 0; i < 19; i++)
		{
			//calculating size
			weaponSize = weapon.size();
			locationSize = location.size();
			murdererSize = murderer.size();
			
			//grabbing a random index
			weaponIndex = random.nextInt(weaponSize);
			locationIndex = random.nextInt(locationSize);
			murdererIndex = random.nextInt(murdererSize);
			
			//grabbing the respective item from the index
			weaponGuess = weapon.get(weaponIndex);
			locationGuess = location.get(locationIndex);
			murdererGuess = murderer.get(murdererIndex);
			
			//creating a new Theory with the randomly chosen items
			guess = new Theory(weaponGuess, locationGuess, murdererGuess);
			
			//check the answer with Jack to see which one is incorrect
			solution = jack.checkAnswer(guess);
			
			//remove the respective item from the Arraylist based on the index
			if(solution == 1)
			{
				weapon.remove(weaponIndex);
			}
			else if(solution == 2)
			{
				location.remove(locationIndex);
			}
			else if(solution == 3)
			{
				murderer.remove(murdererIndex);
			}
			else if(solution == 0)
			{
				//the current guess is correct
				break;
			}
		}
		
		//Do this bc guess was not re-initialized after the last iteration of the for Loop
		//If the last guess was wrong, then guess is kept wrong, even though there is only
		//one element in each ArrayList. 
		if(jack.getTimesAsked() == 19)
		{	
			guess = new Theory(weapon.get(0), location.get(0), murderer.get(0));
		}
		
		keyboard.close();
		//print out he total checks and the actual solution. 
		System.out.println("Total Checks = " + jack.getTimesAsked() + ", Solution = " + guess);
		System.out.println("You can be a detective any day Jill!! Congrats...");
	}
}
