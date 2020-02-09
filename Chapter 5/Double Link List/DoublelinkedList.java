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
				System.out.println(data+" ");
		}
}
class DLinkedList
{
		Node start;
		DLinkedList()
		{
				start=null;
		}
		void insertFirst(int x)
		{
				Node new1=new Node(x);
				new1.next=start;
				if(start!=null)
					start.prev=new1;
				start=new1;
		}
		void deleteFirst()
		{
				if(start!=null)
				{
						System.out.println(start.data+" is deleted");
						start=start.next;
						start.prev=null;
				}
				else
						System.out.println("It is Empty....");
		}
		void insertEnd(int x)
		{
				Node new1=new Node(x);
				if(start==null)
						start=new1;
				else
				{
						Node temp=start;
						while(temp.next!=null)
							temp=temp.next;
						temp.next=new1;
						new1.prev=temp;
						
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
								Node temp=start;
								while(temp.next!=null)
								{
										temp=temp.next;
								}
								temp.prev.next=null;
								System.out.println(temp.data+" is Deleted ");

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
					Node p=null;
					while(temp!=null){
						p=temp;
						temp.display();
						temp=temp.next;
					}
					while(p!=null)
					{
							p.display();
							p=p.prev;
					}
				}
		}
}
class DLinkedListApp
{
		public static void main(String args[])
		{
			DLinkedList d=new DLinkedList();
			d.insertFirst(50);
			d.insertFirst(40);
			d.insertFirst(30);
			d.insertFirst(20);
			d.insertFirst(10);
			d.insertEnd(60);
			d.insertEnd(70);
			d.insertEnd(80);
			d.insertEnd(90);
			d.insertEnd(100);
			d.deleteEnd();
			d.deleteEnd();
			d.deleteEnd();
			d.deleteEnd();
			d.deleteEnd();
			d.deleteFirst();
			d.display();
		}
}
