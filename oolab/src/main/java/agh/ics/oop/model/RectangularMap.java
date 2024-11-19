package agh.ics.oop.model;

import java.util.HashMap;
import java.util.Map;

import agh.ics.oop.model.util.IncorrectPositionException;
import agh.ics.oop.model.util.MapVisualizer;

// implements WorldMap,MoveValidator

public class RectangularMap extends AbstractWorldMap
{
    private final Vector2d lowerLeftCornerOfMap = new Vector2d(0,0);
    private final Vector2d higherRightCornerOfMap;
    private final int width;
    private final int height;

    public RectangularMap (int width, int height)
    {
        this.width = width-1;
        this.height = height-1;
        higherRightCornerOfMap = new Vector2d(width-1,height-1);
    }

    @Override
    public void place(Animal animal) throws IncorrectPositionException
    {
        super.place(animal);
    }

    @Override
    public String toString()
    {
        return mapVisualizer.draw(lowerLeftCornerOfMap, higherRightCornerOfMap);
    }

    @Override
    public boolean canMoveTo(Vector2d position)
    {
        return position.follows(lowerLeftCornerOfMap) && position.precedes(higherRightCornerOfMap) && !isOccupied(position);
    }

}


