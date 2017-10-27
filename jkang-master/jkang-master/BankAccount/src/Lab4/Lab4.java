package Lab4;
import java.util.Scanner;

public class Lab4 
{
	public static void main(String[] args)
	{
		String temp;
		int num, y1, y2;
		Scanner keyboard = new Scanner(System.in);
		System.out.print("Please enter a number to start at : ");
		temp = keyboard.nextLine();
		num = Integer.parseInt(temp);
		keyboard.close();
		for(int i = num; i <= 100; i+=10)
		{
			y1 = 100 * i + 10;
			y2 = 5 * i * i + 2;
			System.out.printf("%d,%d \n ", y1, y2);
		}
	}
}
