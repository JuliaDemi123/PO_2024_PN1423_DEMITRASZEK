package agh.ics.oop.model;

import java.util.HashMap;
import java.util.Map;

import agh.ics.oop.model.IncorrectPositionException;
import agh.ics.oop.model.util.MapVisualizer;

// implements WorldMap,MoveValidator

public class RectangularMap extends AbstractWorldMap
{
    private final Vector2d lowerLeftCornerOfMap = new Vector2d(0,0);
    private final Vector2d higherRightCornerOfMap;
    private final int width;
    private final int height;
    private final Boundary boundary;

    public RectangularMap (int width, int height)
    {
        super();
        this.width = width-1;
        this.height = height-1;
        higherRightCornerOfMap = new Vector2d(width-1,height-1);
        boundary = new Boundary(lowerLeftCornerOfMap,higherRightCornerOfMap);
        super.increaseId();
    }

    @Override
    public void place(Animal animal) throws IncorrectPositionException
    {
        super.place(animal);
    }

    @Override
    public Boundary getCurrentBounds() {
        return boundary;
    }

    @Override
    public boolean canMoveTo(Vector2d position)
    {
        return position.follows(lowerLeftCornerOfMap) && position.precedes(higherRightCornerOfMap) && !isOccupied(position);
    }

}


