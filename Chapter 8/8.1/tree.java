import java.util.*;
class Node1
{
	Node data;
	Node1 next;
	Node1(Node d)
	{
		data=d;
		next=null;
	}
}
class Stack
{
	Node1 start;
	Stack()
	{
		start=null;
	}
	boolean isEmpty()
	{
		return(start==null);
	}
	void push(Node t)
	{
		Node1 temp=new Node1(t);
		if(start==null)
			start=temp;
		else
		{
			temp.next=start;
			start=temp;
		}
	}
	Node pop()
	{
		if(start==null)
		{
			System.out.println("Stack is Empty");
			return null;
		}
		else
		{
			Node temp=start.data;
			start=start.next;
			return temp;
		}
	}

}

class Node
{
	char data;
	Node left;
	Node right;
	Node(char x)
	{
		data= x;
		left=right=null;
	}
	void display()
	{
		System.out.println(data);
	}
}
class Tree
{
	Node root;
	Tree(String s)
	{
		root=null;
		int len=s.length();
		if(len>1)
		{
			Node t1=new Node(s.charAt(0));
			Node t2=new Node(s.charAt(1));
			Node t3=new Node('+');
			t3.left=t1;
			t3.right=t2;
			int i=2;
			root=t3;
			while(i<len)
			{
				Node t=new Node('+');
				Node temp=new Node(s.charAt(i));
				t.right=temp;
				t.left=root;
				root=t;
				i++;
			}
		}
		else
		{
			System.out.println("Not valid only one character is entered");
			System.out.println(s.charAt(0));
		}



	}

	void preorder(Node p)
	{
		if(p==null)
		{
			System.out.println("No data");
			return;
		}
		else
		{
			System.out.println(p.data);
			preorder(p.left);
			preorder(p.right);

		}

	}
	void inorder(Node p)
	{
		if(p==null)
		{
			System.out.println("No data");
			return;
		}
		else
		{
			inorder(p.left);
			inorder(p.right);
			System.out.println(p.data);
		}

	}
	void postorder(Node p)
	{
		if(p==null)
		{
			System.out.println("No data");
			return;
		}
		else
		{
			postorder(p.left);
			postorder(p.right);
			System.out.println(p.data);

		}

	}

	Node getSuccessor(Node delNode)
	{
		Node sparent=delNode;
		Node successor=delNode;
		Node current=delNode.right;
		while(current!=null)
		{
			sparent=successor;
			successor=current;
			current=current.left;
		}
		if(successor !=delNode.right)
		{
			sparent.left=successor.right;
			successor.right=delNode.right;
		}
		return successor;
	}

	void display()
	{
		Stack globalStack=new Stack();
		System.out.println("---------------------------------------------------------------------------------------------");
		int nblank=32;
		boolean isRowEmpty=false;
		globalStack.push(root);
		while(isRowEmpty==false)
		{
			Stack localStack=new Stack();
			isRowEmpty=true;
			for(int i=0;i<nblank;i++)
				System.out.print(" ");
			while(globalStack.isEmpty()==false)
			{
				Node temp=(Node)globalStack.pop();
				if(temp!=null)
				{
					System.out.print(temp.data);
					localStack.push(temp.left);
					localStack.push(temp.right);
					if(temp.left!=null||temp.right!=null)
						isRowEmpty=false;
				}
				else
				{
					System.out.print("..");
					localStack.push(null);
					localStack.push(null);
				}
				for(int j=0;j<nblank*2-2;j++)
					System.out.print(' ');
			}
			System.out.println();
			nblank/=2;
			while (localStack.isEmpty()==false)
				globalStack.push(localStack.pop());
			System.out.println("----------------------------------------------------------------------");
		}
	}
}
class TreeApp
{
	public static void main(String args[])
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter thje string:");
		String s=sc.nextLine();
		Tree t=new Tree(s);
		t.display();
	}
}
