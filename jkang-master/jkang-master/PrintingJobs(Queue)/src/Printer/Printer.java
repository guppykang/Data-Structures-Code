package Printer;

import java.util.LinkedList;
import java.util.Queue;
 /**
  * 
  * @author Joshua Kang
  * @version 1.0
  * Program Name: Printer
  * Program Description: A instance of a Printer mainly keeps track of the print jobs that are given to the specific printer.
  *
  */
public class Printer
{
	private String name; 
	private Queue<PrintJob> jobs = new LinkedList<PrintJob>();
	private static int currentTime = 0;
	private static int currentOrder = 1;
	private int upper;
	private int numOfFinishedJobs;
	
	/**
	 * Full Constructor
	 * @param name
	 */
	public Printer(String name)
	{
		this.name = name;
		upper = 0;
		numOfFinishedJobs = 0;
	}
	
	/**
	 * 
	 * Description: adds a PrintJob to the queue of jobs. 
	 * @param newJob
	 */
	public void addJob(PrintJob newJob)
	{
		currentOrder++;
		jobs.offer(newJob);
	}
	
	/**
	 * 
	 * Description: increments the currentTime. Returns it as well
	 * @return int
	 */
	public static int tick()
	{
		currentTime++;
		return currentTime;
	}
	
	/**
	 * 
	 * Description: processes the extra minute's progress into the next print job
	 */
	public void updateTime()
	{
		System.out.println("\n" + this.name + "\n**************************************");
		if(jobs.isEmpty())
		{
			System.out.println("no more orders for " + this.name);

			System.out.println(this.name + " has finished " + numOfFinishedJobs +  " printing jobs.");
			return;
		}
		
		if(upper == 0)
		{
			calculateEndTime(jobs.peek());
		}
		
		checkIfDone();
		
		
		System.out.println(this.name + " has finished " + numOfFinishedJobs +  " printing jobs.");
		System.out.println("**************************************");
	}
	
	/**
	 * 
	 * Description: returns the "current time" that the next print job will be finished
	 * @param newJob
	 */
	public void calculateEndTime(PrintJob newJob)
	{
		if(jobs.isEmpty() == false)
		{
			upper = currentTime + newJob.getPrintTime();
		}
		
	}
	
	/**
	 * 
	 * Description: checks if the next print job is done
	 */
	public void checkIfDone()
	{
		if(currentTime == upper)
		{
			jobs.peek().setIsPrinted(true);
			System.out.println(this.name + " finished a print job: " + jobs.poll());
			numOfFinishedJobs++;
			upper = 0;
		}
		else
		{
			System.out.println(this.name + " is still printing order " + jobs.peek().getOrderNumber());
		}
	}
	
	/**
	 * 
	 * Description: returns if the queue of print jobs is full or not
	 * @return boolean
	 */
	public boolean isEmpty()
	{
		return this.jobs.isEmpty();
	}
	
	/**
	 * 
	 * Description: returns a String output form of the current time
	 * @return String
	 */
	public static String getCurrentTime()
	{
		if(currentTime < 60)
		{
			return currentTime + " minutes";
		}
		else if(currentTime == 60)
		{
			return "1 hour";
		}
		else 
		{
			return (currentTime/60) + " hours " + (currentTime%60) + " minutes";
		}
		
	}

	public static int getTime()
	{
		return currentTime; 
	}
	/**
	 * 
	 * Description: returns the number of Finished jobs
	 * @return int
	 */
	public int getNumOfFinishedJobs() 
	{
		return numOfFinishedJobs;
	}

	/**
	 * 
	 * Description: returns the current order number.
	 * @return int
	 */
	public static int getCurrentOrder()
	{
		return currentOrder;
	}
	
	

	
}
