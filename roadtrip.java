//roadtrip program

import java.util.*

public class Dijkstras
{
	final int max=1000000;
	int N;
	int[][] graph;
	
	Dijkstras()
	{
		buildGraph();
		dijkstrasPath(0);//the source is plugged into this as a parameter
	}
	
	void buildGraph()
	{
	//instantiate a graph
	graph=new int [N][N];
	//this is where input is done, set N and take in the number of edges, then loop that many times
	//using addEdge(x,y,z) x y and z being the 3 numbers passed in , 2 cities and a weight/cost
	}
	
	//adds the edge to the graph
	void addEdge(int x, int y, int z)
	{
		graph[x][y]=graph[y][x]=z;
	}
	
	ArrayList<Integer>[][] list= new ArrayList[2][];
	
	//the actual algorithm
	int[] dijkstarsPath(int source)
	{
		class linkCities implements Comparable<linkCities>
		{
			int a,b;
			linkCities(int a, int b)
			{
				this.a=a;
				this.b=b;
			}
			
			public int compareTo(linkCities city)
			{
				int z=b-city.b;
				if (z==0)
					z=a-city.a;
				return z;
			}
		}
	
		convertGraph();
		
		int[]A=new int[N];
		int[]B=new int[N];
		Arrays.fill(A,max);
		A[source]=0;
		//B[source]=source;
		
		TreeSet<linkCities> S = new TreeSet<linkCities>();
		for (int i=0;i<N;i++)
			S.add(new linkCities(i,A[i]));
			
			for (int i=0; i<N;i++)
			{
				linkCities top=S.pollFirst(); //removes the first element
				int mina=top.a
			
		
			//relax edges
			for(int k=0;k<list[0][mina].size(); k++)
			{
				int j=list[0][mina].get(k); //this is vertex
				int cost=list[1][mina].get(k); //cost from i to j
				
				int total=A[mina]+cost;
				if (total<A[j])
				{
					S.remove(new linkCities(j,A[j]));
					
					//relax the vertex
					S.add(new linkCities(j,A[j]));
				}
			}		
		}
		return total;
	}
	
	//converts graph to adjacency list for efficiency
	void convertGraph()
	{
		for (int i=0;i<2;i++)
		{
			list[i]=new ArrayList[N];
		}
		
		for (int i =0; i<N;i++)
		{
			list[0][i]=new ArrayList<Integer>(); //holds the verticies
			list[1][i]=new ArrayList<Integer>(); //hold the weight/cost
		
			for (int j=0;j<N;j++)
				if(graph[i][j]>0)
				{
					list[0][i].add(j);
					list[1][i].add(graph[i][j]);
				}
		}
	}
	
	public static void main(String[] args)
	{
		new Dijkstras();
	}
}