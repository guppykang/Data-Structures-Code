package cs113.miracosta.edu;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.Scanner;
/**
 * 
 * @author Joshua Kang
 * @version 1.0	
 * Program Name: Merge sort with large amounts of data 
 * Program Description: This program is able to sort a vast amount of data in the form of ints through the use of files
 * class invarients : the data in the original input file must be integers
 * Algorithm : 
 * create the inputStream and outputStream for the original input file and two output files
 * first read in 10 ints at a time (doubled after first iteration)
 * sort them using merge sort
 * insert them into one of the two files (evenly alternating)
 * do this for all the data in the original input file
 * close the outputStreams
 * get the amount, specified in limit, of data in each file and merge them into the original file
 * do this for all the values in the two output files
 * Complete this whole process until the limit is greater than the number of ints in the original data file.  
 */
public class MergeSortLargeData 
{
	private static Scanner inputStream, inputStream1, inputStream2; 
	private static PrintWriter outputStream, outputStream1, outputStream2;
	public static void main(String[] args)
	{
		
	    
		int limit = 10;
	   	int counter = 0; 
	   	boolean isSorted = false;
	   	do
	   	{
	   		
	   	 /********************* original input file ********************/
			try
		    {
		        inputStream = new Scanner(new FileInputStream("C:\\Users\\Joyce\\git\\jkang\\HW10\\src\\inputFile\\Merge.txt"));
		    }
		      
		    catch(FileNotFoundException e)
		    {
		    	System.out.println("Cannout find file");
		        System.exit(1);
		    }
		    /*********************output file number one********************/
		   	try
		    {
		    	outputStream1 = new PrintWriter(new FileOutputStream("output1.txt"));
		    }
		   	
		    //Check to see if file can be created or exists. If not, end program
		    catch(FileNotFoundException e)
		    {
		    	System.out.println("Error opening the file dataFile output1");
		    	System.exit(0);
		    }
		   	
		    try
		    {
		        inputStream1 = new Scanner(new FileInputStream("C:\\Users\\Joyce\\git\\jkang\\HW10\\output1.txt"));
		    }
		      
		    catch(FileNotFoundException e)
		    {
		    	System.out.println("Cannout find file");
		        System.exit(1);
		    }
		    
		    
		    /*********************output file number two********************/
		   	try
		    {
		    	outputStream2 = new PrintWriter(new FileOutputStream("output2.txt"));
		    }
		   	
		    //Check to see if file can be created or exists. If not, end program
		    catch(FileNotFoundException e)
		    {
		    	System.out.println("Error opening the file dataFile output2");
		    	System.exit(0);
		    }
		   	
			   
		    try
		    {
		        inputStream2 = new Scanner(new FileInputStream("C:\\Users\\Joyce\\git\\jkang\\HW10\\output2.txt"));
		    }
		      
		    catch(FileNotFoundException e)
		    {
		    	System.out.println("Cannout find file");
		        System.exit(1);
		    }
	    
	    
		   	int fileNum = 0; 
		   	
		   	//getting the values from the original file
			while(inputStream.hasNextInt())
			{
				int[] data = new int[limit];
				//break if there is no more values left
				if(!inputStream.hasNextInt())
				{
					break;
				}
				
				//read values in at intervals of limit
				int size = readValues(inputStream, limit, data);
				int[] values = new int[size];
				
				
				//eliminate the extra zero values that the end
				for(int i = 0; i < size; i++)
				{
					values[i] = data[i];
				}
				
				//sort the values via merge sort
				if(!isSorted)
				{
					mergeSort(values);
				}
				//put the array in either one of the output files
				if(fileNum == 0)
				{
					for(int element : values)
					{
						outputStream1.println(element);
					}
					fileNum = 1;
				}
				else
				{
					for(int element : values)
					{
						outputStream2.println(element);
					}
					fileNum = 0;
				}
				
			}//end while
			
			
			isSorted = true;
			outputStream1.close();
			outputStream2.close();
			outputStream1 = null;
			outputStream2 = null;
			
			
			int[] output1 = new int[limit];
			int[] output2 = new int[limit];
			
			//override the original input file to put the new values in 
			try
		    {
		    	outputStream = new PrintWriter(new FileOutputStream("C:\\Users\\Joyce\\git\\jkang\\HW10\\src\\inputFile\\Merge.txt"));
		    }
		   	
		    //Check to see if file can be created or exists. If not, end program
		    catch(FileNotFoundException e)
		    {
		    	System.out.println("Error opening the file dataFile merge.txt");
		    	System.exit(0);
		    }
			
			counter = 0; 
			
			//merge two runs from each of the files as long as at least on of them has values
			while(inputStream1.hasNextInt() || inputStream2.hasNextInt())
			{
				if(!inputStream1.hasNextInt())
				{
					break;
				}
				
				//read in values from the first file
				int size1 = readValues(inputStream1, limit, output1);
				
				//eliminate extra zero values
				int[] realOutput1 = new int[size1];
				for(int i = 0; i < size1; i++)
				{
					realOutput1[i] = output1[i];
				}
				
				//read in values from the second file
				int size2 = readValues(inputStream2, limit, output2);
				
				//eliminate extra zero values
				int[] realOutput2 = new int[size2];
				for(int i = 0; i < size2; i++)
				{
					realOutput2[i] = output2[i];
				}
				
				//create an array that is the capacity of the number of used values in both arrays
				int[] newValues = new int[size1 + size2];
				
				//merge the two arrays together
				merge(realOutput1, realOutput2, newValues);
				
				
				
				
				for(int element : newValues)
				{
					outputStream.println(element);
					counter++;
				}
				
			}//end while
			outputStream.close();
			
			limit *= 2;
	   	} 
	   	while(limit <= counter);
		
	}
	
