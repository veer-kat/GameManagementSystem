package GMS;

import java.util.*;

public class Game 
{
    static Storyline s=new Storyline();
    User u=new User();
    Scanner sc=new Scanner(System.in);
    public String usrnm;
    public String pwd;
    String pair[]=new String[2];
    public int key;
    void login()
    {
        key=0;
        System.out.println("Login Page...");
        System.out.println("Enter username: ");
        usrnm=sc.nextLine();
        System.out.println("Enter password: ");
        pwd=sc.nextLine();
        pair[0]=usrnm;
        pair[1]=pwd;
        System.out.println("Enter unique gamer key");
        key=sc.nextInt();
        boolean srch=u.search(key,pwd);
        if(srch==true)
        {
            welcome();
        }
        else
        {
            System.out.println("User not found!, Register? Y/N");
            char ch=sc.next().charAt(0);
            switch(ch)
            {
                case 'y': register();
                        break;
                case 'Y': register();
                        break;
                case 'n':login();
                        break;
                case 'N':login();
                        break;
                default:System.out.println("Invalid Choice");
                        login();
                        break;
            }
        }
    }
    void register()
    {
        System.out.println("New to Cruesathers? Register and enjoy the game!");
        System.out.println("Enter new username: ");
        String newUsrnm=sc.nextLine();
        System.out.println("Enter new password: ");
        String newPwd=sc.nextLine();
        key=generateKey();
        System.out.println("Your unique gamer tag is: "+key);
        u.insert(key,newPwd);
        System.out.println("Registeration complete...");
        login();
    }
    void welcome()
    {
        System.out.println("Welcome back "+usrnm+" to Cruesathers!\nWhere do you want to spend your leisure time today:\n1. Armoury\n2. Story Mode\n3. Exit");
        int ch=sc.nextInt();
        switch(ch)
        {
            case 1: armoury();
                    break;
            case 2: System.out.println("Continue or New Game? C/N");
                    char ch1=sc.next().charAt(0);
                    switch(ch1)
                    {
                        case 'c':select();
                                break;
                        case 'C':select();
                                break;
                        case 'n':start();
                                break;
                        case 'N':start();
                                break;
                        default:System.out.println("Invalid Choice");
                                welcome();
                                break;
                    }
                    break;
            case 3: exit();
                    break;
            default:System.out.println("Invalid Choice");
                    welcome();
                    break;
        }

    }
    void start()
    {
        System.out.println("You are travelling in an intergalactic spaceship in order to pioneer habitable planets for humans to live on\nYour Rocket AI detects something mysterious coming your way\nSuddenly you wake up on an mysterious high tech alien planet implying by the surroundings");
        System.out.println("You have the following options\n1)Accept the truth and live on rocket supplies till death\n2)Risk your life and explore the planet\n3)Take the illegal way to heaven");
        int ch=sc.nextInt();
        int flag=0;
        while(flag==0)
        {
            switch(ch)
            {
                case 1: s.root=s.insert(ch,"Accept the truth and live on rocket supplies till death", s.root);
                        flag++;
                        welcome();
                        break;
                case 2: s.root=s.insert(ch,"Risk your life and explore the planet", s.root);
                        flag++;
                        break;
                case 3: s.root=s.insert(ch,"Take the illegal way to heaven", s.root);
                        flag++;
                        welcome();
                        break;
                default:System.out.println("Invalid Choice");
                        break;
            }
        }
        System.out.println("Following, you ponder upon a treasure chest...You have the following options\n4)Open\n5)Leave it\n6)Report to Intergalactic police");
        ch=sc.nextInt();
        flag=0;
        while(flag==0)
        {
            switch(ch)
            {
                case 4: s.root=s.insert(ch,"Open the treasure", s.root);
                        flag++;
                        
                        break;
                case 5: s.root=s.insert(ch,"Leave it", s.root);
                        flag++;
                        welcome();
                        break;
                case 6: s.root=s.insert(ch,"Report to intergalactic police", s.root);
                        flag++;
                        welcome();
                        break;
                default:System.out.println("Invalid Choice");
                        break;
            }
        }
        System.out.println("While Roaming, you came accross an alien base...You have the following options\n7)Move on\n8)Just gaze\n9)Enter");
        ch=sc.nextInt();
        flag=0;
        while(flag==0)
        {
            switch(ch)
            {
                case 7: s.root=s.insert(ch,"Move on", s.root);
                        flag++;
                        welcome();
                        break;
                case 8: s.root=s.insert(ch,"Just gaze the spaceship", s.root);
                        flag++;
                        welcome();
                        break;
                case 9: s.root=s.insert(ch,"Enter the spaceship", s.root);
                        flag++;
                        break;
                default:System.out.println("Invalid Choice");
                        break;
            }
        }
        System.out.println("You shocked to find crusades inside, but theres also an Ship to escape...You have the following options\n10)Click and upload on instagram\n11)Sneak inside the spaceship\n12)Attack them");
        ch=sc.nextInt();
        flag=0;
        while(flag==0)
        {
            switch(ch)
            {
                case 10: s.root=s.insert(ch,"Click and upload on instagram", s.root);
                        flag++;
                        welcome();
                        break;
                case 11: s.root=s.insert(ch,"Sneak inside the spaceship", s.root);
                        flag++;
                        break;
                case 12: s.root=s.insert(ch,"Attack them", s.root);
                        flag++;
                        welcome();
                        break;
                default:System.out.println("Invalid Choice");
                        break;
            }
        }
        System.out.println("Entering the ship...You have the following options\n13)Escape the planet\n14)Steal the ship utilities\n15)Destroy the ship from inside");
        ch=sc.nextInt();
        flag=0;
        while(flag==0)
        {
            switch(ch)
            {
                case 13: s.root=s.insert(ch,"Escape the planet", s.root);
                        flag++;
                        break;
                case 14: s.root=s.insert(ch,"Steal the ship utilities", s.root);
                        flag++;
                        welcome();
                        break;
                case 15: s.root=s.insert(ch,"Destroy the ship from inside", s.root);
                        flag++;
                        welcome();
                        break;
                default:System.out.println("Invalid Choice");
                        break;
            }
        }
        welcome();
    }
    void select()
    {
        s.inorder(s.root);
        System.out.println("Select from where to start from: 1-15");
        int searchKey = sc.nextInt();
        Node foundNode = s.search(searchKey);
        
        if (foundNode != null) 
        {
            System.out.println("Found: " + "\nID= "+foundNode.id+"\nDescription= "+foundNode.desc);
            welcome();
        } 
        else 
        {
            System.out.println("Not Found");
            welcome();
        }
    }
    void armoury()
    {
        Shop s1=new Shop();
        s1.purchase();
    }
    void exit()
    {
        System.out.println("Going soon?");
        System.exit(0);
    }
    
    int generateKey() 
    {
        Random random = new Random();
        return random.nextInt(900) + 100; 
    }
    
    public static void main(String args[])
    {
        Game g=new Game();
        g.register();
    }
}
