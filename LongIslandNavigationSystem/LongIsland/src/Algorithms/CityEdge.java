package Algorithms;

/**
 * 
 * @author Joshua Kang
 * @version
 * Program Name: City Edges
 * Program Description: keeps track of the cities respective to their indexes
 *
 */
public class CityEdge extends Edge
{
	private String city; 
	
	/**
	 * creates a new City edge
	 * @param source starting city
	 * @param dest destination city
	 * @param w weight
	 * @param city name of highway
	 */
	public CityEdge(int source, int dest, double w, String city)
	{
		super(source, dest, w);
		this.city = city;
	}
	
	/**
	 * 
	 * Description: returns the name of the highway
	 * @return String
	 */
	public String getCity()
	{
		return this.city;
		
	}
	
	/**
	 * 
	 * Description: returns the String format of the city 
	 * @param index
	 * @return String
	 */
	public static String getCity(int index)
	{
		if(index == 0)
		{
			return "Hempstead";
		}
		else if(index == 1 )
		{
			return "Hicksville";
		}
		else if(index == 2)
		{
			return "Commack";
			
		}
		else if(index == 3)
		{
			return "Bay Shore";
		}
		else if(index == 4)
		{
			return "Shirley";
		}
		else if(index == 5)
		{
			return "Hampton Bays";
		}
		else if(index == 6)
		{
			return "Riverhead";
		}
		else if(index == 7)
		{
			return "Greenport";
		}
		else 
		{
			return "CITY NOT FOUND";
		}
	}
	/**
	 * Returns a string representation of the edge.
	 * 
	 * @return The string representation of the edge.
	 */
	public String toString() {
		return this.getSource() + "	----> via " + this.city + "	----> "+ this.getDest();	
	}
}
