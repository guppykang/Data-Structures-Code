package Printer;

/**
 * 
 * @author Joshua Kang
 * @version 1.0 
 * Program Name: Print Job
 * Program Description: A PrintJob object mainly keeps track of the number of pages in the order, and the duration it will take to finish
 * the print job
 *
 */
public class PrintJob
{
	private int numPages; 
	private boolean isPrinted; 
	private int printTime;
	private int orderNumber;
	
	/**
	 * Full Constructor 
	 * @param numPages
	 * @param orderNumber
	 */
	public PrintJob(int numPages, int orderNumber)
	{
		this.numPages = numPages;
		//something's still wrong with this
		printTime = calculatePrintTime(numPages);
		this.orderNumber = orderNumber;
	}

	/**
	 * 
	 * Description:  returns the number of pages in the order
	 * @return int
	 */
	public int getNumPages()
	{
		return numPages;
	}

	/**
	 * 
	 * Description: returns if the print job has finished 
	 * @return boolean
	 */
	public boolean getIsPrinted()
	{
		return isPrinted;
	}

	/**
	 * 
	 * Description: gets the print time of the print order
	 * @return int
	 */
	public int getPrintTime() 
	{
		return printTime;
	}
	
	/**
	 * 
	 * Description: sets the isPrinted boolean that keeps track if the order is done or not
	 * @param isPrinted
	 */
	public void setIsPrinted(boolean isPrinted)
	{
		this.isPrinted = isPrinted;
	}
	
	/**
	 * 
	 * Description: returns the amount of time it will take to finish the print job (in minutes)
	 * @param numPages
	 * @return int
	 */
	public int calculatePrintTime(int numPages)
	{
		int time = 0; 
		if(numPages < 10 && numPages > 0)
		{
			time = 1;
		}
		else if(numPages == 10 || numPages == 20 || numPages == 30 || numPages == 40|| numPages == 50)
		{
			time = numPages/10;
		}
		else
		{
			time = (numPages/10) + 1;
		}
		return time;
	}
	
	
	/**
	 * 
	 * Description: returns the order number of the print job
	 * @return int
	 */
	public int getOrderNumber()
	{
		return this.orderNumber;
	}

	
	/**
	 * toString method that returns a String of the information for the given print job
	 * @return String
	 */
	public String toString()
	{
		return "\n*******************" +"\nOrder Number : " + orderNumber + "\nNumber of Pages : " + numPages + "\nTime to print : " 
					+ printTime + " minutes" + "\n*******************";
	}
	
	
	
}
