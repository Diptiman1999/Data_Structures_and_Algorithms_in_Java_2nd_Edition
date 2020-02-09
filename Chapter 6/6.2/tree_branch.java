import java.util.*;
class Array
{
	char arr[][];
	int nelem;
	Array(int size)
	{
		arr=new char[size][16];
		nelem=size;

	}
	void makebranch(int left,int right,int row)
	{
		if(left==right)
		{
			arr[row][left]='X';
			row++;
		}
		else
		{
			int mid=(left+right)/2;
			makebranch(left,mid,row);
			makebranch(mid+1,right,row);
		}


	}
	void display()
	{
		for(int i=0;i<nelem;i++)
			for(int j=0;j<16;j++)
				System.out.print(arr[i][j]);
			System.out.println();
	}

}
class ArrayApp
{
	public static void main(String args[])
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the size:");
		int s=sc.nextInt();
		Array a=new Array(s);
		a.makebranch(0,16,0);
		a.display();
	}
}
