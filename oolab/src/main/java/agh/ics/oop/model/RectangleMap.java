package agh.ics.oop.model;

import java.util.HashMap;
import java.util.Map;
import agh.ics.oop.model.util.MapVisualizer;

public class RectangularMap implements WorldMap
{
    Map<Vector2d, Animal> animals = new HashMap<>();
    final private int width;
    final private int height;

    RectangularMap (int width, int height)
    {
        this.width = width;
        this.height = height;
    }


    @Override
    public boolean place(Animal animal)
    {
        if (animals.containsKey(animal.getPosition()))
        {
            return false;
        }
        else
        {
            animals.put(animal.getPosition(), animal);
            return true;
        }
    }

    public 

}


