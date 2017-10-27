package JUnitTesting;
import edu.miracosta.cs113.DoubleLinkedList;

import junit.framework.Assert;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert.*;
import java.util.LinkedList;

public class DoubleLinkedListTester 
{

	private LinkedList throwthisAway;
	
	
	@Test
	public void testAdd()
	{
		DoubleLinkedList<String> linkedList = new DoubleLinkedList();
		linkedList.add("Mom");
		linkedList.add("Dad");
		String temp1 = linkedList.get(0);
		String temp2 = linkedList.get(1);
		
		//testing adding
		Assert.assertNotSame(temp1, temp2);
		
		//testing adding
		linkedList.add("Brother");
		Assert.assertNotSame(linkedList.get(2), linkedList.get(0));
		Assert.assertEquals(linkedList.size(), 3);
		
		
		//testing adding in the middle of the LinkedList
		linkedList.add(2, "Brother");
		Assert.assertEquals(linkedList.get(3), linkedList.get(2));
		Assert.assertEquals(linkedList.size(), 4);
	}
	
	@Test
	public void testRemove()
	{
		DoubleLinkedList<String> linkedList = new DoubleLinkedList();
		linkedList.add("Mom");
		linkedList.add("Dad");
		linkedList.add(2, "Brother");
		linkedList.add("Brother");
		
		//test where node DNE
		boolean exists = linkedList.remove("sister");
		Assert.assertEquals(exists, false);
		
		//test remove at end and middle
		//remove both brothers
		boolean brother1 = linkedList.remove("Brother");
		boolean brother2 = linkedList.remove("Brother");
		Assert.assertEquals(brother1, brother2);

		Assert.assertEquals(linkedList.size(), 2);
		
		//test contains
		boolean containsBrother = linkedList.contains("Brother");
		Assert.assertEquals(containsBrother, false);
		
		//test contains
		boolean containsMother = linkedList.contains("Mom");
		Assert.assertEquals(containsMother, true);
		
		//test remove at head
		String removeMom = linkedList.remove(0);
		Assert.assertEquals(removeMom, "Mom");

		Assert.assertEquals(linkedList.size(), 1);
		
		//testing remove at index method in the middle of the LinkedList
		linkedList.add("Mom");
		linkedList.add("Brother");
		removeMom = linkedList.remove(1);
		Assert.assertEquals(removeMom, "Mom");

		Assert.assertEquals(linkedList.size(), 2);
		
		
	}
	
	@Test
	public void testRemoveAll()
	{
		DoubleLinkedList<Integer> linkedList = new DoubleLinkedList();
		linkedList.add(0);
		linkedList.add(1);
		linkedList.add(2);
		linkedList.add(3);
		
		ArrayList<Integer> removeIntegers = new ArrayList<Integer>();
		removeIntegers.add(0);
		removeIntegers.add(1);
		
		//testing removing all at the beginning
		linkedList.removeAll(removeIntegers);
		int firstIndex = linkedList.get(0);
		int secondIndex = linkedList.get(1);
		Assert.assertEquals(firstIndex, 2);
		Assert.assertEquals(secondIndex, 3);
		Assert.assertEquals(linkedList.size(), 2);

		Assert.assertEquals(linkedList.size(), 2);
		
		//test clear and empty
		linkedList.clear();
		Assert.assertEquals(linkedList.isEmpty(), true);
		
		linkedList.add(0);
		linkedList.add(1);
		linkedList.add(2);
		linkedList.add(3);
		
		//testing remove all scattered throughout
		ArrayList<Integer> removeIntegers1 = new ArrayList<Integer>();
		removeIntegers1.add(2);
		removeIntegers1.add(0);
		linkedList.removeAll(removeIntegers1);
		
		firstIndex = linkedList.get(0);
		secondIndex = linkedList.get(1);
		Assert.assertEquals(firstIndex, 1);
		Assert.assertEquals(secondIndex, 3);
		Assert.assertEquals(linkedList.size(), 2);
		
		
	}
	
	@Test
	public void testAddAll()
	{
		DoubleLinkedList<Integer> linkedList = new DoubleLinkedList();
		linkedList.add(0);
		linkedList.add(1);
		linkedList.add(2);
		linkedList.add(3);
		
		//testing adding all at the end
		ArrayList<Integer> removeIntegers = new ArrayList<Integer>();
		removeIntegers.add(6);
		removeIntegers.add(7);
		linkedList.addAll(removeIntegers);

		Assert.assertEquals(linkedList.size(), 6);
		
		
		int fourthIndex = linkedList.get(4);
		int fifthIndex = linkedList.get(5);
		Assert.assertEquals(fourthIndex, 6);
		Assert.assertEquals(fifthIndex, 7);
		
		//testing adding all in the middle
		ArrayList<Integer> removeIntegers1 = new ArrayList<Integer>();
		removeIntegers1.add(4);
		removeIntegers1.add(5);
		linkedList.addAll(4, removeIntegers1);
		
		fourthIndex = linkedList.get(4);
		fifthIndex = linkedList.get(5);
		Assert.assertEquals(fourthIndex, 4);
		Assert.assertEquals(fifthIndex, 5);

		Assert.assertEquals(linkedList.size(), 8);
		
	}
	
