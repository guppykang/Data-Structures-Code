package cs113.miracosta.edu;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import BinaryTree.BinaryTree;

/**
 * 
 * @author Joshua Kang
 * @version 1.0
 * Program Name: Morse Code
 * Program Description: Creates a Binary Tree consisting of Codes of the letters of the alphabet and their 
 * corresponding morse code translation.
 * Algorithm: create a file input Stream and open the MorseCode.txt file to read the symbols and letters
 * Reading the code and letter, populate the ArrayList by putting the code's length into its respective list
 * Starting at the bottom of the tree, sort the codes with length 4 by putting codes into their respective pair
 * find the morse code with three symbols that matches each pair of morse code of length 4
 * Create 8 Binary tree with the trio of codes
 * Sort the Binary Tree's root's with their respective pair. 
 * find the code of length two that goes with each pair of Binary Trees. 
 * Create 4 Binary Tree with the two binary tree's and the code of length of 2
 * sort the 4 binary trees with their respective pairs. 
 * create 2 binary trees with the two pairs
 * Sort the 2 Binary trees
 * Create 1 binary tree with the two subtrees.
 * 
 *  ask the user if they want to view the codes and letters of the alphabet, translate from an external file, 
 *  or translate through the console. 
 *  
 *  if the first symbol is  a *, return the left sub tree, 
 *  else return the right subtree until the length of the code is 1.
 *  once the length of the code is 1, return the root of the last tree that was passed. 
 *
 */
