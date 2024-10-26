package agh.ics.oop.model;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MapDirectionTest
{
    @Test
    void previousDirectionOfNorthIsWest()
    {
        // given
        MapDirection map = MapDirection.NORTH;

        // when and then
        assertEquals(map.previous(), MapDirection.WEST);

        assertNotEquals(map.previous(), MapDirection.NORTH);
        assertNotEquals(map.previous(), MapDirection.EAST);
        assertNotEquals(map.previous(), MapDirection.SOUTH);
    }

    @Test
    void previousDirectionOfEastIsNorth()
    {
        //given
        MapDirection map = MapDirection.EAST;

        //when and then
        assertEquals(map.previous(), MapDirection.NORTH);

        assertNotEquals(map.previous(), MapDirection.EAST);
        assertNotEquals(map.previous(), MapDirection.WEST);
        assertNotEquals(map.previous(), MapDirection.SOUTH);
    }

    @Test
    void previousDirectionOfSouthIsEast()
    {
        //given
        MapDirection map = MapDirection.SOUTH;

        //when and then
        assertEquals(map.previous(), MapDirection.EAST);

        assertNotEquals(map.previous(), MapDirection.SOUTH);
        assertNotEquals(map.previous(), MapDirection.NORTH);
        assertNotEquals(map.previous(), MapDirection.WEST);
    }

    @Test
    void previousDirectionOfWestIsSouth()
    {
        //given
        MapDirection map = MapDirection.WEST;

        //when and then
        assertEquals(map.previous(), MapDirection.SOUTH);

        assertNotEquals(map.previous(), MapDirection.NORTH);
        assertNotEquals(map.previous(), MapDirection.EAST);
        assertNotEquals(map.previous(), MapDirection.WEST);
    }

    @Test
    void nextDirectionOfNorthIsEast()
    {
        //given
        MapDirection map = MapDirection.NORTH;

        //when and then
        assertEquals(map.next(), MapDirection.EAST);

        assertNotEquals(map.next(), MapDirection.NORTH);
        assertNotEquals(map.next(), MapDirection.SOUTH);
        assertNotEquals(map.next(), MapDirection.WEST);
    }

    @Test
    void nextDirectionOfEastIsSouth()
    {
        //given
        MapDirection map = MapDirection.EAST;

        //when and then
        assertEquals(map.next(), MapDirection.SOUTH);

        assertNotEquals(map.next(), MapDirection.NORTH);
        assertNotEquals(map.next(), MapDirection.EAST);
        assertNotEquals(map.next(), MapDirection.WEST);

    }

    @Test
    void nextDirectionOfSouthIsWest()
    {
        MapDirection map = MapDirection.SOUTH;

        assertEquals(map.next(), MapDirection.WEST);

        assertNotEquals(map.next(), MapDirection.NORTH);
        assertNotEquals(map.next(), MapDirection.EAST);
        assertNotEquals(map.next(), MapDirection.SOUTH);
    }

    @Test
    void nextDirectionOfWestIfNorth()
    {
        MapDirection map = MapDirection.WEST;

        assertEquals(map.next(), MapDirection.NORTH);

        assertNotEquals(map.next(), MapDirection.WEST);
        assertNotEquals(map.next(), MapDirection.EAST);
        assertNotEquals(map.next(), MapDirection.SOUTH);
    }

}