	@Test
	public void testLastIndexOf()
	{
		DoubleLinkedList<String> linkedList = new DoubleLinkedList();
		linkedList.add("Mom");
		linkedList.add("Brother");
		linkedList.add("Dad");
		linkedList.add("Brother");
		linkedList.add("Sister");
		
		int indexOflastBrother = linkedList.lastIndexOf("Brother");
		Assert.assertEquals(indexOflastBrother, 3);
		
		int indexOfSister = linkedList.lastIndexOf("Sister");
		Assert.assertEquals(indexOfSister, 4);
		
		int indexOfMom = linkedList.lastIndexOf("Mom");
		Assert.assertEquals(indexOfMom, 0);
		
		
		
	}
	
	@Test
	public void testRetainAll()
	{
		DoubleLinkedList<Integer> linkedList = new DoubleLinkedList();
		linkedList.add(0);
		linkedList.add(1);
		linkedList.add(2);
		linkedList.add(3);
		
		ArrayList<Integer> removeIntegers = new ArrayList<Integer>();
		removeIntegers.add(0);
		removeIntegers.add(1);
		
		//testing retaining only first 2
		linkedList.retainAll(removeIntegers);
		Assert.assertEquals(linkedList.size(), 2);
		
		int firstIndex = linkedList.get(0);
		int secondIndex = linkedList.get(1);
		Assert.assertEquals(firstIndex, 2);
		Assert.assertEquals(secondIndex, 3);
		
		//testing retaining elements in the middle too
		linkedList.add(0, 0);
		linkedList.add(1, 1);
		
		ArrayList<Integer> removeIntegers1 = new ArrayList<Integer>();
		removeIntegers1.add(1);
		removeIntegers1.add(3);
		linkedList.retainAll(removeIntegers1);
		
		firstIndex = linkedList.get(0);
		secondIndex = linkedList.get(1);
		Assert.assertEquals(firstIndex, 0);
		Assert.assertEquals(secondIndex, 2);
		
		
	}
	
	@Test
	public void testSet()
	{
		DoubleLinkedList<String> linkedList = new DoubleLinkedList();
		linkedList.add("Mom");
		linkedList.add("Dad");
		linkedList.add("Brother");
		
		linkedList.set(0, "Brother");
		linkedList.set(1, "Dad");
		linkedList.set(2, "Mom");
		
		String first = linkedList.get(0);
		String second = linkedList.get(1);
		String third = linkedList.get(2);
		Assert.assertEquals(first, "Brother");
		Assert.assertEquals(second, "Dad");
		Assert.assertEquals(third, "Mom");
		
		
		
	}
	
	@Test
	public void testSubList()
	{
		DoubleLinkedList<String> linkedList = new DoubleLinkedList();
		linkedList.add("Mom");
		linkedList.add("Dad");
		linkedList.add("Brother");
		linkedList.add("Sister");
		linkedList.add("Me");
		
		//testing where both indexes are the equal
		ArrayList<String> expectedList = new ArrayList();
		expectedList.add("Dad");
		
		ArrayList<String> list = (ArrayList<String>) linkedList.subList(1, 1);
		Assert.assertEquals(list, expectedList);
		
		//testing where the second index is equal to the first index
		expectedList.clear();
		expectedList.add("Dad");
		expectedList.add("Brother");
		expectedList.add("Sister");
		
		list = (ArrayList<String>) linkedList.subList(1, 4);
		Assert.assertEquals(list, expectedList);
		
		//testing if the upper bound is less than the lower bound
		list = (ArrayList<String>) linkedList.subList(4, 1);
		Assert.assertEquals(list, new ArrayList<String>());
		
	}
	
	@Test
	public void testToArray()
	{
		//testing for a full list
		DoubleLinkedList<String> linkedList = new DoubleLinkedList();
		linkedList.add("Mom");
		linkedList.add("Dad");
		linkedList.add("Brother");
		linkedList.add("Sister");
		linkedList.add("Me");
		
		String[] expectedList = new String[5];
		expectedList[0] = ("Mom");
		expectedList[1] = ("Dad");
		expectedList[2] = ("Brother");
		expectedList[3] = ("Sister");
		expectedList[4] = ("Me");
		
		Object[] list = (Object[]) linkedList.toArray();
		
		//see issue on github for this annoying nuicance
		int index=0;
		for (String strObj : expectedList)
		{
			Assert.assertEquals(strObj, list[index++]);
		}
		
		//testing toArray with parameter 
		list = linkedList.toArray(expectedList);
		//see issue on github for this annoying nuicance
		int index1=0;
		for (String strObj : expectedList)
		{
			Assert.assertEquals(strObj, list[index1++]);
		}

		/*		
		//testing for an empty list
		linkedList.clear();
		String[] expectedList2 = new String[linkedList.size()];
		
		list = linkedList.toArray();
		//see issue on github for this annoying nuicance
		int index2=0;
		for (String strObj : expectedList)
		{
			Assert.assertEquals(strObj, list[index2++]);
		}
		
		*/
		
	}
	
	
	
	
	
	
}
