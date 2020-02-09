/*	Chapter-2
	Questiun-2.3
	Name-Diptiman Senapati
	Regd No.-1741012062
	Question-2.3*/

class HighArray{
	int arr[];
	int n_elem;
	HighArray(int size){
		arr=new int[size];
		n_elem=0;
	}
	void insert(int i)
	{
		arr[n_elem]=i;
		n_elem++;
	}
	int getmax()
	{
		int highest=arr[0];
		if (n_elem==0)
			return -1;
		else{
			for(int i=1;i<n_elem;i++){
				if(highest<arr[i])
					highest=arr[i]; 
				}
			return highest;
			}
	}
	int removeMax(int x){
		int i;
		for(i=0;i<n_elem;i++){
			if(x==arr[i]){
				for(int j=i;j<n_elem-1;j++){
					arr[j]=arr[j+1];
				}
				n_elem=n_elem-1;
				break;
			}
		}
		return x;
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
class MyFunction{
	public static void main(String args[]){
		HighArray h1=new HighArray(10);
		HighArray h2=new HighArray(10);//To Store the DESCENDING ORDER ARRAY
		
		int max,delete;
		max=h1.getmax();
		if (max==-1)
			System.out.println("Array is Empty ");
		h1.insert(10);
		h1.insert(30);
		h1.insert(40);
		h1.insert(140);
		h1.insert(100);
		h1.insert(66);
		h1.insert(17);
		System.out.println("Inserted value:");
		h1.display();
		max=h1.getmax();

		if (max!=-1){
			while(max!=-1){
				//System.out.println("Highest value: "+max);
				delete=h1.removeMax(max);
				h2.insert(delete);
				max=h1.getmax();
			}
			System.out.println();
			System.out.println("After Deleting:");
			h2.display();
		}
	}
}
