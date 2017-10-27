package Account;
/**
 * 
 * @author Joshua Kang
 * @version 1.0
 * Program Name: Customer
 * Program Description: Customer is an abstract class that keeps track of all the necessary information of a
 * customer. 
 * Class Invariant: n/a
 *
 */
public abstract class Customer 
{
	//instance variables
	private String name;
	private String address;
	private int age;
	private int telephoneNumber;
	private int customerNumber;
	
	//default constructor
	public Customer()
	{
		name = "Erlich Bachman";
		address = "12345 1st Street";
		age = 30;
		telephoneNumber = 123456789;
		customerNumber = 1234567890;
	}
	
	//full constructor
	public Customer(String name, String address, int age, int telephoneNumber, int customerNumber) 
	{
		this.name = name;
		this.address = address;
		this.age = age;
		this.telephoneNumber = telephoneNumber;
		this.customerNumber = customerNumber;
	}
	
	//copy constructor
	public Customer(Customer other)
	{
		this.name = other.name;
		this.address = other.address;
		this.age = other.age;
		this.telephoneNumber = other.telephoneNumber;
		this.customerNumber = other.customerNumber;
	}

	//getters and setters
	public String getName() 
	{
		return name;
	}

	public void setName(String name) 
	{
		this.name = name;
	}

	public String getAddress() 
	{
		return address;
	}

	public void setAddress(String address) 
	{
		this.address = address;
	}

	public int getAge() 
	{
		return age;
	}

	public void setAge(int age) 
	{
		this.age = age;
	}

	public int getTelephoneNumber()
	{
		return telephoneNumber;
	}

	public void setTelephoneNumber(int telephoneNumber)
	{
		this.telephoneNumber = telephoneNumber;
	}

	public int getCustomerNumber()
	{
		return customerNumber;
	}

	public void setCustomerNumber(int customerNumber)
	{
		this.customerNumber = customerNumber;
	}
	
	//equals
	public boolean equals(Customer other)
	{
		if(this.getClass().equals(other.getClass()) && this.name.equals(other.name) && this.age == other.age &&
				this.telephoneNumber == other.telephoneNumber && this.customerNumber == other.customerNumber)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	//toString
	public String toString() 
	{
		return "\nName : " + name + "\nAddress : " + address + "\nAge : " + age + "\nTelephone Number : " + 
				telephoneNumber + "\nCustomer Number : " + customerNumber;
	}
	
	//abstract methods to be instantiated in subclasses
	abstract double getSavingsInterest();
	
	abstract double getCheckInterest();
	
	abstract double getCheckCharge();
	
	
	
	
}
