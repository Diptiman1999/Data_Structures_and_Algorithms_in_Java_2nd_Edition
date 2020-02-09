import java.util.*;
class Anagram
{
		static int size;
		static char word[]=new char[100];
		public static void main(String args[])
		{
				Scanner sc=new Scanner(System.in);
				System.out.println("Enter the word:");
				String s=sc.next();
				size=s.length();
				for(int i=0;i<size;i++)
						word[i]=s.charAt(i);
				doAnagram(size);
		}
		static void doAnagram(int n)
		{
				if(n==1)
						return;
				for(int i=1;i<=n;i++)
				{
					doAnagram(n-1);
					if(n==2)
						displayWord();
					rotate(n);
				}
		}	
		static void rotate(int x)
		{
				int i;
				int index=size-x;
				char ch=word[index];
				for(i=index+1;i<size;i++)
				{
						word[i-1]=word[i];
				}
				word[i-1]=ch;
		}
	    static void displayWord()
		{
				for(int i=0;i<size;i++)
						System.out.print(word[i]);
				System.out.println();
		}
}
