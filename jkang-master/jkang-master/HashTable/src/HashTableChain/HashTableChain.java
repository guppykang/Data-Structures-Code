package HashTableChain;

import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;

/**
 * 
 * @author Joshua Kang
 * @version 1.0
 * * Program Name: Hash Table Chain 
 * Program Description: Creates a Hash table that holds an array of Linkedlists to store a key and a value's information effectively 
 * 
 * @param <K>
 * @param <V>
 */
public class HashTableChain<K, V> implements KWHashMap<K, V>
{
	/** The table */
	private LinkedList<Entry<K, V>>[] table;
	
    /** The number of keys */
    private int numKeys;
    
    /** The capacity */
    private static final int CAPACITY = 101;
    
    /** The maximum load factor */
    private static final double LOAD_THRESHOLD = 3.0;
    
    /**
     * 
     * @author Joshua Kang
     * @version
     * Program Name: Entry
     * Program Description: Creates an Entry which is an object that holds the value of a key and a value that will be 
     * stored in the Hash Table's table instance varaible
     * 
     * @param <K>
     * @param <V>
     */
    private static class Entry<K,V> implements Map.Entry<K, V>
    {
    	private K key; 
    	private V value; 
    	
    	/**
    	 * Description : creates a new Entry object
    	 * @param key
    	 * @param value
    	 */
    	public Entry(K key, V value)
    	{
    		this.key = key;
    		this.value = value;
    	}
    	
    	/**
    	 * 
    	 * Description: return the key
    	 * @return K
    	 */
		@Override
		public K getKey() 
		{
			return this.key;
		}
		
		/**
		 * 
		 * Description: returns the value 
		 * @return V
		 */
		@Override
		public V getValue() 
		{
			return this.value;
			
		}

		/**
		 * 
		 * Description: sets this.value to the value in the paramter
		 * @param value
		 * @return V
		 */
		@Override
		public V setValue(V value) 
		{
			this.value = value;
			return value;
		}
		
		/**
		 * 
		 * Description: returns a string representation of the Entry 
		 * @return String
		 */
		@Override
		public String toString()
		{
			return "" + key + " = " + value;
		}
    	
    }

    /** Inner class to implement the set view. */
    private class EntrySet extends java.util.AbstractSet<Map.Entry<K, V>> 
    {
	    /** Return the size of the set. */
	    @Override
	    public int size() 
	    {
	    	return numKeys;
	    }
	    /** Return an iterator over the set. */
	    @Override
	    public Iterator<Map.Entry<K, V>> iterator()
	    {
	    	return new SetIterator();
	    }
	}
    
    
    /** Inner class to implement the set iterator. */
    private class SetIterator implements Iterator<Map.Entry<K, V>>
    {
	    private int lastItemReturned = -1;
    	int index = 0;
	    Iterator<Entry<K, V>> localIterator = null;
	    
	    @Override
	    public boolean hasNext()
	    {
		    if (localIterator != null) 
		    {
			    if (localIterator.hasNext()) 
			    {
			    	return true;
			    
			    }
			    else 
			    {
				    localIterator = null;
				    index++;
			    }
		    }
		    while (index < table.length && table[index] == null) 
		    {
		    	index++;
		    }
		    if (index == table.length) 
		    {
		    	return false;
		    }
		    localIterator = table[index].iterator();
		    return localIterator.hasNext();
	    }
	    
	    /**
	     * 
	     * Description: moves the iterator down one step. reinitializes the last item returned to the index of the value that 
	     * the iterator just passed over 
	     * @return Map.Entry<K, V> 
	     */
	    @Override
	    public Map.Entry<K, V> next() 
	    {
	    	if(this.hasNext())
	    	{
	    		Map.Entry<K, V> nextValue = localIterator.next();
	    		lastItemReturned = index;
	    		index ++;
	    		
	    		return nextValue;
	    	}
	    	else
	    	{
	    		throw new NoSuchElementException();
	    	}
	    }
	    
	    
	    /**
	     * 
	     * Description: removes the item and the index of the last item returned. Resets last  item returned to -1
	     * The next method must be called in order to call this method. 
	     */
	    @Override
	    public void remove() 
	    {
	    	 if (lastItemReturned == -1)
	    	 {
	    		 throw new IllegalStateException();
	         } 
	    	 else 
	    	 {
	    		 localIterator.remove();
	    		 lastItemReturned = -1;
	    		 
	    	 }
	    }
	    
    }
    
