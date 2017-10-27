package edu.miracosta.cs113;
import java.util.Scanner;
import arrayStack.ArrayStack;

/**
 * 
 * @author Joshua Kang
 * @version 1.0
 * Program Name: Palindrome detector 
 * Program Description: detects if a word is a palindrome
 * pre condition : any string that contains periods, commas, or spaces are allowed. When analyzing Strings with spaces, commas, or periods,
 * the program will neglect those extraneous characters. For example : "A car, a man, a maraca." will turn into "a car a man a maraca" 
 * Algorithm:  
 * prompt the user for an input String
 * push each character of the String into stack
 * pop and push the first half of the letters into otherStack
 * if the String had an odd number of characters, remove the first character on stack
 * WHILE (!stack.isEmpty() && stack.pop().equals(otherStack.pop()))
 * 	index++
 * if it traversed through all of the characters in the supposedly identical stacks, index should equal the lenght divided by 2
 * if index == length/2
 * 	 it's a palindrome
 * else
 * 	it's not a palindrome
 *
 */
public class Palindrome
{
	//add a feature that takes in strings with spaces as well. 
	//Traverse through each item in the stack, and elininate the spaces. 
	public static void main(String[] args)
	{
		//declarations
		Scanner keyboard = new Scanner(System.in);
		ArrayStack<Character> stack = new ArrayStack<Character>();
		ArrayStack<Character> otherStack = new ArrayStack<Character>();
		int index = 0;	
		int size = 0;
		String input; 
		
		System.out.print("Please enter a String to test if it is palindrome : ");
		input = keyboard.nextLine();
		
		//push the characters into the stack
		for(int i = 0; i < input.length(); i++)
		{
			if(Character.compare(input.charAt(i), ' ') != 0 && Character.compare(input.charAt(i), ',') != 0 &&
					Character.compare(input.charAt(i), '.') != 0)
			{
				stack.push(Character.toLowerCase(input.charAt(i)));
				size++;
			}
		}
		
		//pop and push the first half of the word into another stack
		for(int i = 0; i < size/2; i++)
		{
			//swaps the order, not making us traverse the String backwards
			otherStack.push(stack.pop());
		}
		
		//get rid of the extra letter
		if(size%2 != 0)
		{
			stack.pop();
		}
		
		
		while(!stack.isEmpty() && (Character.compare(stack.pop(), otherStack.pop()) == 0))
		{
			index++;
		}
		
		if(index == size/2)
		{
			System.out.println("It is a palindrome!!!");
		}
		else
		{
			System.out.println("It is not a palindrome!!!");
		}
	}
}
