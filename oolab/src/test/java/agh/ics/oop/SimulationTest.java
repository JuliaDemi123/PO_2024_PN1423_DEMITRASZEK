package agh.ics.oop;

import agh.ics.oop.model.MapDirection;
import agh.ics.oop.model.Vector2d;
import agh.ics.oop.OptionsParser;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
class SimulationTest
{
    private final Vector2d pos1 = new Vector2d(0, 0);
    private final Vector2d pos2 = new Vector2d(1, 4);
    private final Vector2d pos3 = new Vector2d(2, 3);

    @Test
    void IsTheDataCorrectlyProcessed()
    {
       Simulation s = new Simulation(List.of(pos1, pos2, pos3),OptionsParser.parse(new String[]{"r","l","f","f","f","b","r","f","f","f","f","f"}));
       s.run();

       Assertions.assertEquals(s.getAnimalPositions().get(0).getPosition(),new Vector2d(1,0));
       Assertions.assertEquals(s.getAnimalPositions().get(0).getOrientation(),MapDirection.SOUTH);

       Assertions.assertEquals(s.getAnimalPositions().get(1).getPosition(),new Vector2d(0,4));
       Assertions.assertEquals(s.getAnimalPositions().get(1).getOrientation(),MapDirection.WEST);

       Assertions.assertEquals(s.getAnimalPositions().get(2).getPosition(),new Vector2d(2,4));
       Assertions.assertEquals(s.getAnimalPositions().get(2).getOrientation(),MapDirection.NORTH);
    }

    @Test
    void IsTheDataCorrectlyProcessedWithOtherStringsInside()
    {
        Simulation s = new Simulation(List.of(pos1, pos2, pos3),OptionsParser.parse(new String[]{"r","l","broccoli","f","orange","f","f","apple","b","r","f","f","spaghetti","f","f","f"}));
        s.run();

        Assertions.assertEquals(s.getAnimalPositions().get(0).getPosition(),new Vector2d(1,0));
        Assertions.assertEquals(s.getAnimalPositions().get(0).getOrientation(),MapDirection.SOUTH);

        Assertions.assertEquals(s.getAnimalPositions().get(1).getPosition(),new Vector2d(0,4));
        Assertions.assertEquals(s.getAnimalPositions().get(1).getOrientation(),MapDirection.WEST);

        Assertions.assertEquals(s.getAnimalPositions().get(2).getPosition(),new Vector2d(2,4));
        Assertions.assertEquals(s.getAnimalPositions().get(2).getOrientation(),MapDirection.NORTH);
    }

  
}