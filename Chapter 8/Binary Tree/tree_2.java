import java.util.*;

class Node
{
	int data;
	Node left;
	Node right;
	Node(int x)
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
	Tree()
	{
		root=null;
	}
	void insert(int data)
	{
		Node new1=new Node(data);
		if(root==null)
			root=new1;
		else
		{
			Node parent=null,current=root;
			while(true)
			{
				parent =current;
				if(data<current.data)
				{
					current=current.left;
					if(current==null)
					{
						parent.left=new1;
						break;
					}
				}
				else
				{
					current=current.right;
					if(current==null)
					{
						parent.right=new1;
						break;
					}
				}
			}
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
	Node search(int data)
	{
		Node current=root;
		if(current==null)
			System.out.println("No Element is present to be searched in the tree");
		else
		{
			while(data !=current.data)
			{
				if(data<current.data)
					current=current.left;
				else if(data>current.data)
					current=current.right;
				if(current==null)
					break;
			}
			if(current!=null)
				//System.out.println("Element found at index :"+current);
				return current;
		}	
				//System.out.println("Element not found");
				return current;
	}
	void delete(int data)
	{
		Node current=root,parent=null;
		boolean isLeft=false;
		if(current ==null)
			System.out.println("Nothing is left");
		else
		{
			while(data!=current.data)
			{
				parent=current;
				if(data<current.data)
				{
					isLeft=true;
					current=current.left;
				}
				else
				{
					isLeft=false;
					current=current.right;
				}
				if(current==null)
					break;
			}
			if(current!=null)
			{
				if(current.left==null && current.right==null)
				{
					int x=current.data;
					System.out.println(x+" is deleted");
					if(current==root)
						root=null;
					else
					{
						if(isLeft)
							parent.left=null;
						else
							parent.right=null;
					}
				}

			}
			else
				System.out.println("Not found.......");
		}
	}
	void display()
	{
		Stack globalStack=new Stack();
		System.out.println("-----------------------------------------------");
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
			System.out.println("-----------------------------------------------");
		}
	}
}
class TreeApp
{
	public static void main(String args[])
	{
		Scanner sc=new Scanner(System.in);
		int ch,data;
		Tree t=new Tree();
		while(true)
		{
			System.out.println("Tree Representation");
			System.out.println("1.Insert");
			System.out.println("2.Preorder");
			System.out.println("3.Inorder");
			System.out.println("4.Postorder");
			System.out.println("5.Display");
			System.out.println("6.Search");
			System.out.println("7.Delete");
			
			System.out.println("Enter the operation:");
			ch=sc.nextInt();
			switch(ch)
			{
				case 1:
					System.out.println("Enter the data to be entered:");
					int v=sc.nextInt();
					t.insert(v);
				break;
				case 2:
					t.preorder(t.root);
				break;
				case 3:
					t.inorder(t.root);
				break;
				case 4:
					t.postorder(t.root);
				break;
				case 5:
					t.display();
				break;
				case 6:
					System.out.println("Enter the data to be search:");
					data=sc.nextInt();
					Node value=t.search(data);
					System.out.println("Element found at index :"+value);
				break;
				case 7:
					System.out.println("Enter the data to be deleted:");
				 	data=sc.nextInt();
					t.delete(data);
				break ;			
				default:
				break;
			}
		}

	}
}
