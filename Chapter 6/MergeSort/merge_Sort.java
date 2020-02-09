import java.util.*;
class Array
{
	int arr[];
	int nelem;
	Array(int size)
	{
		arr=new int[size];
		nelem=0;
	}
	void insert(int x)
	{
		arr[nelem++]=x;
	}
	void display()
	{
		for(int i=0;i<nelem;i++)
		System.out.println(arr[i]);
	}
	void MergeSort()  
	{
		int temp[]=new int [nelem];
		recMergeSort(temp,0,nelem-1);
	}
	void recMergeSort(int t[],int lb,int hb)
	{
		if(lb==hb)
			return;
		else
		{
			int mid=(lb+hb)/2;
			recMergeSort(t,lb,mid);
			recMergeSort(t,mid+1,hb);
			merge(t,lb,mid+1,hb);
		}
	}
	void merge(int t[],int lb,int mid,int hb)
	{
		int l=lb,m=mid-1,k=0,n=hb-lb+1;
		while(lb<=m && mid<=hb)
		{
			if(arr[lb]<arr[mid])
				t[k++]=arr[lb++];
			else
				t[k++]=arr[mid++];
		}
		while(lb<=m)
			t[k++]=arr[lb++];
		while(mid<=hb)
			t[k++]=arr[mid++];
		for(int i=0;i<n;i++)
			arr[l+i]=t[i];
	}

}
class ArrayApp
{
	public static void main(String args[])
	{
		Array a1=new Array(10);
		a1.insert(40);
		a1.insert(0);
		a1.insert(5);
		a1.insert(60);
		a1.insert(45);
		a1.insert(30);
		a1.insert(10);
		a1.insert(55);
		System.out.println("Before Sorting");
		a1.display();
		a1.MergeSort();
		System.out.println("After Sorting");
		a1.display();
	}
}
