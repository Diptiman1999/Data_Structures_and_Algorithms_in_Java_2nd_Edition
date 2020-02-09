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
	SortedLinkedList()
	{
		start=null;
	}
	void insert(int x)
	{
		Node new1=new Node(x);
		Node p=null;
		Node t=start;
		while(t!=null)
		{
			if(new1.getdata()<t.getdata())
				break;
			p=t;
			t=t.next;
		}
		if(p==null)
		{
			new1.next=t;
			start=new1;
		}
		else
		{
			new1.next=t;
			p.next=new1;
		}
	}
	
	void delete()
	{
		if(start!=null)
			start=start.next;
		else
			System.out.println("Linked List is Empty........");
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
class PriorityQueue
{
	SortedLinkedList s;
	PriorityQueue()
	{
		s=new SortedLinkedList();
	}
	void enqueue(int x)
	{
		s.insert(x);
	}
	void dequeue()
	{
		s.delete();
	}
	void display()
	{
		s.display();
	}
}



class PriorityQueueApp
{
	public static void main(String args[])
	{
		Scanner sc=new Scanner(System.in);
		PriorityQueue p=new PriorityQueue();
		p.dequeue();
		p.enqueue(600000);
		p.enqueue(20);
		p.enqueue(10);
		p.enqueue(600);
		p.enqueue(650);
		p.enqueue(6);
		p.enqueue(60);
		p.enqueue(100);
		p.enqueue(60);
		p.display();
		System.out.println("Displaying After deleting");
		p.dequeue();
		p.dequeue();
		p.display();
	}
}
