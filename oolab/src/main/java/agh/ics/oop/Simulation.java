package agh.ics.oop;

import agh.ics.oop.model.*;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Simulation
{
    private final List<Animal> animals = new ArrayList<>();
    private final List<MoveDirection> movements;
    private final WorldMap map;

    public Simulation(List<Vector2d> animals, List<MoveDirection> movements, WorldMap map)
    {
        this.movements = movements;
        this.map = map;
        for(Vector2d animal : animals)
        {
            animals.add(animal);
            map.place(new Animal(animal));
        }
    }

    public void run()
    {
        int ind = 0;
        for (MoveDirection direction : movements)
        {

            map.move( map.objectAt( animals.get(ind).getPosition() ), direction); 



            System.out.println(map.toString());
            //System.out.println( String.format("Zwierze %d: %s", ind, animals.get(ind).toString()) );
            ind = (ind+1) % animals.size(); // wyliczanie indeksu nastepnego rozpatrywanego zwierzecia w tablicy
        }

    }

    public List<Animal> getAnimals()
    {
        return animals;
    }

}
