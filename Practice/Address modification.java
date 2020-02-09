import java .util.*;
class check
{
	public static void main(String args[])
	{
		Scanner sc =new Scanner (System.in);
		int arr[]=new int[10];
		for(int i=0;i<10;i++)
			arr[i]=i;
		int x=10;
		String y="ABCD";
		System.out.println("Printing the array before passing");
		for(int i=0;i<10;i++)
			System.out.println(arr[i]+" "+x+" "+y);

		change(arr,x,y);
		System.out.println("Printing the array after passing");
		for(int i=0;i<10;i++)
			System.out.println(arr[i]+" "+x+" "+y);		
		
	}
	public static void change(int a[],int x,String y)
	{
		for (int i=0;i<10 ;i++ ) {
			a[i]=a[i]+1;
		}
		x++;
		y="YYYYYYY";
		System.out.println("Printing the array in method");
		for(int i=0;i<10;i++)
			System.out.println(a[i]+" "+x+" "+y);			
	}
}