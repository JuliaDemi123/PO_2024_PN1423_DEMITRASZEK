package agh.ics.oop;

public class World {
    public static void run(String[] messages)
    {
        System.out.println("Zwierzak idzie do przodu");
        for(int i = 0; i < messages.length; i++)
        {
            System.out.print(messages[i]);
            if (i < messages.length-1)
            {
                System.out.print(", ");
            }
        }
        System.out.println();
    }
    public static void main(String[] args) {
        System.out.println("system wystartowal");
        run(args);
        System.out.println("system zakonczyl dzialanie");
    }
}
