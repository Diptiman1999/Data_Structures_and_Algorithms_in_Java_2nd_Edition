/*	Chapter-2
	Questiun-2.1
	Name-Diptiman Senapati
	Regd No.-1741012062
	Question-2.1*/

class HighArray{
	int arr[];
	int n_elem;
	HighArray(int x){
		arr=new int[x];
		n_elem=0;
	}
	void insert(int x){
		arr[n_elem]=x;
		n_elem++;
	}
	int getmax(){
		int max=arr[0];
		if (n_elem==0)
			return -1;
		for (int i=1;i<n_elem ;i++ ) {
			if(max<arr[i])
				max=arr[i];
		}
		return max;
	}
	void display(){
		for(int i=0;i<n_elem;i++)
			System.out.println(arr[i]);
	}
}
class MyFunction{
	public static void main(String args[]){
		HighArray a1=new HighArray(10);
		int max=a1.getmax();
		if (max==-1)
			System.out.println("Array Is enumpty");
		a1.insert(10);
		a1.insert(20);
		a1.insert(150);
		a1.insert(103);
		a1.insert(104);
		a1.insert(106);
		System.out.println("Displaying the arrray");
		a1.display();
		if(max!=-1)
			System.out.println("Maximum Element in the array :"+max);
	}
}