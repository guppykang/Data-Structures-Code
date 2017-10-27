package Polynomial;
import edu.miracosta.cs113.*;

import java.util.Scanner;

/**
 * 
 * @author Joshua Kang
 * @version 1.0
 * Program Name: Polynomial
 * Program Description: 
 * Class Invariant:
 * Algorithm: 
 *
 */
public class Polynomial {

	public static void main(String[] args) 
	{
		Scanner keyboard = new Scanner(System.in);
		int counter = 1;
		double coefficient, exponent;
		String again, temp, result;
		
		DoubleLinkedList1 term1 = new DoubleLinkedList1();
		DoubleLinkedList1 term2 = new DoubleLinkedList1();
		for(int i = 1; i < 3; i++)
		{
			counter = 1;
			do
			{
				System.out.println("\n\nPlease enter terms in decreasing order for polynomial " + i + 
																				". (x^3 + x^2 +1)");
				System.out.print("Please enter the coefficient of term " + counter + " : ");
				temp = keyboard.nextLine();
				coefficient = Double.parseDouble(temp);
				
				System.out.print("Please enter the exponent of term " + counter + " : ");
				temp = keyboard.nextLine();
				exponent = Double.parseDouble(temp);
				
				Term newTerm = new Term(exponent, coefficient);
				
				if(i == 1)
				{
					term1.add(newTerm);
				}
				else
				{
					term2.add(newTerm);
				}
				
				System.out.print("Would you like to enter another term (y,n) ; ");
				again = keyboard.nextLine();
				
				counter++;
			}
			while(again.equalsIgnoreCase("y"));
		}
		
		result = term1.addPolynomials(term2);
		
		System.out.println("Polynomial 1 + Polynomial 2 = " + result);
		
	}

	
}
