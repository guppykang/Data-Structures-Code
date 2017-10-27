/**
 * DijkstraAlgorithm.java - Contains Dijkstra's Algorithm method.
 * 
 *  @version 1.0
 */
package Algorithms;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;



public class DijkstraAlgorithm 
{
	/**
	 * Dijkstra's Algorithm - Finds the shortest paths in a weighted graph.
	 * 
	 * @param graph The weighted graph to search.
	 * @param start The vertex to start at.
	 * @param predecessor Array to output containing the predecessors in the shortest path.
	 * @param distance Array to output containing the distance in the shortest path.
	 */
	public static void dijkstrasAlgorithm(ListGraph graph, int start, int[] predecessor, double[] distance)
	{
		int numV = graph.getNumV();
		HashSet<Integer> vMinusS = new HashSet<Integer>(numV);
		
		//Initialize V-S Set
		for (int i = 0; i < numV; i++)
		{
			if (i != start)
			{
				vMinusS.add(i);
			}
		}
		
		//Initialize predecessor and distance arrays
		for (int v : vMinusS)
		{
			predecessor[v] = start;
			distance[v] = graph.getEdge(start, v).getWeight();
		}
		
		//Main loop to calculate shortest paths.
		while (vMinusS.size() != 0)
		{
			//Find the value v in the V-S set with the smallest distance.
			double minimumDistance = Double.POSITIVE_INFINITY;
			int u = -1;
			
			for (int v : vMinusS)
			{
				if (distance[v] < minimumDistance)
				{
					minimumDistance = distance[v];
					u = v;
				}
			}
			
			//Remove u from set V-S
			vMinusS.remove(u);
			
			Iterator<Edge> edgeIterator = graph.edgeIterator(u);
			
			//Update distances using iterator to move through graph
			while (edgeIterator.hasNext())
			{
				Edge edge = edgeIterator.next();
				
				int v = edge.getDest();
				
				if (vMinusS.contains(new Integer(v)))
				{
					double weight = edge.getWeight();
					
					if (distance[u] + weight < distance[v])
					{
						distance[v] = distance[u] + weight;
						predecessor[v] = u;
					}
				}
			}
		}
	}
	
	/**
	 * Returns path from one vertex to another.
	 * 
	 * @param predecessors Array of previous vertices returned by Dijkstra's.
	 * @param destination Vertex to be reached.
	 * @param start Vertex to start at.
	 * 
	 * @return Array with path from start vertex to destination vertex.
	 */
	/*public static int[] printPath(int[] predecessors, int destination, int start)
	{
		int[] path = new int[predecessors.length];
		int index = 0;
		
		//No path between the vertices.
		if (predecessors[destination] == -1)
		{
			System.out.println("No path from " + start + " to " + destination);
			return null;
		}
		
		//Starts at the destination, then backtracks until v is equal to the starting vertex
		for (int v = destination; v != start; v = predecessors[v])
		{
			//Each vertex is added to the new array.
			path[index] = v;
			index++;
			
		}
		
		//Returns path
		return path;
	}*/
	
	/**
	 * Returns path from one vertex to another.
	 * 
	 * @param predecessors Array of previous vertices returned by Dijkstra's.
	 * @param destination Vertex to be reached.
	 * @param start Vertex to start at.
	 * 
	 * @return LinkedList with path from start vertex to destination vertex. Uses a LinkedList because some paths do not
	 * contain all four vertices
	 */
	public static LinkedList<Integer> printPath(int[] predecessors, int destination, int start)
	{
		LinkedList<Integer> path = new LinkedList<Integer>();
		
		//No path between the vertices.
		if (predecessors[destination] == -1)
		{
			System.out.println("No path from " + start + " to " + destination);
			return null;
		}
		
		//Starts at the destination, then backtracks until v is equal to the starting vertex
		for (int v = destination; v != start; v = predecessors[v])
		{
			//Each vertex is added to the new array.
			path.add(v);
			
		}

		path.add(start);
		//Returns path
		return path;
	}
}
