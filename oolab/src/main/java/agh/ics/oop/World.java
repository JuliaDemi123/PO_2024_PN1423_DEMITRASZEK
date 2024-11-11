package agh.ics.oop;
import agh.ics.oop.model.*;
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
        TextMap text = new TextMap();
        text.place("Ala");
        text.place("ma");
        text.place("sowoniedzwiedzia");
        text.move("ma",MoveDirection.RIGHT);
        System.out.println(text.toString());

        text.place("r");
        text.place("f");
        text.place("b");
        text.move("f",MoveDirection.LEFT);
        System.out.println(text.toString());
        System.out.println(text.objectAt(1));
        System.out.println(text.canMoveTo(4));
        System.out.println(text.canMoveTo(10));
    }
}