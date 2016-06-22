//Nicholas Harrison
//Assignment 6
//due 11/27/13

import java.util.*;
import java.io.*;


public class DirectedGraph
{
 	//variables
 	protected int MaxSize = 50;
 	protected int currentSize;
 	protected boolean node[]= new boolean[MaxSize];
 	protected boolean visited[]= new boolean[MaxSize];
 	protected LinkedList adjacency[]=new LinkedList[MaxSize];

	//constructor
	public DirectedGraph()
	{
	currentSize=0;
	for (int i=0; i<MaxSize;i++)
		{
		node[i]=false;
		adjacency[i]= new LinkedList<Integer>();
		}
	}

	//inserts a node into the graph
	public void insertNode(int index)
	{
		//checks to make sure there isnt already a node
		if(!node[index])
			{
			currentSize++;
			node[index]=true;
			}
		}

	//sees if nodes are adjacent/connected to each other
	public boolean isAdjacent(int x, int y)
	{
		return (adjacency[x].contains(y)||adjacency[y].contains(x));
	}

	//creates an edge between x and y
	public void insertEdge(int x, int y)
	{
		if (node[x]&& node[y]&& !(adjacency[x].contains(y)))
			adjacency[x].add(new Integer(y));
	}

	//outputs everything about the graph that has been formatted
	public void output()
	{
		System.out.println("Nodes are: ");
		for (int i=0; i< MaxSize; i++)
		{
			if(node[i])
				System.out.print(i+" ");
		}

		System.out.println();
		System.out.println("Edges are: ");
		for (int i=0; i< MaxSize; i++)
		{
			if(node[i])
				System.out.println(i+" "+ adjacency[i]);
		}

	}

	//creates a path between x and y and sees if there is another node that leads to y
	public boolean dupPath(int x, int y)
		{

			if (node[x]&& node[y]&& !(adjacency[x].contains(y)))
				adjacency[x].add(new Integer(y));

			for (int i=0; i<MaxSize; i++)
			{
				if(isAdjacent(i,y)&&node[i]!=node[x]);
				return true;
			}

		return false;
	}

	//sees if x and y have the same ancestor
	public boolean traceAncestor(int x, int y)
	{
		for (int i=0; i<MaxSize; i++)
		{
			if (isAdjacent(i,x)&&isAdjacent(i,y))
			return true;
		}
	return false;
	}

}

