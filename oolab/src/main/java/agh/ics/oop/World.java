package agh.ics.oop;

public class World {
    public static void run(String[] messages)
    {
        System.out.println("Zwierzak idzie do przodu");
        for (String msg : messages) {
            switch (msg) {
                case "f" -> System.out.println("zwierzak idzie do przodu");
                case "b" -> System.out.println("zwierzak idzie do tylu");
                case "r" -> System.out.println("zwierzak idzie na prawo");
                case "l" -> System.out.println("zwierzak idzie na lewo");
            };
        }
    }
    public static void main(String[] args) {
        System.out.println("system wystartowal");
        run(args);
        System.out.println("system zakonczyl dzialanie");
    }
}
