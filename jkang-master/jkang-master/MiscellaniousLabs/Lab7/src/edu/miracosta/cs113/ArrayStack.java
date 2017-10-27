package edu.miracosta.cs113;
import java.util.ArrayList;
import java.util.EmptyStackException;
/**
 * 
 * @author Joshua Kang
 * @version 1.0
 * Program Name: ArrayStack 
 * Program Description: code for creating an ArrayStack
 * 
 * @param <E>
 */
public class ArrayStack<E> 
{
	private static final int INITIAL_CAPACITY = 10;
	private ArrayList<E> data;
	private int topOfStack = -1;
	
	/**
	 * Constructors
	 */
	@SuppressWarnings("unchecked")
	public ArrayStack() 
	{
		data = new ArrayList<E>();
	}
	
	/**
	 * Constrcutor that specifies a specific size. 
	 * @param size
	 */
	@SuppressWarnings("unchecked")
	public ArrayStack(int size) 
	{
		data = new ArrayList<E>(size);
	}
	
	/**
	 * 
	 * Description: returns the data at the top of the stack, throws an exception if the list is empty 
	 * @return E
	 */
	public E peak()
	{
		if(isEmpty())
		{
			throw new EmptyStackException();
		}
		return data.get(topOfStack);
	}
	
	/**
	 * 
	 * Description: returns if the stack is empty or not 
	 * @return boolean
	 */
	public boolean isEmpty()
	{
		return (topOfStack == -1);
		
	}
	
	/**
	 * 
	 * Description: "removes" the data at the top of the stack 
	 * @return
	 */
	public E pop()
	{
		if(isEmpty())
		{
			throw new EmptyStackException();
		}
		return data.get(topOfStack--);
	}
	
	/**
	 * 
	 * Description: adds a new data to the top of the stack, and returns it
	 * @param obj
	 * @return E
	 */
	public E push(E obj)
	{
		topOfStack++;
		data.add(topOfStack, obj);
		return obj;
		
		
	}
	

	
}
