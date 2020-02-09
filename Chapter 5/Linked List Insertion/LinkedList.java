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
			System.out.println("linked List is Empty.... ");
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
class LinkedListApp
{
	public static void main(String args[])
	{
		Scanner sc=new Scanner(System.in);
		SortedLinkedList s=new SortedLinkedList();
		s.insert(600000);
		s.insert(20);
		s.insert(10);
		s.insert(600);
		s.insert(650);
		s.insert(6);
		s.insert(60);
		s.insert(100);
		s.insert(60);
		s.display();
		System.out.println("Displaying After deleting");
		s.delete();
		s.delete();
		s.display();
	}
}
