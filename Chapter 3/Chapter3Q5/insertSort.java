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
	void insertionSort()
	{

		int j,i,temp;int comp=0,copy=0;
		for(j=1;j<nelem;j++)
		{
			i=j;
			temp=arr[j];
			//comp++;
			while(i>0)
			{
				comp++;
				if(arr[i-1]>temp){
					arr[i]=arr[i-1];
					i--;
					copy++;
				}
				else
					break;
			}
			arr[i]=temp;
		}
		int total=comp+copy;
		System.out.println("Comparision="+comp);
		System.out.println("Copy="+copy);
		System.out.println("Total Comparision+copies="+total);
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
		a.insertionSort();
		a.display();
		a.insertionSort();
	}
}
