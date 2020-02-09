import java.util.*;
class Binary
{
	static int arr[];
	public static void main(String args[])
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the size of the array:");
		int size=sc.nextInt();
		arr=new int[10];
		System.out.println("Enter the element to array:");
		for(int i=0;i<size;i++)
			arr[i]=sc.nextInt();
		System.out.println("Enter the element to be search:");
		int search=sc.nextInt();
		binary_search(search,0,size-1);
	}
	public static void binary_search(int search,int lb,int hb)
	{
		if(lb>hb)
			System.out.println("Element not found.......");
		else{
			int mid=(lb+hb)/2;
			if(arr[mid]==search)
				System.out.println("Element Found at position "+(mid+1));
			else if(arr[mid]>search)
				binary_search(search,lb,mid-1);
			else if(arr[mid]<search) 
				binary_search(search,mid+1,hb);
		}
	}
}
