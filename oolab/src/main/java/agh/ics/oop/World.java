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
        RectangularMap map = new RectangularMap(4,4);
        List<MoveDirection> directions = OptionsParser.parse(args);
        List<Vector2d> positions = List.of(new Vector2d(2,2), new Vector2d(3,4));
        Simulation simulation = new Simulation(positions, directions, map);
        simulation.run();

        Animal a = new Animal(new Vector2d(2,2));
    }
}