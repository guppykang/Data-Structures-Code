package heap;

public abstract class Heap<E>
{
	//insert, remove, toString, peek, is empty
	
	/**
	 * 
	 * Description: adds a new node to the heap in its correct position
	 * @param item
	 * @return boolean
	 */
	public abstract boolean offer(E item);
	
	/**
	 * 
	 * Description: swaps the position of a parent and a hcild node
	 * @param parent
	 * @param child
	 */
	public abstract void swap(int parent, int child);
	
	/**
	 * 
	 * Description: removes the smallest/largest (depending on min or max heap) and replaces it with the last item of the heap 
	 * @return E 
	 */
	public abstract E poll();
	
	/**
	 * 
	 * Description: returns the value of the first element in the list. 
	 * @return E
	 */
	public abstract E peek();
	
	/**
	 * Description: returns all the values in the Heap
	 * @return String
	 */
	public abstract String toString();
	
	/**
	 * 
	 * Description: returns positive if the value of the parent is greater than the child, 0 for the same, and negative if
	 * the parent has a lower value than the child
	 * @param parent
	 * @param child
	 * @return int
	 */
	public abstract int compare(E parent, E child);
	
	/**
	 * 
	 * Description: returns if the ArrayList is empty
	 * @return boolean
	 */
	public abstract boolean isEmpty();
	
}
