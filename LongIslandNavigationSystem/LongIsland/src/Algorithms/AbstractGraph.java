package Algorithms;

import java.util.Scanner;
import java.util.StringTokenizer;

/**
 * Abstract base class for graphs. A graph is a set
 * of vertices and a set of edges. Vertices are 
 * represented by integers from 0 to n-1. Edges
 * are ordered pairs of vertices.
 *
 */
public abstract class AbstractGraph implements Graph{

	// Data Fields
	/** True if this a directed graph. */
	private boolean directed;
	/** The number of vertices */
	private int numV;
	
	// Constructor
	/**
	 * Constructs an empty graph with the specified number of
	 * vertices and with the specified directed flag. If directed 
	 * is true, this is a directed graph.
	 * 
	 * @param numV The number of vertices
	 * @param directed The directed flag
	 */
	public AbstractGraph(int numV, boolean directed) {
		this.numV = numV;
		this.directed = directed;
	}
	
	// Accessor Methods
	/**
	 * Return the number of vertices.
	 * 
	 * @return The number of vertices.
	 */
	public int getNumV() {
		return numV;
	}
	/**
	 * Return whether this is a directed graph.
	 * 
	 * @return true if this is a directed graph
	 */
	public boolean isDirected() {
		return directed;
	}
	// Other Methods
		/**
		 * Load the edges of a graph from the data in an input file.
		 * The file should contain series of lines, each line
		 * with two or three values. The first is the source, 
		 * the second is the destination, and the optional third 
		 * is the weight.
		 * 
		 * @param scan The Scanner connected to the data file
		 */
		// TODO: try catch to open file
		public void loadEdgesFromFile(Scanner scan) {
			String line;
			int source;
			int dest;
			double weight;
			
			while (scan.hasNextLine()) {
				
				line = scan.nextLine();
				StringTokenizer splitLine = new StringTokenizer(line);
				
				source = Integer.parseInt(splitLine.nextToken());
				dest = Integer.parseInt(splitLine.nextToken());
				
				if (splitLine.hasMoreTokens()) {
					weight = Double.parseDouble(splitLine.nextToken());
				} else {
					weight = 1.0;
				}
				this.insert(new Edge(source,dest,weight));
			}
		}
		/**
		 * Factory method to create a graph and load the data from an input
		 * file. The first line of the input file should contain the number
		 * of vertices. The remaining lines should contain the edge data as
		 * described under loadEdgesFromFile.
		 * @param scan The Scanner connected to the data file
		 * @param isDirected true if this is a directed graph,
		 * 						false otherwise
		 * @param type The string "Matrix" if an adjacency matrix is to be
		 * 				created, and the string "List" if an adjacency list 
		 * 				is to be created.
		 * @throws IllegalArgumentException if type id neither "Matrix" 
		 * 										nor "List".
		 */
		public static Graph createGraph(Scanner scan, boolean isDirected, String type) {
			int numV = scan.nextInt();
			AbstractGraph returnValue = null;
			if (type.equalsIgnoreCase("Matrix")) {
				returnValue = new MatrixGraph(numV, isDirected);
			} else if (type.equalsIgnoreCase("List")) {
				returnValue = new ListGraph(numV, isDirected);
			} else {
				throw new IllegalArgumentException();
			}
			returnValue.loadEdgesFromFile(scan);
			return returnValue;
		}
}