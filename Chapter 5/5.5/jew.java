import java.util.*;
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
		System.out.print(data+" ");
	}
}
class SLinkedList
{
	Node current;
	int n;
	SLinkedList()
	{
		current=null;
		n=0;
	}
	void insert(int x)
	{
		Node new1=new Node(x);
		if(current==null)
		{
			current=new1;
			new1.next=current;
		}
		else
		{
			new1.next=current.next;
			current.next=new1;
			current =new1;
		}
		n++;
	}
	void display()
	{
		Node temp=current;
		do
		{
			temp.display();
			temp=temp.next;
		}while(temp!=current);
		System.out.println();
	}
	void delete()
	{
		if (current!=null)
		{
			if(current.next==current)
			{
				System.out.println(current.data+" is deleted");
				current=null;
			}
			else
			{
				System.out.println(current.next.data+" is deleted");
				current.next=current.next.next;
			}
			n--;
		}
		else
			System.out.println("It is Empty");
	}
	
	void step(int count)
	{
		for(int i=1;i<count;i++)
		{
			current=current.next;
		}
	}
	void moving(int first)
	{
		while(current.data!=first)
			current=current.next;
		System.out.println("Current----"+current.data);
	}
}
class Stack
{
	SLinkedList sl;
	Stack()
	{
		sl=new SLinkedList();
	}
	void push(int x)
	{
		sl.insert(x);
	}
	void pop(int count)
	{
		sl.step(count);
		sl.delete();
	}
	void display()
	{
		sl.display();
	}
	void move(int first)
	{
		sl.moving(first);
	}
}
class StackApp
{
	public static void main(String args[])
	{
		Scanner sc=new Scanner (System.in);
		int no,first,count;
		Stack s=new Stack();
		System.out.println("Enter the no of people:");
		no=sc.nextInt();
		for(int i=1;i<=no;i++)
			s.push(i);
		s.display();
		System.out.println("Enter the start position:");
		first=sc.nextInt();
		System.out.println("Enter the counter:");
		count=sc.nextInt();
		System.out.println("Stop");
		s.move(first);
		for(int i=1;i<no;i++)
		{
			s.pop(count);
			s.display();
		}
		s.display();

	}
}