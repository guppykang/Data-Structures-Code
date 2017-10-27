package Lab16;

import java.util.LinkedList;
import java.util.Random;

/**
 * 
 * @author Joshua Kang
 * @version 1.0
 * Program Name: Radix Sort for up to four digits
 * Program Description: Sorts a list of numbers by looking at the digits starting from the ones, tens, hundreds, then thousands
 * Algorithm: fill in a random number in the array
 * put the numbers into an array consisting of the digits and put those arrays into another array
 * look at the respective digit according to the index of the loop and increment the number of those digits in the array
 * add each number to the number after it and store it to the one after it also
 * starting from the end, put look at the respective digit and put it at the index in the array of number of digits and decrement
 * repeat this process for the number of digits (4)
 *
 */
public class radixSort 
{
	public static void main(String[] args)
	{
		Random r = new Random();
		
		int numOfIntegers = 30;
		int[] nums = new int[numOfIntegers];
		for(int i = 0; i < numOfIntegers; i++ )
		{
			nums[i] = r.nextInt(10000);
		}
		
		int[] copyNums = new int[numOfIntegers];
		for(int i = 0; i < numOfIntegers; i++)
		{
			copyNums[i] = nums[i];
		}
		
		
		
		int[][] numList = new int[copyNums.length][4];
		
		int[] currentDigit = new int[10];
		
		
		
		for(int i = 3 ; i >= 0; i--)
		{
			//put the numbers into separate arrays into a two dimensional array
			for(int j = 0; j < copyNums.length; j++)
			{
				int[] currentNumber = new int[4];
				for(int k = 3; k >= 0; k--)
				{
					 currentNumber[k] = copyNums[j] % 10;
					 copyNums[j] = copyNums[j] / 10;
				}
				numList[j] = currentNumber;
			}
			
			//reset the values to zero in current digit
			for(int k = 0; k < 10; k++)
			{
				currentDigit[k] = 0; 
			}
			
			//increment the number of digits
			for(int[] element : numList)
			{
				currentDigit[element[i]]++;
			}
			
			//add the values
			for(int j = 0; j < currentDigit.length-1; j++)
			{
				currentDigit[j+1] += currentDigit[j];
			}
			
			//insert the numbers back in
			for(int j = numList.length-1; j >= 0; j--)
			{
				currentDigit[numList[j][i]]--;
				int index = currentDigit[numList[j][i]];
				copyNums[index] = nums[j];
			}
			
			//copy them to the nums array so that copyNums and nums have the same values
			for(int j = 0; j < copyNums.length; j++)
			{
				nums[j] = copyNums[j];
			}
			
		}//end for
		for(int element : nums)
		{
			System.out.println(element);
		}
	}
}
