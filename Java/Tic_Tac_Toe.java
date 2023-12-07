import java.util.*;
class Tic_Tac_Toe 
{
 static Scanner sc= new Scanner (System.in);
 static int g[][]= new int[3][3];
 static String a[]={"__"," X"," O"};
 static String name ;
 static int n=0;
 static int ur;
 static int uc;
 static int cr;
 static int cc;
 static int hcr;
 static int hcc;

 public static boolean Win ()
 {
    boolean result = true;
    if((g[0][0]==1 && g[1][0]==1 && g[2][0]==1) || (g[0][1]==1 && g[1][1]==1 && g[2][1]==1) || (g[0][2]==1 && g[1][2]==1 && g[2][2]==1))
    {
        System.out.println(name +"has Won the Match");
        result=false;
    }
    else if((g[0][0]==1 && g[0][1]==1 && g[0][2]==1) || (g[1][0]==1 && g[1][1]==1 && g[1][2]==1) || (g[2][0]==1 && g[2][1]==1 && g[2][2]==1))
    {
        System.out.println(name +"has Won the Match");
        result=false;
    }
    else if((g[0][0]==1 && g[1][1]==1 && g[2][2]==1) || (g[0][2]==1 && g[1][1]==1 && g[2][0]==1) )
    {
        System.out.println(name +"has Won the Match");
        result=false;
    }
    else if((g[0][0]==2 && g[1][0]==2 && g[2][0]==2) || (g[0][1]==2 && g[1][1]==2 && g[2][1]==2) || (g[0][2]==2 && g[1][2]==2 && g[2][2]==2))
    {
        System.out.println("Computer has Won the Match");
        result=false;
    }
    else if((g[0][0]==2 && g[0][1]==2 && g[0][2]==2) || (g[1][0]==2 && g[1][1]==2 && g[1][2]==2) || (g[2][0]==2 && g[2][1]==2 && g[2][2]==2))
    {
        System.out.println("Computer has Won the Match");
        result=false;
    }
    else if((g[0][0]==2 && g[1][1]==2 && g[2][2]==2) || (g[0][2]==2 && g[1][1]==2 && g[2][0]==2) )
    {
        System.out.println("Computer has Won the Match");
        result=false;
    }
  
    return result;
 }
 public static void main(String args[])
 {
    boolean c1=true;
    boolean c=false;
    System.out.println("Welcome Player Please Enter you Name =");
    name = sc.nextLine();
    System.out.println();
    System.out.println("Rules are = \n 1.Enter Coordinates with refrence to the diagram given below \n 2.The range of input is from 1 to 2 so please don't Enter any other values");
    System.out.println();
    System.out.println("  1  2  3 \n1 __|__|__\n2 __|__|__\n3   |  |");
    System.out.println();
    do{
        int j,i;
        for(i=0;i<3;i++)
        {
            for(j=0;j<3;j++)
            {
                g[i][j]=0;
            }
        }
        do
        { //draw condition
            do{
            System.out.println("Enter Row Number=");
            ur=sc.nextInt();
            ur=ur-1;
            System.out.println("Enter Column Number");
            uc=sc.nextInt();
            uc=uc-1;
            if(g[ur][uc]!=0)
            {
                System.out.println("The position has already been taken");
                c=true; 
            }
            else
            c=false;
            }while(c); 

            g[ur][uc]=1;

            do{
                hcc=(int)(Math.random()*10);
                hcr=(int)(Math.random()*10);
                if(hcc==0)
                hcc=(int)(Math.random()*10);
                if(hcr==0)
                hcr=(int)(Math.random()*10);
                if(hcc<=3 && hcc>=1 )
                    cc=0;
                if(hcc<=6 && hcc>=4 )
                    cc=1;
                if(hcc<=7 && hcc>=9 )
                    cc=2;
                if(hcr<=3 && hcr>=1 )
                    cr=0;
                if(hcr<=6 && hcr>=4 )
                    cr=1;
                if(hcr<=7 && hcr>=9 )
                    cr=2;
                if(g[cr][cc]!=0)
                    c1=true;
                else
                    c1=false;

            }while(c1);

            g[cr][cc]=2;
            
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
            System.out.println();

            
        }while(Tic_Tac_Toe.Win());

        for(j=0;j<3;j++)
                {
                    if(j!=2)
                    System.out.print(a[g[i][j]]+"|");
                    else
                    System.out.print(a[g[i][j]]);
                }
                System.out.println();
        
        System.out.println("If you want to play again enter 1 or 0 to quit");
        n=sc.nextInt();
    }while(n==1);
 }   
}
