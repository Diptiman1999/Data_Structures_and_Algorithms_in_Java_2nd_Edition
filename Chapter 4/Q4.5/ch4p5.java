import java.util.*;
class CircularQ
{
	int arr[];
	int size,front,rear;
	int nelem;
	CircularQ(int s)
	{
		arr=new int[s];
		size=s;
		front=-1;
		rear=-1;
		nelem=0;
	}
	boolean isFull()
	{
		return front==(rear+1)%size ;
	}
	boolean isEmpty()
	{
		return front==-1;
	}
	void enqueue(int x)
	{
		if(!isFull())
		{
			if(front==-1)
			{
				front=0;
			}
			rear=(rear+1)%size;
			arr[rear]=x;
			nelem++;
		}

	}
	int dequeue()
	{
		int x=-1;
		if(!isEmpty())
		{
			x=arr[front];
			if(front==rear)
			{
				front=-1;
				rear=-1;
			}
			else
				front=(front+1)%size;
			nelem--;
		}
		else
			System.out.println("Queue is Empty.....");
		return x;
	}
	int getLength()
	{
		return nelem;
	}

	void display()
	{
		//System.out.println("the queue is");
		if(!isEmpty())
		{
			if(front<=rear)
			{
				for(int i=front;i<=rear;i++)
					System.out.println(arr[i]+" ");
			}
			else if(front>=rear)
			{
				for(int i=front;i<size;i++)
					System.out.println(arr[i]+" ");
				for(int j=0;j<=rear;j++)
					System.out.println(arr[j]+" ");
			}

		
		}

	}
}
class CheckOut
{
	CircularQ arr[];
	int sz;
	CheckOut(int s)
	{
		sz=s;
		arr=new CircularQ[s];
	}
	void initialise()
	{
		for(int i=0;i<sz;i++)
		{
			arr[i]=new CircularQ(10);
			int x=(int)(Math.ceil(Math.random()*10));
			System.out.println("x value:"+x);
			for(int j=0;j<x;j++)
			{
				arr[i].enqueue((int)(Math.ceil(Math.random()*10)));
			}
		}
	}
	void process()
	{
		Scanner sc=new Scanner(System.in);
		char cust='y';
		int sl=0;
		while(cust=='y')
		{
			int min=arr[0].getLength();
			for(int i=1;i<sz;i++)
			{
				if(min>arr[i].getLength())
				{
					min=arr[i].getLength();
					sl=i;
				}
			}
			arr[sl].enqueue((int)(Math.ceil(Math.random()*10)));
			System.out.println("Customer is successfully entered in Queue no "+(sl+1));

			System.out.println("Proceeding to Checkout");
			System.out.println("The length of the qs are");
			for(int i=0;i<sz;i++)
			{
				int len=arr[i].getLength();
				System.out.println("Lenth of Queue "+(i+1)+" is "+len);
			}

			for(int i=0;i<sz;i++)
			{
				System.out.println("Do you want to Delete from Queue "+(i+1));
				char time=sc.next().charAt(0);
				if(time=='y')
				{
					arr[i].dequeue();
					System.out.println("Deleted From Queue "+(i+1));
				}
			}
			System.out.println("Are u a New Customer?");
			cust=sc.next().charAt(0);
		}

	}
	void display()
	{
		//System.out.println("The elements of the s are");
		for(int i=0;i<sz;i++)
		{
			System.out.println("The elements of the QUEUE "+i+" : ");
			arr[i].display();
		}
	}
}



class CheckOutApp
{
	public static void main(String args[])
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the size of the array of Qs ");
		int n=sc.nextInt();
		CheckOut c1=new CheckOut(n);
		c1.initialise();
		c1.display();
		
		c1.process();
		System.out.println("After Processing");
		c1.display();
	}
}






