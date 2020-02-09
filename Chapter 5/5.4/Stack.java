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
	void search(int x)
	{
		Node temp=current;
		int flag=0;
		if(current!=null)
		{
			do
			{
				if(x==temp.data)
				{
				//	System.out.println("Element "+x+" is Found");
					flag++;
					break;
				}
				temp=temp.next;
			}while(temp!=current);
			if(flag==0)
				System.out.println("Element "+x+" is not Found");
			else
				System.out.println("Element "+x+" is Found");
		}
		else
			System.out.println("No Element is present to search");
	}	
	void step()
	{
		for(int i=1;i<n;i++)
		{
			current=current.next;
		}
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
	void pop()
	{
		sl.step();
		sl.delete();
	}
	void display()
	{
		sl.display();
	}

}
class StackApp
{
	public static void main(String args[])
	{
		Stack s=new Stack();
		s.push(10);
		s.push(20);
		s.push(30);
		s.push(40);
		s.push(50);
		s.push(60);
		s.push(70);
		s.push(80);
		s.push(90);
		s.display();
		s.pop();
		s.pop();
		s.pop();
		s.display();
		s.push(1);
		s.display();
		s.pop();
		s.display();
	}
}
