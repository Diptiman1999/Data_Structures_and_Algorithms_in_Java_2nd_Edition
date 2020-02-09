class Node
{
	int data;
	Node next;
	Node(int x)
	{
		data=x;
		next=null;
	}
	void display()
	{
		System.out.println(data);
	}
}
class LinkedList
{
	Node first;
	LinkedList()
	{
		first=null;
	}
	void insertFirst(int x)
	{
		Node p=new Node(x);
		p.next=first;
		first=p;
	}
	void deleteFirst()
	{
		if(first!=null)
		{
			int x=first.data;
			first=first=first.next;
			System.out.println(x+" is deleted");
		}
		else
			System.out.println("list is Empty...");
	}
	void display()
	{
		if(first!=null)
		{
			Node p=first;
			while(p!=null)
			{
				System.out.println(p.data);
				p=p.next;
			}
		}
		else
			System.out.println("list is Empty...");
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
					if((i==0) && (traverse(i).data>traverse(i+1).data))
					{
						current=traverse(i);
						after=traverse(i+1);
						current.next=after.next;
						after.next=current;
						first=after;
					}
					else if(traverse(i).data>traverse(i+1).data){
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
		LinkedList l1=new LinkedList();
		l1.insertFirst(22);
		l1.insertFirst(20);
		l1.insertFirst(20);
		l1.insertFirst(10);
		l1.insertFirst(220);
		l1.insertFirst(40000);
		l1.display();
		System.out.println("Displaying over after sorting");
		l1.sorting();
		System.out.println("Displaying the contents of Linked List ");
		l1.display();
		System.out.println("Displaying over");
		// l1.deleteFirst();
		// l1.deleteFirst();
		// l1.deleteFirst();
		// l1.deleteFirst();
		// l1.deleteFirst();
		// System.out.println("After deleting....");
		// l1.display();
	}
}