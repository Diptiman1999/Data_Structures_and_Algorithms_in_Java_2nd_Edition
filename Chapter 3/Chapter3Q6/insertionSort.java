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
		//System.out.println("Value of ctr"+nelem);
		System.out.println("Displaying the Array:");
		for(int i=0;i<nelem;i++){
			System.out.println(arr[i]);}
	}
	void insertionSort()
	{

		int j,i,temp;int ctr=0;
		for(j=1;j<nelem;j++)
		{
			i=j;
			temp=arr[j];
			while(i>0)
			{
				if(arr[i-1]>=temp){
					if (arr[i-1]==temp && arr[i-1]!=-1){
						temp=-1;
						ctr++;
					}
					arr[i]=arr[i-1];
					i--;
				}
				else
					break;
			}
			arr[i]=temp;
		}
		System.out.println("Value of ctr:"+ctr);	
		nelem=nelem-ctr;		
		for(int k=0;k<nelem;k++){
			arr[k]=arr[k+ctr];
			}	

	}
}
class ArrayInsApp
{
	public static void main(String args[])
	{
		ArrayIns a=new ArrayIns(10);
		a.insert(33);
		a.insert(33);
		a.insert(266);
		a.insert(2);
		a.insert(266);
		a.insert(2);
		a.insert(2);
	
		a.display();
		a.insertionSort();
		a.display();
	//	a.insertionSort();
	}
}
