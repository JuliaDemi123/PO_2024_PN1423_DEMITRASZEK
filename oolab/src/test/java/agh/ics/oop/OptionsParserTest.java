package agh.ics.oop;

import agh.ics.oop.model.MoveDirection;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

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
        List<MoveDirection> arr1 = parse(dir1);
        List<MoveDirection> arr2 = parse(dir2);

        //then
        Assertions.assertIterableEquals(arr1,Arrays.asList(MoveDirection.RIGHT,MoveDirection.BACKWARD,MoveDirection.FORWARD,MoveDirection.FORWARD,MoveDirection.BACKWARD));
        Assertions.assertIterableEquals(arr2,Arrays.asList(MoveDirection.FORWARD,MoveDirection.LEFT,MoveDirection.BACKWARD,MoveDirection.RIGHT,MoveDirection.LEFT));
    }

    @Test
    void doSomeStringArraysWithErrorsGiveTheCorrectArray()
    {
        String[] dir1 = new String[] {"f","a","f","l","hello","b","r","apple"};
        String[] dir2 = new String[] {"a","c","hello","apple","orange"};
        String[] dir3 = new String[] {};

        try {
            List<MoveDirection> arr1 = parse(dir1);
            fail( "The test should have thrown an exception" );
        } catch (IllegalArgumentException e) {}

        try {
            List<MoveDirection> arr2 = parse(dir2);
            fail( "The test should have thrown an exception" );
        } catch (IllegalArgumentException e) {}

        try {
            List<MoveDirection> arr3 = parse(dir3);
        } catch (IllegalArgumentException e) { e.printStackTrace(); }
    }

}