package agh.ics.oop.model;

import agh.ics.oop.model.util.MapVisualizer;

import java.util.*;

public abstract class AbstractWorldMap implements MoveValidator,WorldMap
{
    protected final Map<Vector2d, Animal> animals = new HashMap<>(); //
    protected final MapVisualizer mapVisualizer = new MapVisualizer(this);
    private final List<MapChangeListener> mapChangeListeners = new ArrayList<>();
    private static int nextMapId = 0;
    private final int currentId = nextMapId;

    public void place(Animal animal) throws IncorrectPositionException
    {
        if (!canMoveTo(animal.getPosition())) // moze sie znalezc tylko na mapie, a nie poza nia, i zwierze nie moze sie znajdowac na zajetym juz polu
        {
            throw new IncorrectPositionException(animal.getPosition());
        }
        else
        {
            animals.put(animal.getPosition(), animal);
            mapChanged("An animal placed at " + animal.getPosition());
        }
    }

    public abstract Boundary getCurrentBounds();

    public synchronized String toString()
    {
        Boundary boundary = getCurrentBounds();
        return mapVisualizer.draw(boundary.lowerLeftCorner(), boundary.upperRightCorner());
    }

    public abstract boolean canMoveTo(Vector2d position);
    public boolean isOccupied(Vector2d position)
    {
        return animals.containsKey(position);
    } // moge wykorzystac funkcjonalnosc w grassfieldzie

    public WorldElement objectAt(Vector2d position)
    { return isOccupied(position) ? animals.get(position) : null; }

    public void move(Animal animal, MoveDirection direction)
    {
        animals.remove(animal.getPosition());
        animal.move(direction, this);
        animals.put(animal.getPosition(), animal);
        mapChanged("An animal moved to " + animal.getPosition());
    }

    public List<WorldElement> getElements()
    {
        return new ArrayList<>(animals.values());
    }

    public void addMapChangeListener(MapChangeListener listener)
    {
        mapChangeListeners.add(listener);
    }

    public void removeMapChangeListener(MapChangeListener listener)
    {
        mapChangeListeners.remove(listener);
    }

    private void mapChanged(String message)
    {
        for (MapChangeListener listener : mapChangeListeners)
        {
            listener.mapChanged(this, message);
        }
    }

    public synchronized int getId() {
        return currentId;
    }

    protected synchronized void increaseId()
    {
        nextMapId++;
    }
}
