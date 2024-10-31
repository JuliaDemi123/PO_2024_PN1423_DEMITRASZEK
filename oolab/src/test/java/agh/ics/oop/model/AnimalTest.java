package agh.ics.oop.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AnimalTest
{

    @Test
    void hasTheRightOrientationWhenTurningRight ()
    {
        Animal a1 = new Animal(); // na poczatku zwierzak jest zwrocony na polnoc

        a1.move(MoveDirection.RIGHT);
        Assertions.assertEquals(a1.getOrientation(), MapDirection.EAST);

        a1.move(MoveDirection.RIGHT);
        Assertions.assertEquals(a1.getOrientation(), MapDirection.SOUTH);

        a1.move(MoveDirection.RIGHT);
        Assertions.assertEquals(a1.getOrientation(), MapDirection.WEST);

        a1.move(MoveDirection.RIGHT);
        Assertions.assertEquals(a1.getOrientation(), MapDirection.NORTH);

    }

    @Test
    void hasTheRightOrientationWhenTurningLeft()
    {
        Animal a1 = new Animal();

        a1.move(MoveDirection.LEFT);
        Assertions.assertEquals(a1.getOrientation(), MapDirection.WEST);

        a1.move(MoveDirection.LEFT);
        Assertions.assertEquals(a1.getOrientation(), MapDirection.SOUTH);

        a1.move(MoveDirection.LEFT);
        Assertions.assertEquals(a1.getOrientation(), MapDirection.EAST);

        a1.move(MoveDirection.LEFT);
        Assertions.assertEquals(a1.getOrientation(), MapDirection.NORTH);

    }


}