package GMS;

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
    Set(int key, String usrnm,String pwd)
    {
        this.key=key;
        this.usrnm=usrnm;
        this.pwd=pwd;
    }
}
public class User 
{
    Set s1[]=new Set[100];
    int c;
    int hashfunc(int key)
    {
        int hashv=Math.round(key/10);
        return hashv;
    }
    public void insert(int key,String usrnm, String pwd)
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
            s1[pos]=new Set(key,usrnm,pwd);
    }
    public boolean search(int key, String usrnme, String pass)
    {
        int temp=key;
        temp=hashfunc(temp);
        if(c==1)
        {
            if(s1[temp+1].usrnm.equals(usrnme) && s1[temp+1].pwd.equals(pass))
                return true;
            else
                return false;
        }
        else if(s1[temp].usrnm.equals(usrnme) && s1[temp].pwd.equals(pass))
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
                System.out.println(s1[i]);
            else
                System.out.println("Username: "+s1[i].usrnm);
        }
    }
}
