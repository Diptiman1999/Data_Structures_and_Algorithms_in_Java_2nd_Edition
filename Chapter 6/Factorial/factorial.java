import java.util.*;
class Factorial
{
		static int fact(int n)
		{
				if (n==0)
						return 1;
				else
						return(n*fact(n-1));

		}

		public static void main(String args[])
		{
				Scanner sc=new Scanner(System.in);
				System.out.println("Enter the number:");
				int v=sc.nextInt();
				System.out.println("factorial of "+v+" is "+fact(v) );
		}
}
