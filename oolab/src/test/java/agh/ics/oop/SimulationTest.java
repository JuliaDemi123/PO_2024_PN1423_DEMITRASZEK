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
    void IsTheAnimalTurningRight()
    {
        Simulation s = new Simulation(List.of(pos1),OptionsParser.parse( new String[] {"r"}) );
        s.run();
        Assertions.assertEquals(s.getAnimals().get(0).getPosition(),new Vector2d(0,0));
        Assertions.assertEquals(s.getAnimals().get(0).getOrientation(),MapDirection.EAST);
    }

    @Test
    void isTheAnimalTurningLeft()
    {
        Simulation s = new Simulation(List.of(pos1),OptionsParser.parse( new String[] {"l"}) );
        s.run();
        Assertions.assertEquals(s.getAnimals().get(0).getPosition(),new Vector2d(0,0));
        Assertions.assertEquals(s.getAnimals().get(0).getOrientation(),MapDirection.WEST);
    }

    @Test
    void isTheAnimalGoingForward()
    {
        Simulation s = new Simulation(List.of(pos3),OptionsParser.parse( new String[] {"f"}) );
        s.run();

        Assertions.assertEquals(s.getAnimals().get(0).getPosition(),new Vector2d(2,4));
        Assertions.assertEquals(s.getAnimals().get(0).getOrientation(),MapDirection.NORTH);
    }

    @Test
    void isTheAnimalStayingInPlaceWhenGoingForwardOutsideMap()
    {
        Simulation s = new Simulation(List.of(pos2),OptionsParser.parse( new String[] {"f"}) );
        s.run();
        Assertions.assertEquals(s.getAnimals().get(0).getPosition(),new Vector2d(1,4));
        Assertions.assertEquals(s.getAnimals().get(0).getOrientation(),MapDirection.NORTH);
    }

    @Test
    void isTheAnimalStayingInPlaceWhenGoingBackwardOutsideMap()
    {
        Simulation s = new Simulation(List.of(pos1),OptionsParser.parse( new String[] {"b"}) );
        s.run();
        Assertions.assertEquals(s.getAnimals().get(0).getPosition(),new Vector2d(0,0));
        Assertions.assertEquals(s.getAnimals().get(0).getOrientation(),MapDirection.NORTH);
    }


    @Test
    void isTheAnimalGoingBackward()
    {
        Simulation s = new Simulation(List.of(pos2),OptionsParser.parse( new String[] {"b"}) );
        s.run();

        Assertions.assertEquals(s.getAnimals().get(0).getPosition(),new Vector2d(1,3));
        Assertions.assertEquals(s.getAnimals().get(0).getOrientation(),MapDirection.NORTH);

    }


    @Test
    void IsTheDataCorrectlyProcessedWithOtherStringsInside()
    {
        Simulation s = new Simulation(List.of(pos1, pos2, pos3),OptionsParser.parse(new String[]{"r","l","broccoli","f","orange","f","f","apple","b","r","f","f","spaghetti","f","f","f"}));
        s.run();

        Assertions.assertEquals(s.getAnimals().get(0).getPosition(),new Vector2d(1,0));
        Assertions.assertEquals(s.getAnimals().get(0).getOrientation(),MapDirection.SOUTH);

        Assertions.assertEquals(s.getAnimals().get(1).getPosition(),new Vector2d(0,4));
        Assertions.assertEquals(s.getAnimals().get(1).getOrientation(),MapDirection.WEST);

        Assertions.assertEquals(s.getAnimals().get(2).getPosition(),new Vector2d(2,4));
        Assertions.assertEquals(s.getAnimals().get(2).getOrientation(),MapDirection.NORTH);
    }

  
}