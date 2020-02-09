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

class SortedLinkedListApp
{
	public static void main(String args[])
	{
		Scanner sc=new Scanner(System.in);
		SortedLinkedList s=new SortedLinkedList();
		s.deleteFirst();
		s.insertEnd(600000);
		s.insertFirst(20);
		s.insertFirst(10);
		s.insertEnd(600);
		s.insertFirst(650);
		s.insertFirst(100);
		s.insertEnd(60);
		s.display();
		System.out.println("Displaying After deleting");
		s.deleteFirst();
		s.deleteFirst();
		s.display();
	}
}
