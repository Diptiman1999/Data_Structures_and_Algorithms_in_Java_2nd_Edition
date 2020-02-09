class Student 
{
	private String name;
	private int registration;
	Student next;
	Student(String n,int x)
	{
		name=n;
		registration=x;
		next=null;
		//System.out.println("next address "+next);
	}
	String getname()
	{
		return name; 
	}
	int getregistration()
	{
		return registration;
	}
	void display()
	{
		System.out.println("Name "+name);
		System.out.println("Registration Number "+registration);
	}
}
class LLStudent
{
	Student first;
	LLStudent()
	{
		first =null;
	}
	void insertFirst(String name,int x)
	{
		Student new1=new Student(name,x);
		new1.next=first;
		first=new1;
		//System.out.println("first address"+first);
	}
	void deleteFirst()
	{
		if(first!=null)
		{
			String x=first.getname();
			System.out.println(x+" is Deleted");
			first=first.next;
		}
		else
			System.out.println("List is Empty");
	}
	void display()
	{
		if(first!=null)
		{
			Student t=first;
			while(t!=null)
			{
				t.display();
				t=t.next;
			}
		}
		else
			System.out.println("list is empty");
	}
}
class StudentListApp
{
	public static void main(String args[])
	{
		LLStudent l1=new LLStudent();
		l1.insertFirst("Diptiman",2062);
		l1.insertFirst("Aryan",2055);
		l1.insertFirst("Snehasis",2123);
		l1.insertFirst("PP",2022);
		l1.insertFirst("Myself",2033);
		l1.insertFirst("Depu",2000);
		l1.insertFirst("Abhi",2011);
		l1.insertFirst("Snehu",2099);
		System.out.println("Displaying the Students in the Linked List ");
		System.out.println("*******************************************");
		l1.display();
		System.out.println("Displaying over");
		System.out.println("*******************************************");
		l1.deleteFirst();
		l1.deleteFirst();
		l1.deleteFirst();
		l1.deleteFirst();
		l1.deleteFirst();
		System.out.println("After deleting....");
		l1.display();
	}
}
