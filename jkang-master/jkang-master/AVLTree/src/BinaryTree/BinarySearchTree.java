package BinaryTree;

/**
 * 
 * @author Joshua Kang
 * @version
 * Program Name: Binary Search Tree 
 * Program Description: creates a Binary Search Tree that allows the user to find an element in O(log n) runtime
 * @param <E>
 */
public class BinarySearchTree<E> extends BinaryTree<E> implements SearchTree <E>
{
	protected boolean addReturn;
	protected E deleteReturn;
	
	/**
	 * default constructor
	 * sets default values for addReturn and deleteReturn 
	 */
	public BinarySearchTree()
	{
		addReturn = false;
		deleteReturn = null;
	}
	/** Starter method add.
		pre: The object to insert must implement the
		Comparable interface.
		@param item The object being inserted
		@return true if the object is inserted, false
		if the object already exists in the tree
	*/
	public boolean add(E item) 
	{
		if(this.contains(item))
		{
			System.out.println("repetition");
			return false;
		}
		root = add(root, item);
		return addReturn;
	}
	
	/** Recursive add method.
		post: The data field addReturn is set true if the item is added to
		the tree, false if the item is already in the tree.
		@param localRoot The local root of the subtree
		@param item The object to be inserted
		@return The new local root that now contains the
		inserted item
	*/
	private Node<E> add(Node<E> localRoot, E item) 
	{
		if (localRoot == null) 
		{
			// item is not in the tree — insert it.
			addReturn = true;
			return new Node<E>(item);
		} 
		//defaulted to integer values only
		else if (((Comparable<E>) item).compareTo(localRoot.data) == 0)  
		{
			// item is equal to localRoot.data
			addReturn = false;
			return localRoot;
		} 
		else if (((Comparable<E>) item).compareTo(localRoot.data) < 0)
		{
			// item is less than localRoot.data
			localRoot.left = add(localRoot.left, item);
			return localRoot;
		} 
		else 
		{
			// item is greater than localRoot.data
			localRoot.right = add(localRoot.right, item);
			return localRoot;
		}
	}

	/**
	 * sees if the item exists in the binary Search Tree through the use of the find method
	 */
	@Override
	public boolean contains(E item) 
	{
		return find(item) != null;
	}

	@Override
	/**
	 * Starter find method
	 * calls the recursive method find
	 */
	public E find(E target) 
	{
		return find(root, target);
	}

	/**
	 * 
	 * Description: Recursive find method
	 * @param localRoot
	 * @param target
	 * @return the object if found otherwise null
	 */
	private E find(Node<E> localRoot , E target)
	{
		if(localRoot == null)
		{
			return null;
		}
		int compResult = ((Comparable<E>) target).compareTo(localRoot.data);
		if(compResult == 0)
		{
			return localRoot.data;
			
		}
		else if (compResult < 0)
		{
			return find(localRoot.left, target);
		}
		else
		{
			return find(localRoot.right, target);
		}
	}

	@Override
	public E remove(E item) 
	{
		return remove(this.root, item);
	}
	
	/**
	 * 
	 * Description: removes the target from the root of the tree
	 * @param localRoot
	 * @param target
	 * @return E 
	 */
	private E remove(Node<E> localRoot, E target)
	{
		if(root == null)
		{
			return null;
		}
		
		if(((Comparable<E>) target).compareTo(localRoot.data) < 0)
		{
			return remove(localRoot.left, target);
		}
		else if (((Comparable<E>) target).compareTo(localRoot.data) > 0)
		{
			return remove(localRoot.right, target);
		}
		else
		{
			deleteReturn = localRoot.data;
			//if the local Root has no children
			if(localRoot.left == null && localRoot.right == null)
			{
				localRoot = null;
			}
			
			//if the local Root has only one child
			else if ((localRoot.left != null && localRoot.right == null)||(localRoot.left == null && localRoot.right != null))
			{
				if(localRoot.left != null)
				{
					localRoot = localRoot.left;
					localRoot.left = null;
				}
				else if(localRoot.right != null)
				{
					localRoot = localRoot.right;
					localRoot.right = null;
				}
			}
			
			//if the local Root has more than one child
			else
			{
				//if there is no predecessor
				if(localRoot.left.right == null)
				{
					localRoot = localRoot.left;
				}
				
				//if there is a predecessor but is further down the tree
				else
				{
					Node<E> current = localRoot;
					while(current.right != null)
					{
						current = current.right;
					}
					localRoot.data = current.data;
					current = current.left;
				}
			}
			
			return deleteReturn;
		}//end else (when the localRoot is the one that we want to remove)
	}
	/**
	 * 
	 * Description: prints out the in order traversal of the tree 
	 * @param localRoot
	 */
	private void printInOrder(Node<E> localRoot)
	{
		if (localRoot == null)
		{
			return;
		}
        /* first recur on left child */
        printInOrder(localRoot.left);
 
        /* then print the data of node */
        System.out.print(localRoot.data + " ");
 
        /* now recur on right child */
        printInOrder(localRoot.right);
		 
	}
	
	/**
	 * 
	 * Description: prints out the in order representation of the Binary Search Tree
	 */
	public void printTree()
	{
		printInOrder( root);
	}
	
	/**
	 * 
	 * Description: returns the height of the tree
	 * @param node
	 * @return int 
	 */
	public int getHeight(Node<E> node)
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
		return getHeight(root);
		
	}
	
	
}
