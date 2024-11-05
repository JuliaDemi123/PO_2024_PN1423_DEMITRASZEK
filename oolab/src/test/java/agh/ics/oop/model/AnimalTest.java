package agh.ics.oop.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AnimalTest
{
    private final RectangularMap map = new RectangularMap(4,4);
    @Test
    void hasTheRightOrientationWhenTurningRight ()
    {
        Animal a1 = new Animal(); // na poczatku zwierzak jest zwrocony na polnoc

        a1.move(MoveDirection.RIGHT,map);
        Assertions.assertEquals(a1.getOrientation(), MapDirection.EAST);

        a1.move(MoveDirection.RIGHT,map);
        Assertions.assertEquals(a1.getOrientation(), MapDirection.SOUTH);

        a1.move(MoveDirection.RIGHT,map);
        Assertions.assertEquals(a1.getOrientation(), MapDirection.WEST);

        a1.move(MoveDirection.RIGHT,map);
        Assertions.assertEquals(a1.getOrientation(), MapDirection.NORTH);

    }

    @Test
    void hasTheRightOrientationWhenTurningLeft()
    {
        Animal a1 = new Animal();

        a1.move(MoveDirection.LEFT,map);
        Assertions.assertEquals(a1.getOrientation(), MapDirection.WEST);

        a1.move(MoveDirection.LEFT,map);
        Assertions.assertEquals(a1.getOrientation(), MapDirection.SOUTH);

        a1.move(MoveDirection.LEFT,map);
        Assertions.assertEquals(a1.getOrientation(), MapDirection.EAST);

        a1.move(MoveDirection.LEFT,map);
        Assertions.assertEquals(a1.getOrientation(), MapDirection.NORTH);

    }

    @Test
    void isAnimalGoingToWhereItIsSupposedTo()
    {
        Animal a1 = new Animal(); // jest zwrocony na polnoc
        Vector2d defaultPosition = new Vector2d(2, 2);

        a1.move(MoveDirection.FORWARD,map);
        Assertions.assertTrue(a1.isAt(new Vector2d(2,3)));
        a1.move(MoveDirection.BACKWARD,map);
        Assertions.assertTrue(a1.isAt(defaultPosition));

        a1.move(MoveDirection.RIGHT,map); // jest zwrocony w na wschod
        a1.move(MoveDirection.FORWARD,map);
        Assertions.assertTrue(a1.isAt(new Vector2d(3,2)));
        a1.move(MoveDirection.BACKWARD,map);
        Assertions.assertTrue(a1.isAt(defaultPosition));

        a1.move(MoveDirection.RIGHT,map); // jest zwrocony na poludnie
        a1.move(MoveDirection.FORWARD,map);
        Assertions.assertTrue(a1.isAt(new Vector2d(2,1)));
        a1.move(MoveDirection.BACKWARD,map);
        Assertions.assertTrue(a1.isAt(defaultPosition));

        a1.move(MoveDirection.RIGHT,map); // jest zwrocony na zachod
        a1.move(MoveDirection.FORWARD,map);
        Assertions.assertTrue(a1.isAt(new Vector2d(1,2)));
        a1.move(MoveDirection.BACKWARD,map);
        Assertions.assertTrue(a1.isAt(defaultPosition));

    }

    @Test
    void animalIsNotGoingOutsideTheMatrix()
    {
        Animal a1 = new Animal(new Vector2d(0,0));
        Animal a2 = new Animal(new Vector2d(0,4));
        Animal a3 = new Animal(new Vector2d(4,0));
        Animal a4 = new Animal(new Vector2d(4,4));

        Animal a5 = new Animal(new Vector2d(0,2));
        Animal a6 = new Animal(new Vector2d(1,0));
        Animal a7 = new Animal(new Vector2d(1,4));
        Animal a8 = new Animal(new Vector2d(4,2));


        a1.move(MoveDirection.BACKWARD,map);
        Assertions.assertEquals(a1.getPosition(),new Vector2d(0,0));

        a2.move(MoveDirection.FORWARD,map);
        Assertions.assertEquals(a2.getPosition(),new Vector2d(0,4));

        a3.move(MoveDirection.RIGHT,map); // jest zwrocony na wschod
        a3.move(MoveDirection.FORWARD,map);
        Assertions.assertEquals(a3.getPosition(),new Vector2d(4,0));

        a4.move(MoveDirection.FORWARD,map);
        Assertions.assertEquals(a4.getPosition(),new Vector2d(4,4));

        a5.move(MoveDirection.LEFT,map);
        a5.move(MoveDirection.FORWARD,map);
        Assertions.assertEquals(a5.getPosition(),new Vector2d(0,2));

        a6.move(MoveDirection.BACKWARD,map);
        Assertions.assertEquals(a6.getPosition(),new Vector2d(1,0));

        a7.move(MoveDirection.FORWARD,map);
        Assertions.assertEquals(a7.getPosition(),new Vector2d(1,4));

        a8.move(MoveDirection.RIGHT,map);
        a8.move(MoveDirection.FORWARD,map);
        Assertions.assertEquals(a8.getPosition(),new Vector2d(4,2));
    }
}