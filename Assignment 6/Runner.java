//Nicholas Harrison
//Assignment 6
//due 11/27/13

/*
Input is handled through a text file that is provided with the program
Output is a formatted version of what the graph is and if 2 nodes leade to the same node as another.  It also states wheather 2 nodes share a similar ancestor
Summary: The purpose of this program was to get us to implement a directed graph and perform actions based on it.
*/





import java.util.*;
import java.io.*;

//runs the program
public class Runner
{
	public static void main(String [] args) throws IOException
	{

		Scanner sc=new Scanner(System.in);

		//scanner for file input
		System.out.println("Enter the name of the file you wish to use for input");
		String q =sc.next();
		Scanner scan = new Scanner(new File(q));

		//finds the number of nodes
		int numNodes = scan.nextInt();

		System.out.println();

		//the graph is instantiated
		DirectedGraph dg = new DirectedGraph();

		//forms the nodes
		for (int i=1;i<=numNodes;i++)
		dg.insertNode(i);

		//creates the edges
		while (scan.hasNext())
		{
		dg.insertEdge(scan.nextInt(), scan.nextInt());
		}

		//dg.insertEdge(1,2);
		//dg.insertEdge(1,3);
		//dg.insertEdge(1,4);
		//dg.insertEdge(1,5);
		//dg.insertEdge(3,5);
		//dg.insertEdge(4,2);

		//output of the graph
		dg.output();

       	//here the user enters 2 nodes and an edge is formed for them and you are told if there is another node that connects to the last node entered
       	System.out.println();
       	System.out.println("Enter the 2 nodes that you wish to connect, the first node will be directed to the second node");
       	int i = sc.nextInt();
		int j = sc.nextInt();
		System.out.println("node "+i+" now has an edge directed to node "+j+" and it is "+dg.dupPath(i,j)+" that there is another node with a directed edge towards node "+j);

		//returns a boolean based on wheather the nodes share an ancestor
		System.out.println();
		System.out.println("Enter the 2 nodes that you want to see if they share a common ancestor");
		int a = sc.nextInt();
		int b = sc.nextInt();
		System.out.println(dg.traceAncestor(a,b));
	}
}