public class MorseCode 
{
	public static void main(String[] args)
	{
		BinaryTree<Code> morse = new BinaryTree<Code>();
		ArrayList<Code> four = new ArrayList<Code>();
		ArrayList<Code> three = new ArrayList<Code>();
		ArrayList<Code> two = new ArrayList<Code>();
		ArrayList<Code> one = new ArrayList<Code>();
		ArrayList<Code> fourSorted = new ArrayList<Code>();
		Scanner inputStream = null;
		   
	    try
	    {
	        inputStream = new Scanner(new FileInputStream("C:\\Users\\Joyce\\Documents\\MorseCode.txt"));
	    }
	      
	    catch(FileNotFoundException e)
	    {
	        System.exit(1);
	    }
	    
	    String letter, code; 
	    
	    
	    //put the codes in the respective ArrayList
	    for(int i = 0; i < 26; i++)
	    {
	    	letter = inputStream.next();
		    code = inputStream.next();
		    
		    Code newCode = new Code(code, letter);
		    if(i >= 0 && i < 12)
		    {
		    	four.add(newCode);
		    }
		    else if(i >= 12 && i < 20)
		    {
		    	three.add(newCode);
		    	
		    }
		    else if(i >= 20 && i < 24)
		    {
		    	two.add(newCode);
		    }
		    else
		    {
		    	one.add(newCode);
		    }
	
	    }
		   
	    //sorting the level five codes
	    for(int i = 0; i < 8; i++)
	    {
	    	Code leftCode = null, rightCode = null;
	    	//only if the code's last symbol is an astrik
	    	if(!four.isEmpty())
	    	{
		    	String lastLetter = four.get(0).getCode().substring(3);
		    	if(lastLetter.equals("*"))
		    	{
		    		leftCode = four.get(0);
		    		for(int j = 0; j < four.size(); j++)
		    		{
		    			String right = four.get(j).getCode();
		    			String left = leftCode.getCode().substring(0,3) + "-";
	    				if(right.equals(left))
	    				{
	    					rightCode = four.get(j);
	    					four.remove(j);
	    					break;
	    				}
		    			//rightCode is left null if there is no match
		    		}
	
					four.remove(0);
		    	}
		    	
		    	//if the code's last symbol is a dash
		    	else
		    	{
		    		rightCode = four.get(0);
		    		for(int j = 0; j < four.size(); j++)
		    		{
	    				if(four.get(j).getCode().equals(rightCode.getCode().substring(0,3) + "*"))
	    				{
	    					leftCode = four.get(j);
	    					four.remove(j);
	    					break;
	    				}
		    			//leftCode is left null if there is no match
		    		}
					four.remove(0);
		    	}
	    	}
	    	if(leftCode == null)
	    	{
	    		fourSorted.add(new Code("No Letter", "No Letter"));
	    		
	    	}
	    	else
	    	{
	    		fourSorted.add(leftCode);
	    	}
	    	
	    	if(rightCode == null)
	    	{
	    		fourSorted.add(new Code("No Letter", "No Letter"));
	    	}
	    	else
	    	{
	    		fourSorted.add(rightCode);
	    	}
	    	
	    	
	    	
	    }
	    
	    ArrayList<BinaryTree<Code>> levelFourSubtrees = new ArrayList<BinaryTree<Code>>();
	    
	    BinaryTree<Code> leftSubtree, rightSubtree, parent = null;
	    for(int i = 0; i <= 14; i += 2)
	    {
	    	leftSubtree = new BinaryTree<Code>(fourSorted.get(i), null, null);
	    	rightSubtree = new BinaryTree<Code>(fourSorted.get(i+1), null, null);
	    	if(rightSubtree.getData().getCode().equals("No Letter") && leftSubtree.getData().getCode().equals("No Letter"))
	    	{
	    		parent = new BinaryTree<Code>(new Code("---", "o"), leftSubtree, rightSubtree);
	    	}
	    	else
	    	{
	    		for(int j = 0; j < three.size(); j++)
		    	{
		    		String match = three.get(j).getCode();
		    		if(match.equals(leftSubtree.getData().getCode().substring(0, 3)))
		    		{
		    			parent = new BinaryTree<Code>(three.get(j), leftSubtree, rightSubtree);
		    			break;
		    		}
		    	}
	    	}
	    	
	    	levelFourSubtrees.add(parent);
	    }
	    
	    ArrayList<BinaryTree<Code>> levelFourSubtreesSorted = new ArrayList<BinaryTree<Code>>();
	    
	    //sorting level 4 subtrees
	    for(int i = 0; i < 4; i++)
	    {
	    	Code leftCode = null, rightCode = null;
	    	BinaryTree<Code> leftSubtree1 = null, rightSubtree1 = null;
	    	
	    	//only if the code's last symbol is an astriks
	    	if(levelFourSubtrees.get(0).getData().getCode().substring(2).equals("*"))
	    	{
	    		leftCode = levelFourSubtrees.get(0).getData();
	    		for(int j = 0; j < levelFourSubtrees.size(); j++)
	    		{
    				if(levelFourSubtrees.get(j).getData().getCode().equals(leftCode.getCode().substring(0,2) + "-"))
    				{
    					rightCode = levelFourSubtrees.get(j).getData();
    					rightSubtree1 = levelFourSubtrees.get(j);
    					leftSubtree1 = levelFourSubtrees.get(0);
    					levelFourSubtrees.remove(0);
    					levelFourSubtrees.remove(j-1);
    					break;
    				}
	    			//rightCode is left null if there is no match
	    		}
	    	}
	    	
	    	//if the code's last symbol is a dash
	    	else
	    	{
	    		rightCode = levelFourSubtrees.get(0).getData();
	    		for(int j = 0; j < three.size(); j++)
	    		{
	    			if(levelFourSubtrees.get(j).getData().getCode().equals(rightCode.getCode().substring(0,2) + "*"))
	    			{
	    				leftCode = levelFourSubtrees.get(j).getData();
    					rightSubtree1 = levelFourSubtrees.get(0);
    					leftSubtree1 = levelFourSubtrees.get(j);
    					levelFourSubtrees.remove(0);
    					levelFourSubtrees.remove(j-1);
    					break;
	    			}
	    		}
	    			//leftCode is left null if there is no match
	    		
	    	}
	    	levelFourSubtreesSorted.add(leftSubtree1);
	    	levelFourSubtreesSorted.add(rightSubtree1);
	    	
	    	
	    }
	    

	    ArrayList<BinaryTree<Code>> levelThreeSubtrees = new ArrayList<BinaryTree<Code>>();
	    leftSubtree = null;
	    rightSubtree = null;
	    parent = null;
	    
	    for(int i = 0; i < 8; i += 2)
	    {
	    	leftSubtree = levelFourSubtreesSorted.get(i);
	    	rightSubtree = levelFourSubtreesSorted.get(i+1);
	    	
	    	for(int j = 0; j < two.size(); j++)
	    	{
	    		if(two.get(j).getCode().equals(leftSubtree.getData().getCode().substring(0, 2)))
	    		{
	    			parent = new BinaryTree<Code>(two.get(j), leftSubtree, rightSubtree);
	    			break;
	    		}
	    	}
	    	levelThreeSubtrees.add(parent);
	    }
	    
	    
	    ArrayList<BinaryTree<Code>> levelThreeSubtreesSorted = new ArrayList<BinaryTree<Code>>();
	    
	    //sorting level 3 subtrees
	    for(int i = 0; i < 2; i++)
	    {
	    	Code leftCode = null, rightCode = null;
	    	BinaryTree<Code> leftSubtree1 = null, rightSubtree1 = null;
	    	
	    	//only if the code's last symbol is an astriks
	    	if(levelThreeSubtrees.get(0).getData().getCode().substring(1).equals("*"))
	    	{
	    		leftCode = levelThreeSubtrees.get(0).getData();
	    		for(int j = 0; j < levelThreeSubtrees.size(); j++)
	    		{
    				if(levelThreeSubtrees.get(j).getData().getCode().equals(leftCode.getCode().substring(0,1) + "-"))
    				{
    					rightCode = levelThreeSubtrees.get(j).getData();
    					rightSubtree1 = levelThreeSubtrees.get(j);
    					leftSubtree1 = levelThreeSubtrees.get(0);
    					levelThreeSubtrees.remove(0);
    					levelThreeSubtrees.remove(j-1);
    					break;
    				}
	    			//rightCode is left null if there is no match
	    		}
	    	}
	    	
	    	//if the code's last symbol is a dash
	    	else
	    	{
	    		rightCode = levelThreeSubtrees.get(0).getData();
	    		for(int j = 0; j < three.size(); j++)
	    		{
	    			if(levelThreeSubtrees.get(j).getData().getCode().equals(rightCode.getCode().substring(0,1) + "*"))
	    			{
	    				leftCode = levelThreeSubtrees.get(j).getData();
    					rightSubtree1 = levelFourSubtrees.get(0);
    					leftSubtree1 = levelFourSubtrees.get(j);
    					levelThreeSubtrees.remove(0);
    					levelThreeSubtrees.remove(j-1);
    					break;
	    			}
	    		}
	    			//leftCode is left null if there is no match
	    		
	    	}
	    	levelThreeSubtreesSorted.add(leftSubtree1);
	    	levelThreeSubtreesSorted.add(rightSubtree1);
	    	
	    	
	    }
	    
	    ArrayList<BinaryTree<Code>> levelTwoSubtrees = new ArrayList<BinaryTree<Code>>();
	    leftSubtree = null;
	    rightSubtree = null;
	    parent = null;
	    
	    for(int i = 0; i < 4; i += 2)
	    {
	    	leftSubtree = levelThreeSubtreesSorted.get(i);
	    	rightSubtree = levelThreeSubtreesSorted.get(i+1);
	    	
	    	for(int j = 0; j < one.size(); j++)
	    	{
	    		if(one.get(j).getCode().equals(leftSubtree.getData().getCode().substring(0,1)))
	    		{
	    			parent = new BinaryTree<Code>(one.get(j), leftSubtree, rightSubtree);
	    			break;
	    		}
	    	}
	    	levelTwoSubtrees.add(parent);
	    }  
	    
	    if(levelTwoSubtrees.get(0).getData().getCode().equals("*"))
	    {
	    	morse = new BinaryTree<Code>(new Code("Root", "Root"), levelTwoSubtrees.get(0), levelTwoSubtrees.get(1));
	    }
	    else
	    {
	    	morse = new BinaryTree<Code>(new Code("Root", "Root"), levelTwoSubtrees.get(1), levelTwoSubtrees.get(0));
	    			
	    }
	    
	    Scanner keyboard = new Scanner(System.in);
	    String again; 
	    do
	    {
	    	System.out.print("Please enter 1 (morse code and translated letter table), 2 (Morse code file translation)"
		    		+ ", 3 (User input Morse Code Translation) : ");
		    String input = keyboard.nextLine();
		    
		    if(input.equals("1"))
		    {
		    	System.out.println(morse);
		    }
		    else if(input.equals("2"))
		    {
		    	System.out.print("Please enter a file name followed by .txt to decode: ");
		    	String fileName = keyboard.nextLine();
		    	try
		 	    {
		 	        inputStream = new Scanner(new FileInputStream(fileName));
		 	    }
		 	      
		 	    catch(FileNotFoundException e)
		 	    {
		 	    	System.out.println("File not found, please try again");
		 	        System.exit(1);
		 	    }
		    	
		    	System.out.println("File found. Here is the message translated to English : ");
		    	ArrayList<String> codes = new ArrayList<String>();
		    	while(inputStream.hasNext())
		    	{
			    	codes.add(inputStream.next());
			    }
		    	
		    	int counter = 0;
		    	String morseCode;
		    	while(!(codes.isEmpty()))
		    	{
		    		morseCode = codes.remove(counter);
		    		
			    	System.out.print(getLetter(morseCode, morse));
		    	}
		    	
		    	
		    }
		    else if(input.equals("3"))
		    {
		    	System.out.print("Please enter a String of morse code to translate to English : ");
		    	input = keyboard.nextLine();
		    	String[] strings = input.split(" ");
		    	for(String s : strings )
		    	{
			    	System.out.print(getLetter(s, morse));
				    	
		    	}
		    }
		    else
		    {
		    	System.out.println("Please enter a valid command");
		    }
		    System.out.print("\nWould you like to enter another command? (y,n) ");
		    again = keyboard.nextLine();
		    
	    }
	    while(again.equalsIgnoreCase("y"));
	    
		    
		System.out.println("Done");
	    
	}
	
	/**
	 * 
	 * Description: from the morse code, and the morse code tree, translate the symbols to their respective letter
	 * @param morseCode
	 * @param tree
	 * @return String
	 * 
	 * 
	 */
	public static String getLetter(String morseCode, BinaryTree<Code> tree)
	{
		if(morseCode.length() == 1)
		{
			if(morseCode.equals("*"))
			{
				return tree.getLeftSubtree().getData().getLetter();
			}
			else
			{
				return tree.getRightSubtree().getData().getLetter();
			}
		}
		else
		{
			if(morseCode.charAt(0) == '*')
			{
				return getLetter(morseCode.substring(1), tree.getLeftSubtree());
			}
			else
			{
				return getLetter(morseCode.substring(1), tree.getRightSubtree());
			}
		}
	}
}
