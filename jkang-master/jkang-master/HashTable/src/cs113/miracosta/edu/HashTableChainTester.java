package cs113.miracosta.edu;

import HashTableChain.HashTableChain;
/**
 * 
 * @author Joshua Kang
 * @version 1.0
 * Program Name: HashTableChain Tester non-Junit
 * Program Description: tests the toString methdo for the HashTableCHain Data Structure
 * Algorithm: add -5, and 10 to the hash table
 * add -1 and 0 to the hash table
 * sysout the table which calls the toString method
 *
 */
public class HashTableChainTester 
{
	public static void main(String[] args)
	{
		HashTableChain table = new HashTableChain();
		table.put(5, 10);
		table.put(-1, 0);
		
		System.out.println(table);
	}
}
