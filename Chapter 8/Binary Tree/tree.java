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
			System.out.println(p.data);
			inorder(p.right);
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
	void delete(int data)
	{
		Node current=root,parent=null;
		boolean isLeft=false;
		if(current ==null)
			System.out.println("Nothing is There to be Deleted...............");
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
				//When the delete node is leaf
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
				//For node having one child i.e. right child
				else if(current.left==null)
				{
					int x=current.data;
					System.out.println(x+" is deleted");
					if(current==root)
						root=current.right;
					else if(isLeft)
						parent.left=current.right;
					else
						parent.right=current.right;
				}
				//For node having one child i.e. left child
				else if(current.right==null)
				{
					int x=current.data;
					System.out.println(x+" is deleted");
					if(current==root)
						root=current.left;
					else if(isLeft)
						parent.left=current.left;
					else
						parent.right=current.left;
				}
				else
				{
					int x=current.data;
					System.out.println(x+" is deleted");

					Node successor=getSuccessor(current);
					if(current==root)
					{
						root=successor;
					}
					else
					{
						if(isLeft)
							parent.left=successor;
						else
							parent.right=successor;
					}
					successor.left=current.left;
				}



			}
			else
				System.out.println("Not found.......");
		}
	}
	int maximum()
	{	
		Node current=root;
		if(current!=null)
		{
			int data=current.data;
			current=current.right;
			while(current!=null)
			{
				if(data<current.data)
					data=current.data;
				current=current.right;
			}
			return data;
		}
		else
			return -1;
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
			System.out.println("5.Search");
			System.out.println("6.Delete");
			System.out.println("7.Maximum");
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
					System.out.println("Enter the data to be search:");
					data=sc.nextInt();
					Node value=t.search(data);
					System.out.println("Element found at index :"+value);
				break;
				case 6:
					System.out.println("Enter the data to be deleted:");
				 	data=sc.nextInt();
					t.delete(data);
				break ;
				case 7:
					v=t.maximum();
					if(v!=-1)
						System.out.println("Maximum value :"+v);
					else
						System.out.println("No Element is present");
				default:
				break;
			}
		}

	}
}
