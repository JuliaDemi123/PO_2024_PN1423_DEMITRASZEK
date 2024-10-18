package agh.ics.oop;
import agh.ics.oop.model.MoveDirection;

public class World {
    public static void run(MoveDirection[] direction)
    {
        System.out.println("start");
        for (MoveDirection dir: direction) {
            if (dir != null)
            {
                switch (dir) {
                    case dir.FORWARD -> System.out.println("zwierzak idzie do przodu");
                    case dir.BACKWARD -> System.out.println("zwierzak idzie do tylu");
                    case dir.RIGHT -> System.out.println("zwierzak skreca w prawo");
                    case dir.LEFT -> System.out.println("zwierzak skreca w lewo");
                };
            }
        }
        System.out.println("stop");
    }
    public static void main(String[] args) {
        run(OptionsParser.getDirections(args));
    }
}
