package GMS;
import java.util.*;

public class Shop 
{
    Game g=new Game();
    Scanner sc=new Scanner(System.in);
    Map<String, Integer> dict = new HashMap<String, Integer>();
    public Shop() 
    {
        dict.put("Laserbeam gun", 32500);
        dict.put("Platinum Armour plates", 65000);
        dict.put("Legendary sword", 76000);
    }
    void purchase()
    {
        System.out.println("Deals:\n"+dict);
        System.out.println("What do you want to purchase?");
        String buy=sc.nextLine();
        System.out.println("Please Pay= "+dict.get(buy));
        g.welcome();
    }
}

