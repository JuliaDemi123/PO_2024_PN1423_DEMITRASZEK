package agh.ics.oop;
import agh.ics.oop.model.*;
import agh.ics.oop.model.IncorrectPositionException;
import agh.ics.oop.model.util.MapVisualizer;

import java.util.ArrayList;
import java.util.List;

public class World {
    public static void run(MoveDirection[] direction) {
        System.out.println("start");
        for (MoveDirection dir : direction) {
            if (dir != null) {
                switch (dir) {
                    case FORWARD -> System.out.println("zwierzak idzie do przodu");
                    case BACKWARD -> System.out.println("zwierzak idzie do tylu");
                    case RIGHT -> System.out.println("zwierzak skreca w prawo");
                    case LEFT -> System.out.println("zwierzak skreca w lewo");
                }
                ;
            }
        }
        System.out.println("stop");
    }

    public static void main(String[] args) {
        ConsoleMapDisplay consoleMap = new ConsoleMapDisplay();
//        RectangularMap map1 = new RectangularMap(5,5);
//        GrassField map2 = new GrassField(10);
//        map1.addMapChangeListener(consoleMap);
//        map2.addMapChangeListener(consoleMap);
//        Animal animal1 = new Animal();
//        try { map1.place(animal1); map2.place(animal1);}
//        catch (IncorrectPositionException e) { e.printStackTrace();}
        List<Vector2d> animals = List.of(new Vector2d(0, 1), new Vector2d(2, 2), new Vector2d(4, 2));
        ConsoleMapDisplay consoleMapDisplay = new ConsoleMapDisplay();
        try {
            List<MoveDirection> movements = OptionsParser.parse(new String[]{"f", "f", "l", "r", "b", "r", "l", "l", "r", "b", "b", "f", "r"});

            for (int i = 0; i < 100; ++i) {
                RectangularMap map1 = new RectangularMap(5, 5);
                GrassField map2 = new GrassField(5);

                Simulation sim1 = new Simulation(animals, movements, map1);
                Simulation sim2 = new Simulation(animals, movements, map2);

                map1.addMapChangeListener(consoleMapDisplay);
                map2.addMapChangeListener(consoleMapDisplay);

                SimulationEngine simulationEngine = new SimulationEngine(List.of(sim1, sim2));
                simulationEngine.runAsyncInThreadPool();
                simulationEngine.awaitSimulationsEnd();
            }

        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }
        System.out.println("System zakończył działanie");
    }
}
