package agh.ics.oop.model;

import agh.ics.oop.model.util.MapVisualizer;

import java.util.HashMap;
import java.util.Map;

public class GrassField implements WorldMap,MoveValidator
{
    private final int numberOfGrassLumps;
    private final MapVisualizer mapVisualizer;
    private final Map<Vector2d,Grass> grassLumps = new HashMap<Vector2d,Grass>();
    private final Map<Vector2d,Animal> animals = new HashMap<Vector2d,Animal>();


    public GrassField(int numberOfGrassLumps, MapVisualizer mapVisualizer)
    {
        this.numberOfGrassLumps = numberOfGrassLumps;
        this.mapVisualizer = mapVisualizer;
    /*
    tu ma sobie generowac losowo kepki trawowe :) <- w sumie od razu na srebrna skrzynke mozna
    */

    }

    @Override
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

    @Override
    public void move(Animal animal, MoveDirection direction)
    {
        animals.remove(animal.getPosition());
        animal.move(direction, this);
        animals.put(animal.getPosition(), animal);
    }

    @Override
    public String toString()
    {
        return mapVisualizer.draw(lowerLeftCorner(),upperRightCorner());
    }

    @Override
    public boolean isOccupied(Vector2d position) // sprawdza tylko dla zwierzaka
    {
        return animals.containsKey(position);
    }

    @Override
    public WorldElement objectAt(Vector2d position)
    {
        if ( animals.containsKey(position) )
        {
            return animals.get(position);
        }
        else if ( grassLumps.containsKey(position) )
        {
            return grassLumps.get(position);
        }
        else
        {
            return null;
        }
    }

    @Override
    public boolean canMoveTo(Vector2d position) // tylko dla zwierzakow
    {
        return !isOccupied(position);
    }

    private Vector2d lowerLeftCorner()
    {
        int minX = Integer.MAX_VALUE;
        int minY = Integer.MAX_VALUE;

        for ( Vector2d animalPosition : animals.keySet() )
        {
            minX = Math.min(animalPosition.getX(),minX);
            minY = Math.min(animalPosition.getY(),minY);
        }

        for ( Vector2d grassPosition : grassLumps.keySet() )
        {
            minX = Math.min(grassPosition.getX(),minX);
            minY = Math.min(grassPosition.getY(),minY);
        }

        return new Vector2d(minX,minY);
    }

    private Vector2d upperRightCorner()
    {
        int maxX = Integer.MIN_VALUE;
        int maxY = Integer.MIN_VALUE;

        for ( Vector2d animalPosition : animals.keySet() )
        {
            maxX = Math.min(animalPosition.getX(),maxX);
            maxY = Math.min(animalPosition.getY(),maxY);
        }

        for ( Vector2d grassPosition : grassLumps.keySet() )
        {
            maxX = Math.min(grassPosition.getX(),maxX);
            maxY = Math.min(grassPosition.getY(),maxY);
        }

        return new Vector2d(maxX,maxY);
    }
}
