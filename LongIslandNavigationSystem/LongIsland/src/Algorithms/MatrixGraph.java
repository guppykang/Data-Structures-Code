package Algorithms;

import java.util.Iterator;

/**
 * A MatrixGraph is an extension of the AbstractGraph abstract class
 * that uses a two-dimensional array of lists to represent the edge weights.
 */
public class MatrixGraph extends AbstractGraph {
	
	// Inner Class
	public class Iter implements Iterator<Double> {

		private int source;
		private int dest;
		
		@Override
		public boolean hasNext() {
			// fix
			return false;
		}

		@Override
		public Double next() {
			// TODO Auto-generated method stub
			return null;
		}
		
	}

	// Data Field
	/** 
	 * A two-dimensional array to contain the 
	 * edges that originate with each vertex.
	 */
	double[][] edges;
	
	// Constructor
	/**
	 * Construct a graph with the specified number of vertices
	 * and directionality.
	 * 
	 * @param numV Number of vertices
	 * @param directed The directionality flag
	 */
	public MatrixGraph(int numV, boolean directed) {
		super(numV, directed);
		edges = new double[numV][numV];
	}
	
	// Methods
	public boolean isEdge(int source, int dest) {
		return edges[source][dest] != Double.POSITIVE_INFINITY;
	}

	@Override
	public void insert(Edge edge) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Edge getEdge(int source, int dest) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterator<Edge> edgeIterator(int source) {
		// TODO Auto-generated method stub
		return null;
	}
}
