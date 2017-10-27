package Account;
/**
 * 
 * @author Joshua Kang
 * @version 1.0
 * Program Name: Student (Subclass of Customer)
 * Program Description: Student has its specified Savings interest, check interest, check charge, and overdraft
 * penalty
 * Class Invariant: n/a
 *
 */
public class Student extends Customer
{
	//instance variables
	private final double SAVINGS_INTEREST = 40;
	private final double CHECK_INTEREST = 40;
	private final double CHECK_CHARGE = 40;
	private final double OVERDRAFT_PENALTY = 30;
	
	
	//default constructor
	public Student() 
	{
		super();
	}

	//copy constructor
	public Student(Customer other)
	{
		super(other);
	}

	//full constructor
	public Student(String name, String address, int age, int telephoneNumber, int customerNumber)
	{
		super(name, address, age, telephoneNumber, customerNumber);
	}

	//getters and setters
	@Override
	public double getSavingsInterest() {
		return SAVINGS_INTEREST;
	}

	@Override
	public double getCheckInterest() {
		// TODO Auto-generated method stub
		return CHECK_INTEREST;
	}

	@Override
	public double getCheckCharge() {
		// TODO Auto-generated method stub
		return CHECK_CHARGE;
	}



	public double getOVERDRAFT_PENALTY() {
		return OVERDRAFT_PENALTY;
	}
	
}
