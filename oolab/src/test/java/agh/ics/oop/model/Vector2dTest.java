package agh.ics.oop.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Vector2dTest
{
    @Test
    void isEqualTo()
    {
        // given
        Vector2d v1 = new Vector2d(1,2);
        Vector2d v2 = new Vector2d(39350925,-23424453);
        Vector2d v3 = new Vector2d(-19343,0);
        Vector2d v4 = new Vector2d(1,2);
        Vector2d v5 = v4;

        // when and then
        assertEquals(v1,v1); // reflexivity
        assertEquals(v4,v1); //
        assertEquals(v1,v4); // symmetry
        assertEquals(v1,v5); // transitivity
        assertEquals(v1, new Vector2d(1,2));
        assertEquals(v2, new Vector2d(39350925,-23424453));
        assertEquals(v3, new Vector2d(-19343,0));
    }

    @Test
    void isNotEqualTo()
    {
        // given
        Vector2d v1 = new Vector2d(1,2);
        Vector2d v2 = new Vector2d(39350925,-23424453);
        Vector2d v3 = new Vector2d(-19343,0);

        // when and then
        assertNotEquals(v1, v2);
        assertNotEquals(v2, v3);
        assertNotEquals(v3, v1);
        assertNotEquals(v1, null);
    }

    @Test
    void isTheWrittenStringCorrect()
    {
        //given
        Vector2d v1 = new Vector2d(1,2);
        Vector2d v2 = new Vector2d(39350925,-23424453);
        Vector2d v3 = new Vector2d(-19343,0);

        //then
        assertEquals(v1.toString(),"(1,2)");
        assertEquals(v2.toString(),"(39350925,-23424453)");
        assertEquals(v3.toString(),"(-19343,0)");
    }

    @Test
    void isTheWrittenStringNotInIncorrectFormat()
    {
        //given
        Vector2d v1 = new Vector2d(1,2);
        Vector2d v2 = new Vector2d(39350925,-23424453);
        Vector2d v3 = new Vector2d(-19343,0);

        //then
        assertNotEquals(v1.toString(),"1,2");
        assertNotEquals(v1.toString(),"[1,2]");
        assertNotEquals(v1.toString(),"(1, 2)");
        assertNotEquals(v2.toString(),"39350925,-23424453");
        assertNotEquals(v2.toString(),"(39350925, -23424453)");
        assertNotEquals(v2.toString(),"[39350925,-23424453]");
        assertNotEquals(v3.toString(),"-19343,0");
        assertNotEquals(v3.toString(),"[-19343,0]");

    }

    @Test
    void oneVectorIsBeforeTheOther()
    {
        Vector2d v1 = new Vector2d(1,2);
        Vector2d v2 = new Vector2d(40,30);
        Vector2d v3 = new Vector2d(-19343,0);
        Vector2d v4 = new Vector2d(-19343,1);

        assertTrue(v1.precedes(v1));
        assertTrue(v3.precedes(v1));
        assertTrue(v1.precedes(v2));
        assertTrue(v3.precedes(v2));
        assertTrue(v3.precedes(v4));
    }

    @Test
    void oneIsntBeforeTheOther()
    {
        Vector2d v1 = new Vector2d(1,2);
        Vector2d v2 = new Vector2d(40,30);
        Vector2d v3 = new Vector2d(-19343,0);

        assertFalse(v2.precedes(v1));
        assertFalse(v1.precedes(v3));
        assertFalse(v2.precedes(v3));
        assertFalse(v3.precedes(null));
    }

    @Test
    void oneVectorFollowsTheOther()
    {
        Vector2d v1 = new Vector2d(1,2);
        Vector2d v2 = new Vector2d(40,30);
        Vector2d v3 = new Vector2d(-19343,0);
        Vector2d v4 = new Vector2d(1,5);

        assertTrue(v1.follows(v1));
        assertTrue(v4.follows(v1));
        assertTrue(v2.follows(v1));
        assertTrue(v2.follows(v3));
    }

    @Test
    void oneVectorDoesNotFollowTheOther()
    {

        Vector2d v1 = new Vector2d(1,2);
        Vector2d v2 = new Vector2d(40,30);
        Vector2d v3 = new Vector2d(-19343,0);

        assertFalse(v1.follows(v2));
        assertFalse(v3.follows(v2));
        assertFalse(v3.follows(v2));
        assertFalse(v3.follows(null));
    }

    @Test
    void theUpperRightOfTwoVectors()
    {
        Vector2d v1 = new Vector2d(1,2);
        Vector2d v2 = new Vector2d(40,2);
        Vector2d v3 = new Vector2d(-19343,5);

        assertEquals(v1.upperRight(v2),new Vector2d(40,2));
        assertEquals(v2.upperRight(v3),new Vector2d(40,5));
        assertEquals(v1.upperRight(v3),new Vector2d(1,5));
    }

    @Test
    void theLowerLeftOfTwoVectors()
    {
        Vector2d v1 = new Vector2d(1,2);
        Vector2d v2 = new Vector2d(40,-1);
        Vector2d v3 = new Vector2d(-19343,5);
        Vector2d v4 = new Vector2d(-19343,0);

        assertEquals(v1.lowerLeft(v2),new Vector2d(1,-1));
        assertEquals(v2.lowerLeft(v3),new Vector2d(-19343,-1));
        assertEquals(v3.lowerLeft(v4),new Vector2d(-19343,0));
        assertEquals(v1.lowerLeft(v3),new Vector2d(-19343,2));
    }

    @Test
    void addingVectorToAnotherVector()
    {
        Vector2d v1 = new Vector2d(1,2);
        Vector2d v2 = new Vector2d(40,2);
        Vector2d v3 = new Vector2d(-19343,5);

        assertEquals(v1.add(v2),new Vector2d(41,4));
        assertEquals(v2.add(v3),new Vector2d(-19303,7));
        assertEquals(v1.add(v3),new Vector2d(-19342,7));
        assertEquals(v2.add(new Vector2d(0,0)),new Vector2d(40,2));
    }

    @Test
    void subtractingVectorFromAnotherVector()
    {
        Vector2d v1 = new Vector2d(1,2);
        Vector2d v2 = new Vector2d(40,2);
        Vector2d v3 = new Vector2d(-19343,5);


        assertEquals(v1.subtract(v2),new Vector2d(-39,0));
        assertEquals(v1,v1.subtract(new Vector2d(0,0)));
        assertEquals(v1.subtract(v3),new Vector2d(19344,-3));
        assertEquals(v3.subtract(v2),new Vector2d(-19383,3));
    }

    @Test
    void doesOppositeOfVectorHaveBothNegatedCoordinates()
    {
        Vector2d v1 = new Vector2d(1,2);
        Vector2d v2 = new Vector2d(40,2);
        Vector2d v3 = new Vector2d(-19343,5);
        Vector2d v4 = new Vector2d(-256,-39);
        Vector2d v5 = new Vector2d(0,0);

        assertEquals(v1.opposite(),new Vector2d(-1,-2));
        assertEquals(v2.opposite(),new Vector2d(-40,-2));
        assertEquals(v3.opposite(),new Vector2d(19343,-5));
        assertEquals(v4.opposite(),new Vector2d(256,39));
        assertEquals(v5.opposite(),new Vector2d(0,0));
    }

    @Test
    void doesOppositeOfVectorNotSwitchOneOrZeroCoordinates()
    {
        Vector2d v1 = new Vector2d(1,10);
        Vector2d v2 = new Vector2d(30,26);
        Vector2d v3 = new Vector2d(-19343,5);

        assertNotEquals(v1.opposite(),new Vector2d(1,-10));
        assertNotEquals(v2.opposite(),new Vector2d(-30,26));
        assertNotEquals(v3.opposite(),new Vector2d(-19343,5));
    }

}