import java .util.*;
class Deque
{
	int arr[];
	int front;
	int rear;
	int maxsize;
	Deque(int s)
	{
		arr=new int[s];
		front=rear=-1;
		maxsize=s;
	}
	boolean isFull()
	{
		return (front==(rear+1)%maxsize);
	}
	boolean isEmpty()
	{
		return (front==-1);
	}
	void insertLeft(int x)
	{
			if(!isFull())
			{
					if(front==-1)
							rear=front=0;
					else
							front=(front-1+maxsize)%maxsize;
					arr[front]=x;

			}
			else
					System.out.println("Deque is Full........");
	}
	void insertRight(int x)
	{
			if(!isFull())
			{
					if(rear==-1)
							rear=front=0;
					else
							rear=(rear+1)%maxsize;;
					arr[rear]=x;
			}
			else
					System.out.println("Deque is Full........");
	}
	int removeLeft()
	{
		int x=-1;
		if(!isEmpty())
		{
			x=arr[front];
			if(front==rear)
				front=rear=-1;
			else 
				front=(front+1)%maxsize;
		}
		else
			System.out.println("Queue is Already Empty.........");
		return x;
	}
	int removeRight()
	{
		int x=-1;
		if(!isEmpty())
		{
			x=arr[front];
			if(front==rear)
				front=rear=-1;
			else 
				rear=(rear-1+maxsize)%maxsize;
		}
		else
			System.out.println("Queue is Already Empty.........");
		return x;
	}

	void display()
	{	if(!isEmpty())
		{	
			System.out.println("Displaying the Contents....");
			if(front<=rear)
			{
				for (int i=front;i<=rear;i++)
					System.out.print(arr[i]+" ");
				System.out.println();
			}
			else
			{	
				for(int i=front;i<maxsize;i++)
					System.out.print(arr[i]+" ");
				for (int i=0;i<=rear;i++)
					System.out.print(arr[i]+" ");
				System.out.println();
			}
		}
		else
			System.out.println("Queue is Empty");
	}

}
class DequeApp
{
	public static void main(String args[])
	{
		Scanner sc=new Scanner(System.in);
		Deque q=new Deque(5);
		int element;
		while(true)
		{
			System.out.println("MENU DRIVEN");
			System.out.println("1.InsertLeft");
			System.out.println("2.InsertRight");
			System.out.println("3.RemoveLeft");
			System.out.println("4.RemoveRight:");
			System.out.println("5.Display:");
			int ch=sc.nextInt();
			switch(ch)
			{
				case 1:
					System.out.println("Enter the Element to be inserted in Left:");
					element=sc.nextInt();
					q.insertLeft(element);
				break;
				case 2:
					System.out.println("Enter the Element to be inserted in right:");
					element=sc.nextInt();
					q.insertRight(element);
				break;
							
				case 3:
					 element=q.removeLeft();
					 if(element!=-1)
						 System.out.println(element+" is Deleted from Left");
				break;
				case 4:
					 element=q.removeRight();
					 if(element!=-1)
						 System.out.println(element+" is Deleted from Right");
				break;
				case 5:
					q.display();
				break;
				default:
					System.out.println("Wrong Choice");
			}
		}
	}
}
