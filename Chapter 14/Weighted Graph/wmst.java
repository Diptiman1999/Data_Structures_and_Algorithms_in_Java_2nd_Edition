class Edge
{
	int src;
	int dest;
	int distance;
	Edge(int s,int d,int w)
	{
		src=s;
		dest=d;
		distance=w;
	}

}
class PriorityQ
{
	Edge list[];
	int size;
	PriorityQ()
	{
		list=new Edge[20];
		size=0;
	}
	void insert(Edge item)
	{
		int i,j;
		for(i=0;i<size;i++)
			if(item.distance>=list[i].distance)
				break;
		for(j=size;j>i;j--)
			list[j]=list[j-1];
		list[i]=item;
		size++;
		

	}

	Edge removemin()
	{
		Edge temp=list[--size];
		return temp;
	}
	void removeN(int n)
	{
		for(int i=n;i<size-1;i++)
			list[i]=list[i+1];
		size--;

	}

	int find(int fvertex)
	{
		for(int i=0;i<size;i++)
			if(list[i].dest==fvertex)
				return i;
		return -1;
	}

	Edge peekmin()
	{
		return list[size-1];
	}
	Edge peekN(int index)
	{
		return list[index];
	}
}






class Vertex
{
	char label;
	boolean wasvisited;
	Vertex(char data)
	{
		label=data;
		wasvisited=false;
	}
	void display_vertex()
	{
		System.out.println(label);
	}
}


class Graph
{
	Vertex arr[];
	int adjacentmat[][];
	int nvertex;
	PriorityQ iq;
	int current;
	int ntree;

	Graph(int size)
	{	
		arr=new Vertex[size];
		adjacentmat=new int[size][size];
		nvertex=0;
		for(int j=0; j<size; j++)
		{
			for(int k=0; k<size; k++)
			{
				adjacentmat[j][k] = 0;
			}
		}
		iq=new PriorityQ();
	}

	void addVert(char ch)
	{
		arr[nvertex]=new Vertex(ch);
		nvertex++;
	}

	void addEdge(int a,int b,int weight)
	{
		adjacentmat[a][b]=weight;
		adjacentmat[b][a]=weight;
	}

	void display()
	{
		System.out.print("   ");
		for(int i=0;i<nvertex;i++)
		{
			System.out.print(arr[i].label+"   ");
		}
		
		System.out.println("");
		for(int i=0;i<nvertex;i++)
		{
			System.out.print(arr[i].label+"  ");
			for(int j=0;j<nvertex;j++)
			{
				System.out.print(adjacentmat[i][j]+"   ");
			}
			System.out.println("");
		}
	}

	void mstw()
	{
		current=0;
		ntree=0;
		while (ntree<nvertex-1)
		{
			arr[current].wasvisited=true;
			ntree++;
			for(int j=0;j<nvertex;j++)
			{
				if(j==current)
					continue;
				else if (arr[j].wasvisited)
					continue;
				int dist=adjacentmat[current][j];
				if(dist==0)
					continue;
				putInPQ(j,dist);
			}
			if(iq.size==0)
			{
				System.out.println("Graph is not Connected");
				return;
			}
			Edge theEdge=iq.removemin();
			int source=theEdge.src;
			current=theEdge.dest;	
			System.out.println(arr[source].label);
			System.out.println(arr[current].label);
			System.out.println(" ");

		}

		for(int j=0;j<nvertex;j++)
			arr[j].wasvisited=false;
	}
	void putInPQ(int newvert, int newdist)
	{
		int queueIndex = iq.find(newvert);
		if(queueIndex != -1)
		{
			Edge tempEdge = iq.peekN(queueIndex);
			int olddist = tempEdge.distance;
			if(olddist > newdist)
			{
				iq.removeN(queueIndex);
				Edge theEdge =new Edge(current, newvert, newdist);
				iq.insert(theEdge);
			}
		} 
		else
		{
			Edge theEdge = new Edge(current, newvert, newdist);
			iq.insert(theEdge);
		}
	} 
}


class WMSTApp
{
	public static void main(String args[])
	{
		Graph g=new Graph(20);
		g.addVert('A');
		g.addVert('B');
		g.addVert('C');
		g.addVert('D');
		g.addVert('E');
		g.addVert('F');
		g.addEdge(0,1,6);
		g.addEdge(1,3,7);
		g.addEdge(0,3,4);
		g.addEdge(1,2,10);
		g.addEdge(1,4,7);
		g.addEdge(2,3,8);
		g.addEdge(2,4,5);
		g.addEdge(2,5,6);
		g.addEdge(4,5,7);
		g.addEdge(3,4,12);
		System.out.print("Minimum Spanning Tree :");
		g.mstw();
		System.out.println();

	}

}
