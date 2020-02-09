/*	Chapter-2
	Question-2.5
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
	void merge(OrderedArray a1,OrderedArray a2){
		int i=0,j=0,k=0;
		while(i<a1.n_elem && j<a2.n_elem)
		{
			if(a1.arr[i]<a2.arr[j]){
				arr[k]=a1.arr[i];
				i++;
			}
			else{
				arr[k]=a2.arr[j];
				j++;
			}
			n_elem++;k++;
		}
		while(i<a1.n_elem){
			arr[k]=a1.arr[i];
			i++;
			n_elem++;
			//k++;
		}
		while(j<a2.n_elem){
			arr[k]=a2.arr[j];
			j++;
			n_elem++;
			//k++;
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
class OrderedArrayAppQ5{
	public static void main(String args[]){
		OrderedArray o1=new OrderedArray(10);
		OrderedArray o2=new OrderedArray(10);
		o1.insert(10);
		o1.insert(20);
		o1.insert(15);
		o1.insert(140);
		o1.insert(100);
		o1.insert(66);
		o1.insert(17);
		o1.insert(1);
		System.out.println("Displaying the 1st Array");
		o1.display();
		o2.insert(120);
		o2.insert(88);
		o2.insert(77);
		o2.insert(66);

		System.out.println("Displaying the 2nd Array");
		o2.display();
		OrderedArray o3=new OrderedArray(o1.n_elem+o2.n_elem);
		o3.merge(o1,o2);
		System.out.println("Displaying the Array after Merging:");
		o3.display();	
	}
}
