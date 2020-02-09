class ArrayIns
{
	int nelem;
	char arr[];
	ArrayIns(String s)
	{

		arr=s.toCharArray();
		nelem=arr.length;
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
	void display()
	{
		System.out.println("Displaying the Array:");
		for(int i=0;i<nelem;i++)
			System.out.print(arr[i]);
		System.out.println();
	}

}
class ArrayInsApp
{
	public static void main(String args[])
	{
		String s="geeksforgeeks";
		ArrayIns a=new ArrayIns(s);
		a.display();
		a.noDups();
		a.noDups();
		a.display();

	}
}
