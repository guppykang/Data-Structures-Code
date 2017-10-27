package edu.miracosta.cs113;
import java.util.Stack;
import  java.util.Queue;
import java.util.LinkedList;

/**
 * 
 * @author Joshua Kang
 * @version 1.0
 * Program Name: Lab 8 practice with Stacks and Queues 
 * Program Description: Testing with Stacks and Queue's properties.
 * Algorithm: 
 * create two stacks of Integers
 * create a queue 
 * populate stack1 with -1, 15, 23, 44, 4, 99
 * remove the items from stack 1 and push them into stack 2, and offer them into the queue	
 * 	this inverts the order of the stack
 * Print out the items in the inversted stack
 * Print out the items in the Queue
 *
 */
public class Lab8 
{
	public static void main(String[] args)
	{
		Stack<Integer> stack1 = new Stack<Integer>();
		Stack<Integer> stack2 = new Stack<Integer>();
		
		Queue<Integer> queue = new LinkedList<Integer>();
		stack1.push(-1);
		stack1.push(15);
		stack1.push(23);
		stack1.push(44);
		stack1.push(4);
		stack1.push(99);
		
		System.out.print("Last number in, but first out : ");
		System.out.println(stack1.peek());
		
		
		while(!stack1.isEmpty())
		{
			stack2.push(stack1.pop());
			queue.offer(stack2.peek());
			
		}
		
		System.out.print("Inverted of stack 1 :  ");
		while(!stack2.isEmpty())
		{
			System.out.print(stack2.pop() + " ");
			
		}
		
		
		System.out.print("\nCopy of items in stack 1 through queue: ");
		while(!queue.isEmpty())
		{
			System.out.print(queue.poll() + " ");
		}
		
		
	}
}
