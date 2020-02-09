import java.util.*;
class Node1
{
	int data;
	Node1 next;
	Node1(int d)
	{
		data=d;
		next=null;
	}
}
class Queue
{
	Node1 start;
	Queue()
	{
		start=null;
	}
	boolean isEmpty()
	{
		return(start==null);
	}
	void insert(int t)
	{
		Node1 temp=new Node1(t);
		if(start==null)
			start=temp;
		else
		{
			Node1 v=start;
			while(v.next!=null)
				v=v.next;
			v.next=temp;
			
		}
	}
	int remove()
	{
		if(!isEmpty())
		{
			Node1 t=start;
			start=start.next;
			return t.data;
		}
		return -1;
		
	}

}

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
		nvertex++;
	}
	void adjacent(int i,int j)
	{
		adjmatrix[i][j]=1;
		adjmatrix[j][i]=1;
	}
	void adjacent_list()
	{
		for(int i=0;i<nvertex;i++)
		{
			list[i]=new LinkedList();
			for(int j=0;j<nvertex;j++)
			{
				if(adjmatrix[i][j]==1)
					list[i].addedge(arr[j].label);
			}
		}	
	}
	
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


	void bfs()
	{
		Queue q=new Queue();
		q.insert(0);
		arr[0].wasvisited=true;
		while(!q.isEmpty())
		{
			int x=q.remove();
			arr[x].display_vertex();
			//arr[x].wasvisited=true;
			int y=getunvisitedvertex(x);
			while(y!=-1)
			{
				arr[y].wasvisited=true;
				q.insert(y);
				y=getunvisitedvertex(x);
			}
		}
		System.out.println();
	}

	int getunvisitedvertex(int x)
	{
		for(int j=0;j<nvertex;j++)
		{
			if(adjmatrix[x][j]==1 && arr[j].wasvisited==false)
				return j;
		}
		return -1;
	}

}


class BFSApp
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
		g.addvertex('F');
		g.addvertex('G');
		g.addvertex('H');
		g.adjacent(0,1);
		g.adjacent(0,3);
		g.adjacent(0,5);
		g.adjacent(1,2);
		g.adjacent(5,4);
		g.adjacent(4,6);
		g.adjacent(5,7);
		g.adjacent_list();
		g.display();
		System.out.println("--------------------------------");
		System.out.println("Using BFS");
		g.bfs();
	}
}
