package GMS;

import java.util.Random;
import java.util.Scanner;

class Set
{
    String usrnm;
    String pwd;
    int key;
    Set()
    {
        usrnm=pwd="";
        key=0;
    }
    Set(int key,String pwd)
    {
        this.key=key;
        this.pwd=pwd;
    }
}
public class User 
{
    Scanner sc=new Scanner(System.in);
    Set s1[]=new Set[100];
    int c;
    int hashfunc(int key)
    {
        int hashv=Math.round(key/10);
        return hashv;
    }
    public void insert(int key, String pwd)
    {
        int temp=key;
            c=0;
            int pos=hashfunc(temp);
            if(s1[pos]!=null)
            {
                if(pos==99)
                            pos=-1;
                        if(c==1)
                        {
                            System.out.println("User Occupied Already");
                            System.exit(0);
                        }
                        pos++;
                        c++;
            }
            s1[pos]=new Set(key,pwd);
    }
    public boolean search(int key, String pass)
    {
        int temp=key;
        temp=hashfunc(temp);
        if(c==1)
        {
            if(s1[temp+1].pwd.equals(pass))
                return true;
            else
                return false;
        }
        else if(s1[temp].pwd.equals(pass))
        {
            return true;
        }
        else
            return false;
    }
    public void display()
    {
        for(int i=0;i<s1.length;i++)
        {
            if(s1[i] == null)
                System.out.println("NA");
            else
                System.out.println("Username: "+s1[i].usrnm);
        }
    }
    
    int generateKey() 
    {
        Random random = new Random();
        return random.nextInt(900) + 100; 
    }
    
    void register()
    {
        System.out.println("New to Cruesathers? Register and enjoy the game!");
        System.out.println("Enter new password: ");
        String newPwd=sc.next();
        int key=generateKey();
        System.out.println("Your unique gamer tag is: "+key);
        insert(key,newPwd);
        System.out.println("Registeration complete...");
        login();
    }
    
    void login()
    {
        try
        {
            System.out.println("Login Page...");

            int key=0;
            System.out.println("Enter unique gamer key:");
            key=sc.nextInt();
            
            System.out.println("Enter the password: ");
            String pwd=sc.next();   

            
            boolean srch=search(key,pwd);
            if(srch==true)
            {
                System.out.println("Logged in...");
            }
        }
        catch(Exception e)
        {
            System.out.println("No user created");
            register();
        }
    }
    
    public static void main(String arg[])
    {
        User u=new User();
        System.out.println("Welcome to the game!!!\nEnter Choice:\n1) Login\n2) Register\n3) Display users\n4) Exit");
        int ch=u.sc.nextInt();
        int flag=0;
        while(flag==0)
        {
            switch(ch)
                {
                    case 1:
                    {
                        u.login();
                        break;
                    }
                    case 2:
                    {
                        u.register();
                        break;
                    }
                    case 3:
                    {
                        u.display();
                        break;
                    }
                    default:
                    {
                        System.out.println("Invalid");
                        break;
                    }
                }
        }
    }
}
