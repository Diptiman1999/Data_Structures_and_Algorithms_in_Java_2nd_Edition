import java.util.*;
class Triangular
{
		static int trian(int n)
		{
			 	if (n==1)
						return 1;
				else
						return(n+trian(n-1));

		}

		public static void main(String args[])
		{
				Scanner sc=new Scanner(System.in);
				System.out.println("Enter the number:");
				int v=sc.nextInt();
				System.out.println("Triangular of "+v+" is "+trian(v) );
		}
}
