package agh.ics.oop.model;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SortingAnimalsTest
{
    GrassField grassField = new GrassField(5);
    private final Vector2d pos1 = new Vector2d(2,3);
    private final Vector2d pos2 = new Vector2d(0,0);
    private final Vector2d pos3 = new Vector2d(3984,34240);
    private final Vector2d pos4 = new Vector2d(-1,5);
    private final Vector2d pos5 = new Vector2d(-3,-3);
    private final Vector2d pos6 = new Vector2d(-3,-4);
    private final Vector2d pos7 = new Vector2d(-3,-7);

    @Test
    void sortingReturnsEmptyListIfNoValues()
    {
        assertEquals(List.of(),grassField.getOrderedAnimals());
    }

    @Test
    void sortingReturnsCorrectList()
    {
        try {
            Animal animal1 = new Animal(pos1);
            Animal animal2 = new Animal(pos2);
            Animal animal3 = new Animal(pos3);
            Animal animal4 = new Animal(pos4);
            Animal animal5 = new Animal(pos5);

            grassField.place(animal1);
            grassField.place(animal2);
            grassField.place(animal3);
            grassField.place(animal4);
            grassField.place(animal5);

            assertEquals( List.of(animal5,animal4,animal2,animal1,animal3) ,grassField.getOrderedAnimals() );

        } catch (IncorrectPositionException e) {
            System.out.println("TEST : placeReturnsTrueIfValidPosition [FAILED]");
            e.printStackTrace();
        }
    }

    @Test
    void checkIfWorksWithDifferentYValues()
    {
        try {
        Animal animal5 = new Animal(pos5);
        Animal animal6 = new Animal(pos6);
        Animal animal7 = new Animal(pos7);

        grassField.place(animal5);
        grassField.place(animal6);
        grassField.place(animal7);

        assertEquals( List.of(animal7,animal6,animal5) ,grassField.getOrderedAnimals() );

        } catch (IncorrectPositionException e) {
            System.out.println("TEST : placeReturnsTrueIfValidPosition [FAILED]");
            e.printStackTrace();
        }
    }

}
