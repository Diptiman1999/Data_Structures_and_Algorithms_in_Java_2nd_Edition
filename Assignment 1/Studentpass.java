class Student
{
	private String name;
	private int regdno;
	Student(String n,int no){
		name=n;
		regdno=no;
	}
	void display(){
		System.out.println("Name :"+name);
		System.out.println("Regd No. :"+regdno);
	}
	int getregd(){
		return regdno;
	}
	String getname(){
		return name;
	}
}
class StudentArray{
	int nelem;
	Student arr[];
	StudentArray(int size)
	{
		nelem=0;
		arr=new Student[size];
	}
	void insert(Student S1){
		//Student S1=new Student(s,r);
		arr[nelem]=S1;
		nelem++;
	}
	void display(){
		for(int i=0;i<nelem;i++)
			arr[i].display();
	}
	int search(String n){
		int i;
		for(i=0;i<nelem;i++){
			if(n.equals(arr[i].getname()))
				break;
		}
		if(i==nelem)
			return -1;
		else return i;
	}
	
	void delete(String n){
		int pos=search(n);
		if(pos==-1)
			System.out.println("Element is Not present so it is not deleted");
		else{
			int i;
			for(i=pos;i<nelem-1;i++)
				arr[i]=arr[i+1];
			
			System.out.println("Element Is Deleted");
		}
	}
	
}

class StudentArrayApp
{
	public static void main(String args[]){
		StudentArray sa=new StudentArray(5);
		sa.insert(new Student("Diptiman",2062));
		sa.insert(new Student("Dip",20));
		sa.insert(new Student("man",2));
		sa.insert(new Student("n",20000062));
		// sa.insert("Aryan",1012000);
		// sa.insert("Snehu",1012077);
		// sa.insert("Abhishek",1012066);
		// sa.insert("Somen",1012055);
		System.out.println("Displaying the detail of the Student");	
		sa.display();
		System.out.println();
		int check=sa.search("n");
		if(check!=-1)
			System.out.println("Search Element Is found "+(check+1));
		else
			System.out.println("Search Elemnt not found");

		sa.delete("Diptiman");
		//System.out.println("After Deleting");
		sa.display();
	}
}
