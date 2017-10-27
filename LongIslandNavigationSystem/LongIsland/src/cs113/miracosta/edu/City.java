package cs113.miracosta.edu;

//for google static map imports
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.util.LinkedList;

//gui
import javax.swing.*;

//Graph and Dijkstra's Algorithm
import Algorithms.*;

/**
 * 
 * @author Joshua Kang
 * @version 1.0
 * Program Name: Long Island Navigator
 * Program Description: Is able to calculate the fastest route from a city to another city on Long Island
 *
 */
public class City extends JFrame
{
	private ListGraph longIsland;
	private JPanel menu;
	private JFrame city; 
	private JButton calculate;
	private JLabel from, too;
	private JTextField fromText, tooText;
	private int[]  predecessor;
	private double[] distance;
	private String fromNodeName, tooNodeName; 
	private int fromNodeIndex, tooNodeIndex;
	
	public City()
	{
		//initialize and set the layout of the Frame
		city = new JFrame("Long Island E Maps");
		city.setLayout(new BorderLayout());
        
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		getCoordinates();
        //add the map to the Center border
        city.add(new JLabel(new ImageIcon((new ImageIcon("image.jpg")).getImage().getScaledInstance(630, 600,java.awt.Image.SCALE_SMOOTH))), BorderLayout.CENTER);
        
        //add the menu items
        getMenu();
        
        //add the menu to the north side border
        city.add(menu, BorderLayout.NORTH);
        
        generateGraph();
        
        
        
        city.pack();
        city.setVisible(true);
				
        
	}
	
	public void generateGraph()
	{
		//add the edges of the cities to the graph
		longIsland = new ListGraph(8, false);
		longIsland.insert(new CityEdge(0,1,18,"Meadowbrook State Boulevard"));
		longIsland.insert(new CityEdge(1,2, 20, "Northern State Boulevard"));
		longIsland.insert(new CityEdge(2,3, 17, "Sagitkos Boulevard"));
		longIsland.insert(new CityEdge(3,0, 36, "Southern State Parkway"));
		longIsland.insert(new CityEdge(3,4, 26, "Sourthern State Parkway"));
		longIsland.insert(new CityEdge(4, 5, 22, "Southern State Parkway"));
		longIsland.insert(new CityEdge(5, 6, 18, "Flanders Road"));
		longIsland.insert(new CityEdge(2, 6, 38, "Northern State Boulevard"));
		longIsland.insert(new CityEdge(6, 7, 36, "County Road"));
		
	}
	public void getMenu()
	{
		//creates the special font
		createFont();
		
		//creates the upper panel for the menu
		menu = new JPanel();
		
		//creates the label and the text field for the starting position
		from = new JLabel("Your location: ");
		from.setFont(myFont);
		fromText = new JTextField(10);
		
		//creates the label and the text field for the destination 
		too = new JLabel("Destination : ");
		too.setFont(myFont);
		tooText = new JTextField(10);
		
		//creates the button to calculate the path from "from" to "too"
		calculate = new JButton("Naviagte!");
		calculate.addActionListener(new SaveInfoListener());
		
		
		//add the labels and text fields to the panel
		menu.add(from);
		menu.add(fromText);
		
		menu.add(too);
		menu.add(tooText);
		
		menu.add(calculate);
	}
	
	
	
