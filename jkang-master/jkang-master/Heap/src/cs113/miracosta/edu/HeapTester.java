package cs113.miracosta.edu;
import org.junit.Test;

import heap.*;
import junit.framework.Assert;


public class HeapTester 
{
	@Test
	public void testIsEmpty()
	{
		MaxHeap max = new MaxHeap();
		
		Assert.assertEquals(max.isEmpty(), true);
		
		
	}
	
	@Test
	public void testCompare()
	{

		MaxHeap max = new MaxHeap();// max and min compare methods are identical
		Assert.assertEquals(max.compare("hi", "hi"), 0);
		Assert.assertEquals(max.compare(1, 3), -1);
		Assert.assertEquals(max.compare(10, 1), 1);
	}
	
	
	
	
	@SuppressWarnings("deprecation")
	@Test
	public void testOffer()
	{
		MaxHeap<Integer> max = new MaxHeap<Integer>();
		MinHeap<Integer> min = new MinHeap<Integer>();
		
		//min heap testing
		min.offer(5);
		Assert.assertEquals(min.isEmpty(), false);
		Assert.assertEquals(min.peek(), 5);
		
		min.offer(7);
		Assert.assertEquals(min.peek(), 5);
		
		min.offer(1);
		Assert.assertEquals(min.peek(), 1);
		
		Assert.assertEquals(min.poll(), 1);
		
		Assert.assertEquals(min.poll(), 5);
		
		Assert.assertEquals(min.poll(), 7);
		
		//max heap testing
		max.offer(1);
		Assert.assertEquals(max.peek(), 1);
		
		max.offer(5);
		Assert.assertEquals(max.peek(), 5);
		
		Assert.assertEquals(max.poll(), 5);
		Assert.assertEquals(max.poll(), 1);
		
	}
	
	
	
}
