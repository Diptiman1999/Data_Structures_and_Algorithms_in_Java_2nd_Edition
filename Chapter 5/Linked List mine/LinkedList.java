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
		if(pos==1)
			insertFirst(data);
		else if(pos<=count())
		{	
			while(i<pos&&temp!=null)
			{
				p=temp;
				temp=temp.next;
				i++;
			}	
				new1.next=temp;
				p.next=new1;

		}
		else if(pos==(count()+1))
			insertAtEnd(data);
		else
			System.out.println("Not a valid position");

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
	void deleteEnd()
	{
		if(first!=null)
		{
			if(first.next==null)
			{	
				int x=first.getdata();
				System.out.println(x+" is deleted");
				first=null;
			}
			else 
			{
				Node temp=first;
				Node p=null;
				while(temp.next!=null)
				{	
					//x=temp.getdata();
					p=temp;
					temp=temp.next;
				}
				int x=temp.getdata();
				p.next=null;
				System.out.println(x+" is deleted");
			}
		}
		else
			System.out.println("list is Empty");
	}
	void deleteAtAny(int pos)
	{
		int i=1;
		Node temp=first;
		Node p=null;
		int number=count();
		System.out.println("Number---------------"+number);
		if(pos==1)
			deleteFirst();
		else if(pos<count())
		{	
			while(i<pos&&temp!=null)
			{
				p=temp;
				temp=temp.next;
				i++;
			}	
				System.out.println(temp.getdata()+" is deleted");
				p.next=temp.next;

		}
		else if(pos==count())
			deleteEnd();
		else
			System.out.println("Not a valid position");

	}

	Node traverse(int x)
	{
		//System.out.println(x);
		Node q=first;
		int i=0;
		while(i<x)
		{	
			i++;
			q=q.next;
		}
		return q;
	
	}

	void sorting()
	{
		Node prev,current,after;
		int out,i;
		if(first!=null)
		{
			int n=0;
			Node p=first;
			while(p!=null)
			{
				n++;
				p=p.next;
			}
			// System.out.println(n);
			// Node q=traverse(0);
			// System.out.println("From Traverse:"+q.data);
			for(out=n-1;out>0;out--)
			{
				for(i=0;i<out;i++)
				{
					if((i==0) && (traverse(i).getdata()>traverse(i+1).getdata()))
					{
						current=traverse(i);
						after=traverse(i+1);
						current.next=after.next;
						after.next=current;
						first=after;
					}
					else if(traverse(i).getdata()>traverse(i+1).getdata()){
						prev=traverse(i-1);
						// System.out.println("Prev value "+prev.data);
						current=traverse(i);
						after=traverse(i+1);
						current.next=after.next;
						after.next=current;
						prev.next=after;
					}
				}
			}

		}
		else
			System.out.println("list is Empty...");

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
			System.out.println("5.Delete at any position");
			System.out.println("6.Delete at End");
			System.out.println("7.Sorting");
			System.out.println("8.Search");
			System.out.println("9.Display");
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
					System.out.println("Enter the position:");
					pos=sc.nextInt();
					l1.deleteAtAny(pos);
				break;
				case 6:
					l1.deleteEnd();
				break;

				case 7:
					l1.sorting();
				break;
				case 8:
					System.out.println("Enter the value to be search:");
					value=sc.nextInt();				
					l1.search(value);	
								
				case 9:
					l1.display();
				break;
				default:
					System.out.println("Wrong Choice");
			}
		}
	}
}
