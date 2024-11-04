package agh.ics.oop.model;

import java.util.HashMap;
import java.util.Map;
import agh.ics.oop.model.util.MapVisualizer;

public class RectangularMap implements WorldMap,MoveValidator
{
    Map<Vector2d, Animal> animals = new HashMap<>();
    final private Vector2d lowerLeftCornerOfMap = new Vector2d(0,0);
    final private Vector2d higherRightCornerOfMap;
    final private int width;
    final private int height;

    RectangularMap (int width, int height)
    {
        this.width = width;
        this.height = height;
        higherRightCornerOfMap = new Vector2d(width,height);
    }


    @Override
    public boolean place(Animal animal)
    {
        if (isOccupied(animal.getPosition()))
        {
            return false;
        }
        else
        {
            animals.put(animal.getPosition(), animal);
            return true;
        }
    }

    @Override
    public void move(Animal animal, MoveDirection direction)
    {
        animal.move(direction,this);
    }

    @Override
    public boolean isOccupied(Vector2d position)
    {
        return animals.containsKey(position);
    }

    @Override
    public Animal objectAt(Vector2d position)
    { return animals.get(position); }


    @Override
    public boolean canMoveTo(Vector2d position)
    {
        return position.follows(lowerLeftCornerOfMap) && position.precedes(higherRightCornerOfMap);
    }

}


