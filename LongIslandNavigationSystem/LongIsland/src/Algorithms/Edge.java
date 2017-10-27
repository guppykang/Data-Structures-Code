package Algorithms;

public class Edge {

	/** The destination vertex of an edge */
	private int dest;
	/** The source vertex for an edge. */
	private int source;
	/** The weight */
	private double weight;
	
	// Constructors
	/**
	 * Constructs an Edge from source to dest. Sets the weight to 1.0.
	 * 
	 * @param source The source vertex for an edge
	 * @param dest The destination vertex of an edge
	 */
	public Edge(int source, int dest) {
		this.weight = 1.0;
		this.source = source;
		this.dest = dest;
	}
	/**
	 * Constructs an Edge from source to dest. Sets the weight to w.
	 * @param source
	 * @param dest
	 * @param weight
	 */
	public Edge(int source, int dest, double w) {
		this.source = source;
		this.dest = dest;
		this.weight = w;
	}
	
	// Methods
	/**
	 * Compares two edge for equality. Edges are equal if their source
	 * and destination vertices are the same. The weight is not considered.
	 */
	public boolean equals(Edge other) {
		return this.source == other.source && this.dest == other.dest;
	}
	/**
	 * Returns the destination vertex
	 * 
	 * @return The destination vertex
	 */
	public int getDest() {
		return this.dest;
	}
	/**
	 * Returns the source vertex.
	 * 
	 * @return The source vertex
	 */
	public int getSource() {
		return this.source;
	}
	/**
	 * Returns the weight.
	 * 
	 * @return The weight.
	 */
	public double getWeight() {
		return this.weight;
	}
	/**
	 * Returns the hash code for an edge. The hash code depends only on
	 * the source and destination.
	 * 
	 * @return The hash code
	 */
	//TODO: Return hashCode
	public int hashCode() {
		return 0;
	}
	/**
	 * Returns a string representation of the edge.
	 * 
	 * @return The string representation of the edge.
	 */
	public String toString() {
		return this.source + "	---->	" + this.dest;	
	}
}
