package Account;
/**
 * 
 * @author Joshua Kang
 * @version 1.0
 * Program Name: Senior (Subclass of Customer)
 * Program Description: Senior has its specified Savings interest, check interest, check charge, and overdraft
 * penalty
 * Class Invariant: n/a
 *
 */
public class Senior extends Customer 
{
	//instance variables
	private final double SAVINGS_INTEREST = 20;
	private final double CHECK_INTEREST = 20;
	private final double CHECK_CHARGE = 20;
	private final double OVERDRAFT_PENALTY = 15;
	
	public Senior()
	{
		super();
	}
	
	public Senior(Customer other) 
	{
		super(other);
	}

	public Senior(String name, String address, int age, int telephoneNumber, int customerNumber) 
	{
		super(name, address, age, telephoneNumber, customerNumber);
	}


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
