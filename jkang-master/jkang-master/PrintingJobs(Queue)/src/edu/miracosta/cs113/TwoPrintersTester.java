package edu.miracosta.cs113;
import Printer.Printer;
import Printer.PrintJob;
/**
 * 
 * @author Joshua Kang
 * @version 1.0
 * Program Name: Two Printers 
 * Program Description: For 100 print orders, three printers (< 10, > 10) receive the orders, and print simultaneously. This program
 * keeps track of the time it takes to print, and the information for all the print orders, and printers. 
 * Algorithm: 
 * Initialize two printers
 * 	one small for orders less than 10
 * 	one medium for orders greater than 10
 * WHILE (the sum of the finished jobs is less than 100)
 * 	call tick()
 * 	if(the number of orders is less than 100)
 * 		create a new random print job between 1 - 50
 * 		add the print job to the respective printer
 * 		increment the number of orders
 * 	call updateTime() for both printers 
 *
 */
public class TwoPrintersTester 
{

	
		public static void main(String[] args)
		{
			int numOfPages;
			PrintJob newPrintJob = null;
			int numOfOrders = 0; 
			Printer smallPrinter = new Printer("Small Printer");
			Printer mediumPrinter = new Printer("Large Printer");
			
			//number of jobs
			while(smallPrinter.getNumOfFinishedJobs() + mediumPrinter.getNumOfFinishedJobs() < 100)
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
					else
					{
						mediumPrinter.addJob(newPrintJob);
					}
					numOfOrders++;
				}	
				
				//check the progress of the two printers
				smallPrinter.updateTime();
				mediumPrinter.updateTime();
				

				//increment the current time
				Printer.tick();
			}
		}

	}


