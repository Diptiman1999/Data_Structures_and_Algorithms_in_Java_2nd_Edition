import java .util.*;
class Stack
{
		char arr[];
		int size;
		int top;
		Stack(int s)
		{
				arr=new char[s];
				top=-1;
				size=s;
		}
		boolean isFull()
		{
				return (top==size);
		}
		boolean isEmpty()
		{
				return (top==-1);
		}
		void push(char x)
		{
				if(!isFull())
				{
						arr[++top]=x;
				}
				else
				{
						System.out.println("Stack is Full....");
				}
		}
		char pop()
		{
				if(!isFull())
				{
						char x=arr[top];
						top--;
						return x;
				}
				else
				{
						System.out.println("Stack is empty.....");
						return '1';
				}
		}
		int peek()
		{	if(!isEmpty())
				return arr[top];
			else
					return '1';
		}

}
class InfixToPostfix
{
		String infix;
		InfixToPostfix(String str)
		{
				infix=str;
		}
		int precedence(char op)
		{
				if(op=='+'||op=='-')
						return 1;
				else
						return 2;
		}
		void doConversion()
		{
				String output="";
				int x=infix.length();
				Stack s1=new Stack(x);
				for(int i=0;i<x;i++)
				{
						char ch=infix.charAt(i);
						if (ch=='(')
								s1.push(ch);
						else if((ch=='+')||(ch=='-')||(ch=='*')||(ch=='/')||(ch=='%'))
						{
								if(s1.isEmpty())
										s1.push(ch);
						

								else
								{
										while(!s1.isEmpty())
										{
												char ch1=s1.pop();
												if(ch1=='(')
												{
														s1.push(ch1);
														break;
												}
												else if(precedence(ch1)>=precedence(ch))
												{
														output+=ch1;
												}
												else
												{
														s1.push(ch1);
														break;
												}
										}
										s1.push(ch);
								}
						}
						else if(ch==')')
						{
								while(!s1.isEmpty())
								{
										char ch1=s1.pop();
										if(ch1=='(')
												break;
										output+=ch1;
								}
						}
						else
								output+=ch;

				}
				while(!s1.isEmpty())
				{
						output+=s1.pop();
				}
				System.out.println("Infixfix: "+infix);
				System.out.println("Postfix: "+output);

		}
}
class InfixToPostfixApp
{
		public static void main(String args[])
		{
				Scanner sc=new Scanner(System.in);
				InfixToPostfix input=new InfixToPostfix(sc.next());
				input.doConversion();
		}
}