	/**
	 * 
	 * Description: uses merge sort to sort the ints in the given array
	 * @param inputArray
	 */
	public static void mergeSort(int[] inputArray) 
	{
        int size = inputArray.length;
	    if(size > 1)
	    {
	        int halfSize = size / 2;
	        int[] leftTable = new int[halfSize];
	        int[] rightTable = new int[size - halfSize];
	        for (int i = 0; i < halfSize; i++)
	        {
	        	leftTable[i] = inputArray[i];
	
	        }
	        for (int i = halfSize; i < size; i++) 
	        {
	        	rightTable[i - halfSize] = inputArray[i];
	        }
	        
	        //recursively call merge sort on both left and right. This will stop when the size is 1
	        mergeSort(leftTable);
	        mergeSort(rightTable);
	        
	        //merge all the arrays together after the recursive calls have finished
	        merge(leftTable, rightTable, inputArray);
	        
	       
	    }
    }

	/**
	 * 
	 * Description: merges the two arrays left and right into arr. Uses the principle of grabbing one element from each 
	 * array by a time and comparing them to ensure that all the int values in arr are sorted. 
	 * @param left
	 * @param right
	 * @param arr
	 */
    public static void merge(int[] left, int[] right, int[] arr)
    {
    	
        int leftSize = left.length;
        int rightSize = right.length;
        int i = 0, j = 0, k = 0;
        while (i < leftSize && j < rightSize)
        {
            if (left[i] <= right[j]) 
            {
                arr[k] = left[i];
                i++;
                k++;
            } 
            else
            {
                arr[k] = right[j];
                k++;
                j++;
            }
        }
        while (i < leftSize) 
        {
            arr[k] = left[i];
            k++;
            i++;
        }
        while (j < rightSize)
        {
            arr[k] = right[j];
            k++;
            j++;
        }
    }
    
    /**
     * 
     * Description: uses the given inputStream to read the number of values specified in limit and store them in the given
     * data array. In addition, it also returns the size, the number of actually used indexes in the array. 
     * @param inputStream
     * @param limit
     * @param data
     * @return int
     */
    public static int readValues(Scanner inputStream, int limit, int[] data)
    {
		
		int size = 0; 
		for(int i = 0; i < limit; i++) 
		{
		   	if(inputStream.hasNextInt())
		   	{
		   		data[i] = inputStream.nextInt();
		   		size++;
		   	}
		   	else
		   	{
		   		break;
		   	}
		   	
		}
		return size;
    }
}