    /*<exercise chapter="7" type="programming-project" number="7">*/
    public java.util.Set<Map.Entry<K, V>> entrySet() 
    {
    	return new EntrySet();
    }
    
   

    /**
     * Creates a new HashTableChain by creating a new array of LinkedLists
     */
	@SuppressWarnings("unchecked")
	public HashTableChain()
    {
    	table = (LinkedList<Entry<K, V>>[])new LinkedList[CAPACITY];
    }
    
  /**
   * 
   * Description: returns a boolean saying if the array is empty.  
   * @return boolean
   */
	@Override
	public boolean isEmpty() 
	{
		return (numKeys == 0);
	}

	
	/**
	 * 
	 * Description: returns the value at the given key
	 * @param key
	 * @return V
	 */
	@Override
	public V get(Object key) 
	{
		int index = key.hashCode() % table.length;
		if(index < 0)
		{
			index += table.length;
		}
		
		if(table[index] == null)
		{
			//not found
			return null;
		}
		for(Entry<K, V> element : table[index])
		{
			if(element.key == key)
			{
				return element.value;
			}
		}
		
		//returns null if the key was not found
		return null;
	}

	/**
	 * 
	 * Description: adds a new Entry with the key and value into the table. 
	 * @param key
	 * @param value
	 * @return
	 */
	@Override
	public V put(K key, V value) 
	{
		int index = key.hashCode() % table.length;
		if(index < 0)
		{
			index += table.length;
		}
		
		if(table[index] == null)
		{
			table[index] = new LinkedList<Entry<K,V>>();
		}
		
		for(Entry<K, V> element : table[index])
		{
			if(element.key == key)
			{
				V oldValue = element.value;
				element.setValue(value);
				return oldValue;
			}
		}
		
		//insert at the beginning for runtime efficiency
		table[index].addFirst(new Entry<K, V>(key, value));
		numKeys++;
		
		if((numKeys/table.length) > LOAD_THRESHOLD )
		{
			rehash();
		}
		
		//return null if we had to rehash
		return null;
	}

	// Difference here is that you loop over the table
	@Override
	public String toString() 
	{
		String result = ""; 
		for(LinkedList<Entry<K, V>> linkedList : table)
		{
			
			if (linkedList != null) 
			{
				for (Entry<K, V> node : linkedList) 
				{
					result += node.toString() + "\n";
				} 
			}
		}
		return result;
	}
	
	/*<exercise chapter="7" section="4" type="programming" number="5">*/
	/** Returns the number of entries in the map */
	@Override
	public int size()
	{
		return numKeys;
		
	}
	
	/**
	 * 
	 * Description: removes the Entry with the given key
	 * @param key
	 * @return V
	 */
	@Override
	public V remove(Object key)
	{
		int index = key.hashCode() % table.length;
		if(index < 0)
		{
			index += table.length;
		}
		
		if(table[index] == null)
		{
			return null;
		}
		
		if(table[index].isEmpty())
		{
			table[index] = null;
			return null;
		}
		
		for(Entry<K, V> element : table[index])
		{
			if(element.key == key)
			{
				table[index].remove(element);
				numKeys--;
				return element.value;
			}
		}
		
		//only reaches here if the key does not exist
		return null;
		
		
		
	}
	/**
	* Expands table size when loadFactor exceeds LOAD_THRESHOLD
	* @post the size of table is doubled and is an
	* odd integer. Each entry from the original
	* table is reinserted into the expanded table.
	*/
	// If you use the rehash of the HashtableOpen the difference is
	// in the reinsertion logic
	public void rehash()
	{
		LinkedList<Entry<K,V>>[] oldTable = table;
		table = (LinkedList<Entry<K, V>>[])new LinkedList[table.length * 2 + 1];
		numKeys = 0; 
		
		int index; 
		for(LinkedList<Entry<K, V>> linkedList : oldTable)
		{
			if(linkedList != null)
			{
				for(Entry<K, V> node : linkedList)
				{
					this.put(node.key, node.value);
					numKeys++;
				}
			}
			
		}
		
	}
	
    
}
