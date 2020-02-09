import java .util.*;
class Priority2
{
		int arr[];
		int nelem;
		int maxsize;
		Priority2(int s)
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
				if(!isFull())
				{
						arr[nelem]=x;
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
						int i,j;
						x=arr[0];
						int pos=0;
						for(i=1;i<nelem;i++)
						{
								if(x<arr[i])
								{
										x=arr[i];
										pos=i;
								}

						}
						for(j=pos;j<nelem-1;j++)
						{
								arr[j]=arr[j+1];
						}
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
				for(int i=0;i<nelem;i++)
						System.out.println(arr[i]+" ");
		}


}
class Priority2App
{

	public static void main(String args[])
	{
			Scanner sc =new Scanner(System.in);
			int x;
			Priority2 q=new Priority2(20);
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
