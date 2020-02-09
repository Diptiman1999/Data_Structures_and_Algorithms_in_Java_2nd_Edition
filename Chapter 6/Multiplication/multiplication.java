import java .util.*;
class Multiplication
{
	public static void main(String args[])
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the two number:");
		int a=sc.nextInt();
		int b=sc.nextInt();
		int product=mul(a,b);
		System.out.println("Multiplication of "+a+" * "+b+" = "+product);
	}
	public static int mul(int a,int b)
	{
		if(a==0||b==0)
			return 0;
		if(b==1)
			return a;
		else
			return	mul(a,b-1)+a;
	}
}
