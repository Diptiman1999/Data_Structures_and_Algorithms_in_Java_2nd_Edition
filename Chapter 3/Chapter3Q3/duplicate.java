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
	void noDups()
	{
		int i=0;
		int j=1;
		while(j<nelem){
			if(arr[i]!=arr[j]){
				i++;
				arr[i]=arr[j];
			}
			j++;
		}
		nelem=i+1;
	}

}
class ArrayInsApp
{
	public static void main(String args[])
	{
		ArrayIns a=new ArrayIns(10);
		a.insert(5);
		a.insert(4);
		a.insert(5);
		a.insert(5);
		a.insert(6);
		a.insert(10);
		a.display();
		a.insertion();
		a.display();
		a.noDups();
		a.display();
	}
}
