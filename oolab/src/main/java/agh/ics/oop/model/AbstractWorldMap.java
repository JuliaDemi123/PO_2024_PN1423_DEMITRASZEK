package agh.ics.oop.model;

import java.util.HashMap;
import java.util.Map;

public abstract class AbstractWorldMap implements MoveValidator
{
    private final Map<Vector2d, Animal> animals = new HashMap<>();
    public boolean place(Animal animal)
    {
        if (!canMoveTo(animal.getPosition())) // moze sie znalezc tylko na mapie, a nie poza nia, i zwierze nie moze sie znajdowac na zajetym juz polu
        {
            return false;
        }
        else
        {
            animals.put(animal.getPosition(), animal);
            return true;
        }
    }

    public abstract boolean canMoveTo(Vector2d position);
    public abstract boolean isOccupied(Vector2d position);

    public void move(Animal animal, MoveDirection direction)
    {
        animals.remove(animal.getPosition());
        animal.move(direction, this);
        animals.put(animal.getPosition(), animal);
    }

    public abstract String toString();
}
