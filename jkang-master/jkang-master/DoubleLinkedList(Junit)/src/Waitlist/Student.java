package Waitlist;

public class Student 
{
	private String name;
	private int units;
	private String school;
	
	public Student()
	{
		name = "Erlich Bachman";
		units = 0;
		school = "MiraCosta College";
	}
	
	public Student(String name, int units, String school)
	{
		this.name = name;
		this.units = units;
		this.school = school;
	}
	
	public Student(Student other)
	{
		this.name = other.name;
		this.units = other.units;
		this.school = other.school;
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

	public int getUnits() 
	{
		return units;
	}

	public void setUnits(int units)
	{
		this.units = units;
	}

	public String getSchool() 
	{
		return school;
	}

	public void setSchool(String school) 
	{
		this.school = school;
	}
	
	public boolean equals(Student other)
	{
		if(this.name.equalsIgnoreCase(other.name) && this.school.equalsIgnoreCase(other.school) && 
				this.units == other.units)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	public String toString()
	{
		return "\nName : " + name + "\nUnits : " + units + "\nSchool : " + school;
	}
	
	
	
}
