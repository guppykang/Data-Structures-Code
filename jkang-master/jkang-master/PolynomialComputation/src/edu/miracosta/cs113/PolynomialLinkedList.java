package edu.miracosta.cs113;

/**
 * 
 * @author Joshua Kang
 * @version 1.0
 * Program Name: Polynomial Linked List 
 * Program Description: Keeps track of a list of Linked List, although it can be done easier with an Array list. 
 * Class Invariant: When adding nodes to the Linked List, the order of powers in the term must be in decreasing order.
 */
public class PolynomialLinkedList 
{
	private class Node
	{
		private Term term;
		private Node next;
		
		public Node()
		{
			term = null;
			next = null;
		}
		
		public Node(Term term, Node next)
		{
			this.term = term;
			this.next = next;
		}
		
		public Node(Term term)
		{
			this.term = term;
			this.next = null;
		}
		
	}
	
	private Node head;
	private int size;
	
	public PolynomialLinkedList()
	{
		head = null;
	}
	
	/**
	 * 
	 * Description: returns the Node at the given index
	 * @param index
	 * @return Node
	 */
	public Node getNode(int index)
	{
		if(this.isValidIndex(index) == false)
		{
			System.out.println("Invalid index!!!");
			return null;
		}
		Node current  = head;
		int i = 0; 
		while(i < index && current != null)
		{
			current = current.next;
			i++;
		}
		return current;
	}
	
	private void addAfter(Term term, Node node)
	{
		node.next = new Node(term, node.next);
		
	}
	
	private void addFirst(Term term)
	{
		if(size != 0)
		{	
			head = new Node(term, head.next);
		}
		else
		{

			head = new Node(term);
		}
		
		size++;
	}
	/**
	 * 
	 * Description: If the size is 0, then we add the new node to the head. Otherwise, the new node is added
	 * to the end. Increments the size of the list. 
	 * @param term
	 */
	public void addLast(Term term)
	{
		if(size == 0)
		{
			this.addFirst(term);
		}
		else
		{
			Node node = getNode(size-1);
			addAfter(term, node);
		}
		
	}
	

	/**
	 * 
	 * Description: checks if the given index exists in the list
	 * @param index
	 * @return boolean
	 */
	public boolean isValidIndex(int index)
	{
		if(index < 0 || index >= size)
		{
			return false;
		}
		else
		{
			return true;	
		}
	}
	
	/**
	 * 
	 * Description: adds two polynomials together.
	 * pre-condition: the polynomial's powers must be in decreasing order. (eg. x^4 + x^2 + 1) 
	 * @param other
	 * @return String
	 */
	public String addPolynomials(PolynomialLinkedList other)
	{
		int callerIndex = 0;
		int otherIndex = 0;
		String result = "";
		
		
		
		while(this.getSize() != 0 || other.getSize() != 0)
		{
			Term callerTerm= null;
			Term otherTerm = null;
			if(this.size == 0)
			{
				callerTerm = new Term(0,0);
			}
			else
			{
				callerTerm = this.getNode(callerIndex).term;
			}
			if(other.size == 0)
			{
				callerTerm = new Term(0,0);
			}
			else
			{
				otherTerm = other.getNode(otherIndex).term;
			}
			
			
			
			if(callerTerm.getExponent() > otherTerm.getExponent())
			{
				result += callerTerm.getCoefficient() + "x^" + callerTerm.getExponent();
				this.removeFirst();
				//blaaaaaa
			}
			else if(callerTerm.getExponent() < otherTerm.getExponent())
			{
				result += otherTerm.getCoefficient() + "x^" + otherTerm.getExponent();
				other.removeFirst();
			}
			else
			{
				result += (otherTerm.getCoefficient() + callerTerm.getCoefficient()) + "x^" + otherTerm.getExponent() ;
				this.removeFirst();
				other.removeFirst();
			}
			if(this.getSize() != 0 || other.getSize() != 0)
			{
				result += " + ";
			}
		}
			
		return result;
			
		
	}
	public void removeFirst() 
	{
        if (head == null)
        {
        	return;
        }
        else 
        {
              if (size == 1)
              {
                    head = head.next;
                    
              }
              else 
              {
                    head = head.next;
              }
        }
        size--;
	}
	
	
	
	/**
	 * 
	 * Description: return the size of the linked List 
	 * @return int
	 */
	public int getSize()
	{
		return this.size;
	}
	
	
	
}
