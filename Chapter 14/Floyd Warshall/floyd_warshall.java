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
	int INFINITY=9999;
	Vertex arr[];
	int nvertex;
	int weight_mat[][];
	Graph()
	{
		arr=new Vertex[20];
		nvertex=0;
		weight_mat=new int[20][20];
	
		for(int i=0;i<20;i++)
		{
			for(int j=0;j<20;j++)
			{
				if(i==j)
					weight_mat[i][j]=0;
					else		
				weight_mat[i][j]=INFINITY;

			}
		}
	}
	void addvertex(char c)
	{
		arr[nvertex]=new Vertex(c);
		nvertex++;
	}
	void addedge(int i,int j,int w)
	{
		weight_mat[i][j]=w;
	}
	void floyd_warshall()
	{
		for(int k=0;k<nvertex;k++)
		{
			for(int i=0;i<nvertex;i++)
			{
				for(int j=0;j<nvertex;j++)
				{


					if(weight_mat[i][k]+weight_mat[k][j]<weight_mat[i][j])
						weight_mat[i][j]=weight_mat[i][k]+weight_mat[k][j];
				}
			}
		}
	}
	void weight_display()
	{
		System.out.println("Displaying the path matrix");
		for(int i=0;i<nvertex;i++)
		{
			for(int j=0;j<nvertex;j++)
			{
				if(weight_mat[i][j]==9999)
					System.out.print("INf ");	
				System.out.print(weight_mat[i][j]+" ");
			}
			System.out.println();
		}
	}

}
class FloydWarshallsApp
{
	public static void main(String args[])
	{
		Scanner sc=new Scanner(System.in);
		Graph g=new Graph();
		g.addvertex('A');
		g.addvertex('B');
		g.addvertex('C');
		g.addvertex('D');
		g.addedge(0,1,3);
		g.addedge(1,2,3);
		g.addedge(2,3,1);
		g.addedge(0,3,10);
		g.weight_display();
		g.floyd_warshall();
		g.weight_display();
	}
}
