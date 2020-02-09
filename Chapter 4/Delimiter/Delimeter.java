import java.util.Scanner;
class Stack
{
	char arr[];
	int top;
	int size;
	Stack(int s)
	{
		arr=new char[s];
		top=-1;
		size=s;
	}
	boolean isFull()
	{
		return(top==size-1);
	}

	boolean isEmpty()
	{
		return(top==-1);
	}
	void push(char s)
	{
		if(!isFull())
			arr[++top]=s;
		else
			System.out.println("Stack is Full.....");
	}
	char pop()
	{
		if (!isEmpty()){
			char x=arr[top];
			top--;
			return x ;
		}
		else{
			System.out.println("Stack is Empty.....................");
			return '1';
		}
	}

	void fun(String s)
	{
		int len=s.length();
		for(int i=0;i<len;i++)
		{
			char ch=s.charAt(i);
			if(ch=='('||ch=='{'||ch=='[')
				push(ch);
			else if(ch==')'||ch=='}'||ch==']')
			{
				if(isEmpty())
					System.out.println("No Matching Found..");
				else
				{
					char ch1=pop();
					if((ch==')'&&ch1!='(')||(ch=='}'&&ch1!='{')||(ch==']'&&ch1!='['))
						System.out.println("Error at index :"+i);
				}
			}
		}
		if(!isEmpty())
			System.out.println("Error in The closing bracket");
	
	}

}
class StackFun
{
	public static void main(String[] args) {
		Scanner sc =new Scanner(System.in);
		Stack s=new Stack(20);
		String str;
		System.out.println("Enter the String:");
		str=sc.next();
		s.fun(str);
		System.out.println("Entered String :"+str);

	}
}
