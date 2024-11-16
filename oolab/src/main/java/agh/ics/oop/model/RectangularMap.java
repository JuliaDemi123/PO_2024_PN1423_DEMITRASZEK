package agh.ics.oop.model;

import java.util.HashMap;
import java.util.Map;
import agh.ics.oop.model.util.MapVisualizer;

// implements WorldMap,MoveValidator

public class RectangularMap extends AbstractWorldMap
{
    private final Map<Vector2d, Animal> animals = new HashMap<>();
    private final Vector2d lowerLeftCornerOfMap = new Vector2d(0,0);
    private final Vector2d higherRightCornerOfMap;
    private final int width;
    private final int height;
    private final MapVisualizer mapVisualizer;

    public RectangularMap (int width, int height)
    {
        this.width = width-1;
        this.height = height-1;
        higherRightCornerOfMap = new Vector2d(width-1,height-1);
        mapVisualizer = new MapVisualizer(this);
    }

    @Override
    public boolean place(Animal animal)
    {
        return super.place(animal);
    }
//
//    @Override
//    public boolean place(Animal animal)
//    {
////        if (!canMoveTo(animal.getPosition())) // moze sie znalezc tylko na mapie, a nie poza nia, i zwierze nie moze sie znajdowac na zajetym juz polu
////        {
////            return false;
////        }
////        else
////        {
////            animals.put(animal.getPosition(), animal);
////            return true;
////        }
//    }

    @Override
    public String toString()
    {
        return mapVisualizer.draw(lowerLeftCornerOfMap, higherRightCornerOfMap);
    }

//    @Override
//    public void move(Animal animal, MoveDirection direction)
//    {
//        animals.remove(animal.getPosition());
//        animal.move(direction, this);
//        animals.put(animal.getPosition(), animal);
//    }

//    @Override
//    public boolean isOccupied(Vector2d position)
//    {
//        return animals.containsKey(position);
//    }
//

//    @Override
//    public Animal objectAt(Vector2d position)
//    {
//        return isOccupied(position) ? animals.get(position) : null;
//    }

//    @Override
//    public Animal objectAt(Vector2d position)
//    {
//        return super.objectAt(position);
//    }


    @Override
    public boolean canMoveTo(Vector2d position)
    {
        return position.follows(lowerLeftCornerOfMap) && position.precedes(higherRightCornerOfMap) && !isOccupied(position);
    }

}


