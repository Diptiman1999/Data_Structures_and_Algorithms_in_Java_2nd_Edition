import java .util.*;
class Queue
{
	int arr[];
	int front;
	int rear;
	int maxsize;
	Queue(int s)
	{
		arr=new int[s];
		front=rear=-1;
		maxsize=s;
	}
	boolean isFull()
	{
		return (rear==maxsize-1);
	}
	boolean isEmpty()
	{
		return (front==-1);
	}
	void insert(int x)
	{
		if(!isFull())
		{
			if(front==-1)
				front=0;
			rear++;
			arr[rear]=x;
		}
		else
		{
			System.out.println("Queue is full.....");
		}
	}
	int dequeue()
	{
		int x=-1;
		if(!isEmpty())
		{
			x=arr[front];
			if(front==rear)
				front=rear=-1;//when there is only one element
			else
				front++;

		}
		else
			System.out.println("Queue is Already Empty.........");
		return x;
	}
	void display()
	{	if(!isEmpty())
		{
			System.out.println("Displaying the Contents....");
			for (int i=front;i<=rear;i++)
				System.out.print(arr[i]+" ");
			System.out.println();
		}
		else
			System.out.println("Queue is Empty");
	}

}
class QueueApp
{
	public static void main(String args[])
	{
		Scanner sc=new Scanner(System.in);
		Queue q=new Queue(10);
		int element;
		while(true)
		{
			System.out.println("MENU DRIVEN");
			System.out.println("1.Enqueue");
			System.out.println("2.Dequeue");
			System.out.println("3.Display");
			System.out.println("Choice:");
			int ch=sc.nextInt();
			switch(ch)
			{
				case 1:
					System.out.println("Enter the Element:");
					element=sc.nextInt();
					q.insert(element);
				break;
				case 2:
					 element=q.dequeue();
					 if(element!=-1)
						 System.out.println(element+" is Deleted");
				break;
				case 3:
					q.display();
				break;
				default:
					System.out.println("Wrong Choice");
			}
		}
	}
}
