import java .util.*;
class Priority
{
		int arr[];
		int nelem;
		int maxsize;
		Priority(int s)
		{
				arr=new int[s];
				maxsize=s;
				nelem=0;
		}
		boolean isEmpty()
		{
				return (nelem==0); 
		}
		boolean isFull()
		{
				return (nelem==maxsize);
		}
		void insert(int x)
		{
				if(!isFull()){
						
						int i,j;
						for(i=0;i<nelem;i++)
								if(arr[i]<x)
										break;
						for(j=nelem;j>i;j--)
								arr[j]=arr[j-1];
						arr[i]=x;
						nelem++;
				}
				else
						System.out.println("Array is Full.......");
		}
		int delete()
		{
				int x=-1;
				if(!isEmpty())
				{
						x=arr[nelem-1];
						nelem--;
						return x;
				}
				else{
						System.out.println("Array is Empty");
						return x;
					}
		}
		void display()
		{
				System.out.println("Displaying the contents");
				for(int i=nelem-1;i>=0;i--)
						System.out.println(arr[i]+" ");
		}


}
class PriorityApp
{

	public static void main(String args[])
	{
			Scanner sc =new Scanner(System.in);
			int x;
			Priority q=new Priority(5);
			int element;
			while(true)
			{
					System.out.println("MENU DRIVEN");
					System.out.println("1.Insert");
					System.out.println("2.Delete");
					System.out.println("3.Display:");
					int ch=sc.nextInt();
					switch(ch)
					{
							case 1:
									System.out.println("Enter the element to be inserted:");
									element=sc.nextInt();
									q.insert(element);
							break;
							case 2:
									element=q.delete();
									if(element!=-1)
										System.out.println(element+" is Deleted");
							break;
							
							case 3:
									q.display();
							break;
							default:
									System.out.println("Wrong Choice");
					}
			}
	}
}
