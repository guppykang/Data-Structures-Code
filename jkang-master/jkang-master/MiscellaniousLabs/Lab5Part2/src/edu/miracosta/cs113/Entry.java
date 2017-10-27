package edu.miracosta.cs113;


public class Entry 
{
	private String name;

	public Entry(String name) {
		super();
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Entry [name=" + name + "]";
	}
	
}
