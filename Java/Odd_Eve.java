import java.util.*;
class Odd_Eve
{
static Scanner sc = new Scanner(System.in);
static String name;
static int n=0;
static int Toss=0;
static int compChoice=0;
static int UserBatting=0;
static int CompBatting=0;
static int choice=0;
public void toss ()
{
    System.out.println("Enter = \n 1 for Odd \n 2 for Even ");
    int ch=sc.nextInt();
    if(ch!=1 && ch!=2 )
        {
            System.out.println();
            System.out.println("Its a foul");
            System.exit(0);
        }
    int com=(int)(Math.random()*10);
    if(com>=5)//n>5 = odd and n<5
    com=1;
    else
    com=0;
    if(ch==com)
    {
        System.out.println("**You Won The Toss**");
        System.out.println();
        Toss=1;
    }
    else
    {
        System.out.println("**You Lost The Toss**");
        System.out.println();
        Toss=0;
    }
    
}
public void CompChoice()
{
    int Ch=0;
    int val=(int)(Math.random()*10);
    if(val>=5)//Batting
    Ch=1;
    else//Bowling
    Ch=0;
    compChoice=Ch;

}
public void batting()
{
    System.out.println("You are Batting=");
    System.out.println();
    int v=0;
    int u;
    int r=0;
    while(r==0)
    {
        v=(int)(Math.random()*10);
        System.out.print("Your Turn : ");
        u=sc.nextInt();
        if(u>9)
        {
            System.out.println();
            System.out.println("Its a foul");
            System.exit(0);
        }
        System.out.println("Computer's Number ="+v);
        UserBatting=UserBatting+u;
        r=v==u?1:0;
        if(v==u)
        {
            System.out.println();
            System.out.println("**You are OUT**");
            System.out.println();
        }
    }
}

public void bowling()
{
    System.out.println("You are Bowling");
    System.out.println();
    int v1=0;
    int u1=0;
    int r1=0;
    while(r1==0)
    {
        v1=(int)(Math.random()*10);
        System.out.print("Your Turn : ");
        u1=sc.nextInt(); 
        if(u1>9)
        {
            System.out.println();
            System.out.println("Its a foul");
            System.exit(0);
        }
        System.out.println("Computer's Number ="+v1);
        CompBatting=CompBatting+u1;
        r1=v1==u1?1:0;
        if(v1==u1)
        {
            System.out.println();
            System.out.println("**Computer is OUT**");
            System.out.println();
        }
    }


}
public static void main(String args[])
{
    Odd_Eve obj= new Odd_Eve();
    System.out.println("Welcome Player Please Enter Your Name =");
    name=sc.nextLine();
    System.out.println();    
    System.out.println("The Rules of the game are = \n 1.There is no limit on Numbers of Balls \n 2. You can only enter runs from 1 to 9 \n 3.Enter The Numbers Carefully Without Making Any Mistake \n 4.There is no further rule ");
    System.out.println();
    do{
        obj.toss();
        if(Toss==1)
        {
            System.out.println("For choosing to go for = \n Batting = 1 \n Bowling = 2");
            choice=sc.nextInt();
            System.out.println();
            if(choice==1)
            {
                obj.batting();
                obj.bowling();
            }
            else
            {
                obj.bowling();
                obj.batting();
            }
        }
        else
        {
            obj.CompChoice();
            if(compChoice==1)
            {
                obj.bowling();
                obj.batting();
            }
            else
            {
                obj.batting();
                obj.bowling();
            }
        }
        if(CompBatting > UserBatting)
        {
            System.out.println();
            System.out.println("**The Almighty Computer Has Won the Match**");
        }
        else if(CompBatting < UserBatting)
        {
            System.out.println();
            System.out.println("**You Have Defeated the Almighty Computer**");
        }
        else
        {
            System.out.println();
            System.out.println("**Its a Draw**");
        }
        System.out.println();
        System.out.println("If you want to play again enter 1 or 0 to quit");
        n=sc.nextInt();
    }while(n==1);
    System.out.println(" Thank You for Playing the Game \n \n This game was created by Aditya Yadav of class 10-B \n \n This was my first attempt to make a game and it turned out to non graphical game.");
}


}