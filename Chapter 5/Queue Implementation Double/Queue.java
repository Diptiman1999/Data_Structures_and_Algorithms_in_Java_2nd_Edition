import java.util.*;
class Node
{
	private int data;
	Node next;
	Node(int x)
	{
		data=x;
		next=null;
	}
	int getdata()
	{
		return data;
	}
	void display()
	{
		System.out.println(data+" ");
	}
}
class SortedLinkedList
{
	Node start;
	Node end;
	SortedLinkedList()
	{
		start=null;
		end=null;
	}

	void insertFirst(int x)
	{
		Node new1=new Node(x);
		if(start==null)
			end=new1;
		new1.next=start;
		start=new1;
	}
	void insertEnd(int x)
	{
		Node new1=new Node(x);
		if(start==null)
			start=new1;
		else
			end.next=new1;
		end=new1;
	}
	void deleteFirst()
	{
		if(start!=null)
		{
			System.out.println(start.getdata()+" is Deleted");
			if(start.next==null)
				end=null;
			start=start.next;
		}
		else
			System.out.println("List is Empty.....");
	}
	void display()
	{
		Node t=start;
		while(t!=null)
		{
			t.display();
			t=t.next;
		}
	}
	
}

class Queue
{
	SortedLinkedList l;
	Queue()
	{
		l=new SortedLinkedList();
	}
	void enqueue(int x)
	{
		l.insertEnd(x);
	}
	void dequeue()
	{
		l.deleteFirst();
	}
	void display()
	{
		l.display();
	}
}
class SortedLinkedListApp
{
	public static void main(String args[])
	{
		Scanner sc=new Scanner(System.in);
		Queue q=new Queue();
		q.enqueue(10);
		q.enqueue(20);
		q.enqueue(50);
		q.enqueue(25);
		q.enqueue(62);
		q.enqueue(66);
		System.out.println("Displaying the Contents:");
		q.display();
		q.dequeue();
		q.dequeue();
		q.dequeue();
		q.dequeue();
		System.out.println("Displaying the Contents After deleteing:");
		q.display();
		q.dequeue();
		q.dequeue();
		q.dequeue();
		q.dequeue();
		//System.out.println("Displaying the Contents After deleteing:");
		q.display();
		q.display();
	}
}
