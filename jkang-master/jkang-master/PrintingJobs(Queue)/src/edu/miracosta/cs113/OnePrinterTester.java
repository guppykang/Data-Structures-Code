package edu.miracosta.cs113;
import Printer.Printer;
import Printer.PrintJob;
/**
 * 
 * @author Joshua Kang
 * @version 1.0
 * Program Name: one Printer 
 * Program Description: For 100 print orders, one printer receives the orders, and print simultaneously. This program
 * keeps track of the time it takes to print, and the information for all the print orders, and printers. 
 * Algorithm: 
 * Initialize the printer
 * 	that one printer accepts all possible number of pages
 * WHILE (the sum of the finished jobs is less than 100)
 * 	call tick()
 * 	if(the number of orders is less than 100)
 * 		create a new random print job between 1 - 50
 * 		add the print job to the printer
 * 		increment the number of orders
 * 	call updateTime() for my little printer
 *
 */
public class OnePrinterTester 
{
		public static void main(String[] args)
		{
			int numOfPages;
			PrintJob newPrintJob = null;
			Printer smallPrinter = new Printer("My little printer");
			int numOfOrders = 0; 
			
			//number of jobs
			while(smallPrinter.getNumOfFinishedJobs() < 100)
			{
				System.out.println("****************************************************************************"
						+ "\nCurrent Time : " + Printer.getCurrentTime()); 
				

				
				//create a new print job, and add it to the respective printer
				if(numOfOrders < 100)
				{
					numOfPages = (int)(Math.random()*50 +1);
					newPrintJob = new PrintJob(numOfPages, Printer.getCurrentOrder());

					System.out.println("\nNew Print Job : " + newPrintJob);
					smallPrinter.addJob(newPrintJob);

					numOfOrders++;
				}
				
				//check the progress on the print job
				smallPrinter.updateTime();
				

				//increment the current time
				Printer.tick();
			}
		}

	

}
