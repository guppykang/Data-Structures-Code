package Tester;
import edu.miracosta.cs113.*;

/**
 * 
 * @author Joshua Kang
 * @version 1.0
 * Program Name: ArrayStack tester
 * Program Description: a tester to test the four methods of the ArrayStack : pop, push, peak, and isEmpty
 * Class Invariant: n/a
 * Algorithm: 
 * create two ArrayStacks
 * 	one using the default constructor
 * 	one using the specified size constructor
 * fill the stack with numbers 0-9
 * after pushing a new number, peak at the top
 * pop and push vaues from the original stack to the new stack
 * after pushing a number, print it out (the two stacks should be in reverse order : FILO)
 * Prove that the original stack is empty
 *
 */
public class ArrayStackTester 
{
	public static void main(String[] args)
	{
		ArrayStack<Integer> stack = new ArrayStack<Integer>();
		ArrayStack<Integer> otherStack = new ArrayStack<Integer>(15);
		
		System.out.print("Original Stack : ");
		for(int i = 0; i < 10; i ++)
		{
			stack.push(i);
			System.out.print(stack.peak() + " ");
		}
		
		
		System.out.println("");

		System.out.print("New Stack : ");
		while(!stack.isEmpty())
		{
			System.out.print(stack.peak() + " ");
			otherStack.push(stack.pop());
		}
		
		System.out.println(" ");
		System.out.println("It is " + stack.isEmpty() + " to say that that the original stack is empty");
		
		
		
		
		
	
	}
}
