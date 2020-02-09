class Array{
	int nelem;
	int arr[];
	Array(int size){
		arr=new int[size];
		nelem=0;
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
	void selectionsort(){
		int out,in,min;
		for(out=0;out<nelem-1;out++)
		{
			min=out;
			for(in=out+1;in<nelem;in++){
				if(arr[in]<arr[min])
					min=in;
			}
				swap(out,min);
			
		}
	}
}
class ArrayApp{
	public static void main(String args[]){
		Array a=new Array(10);
		a.insert(0);
		a.insert(20);
		a.insert(15);
		a.insert(10);
		a.insert(220);
		a.insert(1);
		System.out.println("Before Sorting:");
		a.display();
		System.out.println("After Sorting:");
		a.selectionsort();
		a.display();
	}
}
