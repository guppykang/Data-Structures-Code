package lab18;

/**
 * 
 * @author Joshua Kang
 * @version
 * Program Name: Lab 18 programming project 1 
 * Program Description: reblances the tree on the right side
 * THIS METHOD IS ALSO IN THE AVLTree class
 */
public class RebalanceRight
{
	/**
	 * 
	 * Description: Method to rebalance left side
	 * pre- localRoot is the root of the side that is right heavy
	 * @param localRoot
	 * @return AVLNode<E> new localRoot
	 */
	/*private AVLNode<E> rebalanceRight(AVLNode<E> localRoot)
	{
		AVLNode<E> rightCHild = (AVLNOde<E>)localRoot.right;
		if(rightChild.balance < AVLNode.BALANCED)
		{
			AVLNode<E> rightLeftChild = (AVLNode<E>) rightCHild.left;
			if(rightLeftChild.balance < AVLNode.BALANCED)
			{
				rightChild.balance = AVLNode.BALANCED;
				rightLeftChild.balance = AVLNode.BALANCED;
				localRoot.balance = AVLNode.LEFT_HEAVY;
				
			}
			else
			{
				rightChild.balance = AVLNode.RIGHT_HEAVY;
				rightLeftChild.balance = AVLNode.BALANCED;
				localRoot.balance = AVLNode.BALANCED;
			}
			
			localRoot.right = rotateRight(rightChild);
			
		}
		else
		{
			rightChild.balance = AVLNode.BALANCED;
			localRoot.balance = AVLNode.BALANCED;
		}
		return (AVLNode<E>) rotateLeft(localRoot);
	}*/
}
