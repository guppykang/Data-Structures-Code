package edu.miracosta.cs113;
import Printer.Printer;
import Printer.PrintJob;

/**
 * 
 * @author Joshua Kang
 * @version 1.0
 * Program Name: Three Printers 
 * Program Description: For 100 print orders, three printers (< 10, < 20, >20) receive the orders, and print simultaneously. This program
 * keeps track of the time it takes to print, and the information for all the print orders, and printers. 
 * Algorithm: 
 * Initialize three printers
 * 	one small for orders less than 10
 * 	one medium for orders between 10 and 20
 * 	one large for orders greater that 20
 * WHILE (the sum of the finished jobs is less than 100)
 * 	call tick()
 * 	if(the number of orders is less than 100)
 * 		create a new random print job between 1 - 50
 * 		add the print job to the respective printer
 * 		increment the number of orders
 * 	call updateTime() for all three printers 
 *
 */
public class ThreePrintersTester
{
	public static void main(String[] args)
	{
		int numOfPages;
		PrintJob newPrintJob = null;
		int numOfOrders = 0; 
		Printer smallPrinter = new Printer("Small Printer");
		Printer mediumPrinter = new Printer("Medium Printer");
		Printer largePrinter = new Printer("Large Printer");
		
		//number of jobs
		while(smallPrinter.getNumOfFinishedJobs() + mediumPrinter.getNumOfFinishedJobs() + largePrinter.getNumOfFinishedJobs() < 100)
		{
			
			System.out.println("****************************************************************************"
					+ "\nCurrent Time : " + Printer.getCurrentTime()); 
			
			
			//create a new print job, and add it to the respective printer
			if(numOfOrders < 100)
			{
				numOfPages = (int)(Math.random()*50 +1);
				newPrintJob = new PrintJob(numOfPages, Printer.getCurrentOrder());
				System.out.println("\nNew Print Job : " + newPrintJob);
				if(numOfPages < 10)
				{
					smallPrinter.addJob(newPrintJob);
				}
				else if(numOfPages >= 10 && numOfPages <20)
				{
					mediumPrinter.addJob(newPrintJob);
				}
				else
				{
					largePrinter.addJob(newPrintJob);
				}
				numOfOrders++;
			}
			
			//check the progress of each printer
			smallPrinter.updateTime();
			mediumPrinter.updateTime();
			largePrinter.updateTime();
		


			//increment the current time
			Printer.tick();
		}
	}

}
