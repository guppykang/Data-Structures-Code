package BinaryTree;

import BinaryTree.BinaryTree.Node;

/**
 * 
 * @author Joshua Kang
 * @version 1.0
 * Program Name: AVL Tree
 * Program Description: keeps track of an AVL Tree: a self balancing tree that maintains balancing
 * pre : no repitions
 * @param <E>
 */
public class AVLTree <E extends Comparable<E>> extends BinarySearchTree <E>
{
	
	/**
	 * Private inner class AVL Tree
	 * @author Joshua Kang
	 * @version 1.0
	 * Program Name: AVL Node
	 * Program Description: Keeps track of an AVL Tree's nodes
	 * 
	 * @param <E>
	 */
	private class AVLNode<E> extends Node<E>
	{
		private int balance;
		private AVLNode<E> left;
		private AVLNode<E> right;
		
		public static final int LEFT_HEAVY = -1;
		public static final int BALANCED = 0;
		public static final int RIGHT_HEAVY = 1;
		
		/**
		 * Full Constructor
		 * @param data
		 */
		public AVLNode(E data)
		{
			super(data);
			left = null;
			right = null;
		}
		
		/**
		 * 
		 * Description: returns the balance of the tree 
		 * @return
		 */
		public int getBalance()
		{
			return this.balance;
			
		}
		
		/**
		 * 
		 * Description: sets the balance
		 * @param balance
		 */
		public void setBalance(int balance)
		{
			this.balance = balance;
		}
		
		/**
		 * Returns the data in the form of a string
		 */
		public String toString()
		{
			return data.toString();
		}
		
	}
	
	private boolean increase;
	
	/**
	 * Default Constructor
	 */
	public AVLTree()
	{
		super();
		
	}
	
	/**
	 * full constructor
	 * @param root
	 */
	public AVLTree(AVLNode<E> root)
	{
		this.root = root;
	}
	
	/**
	 * add started method
	 * 
	 * pre: The item to insert implements the Comparable interface
	 * 
	 * @param item The item being inserted.
	 * @return true if the object is inserted; false
	 * 			if the object already exists in the tree
	 * @throws ClassCastException if item is not Comparable
	 */
	@Override
	public boolean add(E item) 
	{
		if(this.contains(item))
		{
			System.out.println("repetition");
			return false;
		}
		increase = false;
		root = add((AVLNode<E>) root, item);
		return addReturn;
	}
	/**
	 * Recursive add method. Inserts the given object into the tree.
	 * 
	 * post: addReturn is set to true if the item is inserted,
	 * 			false if the item is already in the tree.
	 * 
	 * @param localRoot The local root of the subTree
	 * @param item The object to be inserted
	 * @return The new local root of the subtree with the item inserted
	 */
	private AVLNode<E> add(AVLNode<E> localRoot, E item) 
	{
		if (localRoot == null) 
		{
			addReturn = true;
			increase = true;
			return new AVLNode<E>(item);
		}
		if (item.compareTo(localRoot.data) == 0) 
		{
			// Item is already in the tree
			increase = false;
			addReturn = false;
			return localRoot;
		} 
		else if (item.compareTo(localRoot.data) < 0)
		{
			// item < data
			localRoot.left = add((AVLNode<E>) localRoot.left, item);
			if (increase) 
			{
				decrementBalance(localRoot);
				if (localRoot.balance < AVLNode.LEFT_HEAVY) 
				{
					increase = false;
					return rebalanceLeft(localRoot);
				}
			}
		} 
		else 
		{
			// item > data
			localRoot.right = add((AVLNode<E>) localRoot.right, item);
			
			if (increase) 
			{
				incrementBalance(localRoot);
				if (localRoot.balance > AVLNode.RIGHT_HEAVY) 
				{
					increase = false;
					return rebalanceRight(localRoot);
				}
			}
		}
		
		return localRoot; // Rebalance not needed
	}
	/**
	 * Method to rebalance left
	 * 
	 * pre: localRoot is the root of an AVL subtree  that is
	 * 		critically left-heavy
	 * post: Balance is restored
	 * 
	 * @param localRoot Root of the AVL subtree that needs rebalancing
	 * @return a new localRoot
	 */
	private AVLNode<E> rebalanceLeft(AVLNode<E> localRoot)
	{
		// Obtain reference to left child
		AVLNode<E> leftChild = (AVLNode<E>) localRoot.left;
		// See whether left-right heavy
		if (leftChild.balance > AVLNode.BALANCED)
		{
			// Obtain reference to left-right child 
			AVLNode<E> leftRightChild = (AVLNode<E>) leftChild.right;
			/**
			 * Adjust the balances to be their new values after their new rotations
			 * are performed
			 */
			if (leftRightChild.balance < AVLNode.BALANCED)
			{
				leftChild.balance = AVLNode.BALANCED;
				leftRightChild.balance = AVLNode.BALANCED;
				localRoot.balance = AVLNode.RIGHT_HEAVY;
			}
			else
			{
				leftChild.balance = AVLNode.LEFT_HEAVY;
				leftRightChild.balance = AVLNode.BALANCED;
				localRoot.balance = AVLNode.BALANCED;
			}
			// Perform left rotation
			localRoot.left = rotateLeft(leftChild);
		} 
		else 
		{
			/**
			 * left-left case
			 * In this case the leftChild (the new root)
			 * and the root (new right child) will be balanced after the
			 * rotation
			 */
			leftChild.balance = AVLNode.BALANCED;
			localRoot.balance = AVLNode.BALANCED;
		}
		// Now rotate the local root right
		return (AVLNode<E>) rotateRight(localRoot);
	}
	/**
	 * Method to rebalance right
	 * 
	 * pre: localRoot is the root of an AVL subtree  that is
	 * 		critically right-heavy
	 * post: Balance is restored
	 * 
	 * @param localRoot Root of the AVL subtree that needs rebalancing
	 * @return a new localRoot
	 */
	private AVLNode<E> rebalanceRight(AVLNode<E> localRoot)
	{
			// Obtain reference to right child
			AVLNode<E> rightChild = (AVLNode<E>) localRoot.right;
			// See whether right-left heavy //MUST ALSO CHANGE THE > TO A <!!!!
			if (rightChild.balance < AVLNode.BALANCED) 
			{
				// Obtain reference to right-left child 
				AVLNode<E> rightLeftChild = (AVLNode<E>) rightChild.left;
				/**
				 * Adjust the balances to be their new values after their new rotations
				 * are performed
				 */
				//Right-Left-Right 
				if (rightLeftChild.balance > AVLNode.BALANCED) 
				{
					rightChild.balance = AVLNode.BALANCED;
					rightLeftChild.balance = AVLNode.BALANCED;
					localRoot.balance = AVLNode.LEFT_HEAVY;
				} 
				else
				{
					// Right-Left-left
					rightChild.balance = AVLNode.RIGHT_HEAVY;
					rightLeftChild.balance = AVLNode.BALANCED;
					localRoot.balance = AVLNode.BALANCED;
				}
				// Perform right rotation
				localRoot.right = rotateRight(rightChild);
			}
			else 
			{
				/**
				 * right-right case
				 * In this case the rightChild (the new root)
				 * and the root (new left child) will be balanced after the
				 * rotation
				 */
				rightChild.balance = AVLNode.BALANCED;
				localRoot.balance = AVLNode.BALANCED;
			}
			// Now rotate the local root right
			return (AVLNode<E>) rotateLeft(localRoot);
	}
	
