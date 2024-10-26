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

        // then
        assertEquals(map.previous(), MapDirection.WEST);

        //and
        assertNotEquals(map.previous(), MapDirection.NORTH);
        assertNotEquals(map.previous(), MapDirection.EAST);
        assertNotEquals(map.previous(), MapDirection.SOUTH);
    }

    @Test
    void previousDirectionOfEastIsNorth()
    {
        //given
        MapDirection map = MapDirection.EAST;

        //then
        assertEquals(map.previous(), MapDirection.NORTH);

        //and
        assertNotEquals(map.previous(), MapDirection.EAST);
        assertNotEquals(map.previous(), MapDirection.WEST);
        assertNotEquals(map.previous(), MapDirection.SOUTH);
    }

    @Test
    void previousDirectionOfSouthIsEast()
    {
        //given
        MapDirection map = MapDirection.SOUTH;

        //then
        assertEquals(map.previous(), MapDirection.EAST);

        //and
        assertNotEquals(map.previous(), MapDirection.SOUTH);
        assertNotEquals(map.previous(), MapDirection.NORTH);
        assertNotEquals(map.previous(), MapDirection.WEST);
    }

    @Test
    void previousDirectionOfWestIsSouth()
    {
        //given
        MapDirection map = MapDirection.WEST;

        //then
        assertEquals(map.previous(), MapDirection.SOUTH);

        //and
        assertNotEquals(map.previous(), MapDirection.NORTH);
        assertNotEquals(map.previous(), MapDirection.EAST);
        assertNotEquals(map.previous(), MapDirection.WEST);
    }


}