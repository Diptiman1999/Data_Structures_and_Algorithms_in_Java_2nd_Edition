import java.util.*;
class Array
{
	String arr[];
	int nelem;
	Array(int size)
	{
		arr=new String[size];
		nelem=size;
	}
	void insert()
	{
		for(int i=0;i<nelem;i++)
			arr[i]="";
	}
	void display()
	{
		for(int i=0;i<nelem;i++)
		System.out.println(arr[i]);
	}
	void makebranch(int left,int right,int row)
	{
		
		int l=left;
		int r=right;
		if(left==right)
		{
			arr[row]+='X';
			return;
		}
		else
		{
			int mid=(left+right)/2;
			while(l<=r)
			{
				if(mid==l)
					arr[row]+='X';
				else
					arr[row]+='-';
				l++;
			}
			row++;
			makebranch(left,mid,row);
			makebranch(mid+1,right,row);
		}
	}
}
class ArrayApp
{
	public static void main(String args[])
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the row size:");
		int row=sc.nextInt();
		int numRows=(int)(Math.log(row)/Math.log(2))+1;
		Array a1=new Array(numRows);
		a1.insert();
		a1.makebranch(0,row-1,0);		
		a1.display();
	}
}
