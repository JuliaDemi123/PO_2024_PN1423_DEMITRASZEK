package agh.ics.oop;
import java.util.Arrays;
import agh.ics.oop.model.MoveDirection;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

// użyłam ArrayList, dlatego że w symulacji głównie używamy funkcji get, która jest szybsza w ArrayList
// i też dodajemy elementy tylko w momencie utworzenia tej listy/tablicy
// i w całym programie ich również nie usuwamy


public class OptionsParser {
    public static List<MoveDirection> parse(String[] directions)
    {
        List<MoveDirection> movement = new ArrayList<MoveDirection>();
        for (String direction : directions)
        {
            switch (direction)
            {
                case "f" -> {movement.add(MoveDirection.FORWARD);}
                case "b" -> {movement.add(MoveDirection.BACKWARD);}
                case "r" -> {movement.add(MoveDirection.RIGHT);}
                case "l" -> {movement.add(MoveDirection.LEFT);}
            }
        }
        return movement;
    }
}

