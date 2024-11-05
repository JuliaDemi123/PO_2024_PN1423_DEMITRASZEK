package agh.ics.oop;

import agh.ics.oop.model.*;

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
            if(map.place(a)) // nie ma innego zwierzaka na tym miejscu
            {
                this.animals.add( a );
                this.animalPositions.add( a.getPosition() );
            }
        }
    }

    public void run()
    {
        int ind = 0;
        for (MoveDirection direction : movements)
        {
            map.move(  map.objectAt(animals.get(ind).getPosition()) , direction ); // zwierze powinno sie zmodyfikowac tutaj automatycznie
            animalPositions.set(ind,animals.get(ind).getPosition());
            System.out.println(map.toString());
            ind = (ind+1) % animals.size(); // wyliczanie indeksu nastepnego rozpatrywanego zwierzecia w tablicy
        }

    }

    public List<Vector2d> getAnimalPositions()
    {
        return animalPositions;
    }

}
