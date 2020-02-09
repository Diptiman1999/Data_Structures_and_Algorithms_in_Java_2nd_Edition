class Array{
	int arr[];
	int nelem;
	Array(int size){
		nelem=0;
		arr=new int[size];
	}
	void insert(int n){
		arr[nelem]=n;
		nelem++;
	}
	void swap(int i,int j){
		int temp=arr[i];
		arr[i]=arr[j];
		arr[j]=temp;
	}
	void display()
	{
		for(int i=0;i<nelem;i++)
			System.out.println(arr[i]);
	}
	void bubblesort()
	{
		int flag=1;
		while(flag==1)
		{
			flag=0;
			for(int i=0;i<nelem-1;i+=2){
				if(arr[i]>arr[i+1]){
					swap(i,i+1);
					flag=1;
				}
			}
			for(int j=1;j<nelem-1;j+=2){
				if(arr[j]>arr[j+1]){
					swap(j,j+1);
					flag=1;
				}
			}


		}
	}
}
class ArrayApp{
	public static void main(String args[]){
		Array a=new Array(10);
		a.insert(22);
		a.insert(20);
		a.insert(15);
		a.insert(10);
		a.insert(220);
		a.insert(1);
		System.out.println("Before Sorting:");
		a.display();
		System.out.println("After Sorting:");
		a.bubblesort();
		a.display();
	}
}
