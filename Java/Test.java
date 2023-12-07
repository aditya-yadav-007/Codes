import java.util.*;
public class Test 
{
static Scanner sc=new Scanner(System.in);

public static void main(String args[])
{
    int g[][]=new int[3][3];
    String a[]={"__"," X"," O"};
    int j,i,ur,uc;
    boolean c;
    for(i=0;i<3;i++)
    {
        for(j=0;j<3;j++)
        {
            g[i][j]=0;
        }
    }
        do{
        System.out.println("Enter Row Number=");
        ur=sc.nextInt();
        System.out.println("Enter Column Number");
        uc=sc.nextInt();
        if(g[ur][uc]!=0)
        {
            System.out.println("The position has already been taken");
            c=true; 
        }
        else
        c=false; 
    }while(c);
        g[ur][uc]=1;
        for(i=0;i<3;i++)
            {
                for(j=0;j<3;j++)
                {
                    if(j!=2)
                    System.out.print(a[g[i][j]]+"|");
                    else
                    System.out.print(a[g[i][j]]);
                }
                System.out.println();
            }
        }
    }
