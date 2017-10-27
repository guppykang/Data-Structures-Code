package Waitlist;
import java.util.Scanner;

import edu.miracosta.cs113.*;

import javax.swing.plaf.synth.SynthSeparatorUI;

/**
 * 
 * @author Joshua Kang
 * @version 1.0
 * Program Name: Wait list
 * Program Description: keeps track of a students in a wait list. Adds students to the end, beginning, or 
 * removes them from anywhere in the list.
 * Class Invariant: n/a
 * Algorithm: 
 * Create 5 Students already inside the Linked List (by testing out the add last and add first method
 * Add them to the Linked List
 * Ask the user to enter a student onto the waitlist
 * prompt the name
 * prompt the number of units
 * prompt the name of the school
 * create a new Student Object
 * ask the user if they want to add the student to the front or the end
 * add the new Student to the front or end
 * Print the current waitlisters 
 * ask the user if they want to add another student to the wait list
 * ask the user if they want to remove a student from anywhere on the list
 * ask the user for the information for a new Student
 * OR use the remove method to take a student off the waitlist
 * print to the screen the students who have been taken off the wait list
 * print to the screen the students who are still on the waitlist
 * 
 */
public class Waitlist {

	public static void main(String[] args) 
	{
		//declarations and initialization
		String temp, name, school, again;
		int units;
		boolean isLastSemester = false, isSpecial = false;
		Scanner keyboard = new Scanner(System.in);
		DoubleLinkedList1<Student> waitlist = new DoubleLinkedList1();
		
		//initialization of students
		Student emily = new Student("Emily Warner", 5, "MiraCosta college");
		Student phong = new Student("Phong Dang", 12, "Miramar College");
		Student anna = new Student("Anna Feldman", 15, "Palomar College");
		Student aaron = new Student("Aaron Barnes", 4, "Mesa College");
		Student kris = new Student("Kristopher Torres", 9, "City college");
		
		//adding students
		waitlist.add(emily);
		waitlist.add(phong);
		waitlist.add(anna);
		waitlist.add(0, aaron);
		waitlist.add(0, kris);
		

		
		//adding students from user input
		do
		{
			//entering information for a student
			System.out.println("Please enter the information for a new student to add to the waitlist ");
			
			//name
			System.out.print("Please enter the name of the student: ");
			name = keyboard.nextLine();
			
			//units
			System.out.print("Please enter the number of units taken : ");
			temp = keyboard.nextLine();
			units = Integer.parseInt(temp);
			
			//school
			System.out.print("Please enter the school : ");
			school = keyboard.nextLine();
			
			//creating the new student
			Student newStudent = new Student(name, units, school);
			
			//if this is the student's last semester at the school,
			//then we insert them at the beginning of the list.
			System.out.print("Is this this student's last semester? (y,n):");
			temp = keyboard.nextLine();
			if(temp.equalsIgnoreCase("y"))
			{
				isLastSemester = true;
			}
			
			//adding the student to the LinkedList
			if(isLastSemester == true)
			{
				//special case
				waitlist.add(0, newStudent);
			}
			else
			{
				//regular
				waitlist.add(newStudent);
			}
			//viewing students on the waitlist
			System.out.println("***************************");
			System.out.println("Here are the students that are still on the waitlist: ");
			System.out.println(waitlist.getWaitlisters());
			System.out.println("***************************");
			//asking the user if they want to remove another student
			System.out.print("Would you like to add another student to the waitlist? (y,n)");
			again = keyboard.nextLine();
			
		}
		while(again.equalsIgnoreCase("y"));
		
		//Removing a student from the waitlist from user input
		do
		{
			System.out.println("Please allow at least one student into the class.");
			System.out.print("Is there a student you want to add regardless"
								+ " their position in the waitlist? (y,n)");
			temp = keyboard.nextLine();
			if(temp.equalsIgnoreCase("y"))
			{
				isSpecial = true;
			}
			
			//if the user wants to remove a student not necessarily in the front of the line
			if(isSpecial == true)
			{
				System.out.println("Please enter the information of the specific student you would like"
									+ " to remove from the waitlist.");
				
				//name
				System.out.print("Please enter the name of the student : ");
				name = keyboard.nextLine();
				
				//units
				System.out.print("Please enter the number of units " + name + " is taking: ");
				temp = keyboard.nextLine();
				units = Integer.parseInt(temp);
				
				//school
				System.out.print("Please enter the school " + name + " attends: ");
				school = keyboard.nextLine();
				
				//creating a new student
				Student deletedStudent = new Student(name, units, school);
				
				//removing the student selected
				waitlist.remove(deletedStudent);
			}//end if
			//if the user wants to remove a student from the beginning of the waitlist
			else
			{
				//removing the first student on the list
				System.out.println("Removing " + waitlist.get(0).getName() + " from the list.");
				waitlist.remove(waitlist.get(0));
			}
			
			System.out.println("***************************");
			System.out.println("Here are the students that are still on the waitlist: ");
			System.out.println(waitlist.getWaitlisters());
			System.out.println("***************************");
			//asking the user if they want to remove another student
			System.out.print("Would you like to remove another student from the wait list? (y,n)");
			again = keyboard.nextLine();
		}//end do-while
		while(again.equalsIgnoreCase("y"));
		
		keyboard.close();
	}
	//wowowoowoww It actually works!

	
	

}
