package edu.miracosta.cs113;

import java.util.ArrayList;

/**
 * 
 * @author Joshua Kang
 * @version
 * Program Name: Lab 5 Arraylist practice
 * Program Description: plays with the capabilites of an ArrayList, includes: replacing indexes in an array, and 
 * deleting indexes. 
 * Class Invariant: n/a
 * Algorithm: 
 * populate an ArrayList
 * test the replace methods. 
 * test the delete method
 * print the ArrayList to the screen for the user
 *
 */
public class ArrayListLab {

	public static void main(String[] args)
	{
		ArrayList<String> strings = new ArrayList<String>();
		for(int i = 0; i < 10; i++)
		{
			if(i%2 == 0)
			{
				strings.add(i, "mom");
			}
			else
			{
				strings.add(i, "dad");
			}
		}
		strings.add("brother");
		replace(strings, "mom", "dad");
		
		//now, all elements inside strings should be dad except the last one
		//we will now delete the brother in the array of strings
		
		delete(strings, "brother");
		
		for(int i = 0; i < strings.size(); i++)
		{
			System.out.println(strings.get(i));
		}

	}
	
	/**
	 * 
	 * Description: replaces all occurences of the oldItem, and changes the String to newItem 
	 * @param aList
	 * @param oldItem
	 * @param newItem
	 */
	public static void replace(ArrayList<String> aList, String oldItem, String newItem)
	{
		for(int i = 0; i < aList.size(); i++)
		{
			if(aList.get(i).equals(oldItem))
			{
				aList.set(i, newItem);
			}
			
		}
	}
	
	/**
	 * 
	 * Description: deletes the first entry that contains the String target 
	 * @param aList
	 * @param target
	 */
	public static void delete(ArrayList<String> aList, String target)
	{
		for(int i = 0; i < aList.size(); i++)
		{
			if(aList.get(i).equals(target))
			{
				aList.remove(i);
				break;
			}
		}
	}

}

