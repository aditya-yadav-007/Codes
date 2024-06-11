import java.util.*;
class Test2
{
   static int a[][];
   static int b[][];
   static int ra,rb,ca,cb;
   static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) 
     {
        System.out.println("Enter the number of rows and columns of the first matrix: ");
        ra = sc.nextInt();
        ca = sc.nextInt();
        System.out.println("Enter the number of rows and columns of the second matrix: ");
        rb = sc.nextInt();
        cb = sc.nextInt();
        a = new int[ra][ca];
        b = new int[rb][cb]; 
        System.out.println("Elements for 1st Matrix");
        for(int i=0;i<ra;i++)
        {
            for(int j=0;j<ca;j++)
            {
               System.out.println("Enter value for row "+i+"column"+j+"element");
               a[i][j]=sc.nextInt();
                
            }
        }
        System.out.println("Elements for 2nd Matrix");
        for(int i=0;i<ra;i++)
        {
            for(int j=0;j<ca;j++)
            {
               System.out.println("Enter value for row "+(i+1)+" column "+(j+1)+" element ");
               b[i][j]=sc.nextInt();
                
            }
        }
        System.out.println("Matrix 1");
        Test2.clm(a, ra, ca);
        Test2.row(a, ra, ca);
        Test2.dia(a, ra, ca);
        System.out.println("Matrix 2");
        Test2.clm(b, rb, cb);
        Test2.row(b, rb, cb);
        Test2.dia(b, rb, cb);        

     }
     public static void clm(int arr[][],int r,int c)
     {
        int s=0;
        for(int i=0;i<c;i++)
        {
            for(int j=0;j<r;j++)
            {
                s=s+ arr[j][i];
            }
            System.out.println("Sum of Column "+(i+1)+" = "+s);
            s=0;
        }
     }
     public static void row(int arr[][],int r,int c)
     {
        int s=0;
        for(int i=0;i<r;i++)
        {
            for(int j=0;j<c;j++)
            {
                s=s+ arr[i][j];
            }
            System.out.println("Sum of Row "+(i+1)+" = "+s);
            s=0;
        }
     }
     public static void dia(int arr[][],int r,int c)
     {
        int s=0;
        if(r!=c)
         System.out.println("Product of Diagonal not possible as it is not a square matrix.");
         else
         {
            System.out.println("Left Diagonal");
            for(int i=0;i<r;i++)
             s= s+ arr[i][i];
             System.out.println("Sum = " +s);
             s=0;
             System.out.println("Right Diagonal");
             for(int i=0,j =c-1;i<r & j>=0;i++,j--)
             {
                s= s+ arr[i][j];
             }
             System.out.println("Sum = " +s);

         }
     }


    
    
}