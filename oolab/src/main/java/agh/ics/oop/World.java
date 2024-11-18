package agh.ics.oop;
import agh.ics.oop.model.*;
import agh.ics.oop.model.util.MapVisualizer;

import java.util.List;

public class World {
    public static void run(MoveDirection[] direction)
    {
        System.out.println("start");
        for (MoveDirection dir : direction) {
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
        Vector2d pos1 = new Vector2d(-1,-1);
        Vector2d pos2 = new Vector2d(1,4);
        GrassField grassfield = new GrassField(10);
        grassfield.place(new Animal(pos1));
        grassfield.place(new Animal(pos2));
        System.out.println(grassfield.toString());

        List<WorldElement> list = grassfield.getElements();
    }
}
