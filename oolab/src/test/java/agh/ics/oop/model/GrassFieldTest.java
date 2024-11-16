package agh.ics.oop.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GrassFieldTest
{
    private final GrassField grassField = new GrassField(0);
    // jezeli bedzie kepka trawy, a nie bedzie zwierzaka to isOccupied zwroci true
    private final Vector2d pos1 = new Vector2d(2,3);
    private final Vector2d pos2 = new Vector2d(0,0);
    private final Vector2d pos3 = new Vector2d(3984,34240);
    private final Vector2d pos4 = new Vector2d(-1,5);
    private final Vector2d pos5 = new Vector2d(-3,-3);

    @Test
    void placeReturnsTrueIfValidPosition()
    {
        assertTrue(grassField.place(new Animal(pos1)));
        assertTrue(grassField.place(new Animal(pos2)));
        assertTrue(grassField.place(new Animal(pos4)));
    }

    @Test
    void placeReturnsTrueForLargeIntsInVector()
    {
        assertTrue(grassField.place(new Animal(pos3)));
    }

    @Test
    void placeReturnsFalseIfAnAnimalHasAlreadyBeenPlacedInThatPosition()
    {
        grassField.place(new Animal(pos1));
        assertFalse(grassField.place(new Animal(pos1)));
    }

    // Zakladam ze mozna tez dac zwierze na pozycje o ujemnych wspolrzednych
    // gdyz w zadaniu jest napisane ze tylko kepki trawy sa od (0,0) do (sqrt(n*10),sqrt(n*10))

    @Test
    public void moveShouldRemoveAnAnimalFromPreviousPositionInMapIfItChanged()
    {
        Animal a = new Animal(pos1);
        grassField.place(a);
        grassField.move(a,MoveDirection.FORWARD);
        assertNull(grassField.objectAt(pos1));
    }

    @Test
    public void moveShouldAddAnAnimalToNewPositionInMap()
    {
        Animal a = new Animal(new Vector2d(2,2));
        grassField.place(a);
        grassField.move(a,MoveDirection.FORWARD);
        assertEquals(grassField.objectAt(new Vector2d(2,3)),a);
    }

    @Test
    public void isOccupiedIsTrueIfThereIsAnAnimalAtAPosition()
    {
        grassField.place(new Animal(pos1));
        grassField.place(new Animal(pos2));
        grassField.place(new Animal(pos3));

        assertTrue(grassField.isOccupied(pos1));
        assertTrue(grassField.isOccupied(pos2));
        assertTrue(grassField.isOccupied(pos3));
    }

    @Test
    public void isOccupiedIsFalseIfThereIsNoAnimalAtAPosition()
    {
        assertFalse(grassField.isOccupied(pos1));
        assertFalse(grassField.isOccupied(pos2));
        assertFalse(grassField.isOccupied(pos3));
    }


    @Test
    public void objectAtReturnsAnimalPositionIfPositionIsCorrect()
    {
        Animal a1 = new Animal(pos1);
        Animal a4 = new Animal(pos4);
        Animal a5 = new Animal(pos5);

        grassField.place(a1);
        grassField.place(a4);
        grassField.place(a5);

        assertEquals(grassField.objectAt(pos1),a1);
        assertEquals(grassField.objectAt(pos4),a4);
        assertEquals(grassField.objectAt(pos5),a5);
    }

    @Test
    public void objectAtReturnsNullIfPositionIsIncorrect()
    {
        assertNull(grassField.objectAt(pos1));
        assertNull(grassField.objectAt(pos2));
        assertNull(grassField.objectAt(pos3));
    }

}