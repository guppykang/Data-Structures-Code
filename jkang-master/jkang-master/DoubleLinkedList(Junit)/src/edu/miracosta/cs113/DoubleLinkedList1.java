package edu.miracosta.cs113;



	import java.util.ArrayList;
	import java.util.Iterator;
	import java.util.Collection;
	import java.util.Iterator;
	import java.util.List;
	import java.util.ListIterator;
	import java.util.NoSuchElementException;
	import Polynomial.Term;
import Waitlist.Student;

	/**
	 * 
	 * @author Joshua Kang
	 * @version 1.0
	 * Program Name: Double Linked List
	 * Program Description: Keeps track of a list of nodes, with an iterator. Each node has a previous and next
	 * node. 
	 * DISCLAIMER : this double linked list class is special because it needed special extra methods in the
	 * single linked list class from last week. Therefore, to keep the original edition of the Double linked List
	 * class, this class is only used for the implementation of the waitlist and polynomial class. 
	 * Class Invariant: n/a
	 */
	public class DoubleLinkedList1<E> implements List<E>
	{
		private static class Node<E>
		{
			private E data;
			private Node<E> next;
			private Node<E> prev;
			
			/** Creates a new node with a null next field
			@param data The data stored
			*/
			private Node(E data)
			{
				this.data = data;
				this.next = null;
			}
			/** Creates a new node that references another node
			@param data The data stored
			@param nodeRef The node referenced by new node
			*/
			private Node(E data, Node<E> next, Node<E> prev)
			{
				this.data = data;
				this.next = next;
				this.prev = prev;
			}
			
		}
		
		
		private class DoubleListIterator implements ListIterator <E>
		{
			private Node<E> nextItem;
			private Node<E> lastItemReturned; 
			private int index = 0; 
					
			/**
			  * Description : creates a new DoubleListIterator at the specified index
			  * @param e
			  */
			public DoubleListIterator(int i) 
			{
				// error check index
				if (i < 0 || i > size) 
				{
					throw new IndexOutOfBoundsException("Invalid index " + i);
				}
				lastItemReturned = null; // No item returned yet
				// Special case of last item (why not let loop do this?)
				if (i == size) 
				{
					index = size;
					nextItem = null;
				} 
				else 
				{ // Start at the beginning
					nextItem = head;
					for (index = 0; index < i; index++) 
					{
						nextItem = nextItem.next;
					}
				}
			}//end constructor
			
			
			/**
			  * Description : adds the new obj right before nextItem
			  * @param obj
			  */
			@Override
			 public void add(E obj)
			 {
				 //if the list is empty
				 if (head == null) 
				 {
					 head = new Node<E>(obj);
					 tail = head;
				 }
				 
				 //if we are adding to the front of the list
				 else if (nextItem == head) 
				 {
					 Node<E> newNode = new Node<E>(obj);
					 newNode.next = nextItem;
					 nextItem.prev = newNode;
					 head = newNode;
				 }
				 //if we're adding to the end of the list
				 else if (nextItem == null)
				 {
					 Node<E> newNode = new Node<E>(obj);
					 tail.next = newNode;
					 newNode.prev = tail;
					 tail = newNode;
				 }
				 //if we are adding to somewhere in the list (list is at least 1 long)
				 else 
				 {
					 Node<E> newNode = new Node<E>(obj);
					 newNode.prev = nextItem.prev;
					 nextItem.prev.next = newNode;
					 newNode.next = nextItem;
					 nextItem.prev = newNode;
				 }
				 size++;
				 index++;
				 lastItemReturned = null;
			 }
			 
			/**
			  * Description : returns if there is a node right after the iterator
			  * @return boolean
			  */
			 @Override
			 public boolean hasNext() 
			 {
				 return nextItem != null;
			 }
			 
			 /**
			  * Description : iterates the iterator one forward
			  * @return E
			  */
			 @Override
			 public E next() 
			 {
				 if (!hasNext()) 
				 {
					 throw new NoSuchElementException();
				 }
				 lastItemReturned = nextItem;
				 nextItem = nextItem.next;
				 index++;
				 return lastItemReturned.data;
			 }
			 
			 /**
			  * Description : returns if their is a previous node right before the iterator
			  * @return boolean
			  */
			 @Override
			 public boolean hasPrevious()
			 {
				 return (nextItem == null && size != 0) || nextItem.prev != null;
			 }
			 
			 /**
			  * Description : moves the iterator back one index
			  * @return E
			  */
			 @Override
			 public E previous() 
			 {
				 if (!hasPrevious()) 
				 {
					 throw new NoSuchElementException();
				 }
				 if (nextItem == null)
				 { // Iterator past the last element
					 nextItem = tail;
				 }
				 else 
				 {
					 nextItem = nextItem.prev;
				 }
				 lastItemReturned = nextItem;
				 index--;
				 return lastItemReturned.data;
			 }
			 
			 /**
			  * Description : returns the next index
			  * @return int
			  */
			 @Override
			 public int nextIndex()
			 {
				 if(nextItem == null)
				 {
					 return size;
				 }
				 else
				 {
					 return index;
				 }
			 }

			 /**
			  * Description : returns the previous index
			  * @return int
			  */
			 @Override
			 public int previousIndex()
			 {
				 if(nextItem.prev == null)
				 {
					 return -1; 
					 
				 }
				 else
				 {
					 return index - 1;
				 }
			 }

			 /**
			  * Description : removes the lastItemReturned
			  */
			 @Override
			 public void remove()
			 {
				if(lastItemReturned == null)
				{
					return;
				}
				
				if(size == 1)
				{
					head = null;
					tail = null;
				}
				else if(lastItemReturned == head)
				{
					head = lastItemReturned.next;
					lastItemReturned.next.prev = null;
					
				}
				else if(lastItemReturned == tail)
				{
					Node<E> previous = lastItemReturned.prev;
					
					previous.next = null;
					tail = lastItemReturned.prev;
				}
				else
				{
					Node<E> before = lastItemReturned.prev;
					Node<E> after = lastItemReturned.next;
					before.next = after;
					after.prev = before;
					
				}
				size--;
				lastItemReturned = null;
			 }

			
			 /**
			  * Description : sets the lastItemReturned to e
			  * @param e
			  */
			 @Override
			 public void set(E e)
			 {
				 if(lastItemReturned == null)
				 {
					 return;
				 }
				 lastItemReturned.data = e;
				
			 }
			
			public int getIndex()
			{
				return this.index;
			}
			
		}
		private Node<E> head;
		private Node<E> tail;
		private int size;
		
		/**
		 * Constructor. Sets everything to null or 0, for an empty LinkedList
		 */
		public DoubleLinkedList1()
		{
			head = null;
			tail = null;
			size = 0;
		}
		/**
		 * 
		 * Description: returns a DoubleListIterator at the specified index
		 * @param index
		 * @return DoubleListIterator
		 */
		public DoubleListIterator listIterator(int index)
		{
			return new DoubleListIterator(index);
		}
		
		/**
		 * 
		 * Description: returns a DoubleListIterator that starts at the beginning of the list
		 * @return DoubleListIterator
		 */
		
		public DoubleListIterator listIterator()
		{
			return new DoubleListIterator(0);
		}
		
		/**
		 * 
		 * Description: returns an Iterator that starts at the beginning of the list
		 * @return Iterator<E>
		 */
		@Override
		public Iterator<E> iterator()
		{
			return  new DoubleListIterator(0);
		} 

		
		/** Add an item at the specified index.
		@param index The index at which the object is to be inserted
		@param obj The object to be inserted
		@throws IndexOutOfBoundsException
		if the index is out of range (i < 0 || i > size())
		*/
		public void add(int index, E obj) 
		{
			listIterator(index).add(obj);
		}
		
		/**
		 * 
		 * Description: add an object of type E to the end of the LinkedList
		 * @param e
		 * @return boolean
		 */
		@Override
		public boolean add(E e)
		{
			if(size == 0)
			{
				listIterator().add(e);
			}
			else
			{
				listIterator(this.size).add(e);
			}
			
			return true;
		}
		
		/**
		 * 
		 * Description: adds the collection to the end of the LinkedList
		 * @param c
		 * @return boolean
		 */
		@Override
		public boolean addAll(Collection<? extends E> c) 
		{
			E[] newArray = (E[])c.toArray();
			for(int i = 0; i < newArray.length; i++)
			{
				listIterator(this.size()).add(newArray[i]);
			}
			return true;
		}
		
		/**
		 * 
		 * Description: adds the collection at index in the specified order
		 * @param index
		 * @param c
		 * @return boolean
		 */
		@Override
		public boolean addAll(int index, Collection<? extends E> c) 
		{
			// TODO Auto-generated method stub
			E[] newArray = (E[])c.toArray();
			for(int i = 0; i < newArray.length; i++)
			{
				listIterator(index).add(newArray[i]);
				index++;
			}
			return true;
		}
		
		/**
		 * 
		 * Description: Removes the first occurrence of the specified element from this list, if it is present
		 * @param o
		 * @return boolean
		 */
		@Override
		public boolean remove(Object o) 
		{
			int index = this.indexOf(o);
			if(index == -1)
			{
				return false;
			}
			DoubleListIterator iterator = listIterator(index);
			iterator.next();
			iterator.remove();
			return true;
		}
		
		/**
		 * 
		 * Description: Removes the element at the specified position in this list
		 * @param index
		 * @return E
		 */
		@Override
		public E remove(int index) 
		{
			DoubleListIterator iterator = listIterator(index);
			iterator.next();
			E returnMessage = iterator.lastItemReturned.data;
			iterator.remove();
			return returnMessage;
		}
		
		/**
		 * 
		 * Description: Removes from this list all of its elements that are contained in the specified collection
		 * @param c
		 * @return boolean
		 */
		@Override
		public boolean removeAll(Collection<?> c) 
		{
			E[] newArray = (E[]) c.toArray();
			
			if(this.containsAll(c))
			{
				for(int i = 0; i < newArray.length; i++)
				{
					this.remove(newArray[i]);
					
				}
				return true;
			}
			else
			{
				return false;
			}
		}
		
		/** Get the element at position index.
		 @param index Position of item to be retrieved
		 @return The item at index
		 */
		 public E get(int index) 
		 {
			 return listIterator(index).next();
		 }
		 
		
		/**
		 * 
		 * Description: removes all the items in the LinkedList
		 */
		@Override
		public void clear() 
		{
			DoubleListIterator iterator = listIterator();
			//initialize to variable bc size changes as clearing
			int size = this.size;
			for(int i = 0; i < size; i++)
			{
				iterator.next();
				iterator.remove();
			}
		}
		
		/**
		 * 
		 * Description: checks if o is inside the LinkedList
		 * @param o
		 * @return boolean
		 */
		@Override
		public boolean contains(Object o) 
		{
			boolean isFound = false;
			DoubleListIterator iterator = listIterator();
			iterator.next();
			while(iterator.index <= this.size)
			{
				
				if(iterator.lastItemReturned.data.equals(o))
				{
					isFound = true;
				}
				if(iterator.hasNext() == true)
				{
					iterator.next();
				}
				else
				{
					iterator.index++;
				}
			}
			return isFound;
			
		}
		
		/**
		 * 
		 * Description: checks if the entire collection is present in the LinkedList
		 * @param c
		 * @return boolean
		 */
		@Override
		public boolean containsAll(Collection<?> c) 
		{
			E[] newArray = (E[])c.toArray();
			for(int i = 0; i < newArray.length; i++)
			{
				if(!this.contains(newArray[i]))
				{
					return false;
				}
			}
			return true;
		}
		
		/**
		 * 
		 * Description: returns the index of the first occurence of o in the LinkedList
		 * @param o
		 * @return int
		 */
		@Override
		public int indexOf(Object o) 
		{
			DoubleListIterator iterator = listIterator();
			iterator.next();
			while(iterator.index <= this.size)
			{
				
				if(iterator.lastItemReturned.data.equals(o))
				{
					
					return iterator.index-1;
				}
				if(iterator.hasNext() == true)
				{

					iterator.next();
				}
				else
				{
					iterator.index++;
				}
			}
			return -1;
		}
		
		/**
		 * 
		 * Description: Returns true if this list contains no elements.
		 * @return boolean
		 */
		@Override
		public boolean isEmpty() 
		{
			if(this.size == 0)
			{
				return true;
			}
			else
			{
				return false;
			}
		}
		
		/**
		 * 
		 * Description: Returns the index of the last occurrence of the specified element in this list, 
		 * or -1 if this list does not contain the element.
		 * @param o
		 * @return int
		 */
		@Override
		public int lastIndexOf(Object o) 
		{
			int index = -1;
			DoubleListIterator iterator = listIterator();
			for(int i = 0; i < this.size; i++)
			{
				iterator.next();
				if(iterator.lastItemReturned.data.equals(o))
				{
					index = i; 
				}
			}
			return index;
		}
		
		
		/**
		 * 
		 * Description: Retains only the elements in this list that are contained in the specified collection
		 * pre-condition : if there are more than one instance of an element in the collection, it only keeps
		 * one
		 * @param c
		 * @return boolean
		 */
		@Override
		public boolean retainAll(Collection<?> c) 
		{
			boolean isPresent = false;
			E[] newArray = (E[]) c.toArray();
			DoubleListIterator iterator = listIterator();
			
			for(int i = 0; i < this.size; i++)
			{
				iterator.next();
				for(int j = 0; j < newArray.length; j++)
				{
					if(iterator.lastItemReturned.data.equals(newArray[j]))
					{
						isPresent = true;
						//even though this is bad coding, saves runtime
						break;
					}
				}
				if(isPresent)
				{
					iterator.remove();
				}
				isPresent = false;
			}
			return true;
		}
		
		/**
		 * 
		 * Description: Replaces the element at the specified position in this list with the specified element
		 * @param index
		 * @param element
		 * @return E
		 */
		@Override
		public E set(int index, E element) 
		{
			DoubleListIterator iterator = listIterator(index);
			E oldData =  iterator.next();
			iterator.set(element);
			return oldData;
		}
		
		/**
		 * 
		 * Description: Returns the number of elements in this list.
		 * @return int
		 */
		@Override
		public int size() 
		{
			return this.size;
		}
		
		/**
		 * 
		 * Description: Returns a view of the portion of this list between the specified fromIndex, 
		 * inclusive, and toIndex, exclusive.
		 * @param fromIndex
		 * @param toIndex
		 * @return List<E>
		 */
		@Override
		public List<E> subList(int fromIndex, int toIndex) 
		{
			ArrayList<E> data = new ArrayList<E>();
			DoubleListIterator iterator = listIterator(fromIndex);
			
			if(toIndex < toIndex)
			{
				throw new IllegalArgumentException();
				
			}
			if(fromIndex == toIndex )
			{
				iterator.next();
				data.add(iterator.lastItemReturned.data);
			}
			else
			{
				for(int i = 0; i < (toIndex - fromIndex); i++)
				{
					iterator.next();
					data.add((E) iterator.lastItemReturned.data);
				}
			}
			
			return data;
			
		}
		
		/**
		 * 
		 * Description: Returns an array containing all of the elements in this list in proper sequence 
		 * (from first to last element).
		 * @return Object[]
		 */
		@Override
		public Object[] toArray() 
		{
			Object[] data = new Object[size];
			DoubleListIterator iterator = listIterator();
			for(int i = 0; i < size; i++)
			{
				Object obj = iterator.next();
				
				data[i] = obj;
				
				//data[i] = iterator.lastItemReturned.data;
			}
			return data;
		}
		
		/**
		 * 
		 * Description: Returns an array containing all of the elements in this list in proper sequence (from first to last element);
		 *  the runtime type of the returned array is that of the specified array.
		 * @param a
		 * @return E[]
		 */
		@Override
		public <E> E[] toArray(E[] a) 
		{
			int index =0;
			if(a.length < this.size)
			{
				a = (E[]) new Object[this.size];
			}
			DoubleListIterator iterator = listIterator();
			while (iterator.hasNext())
			{
				iterator.next();
				E element = (E) iterator.lastItemReturned.data;
				a[index] = element;
			}
			
			return a;
		}
		
		
		
		
		
	

	/**
	 * 
	 * Description: get all the students still remaining on the waitlist
	 * @return
	 */
	public String getWaitlisters()
	{
		String result = "";
		for(int i = 0; i < this.size; i++)
		{
			result += this.get(i) + "\n*********";
		}
		return result;
	}
	

	
	
	/**
	 * 
	 * Description: returns the name of the student at the given index in the LinkedList
	 * @param index
	 * @return String
	 */
	public String getStudentName(int index)
	{
		return (String) this.get(index);
	}
	
	/**
	 * 
	 * Description: adds two polynomials together.
	 * pre-condition: the polynomial's powers must be in decreasing order. (eg. x^4 + x^2 + 1) 
	 * @param other
	 * @return String
	 */
	public String addPolynomials(DoubleLinkedList1 other)
	{
		int callerIndex = 0;
		int otherIndex = 0;
		String result = "";
		
		
		
		while(this.size() != 0 || other.size() != 0)
		{
			Term callerTerm= null;
			Term otherTerm = null;
			if(this.size == 0)
			{
				callerTerm = new Term(0,0);
			}
			else
			{
				callerTerm = (Term) this.get(callerIndex);
			}
			if(other.size() == 0)
			{
				callerTerm = new Term(0,0);
			}
			else
			{
				otherTerm = (Term) other.get(otherIndex);
			}
			
			
			
			if(callerTerm.getExponent() > otherTerm.getExponent())
			{
				result += callerTerm.getCoefficient() + "x^" + callerTerm.getExponent();
				this.remove(0);
				//blaaaaaa
			}
			else if(callerTerm.getExponent() < otherTerm.getExponent())
			{
				result += otherTerm.getCoefficient() + "x^" + otherTerm.getExponent();
				other.remove(0);
			}
			else
			{
				result += (otherTerm.getCoefficient() + callerTerm.getCoefficient()) + "x^" + otherTerm.getExponent() ;
				this.remove(0);
				other.remove(0);
			}
			if(this.size() != 0 || other.size() != 0)
			{
				result += " + ";
			}
		}
			
		return result;
			
		
	}
}
