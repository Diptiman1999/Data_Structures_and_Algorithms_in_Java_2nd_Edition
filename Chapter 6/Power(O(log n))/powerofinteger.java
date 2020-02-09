import java.util.*;
class PowerInteger
{
	public static void main(String args[])
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the number :");
		int a=sc.nextInt();
		System.out.println("Enter the power :");
		int p=sc.nextInt();
		System.out.println(a+" ^ "+p+" = "+power(a,p));
	}
	public static int power(int x,int p)
	{
		if(p==0)
			return 1;
		else
			if(p%2==0)
				return (power(x*x,p/2));
			else
				return x*(power(x*x,p/2));
	}
}