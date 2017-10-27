package cs113.miracosta.edu;

import junit.framework.Assert;

import org.junit.Test;

import HashTableChain.HashTableChain;
/**
 * 
 * @author Joshua Kang
 * @version 1.0
 * Program Name: Hash Table Chain tester : Junit
 * Program Description: Tests the Hash Table Chain
 * Algorithm: 
 *
 */
public class HashTableChainTesterJunit 
{
	@Test
	public void testHashTableChain()
	{
		HashTableChain table = new HashTableChain();
		Assert.assertEquals(table.isEmpty(), true);
		
		table.put(5, 10);
		
		Assert.assertEquals(table.get(5), 10);
		
		table.put(5, 15);
		Assert.assertEquals(table.get(5), 15);
		
		Assert.assertEquals(table.get(5).equals(10), false);
		
		Assert.assertEquals(table.size(), 1);
		
		table.put(-1, 0);
		
		table.remove(5);
		Assert.assertEquals(table.size(), 1);
		Assert.assertEquals(table.get(-1) , 0);
		
		table.remove(-1);
		Assert.assertEquals(table.size(), 0);
		Assert.assertEquals(table.get(-1), null);
		
	}
	
	
	
	
}