	/**
	 * 
	 * Description: decrements the balance and if it is balanced sets increase to false
	 * @param node
	 */
	private void decrementBalance(AVLNode<E> node)
	{
		// Decrement the balance
		node.balance--;
		if (node.balance == AVLNode.BALANCED) 
		{
			/**
			 * If now balanced, overall height has not increased.
			 */
			increase = false;
		}
	}
	
	/**
	 * 
	 * Description: increments the balance of the node, and if it is equal to 0, sets increase to false
	 * @param node
	 */
	private void incrementBalance(AVLNode<E> node)
	{
		// Increment the balance
		node.balance++;
		if (node.balance == AVLNode.BALANCED)
		{
			/**
			 * If now balanced, overall height has not decreased
			 */
			increase = false;
		}
	}
	
	/**
	 * 
	 * Description: perfroms the counter clock wise rotation
	 * @param root
	 * @return AVLNode<E>
	 */
	private AVLNode<E> rotateRight(AVLNode<E> root)
	{
		AVLNode<E> temp = root.left;
		root.left = root.right;
		temp.right  = root;
		return temp;
	}
	
	/**
	 * 
	 * Description: performs the counter-clockwise rotation 
	 * @param root
	 * @return AVLNode<E>
	 */
	private AVLNode<E> rotateLeft(AVLNode<E> root)
	{
		AVLNode<E> temp = root.right;
		root.right = root.left;
		temp.left = root;
		return temp;
	}
	/**
	 * 
	 * Description: prints out the in order traversal of the tree 
	 * @param localRoot
	 */
	private void printInOrder(AVLNode<E> localRoot)
	{
		if (localRoot == null)
		{
			return;
		}
		//traverse to the left side
        printInOrder(localRoot.left);
 
        //print the data of the node
        System.out.print(localRoot.data + " ");
 
        //traverse to the right
        printInOrder(localRoot.right);
		 
	}
	 /**
	  * helper method that prints out the contents of an AVL tree
	  */
	public void printTree()
	{
		printInOrder((AVLTree<E>.AVLNode<E>) root);
	}
	
	/**
	 * 
	 * Description: returns the height of the tree
	 * @param node
	 * @return int 
	 */
	public int getHeight(AVLNode<E> node)
	{
	    if (node == null)
	    {
	        return 0;
	    }
	    else
	    {
	        return 1 + Math.max(getHeight(node.left), getHeight(node.right));
	    }
	}
	
	/**
	 * 
	 * Description: calls the recursive method getHeight
	 * @return int
	 */
	public int getHeight()
	{
		return getHeight((AVLTree<E>.AVLNode<E>) root);
		
	}
	
	
}