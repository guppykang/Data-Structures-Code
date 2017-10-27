package edu.miracosta.cs113;

import java.util.ArrayList;

/**
 * 
 * @author Joshua Kang
 * @version 1.0
 * Program Name: Lab 5 DirectoryDriver
 * Program Description: Driver program for an array of Entries. Since the description of the project on the 
 * book was very vauge, I wanted to create the classes that were neceessary for it to work. In addition, the 
 * methods could not function correctly unless the ArrayLists were instance variables. 
 * Class Invariant: n/a
 * Algorithm: 
 * Create two ArrayLists of two different types, for the two different methods that were required for Lab 5
 * Add two DirectoryEntry to the ArrayList
 * use the addOrChange Methods to add 1234 to the ArrayList
 *
 *add two Entries to the ArrayList
 *use the removeEntry method to remove the entry consisting of the name "dad"
 *Print the ArrayList for the user to view. 
 */
public class DirectoryDriver {
	private static ArrayList<DirectoryEntry> directories = new ArrayList();
	private static ArrayList<Entry> directories2 = new ArrayList();
	
	public static void main(String[] args) 
	{
		directories.add(new DirectoryEntry("mom", "1234"));
		directories.add(new DirectoryEntry("dad", "4321"));
		addOrChangeEntry("mom", "1234");
		addOrChangeEntry("brother", "0987");
		
		directories2.add(new Entry("mom"));
		directories2.add(new Entry("dad"));
		Entry removedEntry = removeEntry("dad");
		
		System.out.println(directories);
		System.out.println("****************************");
		System.out.println(directories2);
	}
	
	/**
	 * 
	 * Description: adds or changes a name's number
	 * @param name
	 * @param newNumber
	 * @return String
	 */
	public static String addOrChangeEntry(String name, String newNumber)
	{
		for(int i = 0; i < directories.size(); i++)
		{
			if(directories.get(i).getName().equals(name))
			{
				directories.get(i).setNumber(newNumber);
				return directories.get(i).getNumber();
			}
			
		}
		directories.add(new DirectoryEntry(name, newNumber));
		return null;
	}
	
	/**
	 * 
	 * Description: removes the first entry that contains the name 
	 * @param name
	 * @return Entry
	 */
	//For this method, you cannot use the indexOf method without the instance variable number. 
	//So, I had to create a super class Entry that contained objects with only attributes of a name
	public static Entry removeEntry(String name)
	{
		Entry newEntry = new Entry(name);
		int index = directories.indexOf(newEntry);
		if(index != -1)
		{
			directories.remove(index);
			return newEntry;
		}
		else
		{
			return null;
		}

	}

}
