import java.util.*;
class Deque
{
	int arr[];
	int rear;
	int front;
	int maxsize;
	Deque(int size)
	{
		arr=new int[size];
		maxsize=size;
		rear=front=-1;
	}
	boolean isFull()
	{
		return (front ==(rear+1)%maxsize);
	}
	boolean isEmpty()
	{
		return (front==-1);
	}
	// void insertLeft(int x)
	// {
	// 	if(!isFull())
	// 	{
	// 		if (front==-1)
	// 			front=rear=0;
	// 		else
	// 			front=(front-1+maxsize)%maxsize;
	// 		arr[front]=x;
	// 	}
	// 	else
	// 		System.out.println("Array is Full.....");
	// }
	void insertRight(int x)
	{
		if(!isFull())
		{
			if (rear==-1)
				front=rear=0;
			else
				rear=(rear+1)%maxsize;
			arr[rear]=x;
		}
		else
			System.out.println("Array is Full.....");		
	}
	// int removeLeft()
	// {
	// 	int x;
	// 	if(!isEmpty())
	// 	{
	// 		x=arr[front];
	// 		if ( rear==front) {
	// 			rear=front=-1;
	// 		}
	// 		else
	// 			front=(front+1)%maxsize;
	// 		return x;

	// 	}
	// 	else
	// 	{
	// 		System.out.println("Array is is Empty");
	// 		return -1;
	// 	} 
	// }
	int removeRight()
	{
		int x;
		if(!isEmpty())
		{
			x=arr[rear];
			if(rear==front)
				rear=front=-1;
			else
				rear=(rear-1+maxsize)%maxsize;
			return x;
		}
		else
		{
			System.out.println("Array is Empty");
			return -1;
		}
	}
	void display()
	{	
		if(!isEmpty())
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


class Stackx
{
	Deque q;
	Stackx(int size)
	{
		q=new Deque(size);
	}
	void push(int x)
	{
		q.insertRight(x);
	}
	int pop()
	{
		int x=q.removeRight();
		return x;
	}
	void display()
	{
		q.display();
	}

}


class StackApp
{
	public static void main(String args[])
	{
		Scanner sc=new Scanner(System.in);
		Stackx s=new Stackx(5);
		int element;
		while(true)
		{
			System.out.println("MENU DRIVEN");
			System.out.println("1.PUSH");
			System.out.println("2.POP:");
			System.out.println("3.Display:");
			int ch=sc.nextInt();
			switch(ch)
			{
				case 1:
					System.out.println("Enter the Element to be pushed:");
					element=sc.nextInt();
					s.push(element);
				break;
				case 2:
					 element=s.pop();
					 if(element!=-1)
						 System.out.println(element+" is poped");
				break;
				case 3:
					s.display();
				break;
				default:
					System.out.println("Wrong Choice");
			}
		}
	}
}

