package agh.ics.oop.model;

import java.util.HashMap;
import java.util.Map;
import agh.ics.oop.model.util.MapVisualizer;

public class RectangularMap implements WorldMap,MoveValidator
{
    private Map<Vector2d, Animal> animals = new HashMap<>();
    final private Vector2d lowerLeftCornerOfMap = new Vector2d(0,0);
    final private Vector2d higherRightCornerOfMap;
    final private int width;
    final private int height;
    private MapVisualizer mapVisualizer;

    public RectangularMap (int width, int height)
    {
        this.width = width;
        this.height = height;
        higherRightCornerOfMap = new Vector2d(width,height);
        mapVisualizer = new MapVisualizer(this);
    }


    @Override
    public boolean place(Animal animal)
    {
        if (!canMoveTo(animal.getPosition())) // moze sie znalezc tylko na mapie
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
    public String toString()
    {
        return mapVisualizer.draw(lowerLeftCornerOfMap, higherRightCornerOfMap);
    }

    @Override
    public void move(Animal animal, MoveDirection direction)
    {
        if ( objectAt(animal.getPosition()) == animal )
        {
            animals.remove(animal.getPosition());
            animal.move(direction, this);
            animals.put(animal.getPosition(), animal);
        }
    }

    @Override
    public boolean isOccupied(Vector2d position)
    {
        return animals.containsKey(position);
    }

    @Override
    public Animal objectAt(Vector2d position)
    {
        return isOccupied(position) ? animals.get(position) : null;
    }


    @Override
    public boolean canMoveTo(Vector2d position)
    {
        return position.follows(lowerLeftCornerOfMap) && position.precedes(higherRightCornerOfMap) && !isOccupied(position);
    }

}


