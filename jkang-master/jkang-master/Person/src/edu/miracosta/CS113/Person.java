package edu.miracosta.CS113;

public class Person 
{
	//instance variables
	private String name;
	private int socialSecurityNumber;
	private int age;
	private String gender; 
	private String address;
	private int telephoneNumber;
	
	//default constructor
	public Person()
	{
		name = "Erlich Bachman";
		socialSecurityNumber = 123456789;
		age = 30;
		gender = "Male";
		address = "1234 1st Street";
		telephoneNumber = 1234567890;
		
	}
	
	//full constructor
	public Person(String name, int socialSecurityNumber, int age, String gender, String address, int telephoneNumber)
	{
		this.name = name;
		this.socialSecurityNumber = socialSecurityNumber;
		this.age = age;
		this.gender = gender;
		this.address = address;
		this.telephoneNumber = telephoneNumber;
		
	}
	
	//copy constructor
	public Person(Person other)
	{
		this.name = other.getName();
		this.socialSecurityNumber = other.getSocialSecurityNumber();
		this.age = other.getAge();
		this.gender = other.getGender();
		this.address = other.getAddress();
		this.telephoneNumber = other.getTelephoneNumber();
	}
	
	//toString
	public String toString()
	{
		return "Name : " + name + "\nSocial Security Number : " + socialSecurityNumber  + "\nAge : " + age +
				"\nGender : " + gender + "\nAddress : " + address + "\nTelephone Number : " + telephoneNumber; 
	}
	
	//getters/setters
	public String getName() 
	{
		return name;
	}


	public void setName(String name) 
	{
		this.name = name;
	}


	public int getSocialSecurityNumber() 
	{
		return socialSecurityNumber;
	}


	public void setSocialSecurityNumber(int socialSecurityNumber) 
	{
		this.socialSecurityNumber = socialSecurityNumber;
	}


	public int getAge() 
	{
		return age;
	}


	public void setAge(int age) 
	{
		this.age = age;
	}


	public String getGender() 
	{
		return gender;
	}


	public void setGender(String gender) 
	{
		this.gender = gender;
	}


	public String getAddress() 
	{
		return address;
	}


	public void setAddress(String address) 
	{
		this.address = address;
	}


	public int getTelephoneNumber() 
	{
		return telephoneNumber;
	}


	public void setTelephoneNumber(int telephoneNumber) 
	{
		this.telephoneNumber = telephoneNumber;
	}

	//equals
	public boolean equals(Person other) 
	{
		if(this.getName().equals(other.getName()) && this.getSocialSecurityNumber() == other.getSocialSecurityNumber() &&
				this.getAge() == other.getAge() && this.getGender().equals(other.getGender()) && 
				this.getAddress().equals(other.getAddress()) && this.getTelephoneNumber() == other.getTelephoneNumber())
		{
			return true;
		}
		else
		{
			return false;
		}
	}
}
