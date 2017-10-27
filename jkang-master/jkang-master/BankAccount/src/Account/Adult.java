package Account;
/**
 * 
 * @author Joshua Kang
 * @version 1.0
 * Program Name: Adult (subclass of Customer)
 * Program Description: Adult has its own savings interest, check interest, check charge, and overdaft penalty
 * Class Invariant:n/a
 *
 */
public class Adult extends Customer
{
	//instance variables
	private final double SAVINGS_INTEREST = 50;
	private final double CHECK_INTEREST = 50;
	private final double CHECK_CHARGE = 50;
	private final double OVERDRAFT_PENALTY = 25;
	
	//default constructor
	public Adult()
	{
		super();
	}

	//copy constructor
	public Adult(Customer other) 
	{
		super(other);
	}

	//full Constructor
	public Adult(String name, String address, int age, int telephoneNumber, int customerNumber) 
	{
		super(name, address, age, telephoneNumber, customerNumber);
	}
	
	//getters/setters
	@Override
	public double getSavingsInterest() {
		return SAVINGS_INTEREST;
	}


	@Override
	public double getCheckInterest() {
		// TODO Auto-generated method stub
		return CHECK_INTEREST;
	}

	
	public double getCheckCharge() {
		// TODO Auto-generated method stub
		return CHECK_CHARGE;
	}

	public double getOVERDRAFT_PENALTY() {
		return OVERDRAFT_PENALTY;
	}
	
}
