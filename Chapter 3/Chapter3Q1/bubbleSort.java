class Array
{
	int arr[];
	int n;
	Array(int size)
	{
		arr =new int[size];
		n=0;
	}
	void insert(int element)
	{
		arr[n]=element;
		n++;
	}
	void display()
	{
		System.out.println("Displaying the Array:");
		for(int i=0;i<n;i++)
			System.out.println(arr[i]);
	}
	void bubble()
	{
		int out,out1,in;
		for(out=n-1,out1=0;out1<out;out--,out1++)
		{
			for(in=out1;in<out;in++)
			{
				if(arr[in]>arr[in+1])
					swap(in,in+1);
			}
			for(in=out-1;in>out1;in--)
				if(arr[in]<arr[in-1])
					swap(in,in-1);
		}
	}
	void swap(int i,int j)
	{
		int temp=arr[i];
		arr[i]=arr[j];
		arr[j]=temp;
	}
}

class ArrayApp
{
	public static void main(String args[])
	{
		Array a=new Array(10);
		a.insert(5);
		a.insert(4);
		a.insert(3);
		a.insert(2);
		a.insert(1);
		a.display();
		a.bubble();
		a.display();
	}
}
