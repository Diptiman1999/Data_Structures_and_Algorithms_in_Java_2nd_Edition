import java.util.*;
class Hanoi
{
	public static void main(String args[])
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the no of disk:");
		int n=sc.nextInt();
		doTower(n,'A','B','C');
	}
	public static void doTower(int n,char source,char inter,char destination){
		if(n==1)
			System.out.println("Disk 1 from "+source+" to "+destination);
		else
		{
			doTower(n-1,source ,destination,inter);
			System.out.println("Disk " + n +" from " +source  + " to "+ destination);
			doTower(n-1,inter,source,destination);
		}
	}
}

