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
public class BinaryTree<E> implements Serializable 
{
	protected Node<E> root;
	
	
	public BinaryTree()
	{
		root = null;
	}
	
	
	public BinaryTree(Node<E> root)
	{
		this.root = root;
	}
	
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
	
	
	public boolean isLeaf()
	{
		return (root.left == null && root.right == null); 
	}
	
	public String toString() 
	{
		 StringBuilder sb = new StringBuilder();
		 preOrderTraverseChart(root, 1, sb);
		 return sb.toString();
	} 
	
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
	
	public void preOrderTraverseChart(Node<E> node, int depth, StringBuilder sb)
	{
		 if (node == null) 
		 {
			 sb.append("");
		 } 
		 else 
		 {
			 
			 String nodeString = node.toString() + "\n";
			 if(!(nodeString.equals("Code : code = No Letter : letter = No Letter" + "\n")))
			 {
				 sb.append(nodeString);
			 }
			 preOrderTraverseChart(node.left, depth + 1, sb);
			 preOrderTraverseChart(node.right, depth + 1, sb);
		 }
	}
	
	public E getData()
	{
		return this.root.data;
	}
	
	protected static class Node<E> implements Serializable 
	{
		protected Node<E> left; 
		protected Node<E> right; 
		protected E data; 
		
		public Node(E data)
		{
			this.left = null;
			this.right = null;
			this.data = data;
			
		}
		
		public String toString()
		{
			return data.toString();
		}
	}
	
	
}
