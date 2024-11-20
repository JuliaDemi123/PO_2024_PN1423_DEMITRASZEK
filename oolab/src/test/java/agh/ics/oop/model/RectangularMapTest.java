package agh.ics.oop.model;

import agh.ics.oop.model.util.IncorrectPositionException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


//tutaj tez bedzie test validatora
class RectangularMapTest
{
    private final RectangularMap map = new RectangularMap(4,4);
    private final Vector2d pos1 = new Vector2d(2,2);
    private final Vector2d pos2 = new Vector2d(0,3);
    private final Vector2d pos3 = new Vector2d(3,0);
    private final Vector2d pos4 = new Vector2d(0,0);
    private final Vector2d pos5 = new Vector2d(3,3);

    @Test
    public void isPlaceCorrectlyAddingAnimalsToMap()
    {

        try {
            map.place(new Animal(pos1));
            map.place(new Animal(pos2));
            map.place(new Animal(pos3));
            map.place(new Animal(pos4));
            map.place(new Animal(pos5));
        }
        catch (IncorrectPositionException e) {System.out.println("TEST : isPlaceCorrectlyAddingAnimalsToMap [FAILED]"); e.printStackTrace();};
    }


    @Test
    public void placeShouldNotAddAnimalsAtTheSamePosition()
    {
        try {
            map.place(new Animal(pos1));
            map.place(new Animal(pos1));
            fail("Animals should not have been placed");
        }
        catch (IncorrectPositionException e)
        {
            //if execution reaches here,
            //it indicates this exception has occured.
            //and so the test is okay!
        }
    }

    @Test
    public void objectAtReturnsAnimalPositionIfPositionIsCorrect()
    {
        Animal a1 = new Animal(pos1);
        Animal a4 = new Animal(pos4);
        Animal a5 = new Animal(pos5);

        try {
            map.place(a1);
            map.place(a4);
            map.place(a5);
        } catch (IncorrectPositionException e) {
            System.out.println("TEST : objectAtReturnsAnimalPositionIfPositionIsCorrect [FAILED]"); e.printStackTrace();
        }
        assertEquals(map.objectAt(pos1),a1);
        assertEquals(map.objectAt(pos4),a4);
        assertEquals(map.objectAt(pos5),a5);


    }

    @Test
    public void objectAtReturnsNullIfPositionIsIncorrect()
    {
        assertNull(map.objectAt(pos1));
        assertNull(map.objectAt(pos2));
        assertNull(map.objectAt(pos3));
    }


    @Test
    public void moveShouldRemoveAnAnimalFromPreviousPositionInMapIfItChanged()
    {
        Animal a = new Animal(pos1);
        try
        {
            map.place(a);
        }
        catch (IncorrectPositionException e) { System.out.println("TEST : moveShouldRemoveAnAnimalFromPreviousPositionInMapIfItChanged [FAILED]"); e.printStackTrace(); }
        map.move(a,MoveDirection.FORWARD);
        assertNull(map.objectAt(pos1));
    }

    @Test
    public void moveShouldAddAnAnimalToNewPositionInMap()
    {
        Animal a = new Animal(new Vector2d(2,2));
        try {
            map.place(a);
        } catch (IncorrectPositionException e) { System.out.println("TEST : moveShouldAddAnAnimalToNewPositionInMap [FAILED]"); e.printStackTrace(); }
        map.move(a,MoveDirection.FORWARD);
        assertEquals(map.objectAt(new Vector2d(2,3)),a);
    }

    @Test
    public void isOccupiedIsTrueIfThereIsAnAnimalAtAPosition()
    {
        try
        {
            map.place(new Animal(pos1));
            map.place(new Animal(pos2));
            map.place(new Animal(pos3));
        } catch (IncorrectPositionException e) { System.out.println("TEST : isOccupiedIsTrueIfThereIsAnAnimalAtAPosition [FAILED]"); e.printStackTrace(); }
        assertTrue(map.isOccupied(pos1));
        assertTrue(map.isOccupied(pos2));
        assertTrue(map.isOccupied(pos3));
    }

    @Test
    public void isOccupiedIsFalseIfThereIsNoAnimalAtAPosition()
    {
        assertFalse(map.isOccupied(pos1));
        assertFalse(map.isOccupied(pos2));
        assertFalse(map.isOccupied(pos3));
    }


    @Test
    public void cannotMoveToAPositionIfTheDesiredYIsAboveHeight()
    {
        Animal a1 = new Animal(pos2);
        try {
            map.place(a1);
        } catch (IncorrectPositionException e) { System.out.println("TEST : cannotMoveToAPositionIfTheDesiredYIsAboveHeight [FAILED]"); e.printStackTrace(); }
        map.move(a1,MoveDirection.FORWARD);
        assertEquals(a1.getPosition(),new Vector2d(0,3));
    }

    @Test
    public void cannotMoveToAPositionIfTheDesiredYIsBelow0()
    {
        Animal a1 = new Animal(pos4);
        try {
            map.place(a1);
        } catch (IncorrectPositionException e) { System.out.println("TEST : cannotMoveToAPositionIfTheDesiredYIsBelow0 [FAILED]"); e.printStackTrace(); }
        map.move(a1,MoveDirection.BACKWARD);
        assertEquals(a1.getPosition(),new Vector2d(0,0));
    }

    @Test
    public void cannotMoveToAPositionIfTheDesiredXIsBelow0()
    {
        Animal a1 = new Animal(pos4);
        try {
            map.place(a1);
        } catch (IncorrectPositionException e) { System.out.println("TEST : cannotMoveToAPositionIfTheDesiredXIsBelow0 [FAILED]"); e.printStackTrace(); }
        map.move(a1,MoveDirection.LEFT);
        map.move(a1,MoveDirection.FORWARD);
        assertEquals(a1.getPosition(),new Vector2d(0,0));
    }

    @Test
    public void cannotMoveToAPositionIfTheDesiredXIsAboveWidth()
    {
        Animal a1 = new Animal(pos3);
        try {
            map.place(a1);
        } catch (IncorrectPositionException e) {
            System.out.println("TEST : cannotMoveToAPositionIfTheDesiredXIsAboveWidth [FAILED]"); e.printStackTrace(); }
        map.move(a1,MoveDirection.RIGHT);
        map.move(a1,MoveDirection.FORWARD);
        assertEquals(a1.getPosition(),new Vector2d(3,0));
    }

}