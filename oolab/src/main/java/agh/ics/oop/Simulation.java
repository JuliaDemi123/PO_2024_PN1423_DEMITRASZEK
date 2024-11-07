package agh.ics.oop;

import agh.ics.oop.model.*;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Simulation<T,P>
{
    private final List<T> objects = new ArrayList<>();
    private final List<P> objectPositions = new ArrayList<>();
    private final List<MoveDirection> movements;
    private final WorldMap<T,P> map;

    public <T,P> Simulation(List<P> objectPositions, List<MoveDirection> movements, WorldMap<T,P> map)
    {
        this.movements = movements;
        this.map = map;
        int i = 0;
        for(P position : objectPositions)
        {
            T a = new T(position);
            if(map.place(a)) // nie ma innego zwierzaka na tym miejscu
            {
                this.objects.add(new T());
                this.objectPositions.add( position );
            }
        }
    }

    public <T,P> void run()
    {
        int ind = 0;
        for (MoveDirection direction : movements)
        {
            map.move(  map.objectAt(objects.get(ind).getPosition()) , direction ); // zwierze powinno sie zmodyfikowac tutaj automatycznie
            objectPositions.set(ind,objects.get(ind).getPosition());
            System.out.println(map.toString());
            ind = (ind+1) % objects.size(); // wyliczanie indeksu nastepnego rozpatrywanego zwierzecia w tablicy
        }

    }

    public <P> List<P> getAnimalPositions()
    {
        return objectPositions;
    }

}
