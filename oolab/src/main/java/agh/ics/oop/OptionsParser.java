package agh.ics.oop;

import agh.ics.oop.model.MoveDirection;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class OptionsParser {
    public static List<MoveDirection> getDirections(String[] directions)
    {
        List<MoveDirection> movement = new LinkedList<MoveDirection>();
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