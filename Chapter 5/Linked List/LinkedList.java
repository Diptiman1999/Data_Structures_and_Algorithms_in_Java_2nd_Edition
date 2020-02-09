import java.util.*;
class Node
{
	private int data;
	Node next;
	Node(int x)
	{
		data=x;
		next=null;
		//System.out.println("next address "+next);
	}
	int getdata()
	{
		return data; 
	}
	void display()
	{
		System.out.print(data+" ");
	}
}
class LL
{
	Node first;
	LL()
	{
		first =null;
	}
	void insertFirst(int x)
	{
		Node new1=new Node(x);
		new1.next=first;
		first=new1;
		//System.out.println("first address"+first);
	}
	void deleteFirst()
	{
		if(first!=null)
		{
			int x=first.getdata();
			System.out.println(x+" is Deleted");
			first=first.next;
		}
		else
			System.out.println("List is Empty");
	}
	void display()
	{
		System.out.println("Count----"+count());
		if(first!=null)
		{
			Node t=first;
			while(t!=null)
			{
				t.display();
				t=t.next;
			}
			System.out.println();
		}
		else
			System.out.println("list is empty");
	}
	int count()
	{
		int no=0;
		Node q=first;
		while(q!=null)
		{
			no++;
			q=q.next;
		}
		return no;
	}	
	void search(int x)
	{
		int i=0,j=-1;
		if(first!=null)
		{
			Node t=first;
			while(t!=null)
			{
				if(x==t.getdata())
				{
					System.out.println("Element found at index :"+(i+1));
					j++;
				}
				t=t.next;
				i++;
			}
			if(j==-1)
				System.out.println("Element is not present");
		}
		else
			System.out.println("List is empty.....");
	}
	void insertatAny(int data,int pos)
	{
		Node new1=new Node(data);
		int i=1;
		Node temp=first;
		Node p=null;
		int number=count();
		System.out.println("Number---------------"+number);
		while(i<pos&&temp!=null)
		{
			p=temp;
			temp=temp.next;
			i++;
		}	
		if(temp==null)
			System.out.println("Not a valid position");
		else
		{
			if(pos==1)
			{
				new1.next=first;
				first=new1;
			}
			else
			{
				new1.next=temp;
				p.next=new1;
			}
		}
	}
	void insertAtEnd(int x)
	{
		Node new1=new Node(x);
		Node temp=first;
		if(first==null)
		{
			first=new1;	
		}
		else
		{
			while(temp.next!=null)
				temp=temp.next;
			temp.next=new1;

		}
	}
}
class LinkedListApp
{
	public static void main(String args[])
	{
		Scanner sc=new Scanner(System.in);
		int value,pos;
		LL l1=new LL();
		while(true)
		{
			System.out.println("Menu Driven:");
			System.out.println("1.Insert at First");
			System.out.println("2.Insert at any position");
			System.out.println("3.Insert at End");
			System.out.println("4.Delete from First");
			System.out.println("5.Display");
			System.out.println("Enter your choice:");
			int ch=sc.nextInt();
			switch(ch)
			{
				case 1:
					System.out.println("Enter the value to be inserted:");
					value=sc.nextInt();
					l1.insertFirst(value);
					System.out.println("number---------"+l1.count());
				break;
				case 2:
					System.out.println("Enter the position:");
					pos=sc.nextInt();			
					System.out.println("Enter the value to be inserted:");
					value=sc.nextInt();
					l1.insertatAny(value,pos);
				break;
				case 3:
					System.out.println("Enter the value to be inserted:");
					value=sc.nextInt();	
					l1.insertAtEnd(value);
				break;
				case 4:
					l1.deleteFirst();
				break;
				case 5:
					l1.display();
				break;
				default:
					System.out.println("Wrong Choice");
			}
		}
	}
}
