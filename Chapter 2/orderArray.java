/*	Chapter-2
	Question-2.4
	Name-Diptiman Senapati
	Regd No.-1741012062
*/

class OrderedArray{
	int arr[];
	int n_elem;
	OrderedArray(int size){
		arr=new int[size];
		n_elem=0;
	}
	void insert(int x)
	{
		int i,j;
		for(i=0;i<n_elem;i++)
			if(arr[i]>x)
				break;
		for(j=n_elem;j>i;j--)
			arr[j]=arr[j-1];
		arr[i]=x;
		n_elem++;
		
	}
	int find(int x){
		int first=0,last=n_elem-1;
		int mid=0;
		while(first<=last){
			mid=(first+last)/2;
			if (arr[mid]==x)
				return mid;
			else{
				if(x<arr[mid])
					last=mid-1;
				else
					first=mid+1;
			}
		}
		return -1;
	}
	int delete(int x){
		int i;
		for(i=0;i<n_elem;i++){
			if(x==arr[i]){
				for(int j=i;j<n_elem-1;j++){
					arr[j]=arr[j+1];
				}
				n_elem=n_elem-1;
				return 1;
			}
		}
		return -1;

	}	

	void display()
		{
		System.out.println("Displaying");
		for(int i=0;i<n_elem;i++)
		{
			System.out.println(arr[i]);		
		}
	}
}
class OrderedArrayApp{
	public static void main(String args[]){
		OrderedArray o1=new OrderedArray(10);
		o1.insert(10);
		o1.insert(20);
		o1.insert(15);
		o1.insert(140);
		o1.insert(100);
		o1.insert(66);
		o1.insert(17);
		o1.insert(1);
		System.out.print("Inserted value in Ordered ");
		o1.display();
		int x=o1.find(20);
		if(x==-1)
			System.out.println("Search Element Not found");
		else
			System.out.println("Search Element found at "+(x+1));
		int y=o1.delete(20);
		if(y==-1)
			System.out.println("Element is not Deleted");
		else{
			System.out.println("Element is Deleted");
			o1.display();
		}

		
	}
}
