package agh.ics.oop;

import agh.ics.oop.model.MoveDirection;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

// użyłam ArrayList, dlatego że w symulacji głównie używamy funkcji get, która jest szybsza w ArrayList
// i też dodajemy elementy tylko w momencie utworzenia tej listy/tablicy
// i w całym programie ich również nie usuwamy


public class OptionsParser {
    public static List<MoveDirection> parse(String[] directions) throws IllegalArgumentException
    {
        return Stream.of(directions).map(
                        direction -> switch (direction) {
                                case "f", "forward" -> MoveDirection.FORWARD;
                                case "b", "backward" -> MoveDirection.BACKWARD;
                                case "r", "right" -> MoveDirection.RIGHT;
                                case "l", "left" -> MoveDirection.LEFT;
                                default -> {throw new IllegalArgumentException(direction + " is not legal move specification");}
                                }
                ).collect(Collectors.toList());
    }
}