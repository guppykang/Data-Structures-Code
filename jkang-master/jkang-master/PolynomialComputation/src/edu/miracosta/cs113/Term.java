package edu.miracosta.cs113;

/**
 * 
 * @author Joshua Kang
 * @version 1.0
 * Program Name: Term
 * Program Description: A Term object stores a term in a polynomial's exponent, and coefficients. 
 * Class Invariant: n/a
 *
 */
public class Term implements Comparable<Term>
{
	private double exponent;
	private double coefficient;
	
	public Term()
	{
		exponent = 0; 
		coefficient = 0;
	}
	
	public Term(double exponent, double coefficient)
	{
		this.exponent = exponent;
		this.coefficient = coefficient;
	}
	
	public Term(Term other)
	{
		this.exponent = other.exponent;
		this.coefficient = other.coefficient;
	}

	//getters and setters
	public double getExponent() 
	{
		return exponent;
	}

	public void setExponent(double exponent)
	{
		this.exponent = exponent;
	}

	public double getCoefficient() 
	{
		return coefficient;
	}

	public void setCoefficient(double coefficient) 
	{
		this.coefficient = coefficient;
	}

	@Override
	public int compareTo(Term other) 
	{
		if(other.exponent > this.exponent)
		{
			return 1;
		}
		else if(other.exponent < this.exponent)
		{
			return -1;
		}
		else
		{
			return 0;
		}
	}
	
	
	
}
