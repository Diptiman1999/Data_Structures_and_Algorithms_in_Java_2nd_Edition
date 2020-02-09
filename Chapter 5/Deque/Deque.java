import java.util.*;
class Node
{
		Node prev;
		int data;
		Node next;
		Node(int x)
		{
				data=x;
				prev=null;
				next=null;
		}
		void display()
		{
				System.out.print(data+" ");
		}
}
class DLinkedList
{
		Node start;
		Node end;
		DLinkedList()
		{
				start=null;
				end=null;
		}
		void insertFirst(int x)
		{
				Node new1=new Node(x);
				new1.next=start;
				if(start!=null)
				{
					start.prev=new1;
				}
				else
					end=new1;
				start=new1;
				

		}
		void deleteFirst()
		{
				if(start!=null)
				{
						System.out.println(start.data+" is deleted");
						if(start.next==null)
							start=end=null;
						else
						{
							start=start.next;
							start.prev=null;
						}
				}
				else
						System.out.println("It is Empty....");
		}
		void insertEnd(int x)
		{
				Node new1=new Node(x);
				if(start==null)
						start=end=new1;
				else
				{
						end.next=new1;
						new1.prev=end;
						end=new1;
				}
		}
		void deleteEnd()
		{
				if(start!=null)
				{
						if(start.next==null)
						{
								System.out.println(start.data+" is Deleted ");
								start=null;
						}
						else
						{
							if(start.next==null)
							{
								System.out.println(start.data+" is Deleted");
								start=end=null;
							}
							else
							{
								System.out.println(end.data+" is Deleted");
								end.prev.next=null;
								end=end.prev;
							}
						}

				}
				else
					System.out.println("it is Empty....");

		}
		void display()
		{
				Node temp=start;
				if(temp==null)
					System.out.println("it is Empty....");
				else
				{
					while(temp!=null){
						temp.display();
						temp=temp.next;
					}
					System.out.println();
				}
		}
}
class Deque
{
	DLinkedList dl;
	Deque()
	{
		dl=new DLinkedList();
	}
	void insertLeft(int x)
	{
		dl.insertFirst(x);
	}
	void insertRight(int x)
	{
		dl.insertEnd(x);
	}
	void deleteLeft()
	{
		dl.deleteFirst();
	}
	void deleteRight()
	{
		dl.deleteEnd();
	}
	void display()
	{
		dl.display();
	}

}
class DequeApp
{
		public static void main(String args[])
		{
			Scanner sc=new Scanner(System.in);
			Deque d=new Deque();
			int element;
			while(true)
			{
				System.out.println("MENU DRIVEN");
				System.out.println("1.InsertLeft");
				System.out.println("2.InsertRight");
				System.out.println("3.DeleteLeft");
				System.out.println("4.DeleteRight");
				System.out.println("5.Display");
				System.out.println("Choice:");
				int ch=sc.nextInt();
				switch(ch)
				{
					case 1:
						System.out.println("Enter the Element:");
						element=sc.nextInt();
						d.insertLeft(element);
					break;
					case 2:
						System.out.println("Enter the Element:");
						element=sc.nextInt();
						d.insertRight(element);				 
					break;
					case 3:
						d.deleteLeft();				 
					break;
					case 4:
						d.deleteRight();				 
					break;	
					case 5:
						d.display();
					break;
					default:
						System.out.println("Wrong Choice");
				}
			}

		}
}
