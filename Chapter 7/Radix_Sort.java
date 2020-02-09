import java.util.Scanner;
class Node
 {
   Node next;
   int data;
    Node(int d)
     {
       next=null;
       data=d;
     }
     void Display()
     {
         System.out.println("The data is:"+data);
     }
 }
class LinkedList
 {
   Node start;
   Node end;
   LinkedList()
    {
       start=null;
       end=null;
    }
    void InsertEnd(int d)
     {
        Node new1=new Node(d);
        if(start==null)
         {
            start=end=new1;
         }
        else
          {
            end.next=new1;
            end=new1;
          }
     }
    int DeleteBeg()
     {
       int x;
       if(start==null)
         {
           //System.out.println("Linked list is empty");
           x=-1;
         }
       else if(start.next==null)
         {
            x=start.data;
            start=end=null;
         }
        else
          {
             x=start.data;
             start=start.next;
          }
        return x;
     }
    void Display()
     {
        Node p=start;
        if(p==null)
         System.out.println("Empty");
        else
       {
        while(p!=null)
         {
           p.Display();
           p=p.next;
         }
       }
     }
 }
  /*class User
  {
   public static void main(String [] args)
    {
      LinkedList l1=new LinkedList();
      l1.InsertEnd(8);
      l1.InsertEnd(10);
      l1.DeleteBeg();
      l1.Display();
    }
 }*/
  class RadixSort
  {
    public static void main(String[] args)
      {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the number of elements to be sorted");
        int size=sc.nextInt();
        int a=1;
        int ar[]=new int[size];
        for(int i=0;i<size;i++)
         {
           ar[i]=sc.nextInt();
         }
         int max=MaximumElement(ar);
         int dig=NumberDigits(max);
         LinkedList a1[]=new LinkedList[10];
         for(int i=0;i<10;i++)
           {
             a1[i]=new LinkedList();
           }
         for(int i=0;i<dig;i++)
          {
            //a=a*10;
            for(int j=0;j<size;j++)
             {
              int dig1=(ar[j]/a)%10;
              a1[dig1].InsertEnd(ar[j]);
             }
            int j=0,k=0;
            do
              {
                int y=a1[k].DeleteBeg();
                if(y!=-1)
                {
                  ar[j]=y;
                  j++;
                }
                else
                 {
                   k++;
                 }
             }while(k!=a1.length);
             a=a*10;
           }
           for(int m=0;m<size;m++)
            {
              System.out.println("Array element:"+ar[m]);
            }
           /*for(int i=0;i<a1.length;i++)
             {
                 //System.out.println("Entered the loop");
                 a1[i].Display();
             }*/   
      }
    static int MaximumElement(int ar[])
     {
       int max=ar[0];
       for(int i=1;i<ar.length;i++)
        {
         if(ar[i]>max)
           max=ar[i];
        }
       return max;
     }
     static int NumberDigits(int max)
      {
         int i=max;
         int c=0;
          while(i!=0)
          {
             c++;
             i=i/10;
          }
          return c;
      }
}