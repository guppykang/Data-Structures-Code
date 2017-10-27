package heap;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.NoSuchElementException;
/**
 * 
 * @author Joshua Kang
 * @version 1.0
 * Program Name: Min Heap
 * Program Description: Keeps track of heap in the from of an arraylist where the smallest value is at the top of the heap
 * 
 * @param <E>
 */
public  class MinHeap<E> extends Heap 
{
	private ArrayList<E> theData;
	private Comparator<E> comparator = null; 
	
	public MinHeap()
	{
		theData = new ArrayList<E>();
		
	}
	
	/** Creates a heap-based priority queue with the specified initial
	capacity that orders its elements according to the specified
	comparator.
	@param cap The initial capacity for this priority queue
	@param comp The comparator used to order this priority queue
	@throws IllegalArgumentException if cap is less than 1
	*/
	public MinHeap(Comparator<E> comp, int cap)
	{
		if (cap < 1) 
		{
			throw new IllegalArgumentException();
		}
		theData = new ArrayList<E>(cap);
		comparator = comp;
	}
	
	public int compare(Object parent, Object child)
	{
		
		if(comparator != null)
		{
			return comparator.compare((E)parent, (E)child);
		}
		else
		{
			return ((Comparable<E>) parent).compareTo((E)child);
		}
		
		
	}


	//why can't I use E as the type for item?
	public boolean offer(Object item) 
	{
		// Add the item to the heap.
		theData.add((E)item);
		
		// child is newly inserted item.
		int child = theData.size() - 1;
		int parent = (child - 1) / 2; // Find child’s parent.
		
		// Reheap
		while (parent >= 0 && compare(theData.get(parent), theData.get(child)) > 0) //as long as the parent has a higher value than the child
		{
			swap(parent, child);
			child = parent;
			parent = (child - 1) / 2;
		}
		return true;
	}
	
	public void swap(int parent , int child) 
	{
		E temp = theData.get(parent);
		theData.set(parent, theData.get((int) child));
		theData.set(child, temp);
		
	}
	
	
	public Object poll()
	{
		if (isEmpty()) 
		{
			return null;
		}
		
		// Save the top of the heap.
		E result = theData.get(0);
		// If only one item then remove it.
		if (theData.size() == 1) 
		{
			theData.remove(0);
			return result;
		}
		/* Remove the last item from the ArrayList and place it into
		the first position. */
		theData.set(0, theData.remove(theData.size() - 1));
		// The parent starts at the top.
		int parent = 0;
		
		int leftChild;	
		int minChild;
		int rightChild;
		
		//reheap
		do
		{
			leftChild = 2 * parent + 1;
		
			if(leftChild >= theData.size())
			{
				break;
			}
			
			rightChild = leftChild + 1;
			minChild = leftChild; // Assume leftChild is smaller.
			// See whether rightChild is smaller.
			
			if (rightChild < theData.size()	&& compare(theData.get(leftChild), theData.get(rightChild)) > 0) 
			{
				minChild = rightChild;
			}
			// assert: minChild is the index of the smaller child.
			// Move smaller child up heap if necessary.
			if (compare(theData.get(parent), theData.get(minChild)) > 0) //still have to check for the first time
			{
				swap(parent, minChild);
				parent = minChild;
			} 
		}
		while(compare(theData.get(parent), theData.get(minChild)) > 0);
		
		
		return result;
		
	}

	
	public Object peek() 
	{
		if(isEmpty())
		{
			return null;
		}
		else
		{
			return theData.get(0);
		}
	}
	
	
	public boolean isEmpty() 
	{
		return theData.isEmpty();
	}

	public String toString() 
	{
		String output = "";
		for(int i = 0; i < theData.size(); i++)
		{
			output += theData.get(i).toString() + ", ";
		}
		// TODO Auto-generated method stub
		return output;
	}
}
