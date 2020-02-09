/*Program To Insert,Search,Delete Elements in the array */
class Array
{
	int arr[];
	int n_elem;

	Array(int x)
	{
		arr=new int[x];
		n_elem=0;

	}

	void insert(int i)
	{
		arr[n_elem]=i;
		n_elem++;
	}
	void display()
	{
		System.out.println("Displaying");
		for(int i=0;i<n_elem;i++)
		{
			System.out.println(arr[i]);
		}
	}
	void search(int x){
		int i;
		for(i=0;i<n_elem;i++){
			if(x==arr[i]){
				System.out.println("Element found at pos: "+(i+1));
				break;
			}
		}
			if(i==n_elem){
				System.out.println("Element Not Found");
				}
		}
	void delete(int x){
		int i;
		for(i=0;i<n_elem;i++){
			if(x==arr[i]){
				for(int j=i;j<n_elem-1;j++){
					arr[j]=arr[j+1];
				}
				n_elem=n_elem-1;
				System.out.println("Element Deleted");
				break;
			}
		}
		if(i==n_elem)
			System.out.println("Element Not Deleted");
	}	
}
class MyFunction
{
	public static void main(String args[])
	{
		Array a1 =new Array(10);
		a1.insert(199);
		a1.insert(100);
		a1.insert(14);
		a1.insert(13);
		a1.insert(12);
		a1.insert(10);
		a1.display();
		System.out.println();
		a1.search(100);
		a1.search(1000);
		System.out.println();
		a1.delete(14);
		a1.display();
		a1.delete(140);
		
	}
	

}



