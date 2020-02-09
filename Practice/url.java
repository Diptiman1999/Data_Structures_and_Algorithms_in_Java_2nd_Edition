import java.util.Scanner;
class URL
{
	public static void main(String args[])
	{
		Scanner sc=new Scanner(System.in);
		char c;
		System.out.println("Enter the string:");
		c=sc.next().charAt(0);
		System.out.println((int)c);
		System.out.println("-------------------------------------");
		System.out.println("Enter the Number:");
		int n=sc.nextInt();
		String res=((char)(c+n)) + "a";
		System.out.println(res);
		System.out.println((char)(c+n));
	}
	
}