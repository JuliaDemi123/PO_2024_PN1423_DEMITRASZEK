package agh.ics.oop;
import agh.ics.oop.model.MoveDirection;
import agh.ics.oop.model.Vector2d;
import agh.ics.oop.model.MapDirection;

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
    }
}
