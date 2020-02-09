import java.util.*;
class Vertex
{
	char label;
	boolean wasvisited;
	Vertex(char l)
	{
		label=l;
		wasvisited=false;
	}
	void display()
	{
		System.out.println(label);
	}
}

class Graph
{
	Vertex arr[];
	int nvertex;
	int path[][];
	Graph()
	{
		arr=new Vertex[20];
		nvertex=0;
		path=new int[20][20];
		for(int i=0;i<20;i++)
			for(int j=0;j<20;j++)
				path[i][j]=0;
	}
	void addvertex(char c)
	{
		arr[nvertex]=new Vertex(c);
		nvertex++;
	}
	void addedge(int i,int j)
	{
		path[i][j]=1;
	}
	void warshall()
	{
		for(int k=0;k<nvertex;k++)
		{
			for(int i=0;i<nvertex;i++)
			{
				for(int j=0;j<nvertex;j++)
				{
					if(path[i][k]==1 && path[k][j]==1)
						path[i][j]=1;
				}
			}
		}
	}
	void path_display()
	{
		System.out.println("Displaying the path matrix");
		for(int i=0;i<nvertex;i++)
		{
			for(int j=0;j<nvertex;j++)
			{
				System.out.print(path[i][j]);
			}
			System.out.println();
		}
	}

}
class WarshallsApp
{
	public static void main(String args[])
	{
		Scanner sc=new Scanner(System.in);
		Graph g=new Graph();
		g.addvertex('A');
		g.addvertex('B');
		g.addvertex('C');
		g.addvertex('D');
		g.addedge(2,0);
		g.addedge(3,2);
		g.addedge(1,3);
		g.path_display();
		g.warshall();
		g.path_display();
	}
}
