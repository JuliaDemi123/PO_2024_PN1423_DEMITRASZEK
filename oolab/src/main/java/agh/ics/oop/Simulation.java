package agh.ics.oop;

import agh.ics.oop.model.*;
import org.w3c.dom.css.Rect;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Simulation<T,P>
{
    private final List<T> objects = new ArrayList<>();
    private final List<MoveDirection> movements;
    private final WorldMap<T,P> map;

    public Simulation(List<P> objectPositions, List<MoveDirection> movements, WorldMap<T,P> map)
    {
        this.movements = movements;
        this.map = map;
        Integer ind = 0;
        for(P position : objectPositions)
        {
            //T a = new T(position);
            T newObject = createObject(map,position);
            if ((map instanceof RectangularMap && map.canMoveTo(position)) || map instanceof TextMap) // nie ma innego zwierzaka na tym miejscu
            {
                map.place(newObject);
                this.objects.add(newObject);
            }
        }
    }

    public <T,P> void run()
    {
        int ind = 0;
        for (MoveDirection direction : movements)
        {
            map.move( objects.get(ind) , direction ); // zwierze powinno sie zmodyfikowac tutaj automatycznie
            System.out.println(map.toString());
            ind = (ind+1) % objects.size(); // wyliczanie indeksu nastepnego rozpatrywanego zwierzecia w tablicy
        }

    }

    private T createObject(WorldMap<T,P> Map, P position)
    {
        if (Map instanceof TextMap)
        {
            return (T) new String();
        }
        else if(Map instanceof RectangularMap)
        {
            return (T) new Animal((Vector2d) position);
        }
        return null;
    }

}



