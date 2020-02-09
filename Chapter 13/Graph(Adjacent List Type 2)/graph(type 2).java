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
		System.out.println(label);
	}
}

class Node
{
	char c;
	Node next;
	Node(char v)
	{
		c=v;
		next=null;
	}
	void display()
	{
		System.out.println(c);
	}
}

class LinkedList
{
	Node start;
	LinkedList()
	{
		start=null;
	}

	void addedge(char c)
	{
		Node temp=new Node(c);
		if(start==null)
			start=temp;
		else
		{
			Node t=start;
			while(t.next!=null)
				t=t.next;
			t.next=temp;
		}
	}

	void display()
	{
		Node temp=start;
		while(temp!=null)
		{
			System.out.print("-->"+temp.c);
			temp=temp.next;
		}
		System.out.println();
	}
	
}

class Graph
{
	Vertex arr[];
	int adjmatrix[][];
	int nvertex;
	LinkedList list[];
	Graph(int x)
	{
		arr=new Vertex[x];
		list=new LinkedList[x];
		nvertex=0;
		adjmatrix=new int[x][x];
		for(int i=0;i<nvertex;i++)
			for(int j=0;j<nvertex;j++)
				adjmatrix[i][j]=0;
		
	}
	void addvertex(char ch)
	{
		arr[nvertex]=new Vertex(ch);
		list[nvertex]=new LinkedList();
		nvertex++;
	}
	void adjacent(int i,int j)
	{
		adjmatrix[i][j]=1;
		adjmatrix[j][i]=1;
		list[i].addedge(arr[j].label);
		list[j].addedge(arr[i].label);
	}
	// void adjacent_list()
	// {
	// 	for(int i=0;i<nvertex;i++)
	// 	{
	// 		list[i]=new LinkedList();
	// 		for(int j=0;j<nvertex;j++)
	// 		{
	// 			if(adjmatrix[i][j]==1)
	// 				list[i].addedge(arr[j].label);
	// 		}
	// 	}	
	// }

	void display()
	{
		System.out.println("Adjacent matrix");
		for(int i=0;i<nvertex;i++)
		{
			for(int j=0;j<nvertex;j++)
				System.out.print(adjmatrix[i][j]);
			System.out.println();
		}
		System.out.println("Adjancent List");
		for(int i=0;i<nvertex;i++)
		{
			System.out.print(arr[i].label);
			list[i].display();
		}
		System.out.println();
	}

}


class GraphApp
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
		g.adjacent(0,1);
		g.adjacent(2,4);
		g.adjacent(1,2);
		g.adjacent(1,3);
		g.display();
	}
}
