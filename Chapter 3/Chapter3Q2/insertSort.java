class ArrayIns
{
	int arr[];
	int nelem;
	ArrayIns(int n)
	{
		arr=new int [n];
		nelem=0;
	}
	void insert(int element)
	{
		arr[nelem]=element;
		nelem++;
	}
	void display()
	{
		System.out.println("Displaying the Array:");
		for(int i=0;i<nelem;i++)
			System.out.println(arr[i]);
	}
	void insertion()
	{
		int j,i,temp;
		for(j=1;j<nelem;j++)
		{
			i=j;
			temp=arr[j];
			while(i>0&&arr[i-1]>temp)
			{
				arr[i]=arr[i-1];
				i--;
			}
			arr[i]=temp;
		}
	}
	int median()
	{
		if(nelem%2==0)
		{
			int first=(nelem/2)-1;
			int second=(nelem/2);
			return (arr[first]+arr[second])/2;
		}
		return arr[(nelem-1)/2];
	}
}
class ArrayInsApp
{
	public static void main(String args[])
	{
		ArrayIns a=new ArrayIns(10);
		a.insert(5);
		a.insert(4);
		a.insert(3);
		a.insert(2);
		a.insert(6);
		a.insert(10);
		a.display();
		a.insertion();
		a.display();
		int mid=a.median();
		System.out.println("Median is "+mid);
	}
}
