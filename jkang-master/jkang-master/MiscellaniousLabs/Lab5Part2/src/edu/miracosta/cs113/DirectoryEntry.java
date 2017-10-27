package edu.miracosta.cs113;


public class DirectoryEntry extends Entry
{
	private String number;
	
	public DirectoryEntry(String name, String number)
	{
		super(name);
		this.number = number;
	}

	public String getNumber() 
	{
		return number;
	}

	public void setNumber(String number)
	{
		this.number = number;
	}

	@Override
	public String toString() {
		return "DirectoryEntry [name=" + getName() + ", number=" + number + "]";
	}

}
