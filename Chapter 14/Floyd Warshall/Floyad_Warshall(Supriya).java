import java.util.Scanner;
class Vertex
 {
    char label;
    boolean wasVisited;
    Vertex(char c)
     {
       label=c;
       wasVisited=false;
     }
    void Display()
     {
       System.out.println(label);
     }
 }
  class Graph
   {
      int pathMatrix[][];
      int weightMatrix[][];
      int v;
      int e;
      int n;
      Vertex v1[];
      Scanner sc=new Scanner(System.in);
      Graph(int v0,int e1)
       {
          n=0;
          v=v0;
          e=e1;
          pathMatrix=new int[v][v];
          weightMatrix=new int[e1][e1];
          v1=new Vertex[v];
          for(int i=0;i<v;i++)
            {
              for(int j=0;j<v;j++)
                {
                   pathMatrix[i][j]=0;
                   weightMatrix[i][j]=999999;
                }
            }
          for(int i=0;i<e;i++)
            {
               System.out.println("Enter the pair between which edge exists");
               int u=sc.nextInt();
               int v=sc.nextInt();
               pathMatrix[u][v]=1;
               System.out.println("Enter the weight between this vertex");
               int w=sc.nextInt();
               weightMatrix[u][v]=w;
            }
      }
      void AddVertex(char c)
        {
           v1[n]=new Vertex(c);
           n++;
        }
      void Floyd_Warshall()
        {
          for(int k=0;k<n;k++)
            {
              for(int i=0;i<n;i++)
                {
                  for(int j=0;j<n;j++)
                   {
                      if(pathMatrix[i][k]==1 && pathMatrix[k][j]==1)
                        {
                           pathMatrix[i][j]=1;
                        }
                      if((weightMatrix[i][k]+weightMatrix[k][j])<weightMatrix[i][j])
                           {
                              weightMatrix[i][j]=weightMatrix[i][k]+weightMatrix[k][j];
                           }
                   }
               }
           }
       }
     void Display()
      {
        for(int i=0;i<n;i++)
          {
            for(int j=0;j<n;j++)
              {
                System.out.print(pathMatrix[i][j]+"  ");
               }
             System.out.println();
          }
         for(int i=0;i<n;i++)
            {
              for(int j=0;j<n;j++)
               {
                  System.out.print(weightMatrix[i][j]+" ");
               }
               System.out.println();
           }
      }
  }
  class User
   {
     public static void main(String [] args)
       {
         Scanner sc=new Scanner(System.in);
         System.out.println("Enter the number of vertices and edges");
         int v1=sc.nextInt();
         int e1=sc.nextInt();
         Graph g1=new Graph(v1,e1);
         g1.AddVertex('A');
         g1.AddVertex('B');
         g1.AddVertex('C');
         g1.AddVertex('D');
         System.out.println("Before");
         g1.Display();
         System.out.println("After");
         g1.Floyd_Warshall();
         g1.Display();
       }
   }
            
