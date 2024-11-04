package agh.ics.oop;

import agh.ics.oop.model.*;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Simulation
{
    private final List<Animal> animals = new ArrayList<Animal>();
    private final List<MoveDirection> movements;

    public Simulation(List<Vector2d> defaultPositions, List<MoveDirection> movements)
    {
        this.movements = movements;

        for(Vector2d position : defaultPositions)
        {
            animals.add(new Animal(position));
        }

    }

    public void run()
    {
        int ind = 0;
        for (MoveDirection direction : movements)
        {
            animals.get(ind).move(direction);
            System.out.println( String.format("Zwierze %d: %s", ind, animals.get(ind).toString()) );
            ind = (ind+1) % animals.size(); // wyliczanie indeksu nastepnego rozpatrywanego zwierzecia w tablicy
        }
    }

    public List<Animal> getAnimals()
    {
        return animals;
    }

}
