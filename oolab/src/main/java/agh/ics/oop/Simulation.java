package agh.ics.oop;

import agh.ics.oop.model.*;
import agh.ics.oop.model.util.IncorrectPositionException;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Simulation
{
    private final List<Animal> animals = new ArrayList<>();
    private final List<Vector2d> animalPositions = new ArrayList<>();
    private final List<MoveDirection> movements;
    private final WorldMap map;

    public Simulation(List<Vector2d> animals, List<MoveDirection> movements, WorldMap map)
    {
        this.movements = movements;
        this.map = map;
        for(Vector2d animal : animals)
        {
             Animal a = new Animal(animal);
             try
             {
                 map.place(a); // ?
                 this.animals.add(a);
                 this.animalPositions.add(a.getPosition());
             }
             catch (IncorrectPositionException e) {} // zwierze nie zostalo dodane, swiadoma decyzja ze w catchu nic nie ma

        }
    }

    public void run()
    {
        int ind = 0;
        for (MoveDirection direction : movements)
        {
            map.move( animals.get(ind) , direction ); // zwierze powinno sie zmodyfikowac tutaj automatycznie
            animalPositions.set(ind,animals.get(ind).getPosition());
            ind = (ind+1) % animals.size(); // wyliczanie indeksu nastepnego rozpatrywanego zwierzecia w tablicy
        }

    }

    public List<Vector2d> getAnimalPositions()
    {
        return animalPositions;
    }

}
