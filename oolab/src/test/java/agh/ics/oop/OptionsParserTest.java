package agh.ics.oop;

import agh.ics.oop.model.MoveDirection;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static agh.ics.oop.OptionsParser.*;
import static org.junit.jupiter.api.Assertions.*;

class OptionsParserTest
{
    @Test
    void doTheRightDirectionsGiveTheCorrectArray()
    {
        //given
        String[] dir1 = new String[] {"r","b","f","f","b"};
        String[] dir2 = new String[] {"f","l","b","r","l"};

        //when
        MoveDirection[] arr1 = getDirections(dir1);
        MoveDirection[] arr2 = getDirections(dir2);

        //then
        Assertions.assertArrayEquals(arr1,new MoveDirection[]{MoveDirection.RIGHT,MoveDirection.BACKWARD,MoveDirection.FORWARD,MoveDirection.FORWARD,MoveDirection.BACKWARD});
        Assertions.assertArrayEquals(arr2,new MoveDirection[] {MoveDirection.FORWARD,MoveDirection.LEFT,MoveDirection.BACKWARD,MoveDirection.RIGHT,MoveDirection.LEFT});
    }

    @Test
    void doSomeStringArraysWithErrorsGiveTheCorrectArray()
    {
        String[] dir1 = new String[] {"f","a","f","l","hello","b","r","apple"};
        String[] dir2 = new String[] {"a","c","hello","apple","orange"};
        String[] dir3 = new String[] {};

        MoveDirection[] arr1 = getDirections(dir1);
        MoveDirection[] arr2 = getDirections(dir2);
        MoveDirection[] arr3 = getDirections(dir3);

        Assertions.assertArrayEquals(arr1,new MoveDirection[] {MoveDirection.FORWARD,MoveDirection.FORWARD,MoveDirection.LEFT,MoveDirection.BACKWARD,MoveDirection.RIGHT});
        Assertions.assertArrayEquals(arr2,new MoveDirection[] {});
        Assertions.assertArrayEquals(arr3,new MoveDirection[] {});
    }

}