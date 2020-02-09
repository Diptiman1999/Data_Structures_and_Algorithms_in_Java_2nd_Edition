import java.util.*;
class PowerInt
{
	public static void main (String args[])
	{
		Scanner sc=new Scanner(System.in);
		int a,b;
		System.out.println("Enter the NUMBER:");
		a=sc.nextInt();
		System.out.println("power to:");
		b=sc.nextInt();		
		int value=power(a,b);
		System.out.println("The value of "+a+" is "+value);
	}
	public static int power(int a,int b)
	{
		if(b==0)
			return 1;
		else
			return a*power(a,b-1);

	}
}
