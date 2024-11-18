package agh.ics.oop.model;

import agh.ics.oop.model.util.MapVisualizer;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class GrassField extends AbstractWorldMap
{
    private final int grassCount;
    private final Map<Vector2d,Grass> grasses = new HashMap<Vector2d,Grass>();


    public GrassField(int grassCount)
    {
        this.grassCount = grassCount;

        int maxWidth = (int)Math.ceil(Math.sqrt(grassCount*10));
        int maxHeight = (int)Math.ceil(Math.sqrt(grassCount*10));

        RandomPositionGenerator randomPositionGenerator = new RandomPositionGenerator(maxWidth, maxHeight, grassCount);
        for(Vector2d grassPosition : randomPositionGenerator) {
            grasses.put(grassPosition, new Grass(grassPosition));
        }

    }

    @Override
    public String toString() { return mapVisualizer.draw(getLowerLeftCorner(),getUpperRightCorner()); }

    @Override
    public boolean isOccupied(Vector2d position) // sprawdza tylko dla zwierzaka
    {
        return super.isOccupied(position) || grasses.containsKey(position);
    }

    @Override
    public WorldElement objectAt(Vector2d position)
    {
        WorldElement elem = super.objectAt(position);
        if( elem == null )
        {
            if (grasses.containsKey(position)) { return grasses.get(position); }
            return null;
        }
        else
        {
            return elem;
        }
    }

    @Override
    public boolean canMoveTo(Vector2d position) // tylko dla zwierzakow
    {
        return !animals.containsKey(position) && position.getX() < Integer.MAX_VALUE && position.getY() < Integer.MAX_VALUE;
    }

    private Vector2d getLowerLeftCorner()
    {
        int minX = Integer.MAX_VALUE;
        int minY = Integer.MAX_VALUE;

        for ( Vector2d animalPosition : animals.keySet() )
        {
            minX = Math.min(animalPosition.getX(),minX);
            minY = Math.min(animalPosition.getY(),minY);
        }

        for ( Vector2d grassPosition : grasses.keySet() )
        {
            minX = Math.min(grassPosition.getX(),minX);
            minY = Math.min(grassPosition.getY(),minY);
        }

        return new Vector2d(minX,minY);
    }

    private Vector2d getUpperRightCorner()
    {
        int maxX = Integer.MIN_VALUE;
        int maxY = Integer.MIN_VALUE;

        for ( Vector2d animalPosition : animals.keySet() )
        {
            maxX = Math.max(animalPosition.getX(),maxX);
            maxY = Math.max(animalPosition.getY(),maxY);
        }

        for ( Vector2d grassPosition : grasses.keySet() )
        {
            maxX = Math.max(grassPosition.getX(),maxX);
            maxY = Math.max(grassPosition.getY(),maxY);
        }

        return new Vector2d(maxX,maxY);
    }

    public List<WorldElement> getElements()
    {
        List<WorldElement> elementList = super.getElements();
        elementList.addAll((grasses.values()));
        return elementList;
    }
}
