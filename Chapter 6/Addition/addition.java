import java .util.*;
class Addition
{
	public static void main(String args[])
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the two number:");
		int a=sc.nextInt();
		int b=sc.nextInt();
		int sum=add(a,b);
		System.out.println("Addition of "+a+" + "+b+" = "+sum);
	}
	public static int add(int a,int b)
	{
		if(b==0)
			return a;
		else
			return	add(a+1,b-1);
	}
}
