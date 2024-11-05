package agh.ics.oop;

import agh.ics.oop.model.*;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Simulation
{
    private final List<Animal> animals = new ArrayList<>();
    private final List<Vector2d> animalPositions;
    private final List<MoveDirection> movements;
    private final WorldMap map;

    public Simulation(List<Vector2d> animals, List<MoveDirection> movements, WorldMap map)
    {
        this.movements = movements;
        this.map = map;
        this.animalPositions = animals;
        for(Vector2d animal : animals)
        {
            this.animals.add( new Animal(animal) );
            map.place(new Animal(animal));
        }
    }

    public void run()
    {
        int ind = 0;
        for (MoveDirection direction : movements)
        {
            map.move(  map.objectAt(animals.get(ind).getPosition()) , direction ); // zwierze powinno sie zmodyfikowac tutaj automatycznie
            System.out.println(map.toString());
            ind = (ind+1) % animals.size(); // wyliczanie indeksu nastepnego rozpatrywanego zwierzecia w tablicy
        }

    }

    public List<Vector2d> getAnimalPositions()
    {
        return animalPositions;
    }

}
