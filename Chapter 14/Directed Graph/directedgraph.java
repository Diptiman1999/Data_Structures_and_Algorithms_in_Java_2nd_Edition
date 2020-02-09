import java.util.*;

class Vertex
{
	char label;
	boolean wasvisited;
	Vertex(char c)
	{
		label=c;
		wasvisited=false;
	}
	void display_vertex()
	{
		System.out.print(label);
	}
}

class Graph
{
	Vertex arr[];
	int adjmatrix[][];
	int nvertex;
	Graph(int x)
	{
		arr=new Vertex[x];
		nvertex=0;
		adjmatrix=new int[x][x];
		for(int i=0;i<nvertex;i++)
			for(int j=0;j<nvertex;j++)
				adjmatrix[i][j]=0;
		
	}
	void addvertex(char ch)
	{
		arr[nvertex]=new Vertex(ch);
		nvertex++;
	}
	void adjacent(int i,int j)
	{
		adjmatrix[i][j]=1;
	}

	void transitive()
	{
		for(int i=0;i<nvertex;i++)
		{
			for(int j=0;j<nvertex;j++)
			{
				if(adjmatrix[i][j]==1)
					for(int k=0;k<nvertex;k++)
						if(adjmatrix[j][k]==1)
							adjmatrix[i][k]=1;

			}
		}
	}


	void display()
	{
		System.out.println("Transitive closure");
		for(int i=0;i<nvertex;i++)
		{
			for(int j=0;j<nvertex;j++)
				System.out.print(adjmatrix[i][j]);
			System.out.println();
		}
	}

}


class DirectedGraphApp
{
	public static void main(String args[])
	{
		Scanner sc=new Scanner(System.in);
		Graph g=new Graph(20);
		g.addvertex('A');
		g.addvertex('B');
		g.addvertex('C');
		g.addvertex('D');
		g.addvertex('E');
		g.adjacent(1,0);
		g.adjacent(0,2);
		g.adjacent(1,4);
		g.adjacent(4,2);
		g.adjacent(3,4);
		g.display();
		g.transitive();
		g.display();

	}
}
