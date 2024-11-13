package agh.ics.oop.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


//tutaj tez bedzie test validatora
class RectangularMapTest
{
    private final RectangularMap map = new RectangularMap(4,4);
    private final Vector2d pos1 = new Vector2d(3,3);
    private final Vector2d pos2 = new Vector2d(0,4);
    private final Vector2d pos3 = new Vector2d(4,0);
    private final Vector2d pos4 = new Vector2d(0,0);
    private final Vector2d pos5 = new Vector2d(4,4);

    @Test
    public void isPlaceCorrectlyAddingAnimalsToMap()
    {
       assertTrue(map.place(new Animal(pos1)));
       assertTrue(map.place(new Animal(pos2)));
       assertTrue(map.place(new Animal(pos3)));
       assertTrue(map.place(new Animal(pos4)));
       assertTrue(map.place(new Animal(pos5)));
    }


    @Test
    public void placeShouldNotAddAnimalsAtTheSamePosition()
    {
        assertTrue(map.place(new Animal(pos1)));
        assertFalse(map.place(new Animal(pos1)));
    }

    @Test
    public void objectAtReturnsAnimalPositionIfPositionIsCorrect()
    {
        Animal a1 = new Animal(pos1);
        Animal a4 = new Animal(pos4);
        Animal a5 = new Animal(pos5);

        map.place(a1);
        map.place(a4);
        map.place(a5);

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
        map.place(a);
        map.move(a,MoveDirection.FORWARD);
        assertNull(map.objectAt(pos1));
    }

    @Test
    public void moveShouldAddAnAnimalToNewPositionInMap()
    {
        Animal a = new Animal(new Vector2d(3,3));
        map.place(a);
        map.move(a,MoveDirection.FORWARD);
        assertEquals(map.objectAt(new Vector2d(3,4)),a);
    }

    @Test
    public void isOccupiedIsTrueIfThereIsAnAnimalAtAPosition()
    {
        map.place(new Animal(pos1));
        map.place(new Animal(pos2));
        map.place(new Animal(pos3));

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
        map.place(a1);
        map.move(a1,MoveDirection.FORWARD);
        assertEquals(a1.getPosition(),new Vector2d(0,4));
    }

    @Test
    public void cannotMoveToAPositionIfTheDesiredYIsBelow0()
    {
        Animal a1 = new Animal(pos4);
        map.place(a1);
        map.move(a1,MoveDirection.BACKWARD);
        assertEquals(a1.getPosition(),new Vector2d(0,0));
    }

    @Test
    public void cannotMoveToAPositionIfTheDesiredXIsBelow0()
    {
        Animal a1 = new Animal(pos4);
        map.place(a1);
        map.move(a1,MoveDirection.LEFT);
        map.move(a1,MoveDirection.FORWARD);
        assertEquals(a1.getPosition(),new Vector2d(0,0));
    }

    @Test
    public void cannotMoveToAPositionIfTheDesiredXIsAboveWidth()
    {
        Animal a1 = new Animal(pos3);
        map.place(a1);
        map.move(a1,MoveDirection.RIGHT);
        map.move(a1,MoveDirection.FORWARD);
        assertEquals(a1.getPosition(),new Vector2d(4,0));
    }

}