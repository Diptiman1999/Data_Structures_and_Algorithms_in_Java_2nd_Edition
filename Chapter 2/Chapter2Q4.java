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
		int lb=0,hb=n_elem-1;
		int mid=0;
		while(lb<=hb){
			mid=(lb+hb)/2;
			if (x<arr[mid])
				hb=mid-1;
			else
				lb=mid+1;
		}
		for(int i=n_elem;i>lb;i--)
			arr[i]=arr[i-1];
		arr[lb]=x;
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
	void delete(int x){
		int lb=0,hb=n_elem-1;
		int mid=0;
		while(lb<=hb){
			mid=(hb-lb)/2;
			if(arr[mid]==x)
				break;
			else{
				if(x<arr[mid])
					hb=mid-1;
				else
					lb=mid+1;
			}
		}
		if(lb>hb)
			System.out.println("Not Found");
		else{
			for(int i=mid;i<n_elem-1;i++)
				arr[i]=arr[i+1];
			n_elem=n_elem-1;
		}	
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
class OrderedArrayAppQ4{
	public static void main(String args[]){
		OrderedArray o1=new OrderedArray(10);
		o1.insert(10);
		o1.insert(20);
		o1.insert(15);
		o1.insert(140);
		o1.insert(1);
		System.out.print("Inserted value in Ordered ");
		o1.display();
		int pos=o1.find(15);
		if(pos==-1){
			System.out.println("Search Element Not found");
			}
		else{
			System.out.println("Search Element found at "+(pos+1));
			o1.delete(15);
			o1.display();
		}

		
	}
}
