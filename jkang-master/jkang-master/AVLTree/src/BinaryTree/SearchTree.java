package BinaryTree;

public interface SearchTree<E> 
{
	public boolean add(E item);
	
	public boolean contains(E item);
	
	public E find(E item);
	
	public E remove(E item);
	
}
