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
	void insert(String s,int r){
		Student S1=new Student(s,r);
		arr[nelem]=S1;
		nelem++;
	}
	void display(){
		for(int i=0;i<nelem;i++)
			arr[i].display();
	}
		void insertion()
	{
		int j,i;Student temp;
		for(j=1;j<nelem;j++)
		{
			i=j;
			temp=arr[j];
			while(i>0 && arr[i-1].getname().compareTo(temp.getname())>0)
			{
				arr[i]=arr[i-1];
				i--;
			}
			arr[i]=temp;
		}
	
	}
	
}

class StudentArrayApp
{
	public static void main(String args[]){
		StudentArray sa=new StudentArray(5);
		sa.insert("Diptiman",1012062);
		sa.insert("Aryan",1012000);
		sa.insert("Snehu",1012077);
		sa.insert("Abhishek",1012066);
		sa.insert("Somen",1012055);
		System.out.println("Displaying the detail of the Student");	
		sa.display();
		sa.insertion();
		System.out.println();
		// int check=sa.search("Diptiman");
		// if(check!=-1)
		// 	System.out.println("Search Element Is found");
		// else
		// 	System.out.println("Search Elemnt not found");

		// sa.delete("Diptiman");
		// //System.out.println("After Deleting");
		sa.display();
	}
}
