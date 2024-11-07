package agh.ics.oop.model;

import java.util.HashMap;
import java.util.Map;
import agh.ics.oop.model.util.MapVisualizer;

public class RectangularMap implements WorldMap<Animal,Vector2d>,MoveValidator<Vector2d>
{
    private final Map<Vector2d, Animal> animals = new HashMap<>();
    private final Vector2d lowerLeftCornerOfMap = new Vector2d(0,0);
    private final Vector2d higherRightCornerOfMap;
    private final int width;
    private final int height;
    private final MapVisualizer mapVisualizer;

    public RectangularMap (int width, int height)
    {
        this.width = width;
        this.height = height;
        higherRightCornerOfMap = new Vector2d(width,height);
        mapVisualizer = new MapVisualizer(this);
    }


    @Override
    public boolean place(Animal object)
    {
        if (!canMoveTo(object.getPosition())) // moze sie znalezc tylko na mapie, a nie poza nia, i zwierze nie moze sie znajdowac na zajetym juz polu
        {
            return false;
        }
        else
        {
            animals.put(object.getPosition(), object);
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


