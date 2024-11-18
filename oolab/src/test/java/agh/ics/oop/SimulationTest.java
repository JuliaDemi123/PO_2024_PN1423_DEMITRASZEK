package agh.ics.oop;

import agh.ics.oop.model.MapDirection;
import agh.ics.oop.model.Animal;
import agh.ics.oop.model.RectangularMap;
import agh.ics.oop.model.Vector2d;
import agh.ics.oop.OptionsParser;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
class SimulationTest
{
    private final Vector2d pos1 = new Vector2d(0, 0);
    private final Vector2d pos2 = new Vector2d(1, 2);
    private final Vector2d pos3 = new Vector2d(2, 2);
    private final RectangularMap map = new RectangularMap(4,4);

    @Test
    void IsTheAnimalTurningRight()
    {
        Simulation s = new Simulation(List.of(pos1),OptionsParser.parse( new String[] {"r"}),map );
        s.run();
        Assertions.assertEquals(s.getAnimalPositions().get(0),new Vector2d(0,0));
        Assertions.assertEquals(((Animal)map.objectAt(s.getAnimalPositions().get(0))).getOrientation(),MapDirection.EAST);
    }

    @Test
    void isTheAnimalTurningLeft()
    {
        Simulation s = new Simulation(List.of(pos1),OptionsParser.parse( new String[] {"l"}),map );
        s.run();
        Assertions.assertEquals(s.getAnimalPositions().get(0),new Vector2d(0,0));
        Assertions.assertEquals(((Animal)map.objectAt(s.getAnimalPositions().get(0))).getOrientation(),MapDirection.WEST);
    }

    @Test
    void isTheAnimalGoingForward()
    {
        Simulation s = new Simulation(List.of(pos3),OptionsParser.parse( new String[] {"f"}),map );
        s.run();

        Assertions.assertEquals(s.getAnimalPositions().get(0),new Vector2d(2,3));
        Assertions.assertEquals(((Animal)map.objectAt(s.getAnimalPositions().get(0))).getOrientation(),MapDirection.NORTH);
    }

    @Test
    void isTheAnimalStayingInPlaceWhenGoingForwardOutsideMap()
    {
        Simulation s = new Simulation(List.of(pos2),OptionsParser.parse( new String[] {"f"}),map );
        s.run();
        Assertions.assertEquals(s.getAnimalPositions().get(0),new Vector2d(1,3));
        Assertions.assertEquals(((Animal)map.objectAt(s.getAnimalPositions().get(0))).getOrientation(),MapDirection.NORTH);
    }

    @Test
    void isTheAnimalStayingInPlaceWhenGoingBackwardOutsideMap()
    {
        Simulation s = new Simulation(List.of(pos1),OptionsParser.parse( new String[] {"b"}),map );
        s.run();
        Assertions.assertEquals(s.getAnimalPositions().get(0),new Vector2d(0,0));
        Assertions.assertEquals(((Animal)map.objectAt(s.getAnimalPositions().get(0))).getOrientation(),MapDirection.NORTH);
    }


    @Test
    void isTheAnimalGoingBackward()
    {
        Simulation s = new Simulation(List.of(pos2),OptionsParser.parse( new String[] {"b"}),map);
        s.run();

        Assertions.assertEquals(s.getAnimalPositions().get(0),new Vector2d(1,1));
        Assertions.assertEquals(((Animal)map.objectAt(s.getAnimalPositions().get(0))).getOrientation(),MapDirection.NORTH);

    }

    @Test
    void areTheAnimalsHavingCorrectOrderOfCommands()
    {
        Simulation s = new Simulation(List.of(pos1,pos2,pos3),OptionsParser.parse( new String[] {"b","l","r","l","f"}),map);
        s.run();

        Assertions.assertEquals(s.getAnimalPositions().get(0),pos1);
        Assertions.assertEquals( ((Animal)(map.objectAt(s.getAnimalPositions().get(0)))).getOrientation(),MapDirection.WEST);


        Assertions.assertEquals(s.getAnimalPositions().get(1),new Vector2d(0,2) );
        Assertions.assertEquals( ((Animal)map.objectAt(s.getAnimalPositions().get(1))).getOrientation(),MapDirection.WEST);


        Assertions.assertEquals(s.getAnimalPositions().get(2),pos3);
        Assertions.assertEquals(((Animal)map.objectAt(s.getAnimalPositions().get(2))).getOrientation(),MapDirection.EAST);

    }

  
}