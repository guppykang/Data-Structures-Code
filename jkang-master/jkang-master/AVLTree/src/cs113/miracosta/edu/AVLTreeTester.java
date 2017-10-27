package cs113.miracosta.edu;
import BinaryTree.*;

/**
 * 
 * @author Joshua Kang
 * @version 1.0
 * Program Name: avl and binary search tree tester
 * Program Description: adds a series of integers to a Binary Search Tree and a self balancing AVL tree
 * Algorithm: 
 * create an AVL Tree
 * Create a search Tree
 * add the numbers 30, 15, 40, 25, 90, 80, 70, 85, 72 to both trees for testing purposes
 * call the in order traversal method for both trees
 * next try to add random numbers
 * 
 * 
 *
 */
public class AVLTreeTester 
{
	public static void main (String[] args)
	{
		AVLTree<Integer> avl = new AVLTree<Integer>();
		BinarySearchTree<Integer> searchTree = new BinarySearchTree<Integer>();
		
	/*	searchTree.add(30);
		searchTree.add(15);
		searchTree.add(40);
		searchTree.add(25);
		searchTree.add(90);
		searchTree.add(80);
		searchTree.add(70);
		searchTree.add(85);
		searchTree.add(72);
		
		avl.add(30);
		avl.add(15);
		avl.add(40);
		avl.add(25);
		avl.add(90);
		avl.add(80);
		avl.add(70);
		avl.add(85);
		avl.add(72);*/
		
		for(int i = 0; i < 10; i++)
		{
			int newInt = (int)(Math.random()*1000) + 1; 
			System.out.println("adding : " + newInt);
			searchTree.add(newInt);
			avl.add(newInt);
			
		}
		
		//for some reason the AVL Tree does not print correctly but repeats some of the values. 
		//However, the construction and rebalancing of the tree is correct, but for some reason it does not 
		//want to print out correctly. Sometimes it prints out correctly, sometimes it crashes, sometimes it prints out 
		//odd repeated numbers
		System.out.print("AVL Tree balanced: ");
		avl.printTree();
		System.out.println("\nHeight : "  + avl.getHeight());
		
		System.out.print("\nBinary Search Tree :");
		searchTree.printTree();
		System.out.println("\nHeight : "  + searchTree.getHeight());
		
		
	}
	
	
	
	
}
