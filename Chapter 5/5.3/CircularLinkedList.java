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
	SLinkedList()
	{
		current=null;
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
}
class SLinkedListApp
{
	public static void main(String args[])
	{
		SLinkedList sl=new SLinkedList();
		sl.insert(10);
		sl.insert(20);
		sl.insert(30);
		sl.insert(40);
		sl.insert(50);
		sl.insert(60);
		sl.display();
		sl.delete();
		sl.search(10);
		sl.search(30);
		sl.display();
		sl.delete();
		sl.delete();
		sl.search(60);
		sl.delete();
		sl.delete();
		sl.delete();
		sl.delete();
		sl.delete();
		sl.delete();
		sl.delete();
		sl.delete();
		sl.delete();
		sl.search(60);
	}
}
