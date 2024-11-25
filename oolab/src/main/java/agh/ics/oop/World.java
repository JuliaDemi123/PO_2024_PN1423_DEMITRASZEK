package agh.ics.oop;
import agh.ics.oop.model.*;
import agh.ics.oop.model.IncorrectPositionException;
import agh.ics.oop.model.util.MapVisualizer;

import java.util.List;

public class World {
    public static void run(MoveDirection[] direction)
    {
        System.out.println("start");
        for (MoveDirection dir: direction) {
            if (dir != null)
            {
                switch (dir) {
                    case FORWARD -> System.out.println("zwierzak idzie do przodu");
                    case BACKWARD -> System.out.println("zwierzak idzie do tylu");
                    case RIGHT -> System.out.println("zwierzak skreca w prawo");
                    case LEFT -> System.out.println("zwierzak skreca w lewo");
                };
            }
        }
        System.out.println("stop");
    }
    public static void main(String[] args)
    {
        ConsoleMapDisplay consoleMap = new ConsoleMapDisplay();
        RectangularMap map1 = new RectangularMap(5,5);
        map1.addMapChangeListener(consoleMap);
        Animal animal1 = new Animal();
        try { map1.place(animal1); }
        catch (IncorrectPositionException e) { e.printStackTrace();}
    }
}