	private class SaveInfoListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e) 
		{
			boolean exists = true;
			
			//get the city names
			fromNodeName = fromText.getText();
			tooNodeName = tooText.getText();
			
			/**** calculate the indexes from the name of the city ********/
			//for the starting point
			if(fromNodeName.equalsIgnoreCase("Hempstead"))
			{
				fromNodeIndex = 0;
			}
			else if(fromNodeName.equalsIgnoreCase("Hicksville"))
			{
				fromNodeIndex = 1;
			}
			else if(fromNodeName.equalsIgnoreCase("Commack"))
			{
				fromNodeIndex = 2;
			}
			else if(fromNodeName.equalsIgnoreCase("Bay Shore"))
			{
				fromNodeIndex = 3;
			}
			else if(fromNodeName.equalsIgnoreCase("Shirley"))
			{
				fromNodeIndex = 4; 
			}
			else if(fromNodeName.equalsIgnoreCase("Hampton Bays"))
			{
				fromNodeIndex = 5;
			}
			else if(fromNodeName.equalsIgnoreCase("RiverHead"))
			{
				fromNodeIndex = 6;
			}
			else if(fromNodeName.equalsIgnoreCase("GreenPort"))
			{
				fromNodeIndex = 7;
			}
					
			else if(fromNodeName.equalsIgnoreCase(""))
			{
				exists = false;
				JOptionPane.showMessageDialog(null, "Please enter a Starting point");
			}
			else
			{
				exists = false;
				JOptionPane.showMessageDialog(null, fromNodeName + " is not a valid Starting Point");
			}
			
			//for the destination
			if(tooNodeName.equalsIgnoreCase("Hempstead"))
			{
				tooNodeIndex = 0;
			}
			else if(tooNodeName.equalsIgnoreCase("Hicksville"))
			{
				tooNodeIndex = 1;
			}
			else if(tooNodeName.equalsIgnoreCase("Commack"))
			{
				tooNodeIndex = 2;
			}
			else if(tooNodeName.equalsIgnoreCase("Bay Shore"))
			{
				tooNodeIndex = 3;
			}
			else if(tooNodeName.equalsIgnoreCase("Shirley"))
			{
				tooNodeIndex = 4; 
			}
			else if(tooNodeName.equalsIgnoreCase("Hampton Bays"))
			{
				tooNodeIndex = 5;
			}
			else if(tooNodeName.equalsIgnoreCase("RiverHead"))
			{
				tooNodeIndex = 6;
			}
			else if(tooNodeName.equalsIgnoreCase("GreenPort"))
			{
				tooNodeIndex = 7;
			}
			else if(tooNodeName.equalsIgnoreCase(""))
			{
				exists = false;
				JOptionPane.showMessageDialog(null, "Please enter a destination");
			}
			else
			{
				exists = false;
				JOptionPane.showMessageDialog(null, tooNodeName + " is not a valid Destination Point");
			}
			
			//if both a starting point and a destination exist then calculate the fastest path
			if (exists) {
				distance = new double[8];
				predecessor = new int[8];
				DijkstraAlgorithm.dijkstrasAlgorithm(longIsland, fromNodeIndex, predecessor, distance);
				LinkedList<Integer> path = DijkstraAlgorithm.printPath(predecessor, tooNodeIndex, fromNodeIndex);
				String pathString = "";
				for (int i = path.size() - 1; i >= 0; i--) {
					pathString += CityEdge.getCity(path.get(i));
					if (i != 0) {
						pathString += " ---> " +  "\n";
					}

				}
				JOptionPane.showMessageDialog(null, pathString, "Route from " + fromNodeName + " to " + tooNodeName, JOptionPane.INFORMATION_MESSAGE);
			}
		}
	}
	
	
	/**
	 * 
	 * Description: extracts the URL and puts into into .jpg form of an image, and takes byte by byte the bits of 
	 * static image of the location at the coordinates. 
	 */
	public void getCoordinates()
	{
		try 
        {
        	//google search coordinates are wrong!!! Needs a negative in front to go to the other side of the world
        	String imageUrl =  "https://maps.googleapis.com/maps/api/staticmap?center=40.8128,-73.0059&zoom=9&size=612x612&scale=2&maptype=roadmap";
        	String destinationFile = "image.jpg";
            String str = destinationFile;
            URL url = new URL(imageUrl);
            InputStream is = url.openStream();
            OutputStream os = new FileOutputStream(destinationFile);

            byte[] b = new byte[2048];
            int length;

            while ((length = is.read(b)) != -1)
            {
                os.write(b, 0, length);
            }

            is.close();
            os.close();
        }
        catch (IOException e)
        {
            e.printStackTrace();
            System.exit(1);
        }
	}
	
	Font myFont;
	/**
	 * 
	 * Description: Creates a new font and size to make things look different.
	 */
	public void createFont()
	{
		myFont = new Font("Serif", Font.BOLD, 20);
	}
}
