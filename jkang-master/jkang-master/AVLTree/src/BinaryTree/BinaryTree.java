package BinaryTree;

import java.io.Serializable;
/**
 * 
 * @author Joshua Kang
 * @version 1.0
 * Program Name: Binary Tree class
 * Program Description: This class keeps track of a binary tree that consists of a root, left subtree, and right subtree
 * 
 * 
 * @param <E>
 */

//ADD DOCUMENTATION TO THE CODE

public class BinaryTree<E> implements Serializable 
{
	protected Node<E> root;
	
	/**
	 * default constructor
	 */
	public BinaryTree()
	{
		root = null;
	}
	
	/**
	 * Full Constructor for Root
	 * @param root
	 */
	public BinaryTree(Node<E> root)
	{
		this.root = root;
	}
	
	/**
	 * Creates a new Binary Tree with the left and right tree provided and data as the root
	 * @param data
	 * @param leftTree
	 * @param rightTree
	 */
	public BinaryTree(E data, BinaryTree<E> leftTree, BinaryTree<E> rightTree)
	{
		root = new Node<E>(data);
		if (leftTree != null)
		{
			root.left = leftTree.root;
		} 
		else 
		{
			root.left = null;
		}
		if (rightTree != null) 
		{
			root.right = rightTree.root;
		}
		else 
		{
			root.right = null;
		} 
	}
	
	/**
	 * 
	 * Description: returns the left subtree
	 * @return BinaryTree<E>
	 */
	public BinaryTree<E> getLeftSubtree() 
	{
		 if (root != null && root.left != null) 
		 {
			 return new BinaryTree<E>(root.left);
		 }
		 else 
		 {
			 return null;
		 }
	} 
	
	/**
	 * 
	 * Description: returns the right subtree
	 * @return BinaryTree<E>
	 */
	public BinaryTree<E> getRightSubtree() 
	{
		 if (root != null && root.right != null) 
		 {
			 return new BinaryTree<E>(root.right);
		 }
		 else 
		 {
			 return null;
		 }
	} 
	
	/**
	 * 
	 * Description: returns if the calling node is a leaf node 
	 * @return boolean
	 */
	public boolean isLeaf()
	{
		return (root.left == null && root.right == null); 
	}
	
	/**
	 * prints out the BinaryTree as a String
	 */
	public String toString() 
	{
		 StringBuilder sb = new StringBuilder();
		 preOrderTraverse(root, 1, sb);
		 return sb.toString();
	} 
	
	/**
	 * x
	 * Description: uses recursion to do the preorder Traversing through the tree
	 * @param node
	 * @param depth
	 * @param sb
	 */
	private void preOrderTraverse(Node<E> node, int depth, StringBuilder sb) 
	{
		 for (int i = 1; i < depth; i++) 
		 {
			 sb.append(" ");
		 }
		 if (node == null) 
		 {
			 sb.append("null\n");
		 } 
		 else 
		 {
			 String nodeString = node.toString() + "\n";
			 sb.append(nodeString);
			 preOrderTraverse(node.left, depth + 1, sb);
			 preOrderTraverse(node.right, depth + 1, sb);
		 }
	}
	
	/**
	 * 
	 * Description: returns the root's data
	 * @return
	 */
	public E getData()
	{
		return this.root.data;
	}
	
	/**
	 * 
	 * @author Joshua Kang
	 * @version
	 * Program Name: Node
	 * Program Description: keeps track of a Node's left and right nodes, and it's data 
	 * 
	 * @param <E>
	 */
	protected static class Node<E> implements Serializable 
	{
		protected Node<E> left; 
		protected Node<E> right; 
		protected E data; 
		
		/**
		 * full constructor
		 * @param data
		 */
		public Node(E data)
		{
			this.left = null;
			this.right = null;
			this.data = data;
			
		}
		
		/**
		 * copy constructor
		 * @param other
		 */
		public Node(Node<E> other)
		{
			this.left = other.left;
			this.right = other.right;
			this.data = other.data;
		}
		
		/**
		 * returns the string version of the data
		 */
		public String toString()
		{
			return data.toString();
		}
	}
	
	
}
