/*	Chapter-2
	Questiun-2.1
	Name-Diptiman Senapati
	Regd No.-1741012062
	Question-2.6*/

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
	void noDups()
	{
		for(int i=0;i<n_elem;i++){
			for(int j=i+1;j<n_elem;j++){
				if(arr[i]==arr[j])
					arr[j]=-1;
			}
		}
		int i;
		for(i=0;i<n_elem;i++){
			if(arr[i]==-1){
				for(int j=i;j<n_elem-1;j++)
					arr[j]=arr[j+1];
				n_elem=n_elem-1;i--;
			}
		}
	}

	void display(){
		for(int i=0;i<n_elem;i++)
			System.out.println(arr[i]);
	}
}
class HighArrayAppQ6{
	public static void main(String args[]){
		HighArray a1=new HighArray(20);
		a1.insert(10);
		a1.insert(20);
		a1.insert(150);
		a1.insert(103);
		a1.insert(150);
		a1.insert(1);
		a1.insert(10);
		a1.insert(150);
		a1.insert(1);
		a1.insert(1);
		a1.insert(106);
		System.out.println("Displaying the arrray");
		a1.display();
		a1.noDups();		
		System.out.println("Dispalaying the Array after Deleteng the Duplicate Element:");
		a1.display();
	}
}
