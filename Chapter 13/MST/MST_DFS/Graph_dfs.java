import java.util.*;
class Stack_node
{
	int data;
	Stack_node next;

	Stack_node(int in)
	{
		data=in;
	}
}
class Stack
{
	Stack_node start;
	Stack()
	{
		start=null;
	}
	boolean isEmpty()
	{
		return(start==null);
	}
	int peek()
	{
		return start.data;
	}
	void push(int t)
	{
		Stack_node temp=new Stack_node(t);
		if(start==null)
			start=temp;
		else
		{
			temp.next=start;
			start=temp;
		}
	}
	void pop()
	{
		if(!isEmpty())
		{
			start=start.next;
		}
	}

										
}
class Node
{
	char data;
	Node next;

	Node(char in)
	{
		data=in;
	}
}
class Linklist
{
	Node root;

	Linklist() 
	{
		root=null;
	}

	void insert(char data)
	{

		if(root==null)
		{
			Node temp=new Node(data);
			temp.next=null;
			root=temp;
		}

		else
		{
			Node temp1=root;

			while(temp1.next!=null)
			{
				temp1=temp1.next;
			}

			Node temp=new Node(data);
			temp.next=null;
			temp1.next=temp;
		}
	}

	void display() 
	{

		Node temp=root;
		while(temp!=null)
		{
			System.out.print(temp.data+"-->");
			temp=temp.next;
		}
	}



}

class Vert
{
	char label;
	boolean is_visited;
	Vert(char ch)
	{
		label =ch;
		is_visited=false;
	}

	void display()
	{
		System.out.println(label);	
	}
}

class Graph
{
	Vert arr[];
	int adj_mat[][];
	int mst_adj[][];
	Linklist adj_list[];
	int nvert;

	Graph(int size)
	{	
		arr=new Vert[size];
		adj_mat=new int[size][size];
		mst_adj=new int[size][size];
		adj_list=new Linklist[size];
		nvert=0;
		for(int j=0; j<size; j++)
		{
			for(int k=0; k<size; k++)
			{
				adj_mat[j][k] = 0;
				mst_adj[j][k] = 0;
			}
		}
	}

	void addVert(char ch)
	{
		arr[nvert]=new Vert(ch);
		nvert++;
	}

	void addEdge(int a,int b)
	{
		adj_mat[a][b]=1;
		adj_mat[b][a]=1;
	}
	
	void list_create()
	{
		for(int i=0;i<nvert;i++)
		{
			adj_list[i]=new Linklist();
			adj_list[i].insert(arr[i].label);
				for(int k=0;k<nvert;k++)
				{
					if(adj_mat[i][k]==1)
					{
						adj_list[i].insert(arr[k].label);
					}	
				}
		}
	}

	void list_view()
	{
		list_create();
		for(int i=0;i<nvert;i++)
		{
			adj_list[i].display();
			System.out.println("");
		}
	}

	void dfs()
	{
		Stack s1=new Stack();
		arr[0].display();
		arr[0].is_visited=true;
		s1.push(0);
		while(!s1.isEmpty())
		{
			int x =s1.peek();
			int y =get_unvisited_adjver(x);
			if(y!=-1)
			{
				arr[y].display();
				arr[y].is_visited=true;
				s1.push(y);
			}
			else
			{
				s1.pop();
			}
		}

	}

	int get_unvisited_adjver(int x)
	{
		for(int i=0;i<nvert;i++)
		{
				if(adj_mat[x][i]==1 && arr[i].is_visited==false)
				{
					return i;
				}
		}
		return -1;
	}

	void display()
	{
		System.out.print("   ");
		for(int i=0;i<nvert;i++)
		{
			System.out.print(arr[i].label+"   ");
		}
		
		System.out.println("");
		for(int i=0;i<nvert;i++)
		{
			System.out.print(arr[i].label+"  ");
			for(int j=0;j<nvert;j++)
			{
				System.out.print(adj_mat[i][j]+"   ");
			}
			System.out.println("");
		}
	}

	void mst()
	{
		Stack s1=new Stack();
                arr[0].display();
                arr[0].is_visited=true;
                s1.push(0);
                while(!s1.isEmpty())
                {
                        int x =s1.peek();
                        int y =get_unvisited_adjver(x);
                        if(y!=-1)
                        {
                                arr[y].display();
				mst_adj[x][y]=1;
                                arr[y].is_visited=true;
                                s1.push(y);
                        }
                        else
                        {
                                s1.pop();
                        }
                }

		
		System.out.print("   ");
                for(int i=0;i<nvert;i++)
                {
                        System.out.print(arr[i].label+"   ");
                }

                System.out.println("");
                for(int i=0;i<nvert;i++)
                {
                        System.out.print(arr[i].label+"  ");
                        for(int j=0;j<nvert;j++)
                        {
                                System.out.print(mst_adj[i][j]+"   ");
                        }
                        System.out.println("");
                }


	}


}

class GraphdfsApp
{
	public static void main(String []args)
	{
		Scanner sc =new Scanner(System.in);
		Graph g=new Graph(5);
		int choice;
		char ch;

		while(true)
		{
			System.out.println("1 - ADD VERTICES");
			System.out.println("2 - ADD EDGE");
			System.out.println("3 - DISPLAY");
			System.out.println("4 - LIST DISPLAY");
			System.out.println("5 - DFS");
			System.out.println("6 - MST");
			System.out.print(":");
			choice=sc.nextInt();
			if(choice==1)
			{
				System.out.print("Enter the Vertex : ");
				ch=sc.next().charAt(0);
				g.addVert(ch);
			}
			else if(choice==2)
			{
				System.out.println("Enter the index:");
				int i=sc.nextInt();
				int j=sc.nextInt();
				g.addEdge(i,j);
			}
			else if(choice==3)
			{
				g.display();
			}
			else if(choice==4)
			{
				g.list_view();
			}
			else if(choice==5)
			{
				g.dfs();
				break;
			}
			else if(choice==6)
			{
				g.mst();
			}
			else if(choice==0)
			{
				break;
			}
			else
			{
			}
		}
	}
}
