package agh.ics.oop;

import agh.ics.oop.model.MoveDirection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class OptionsParser {
    public static List<MoveDirection> getDirections(String[] directions)
    {
        List<MoveDirection> movement = new ArrayList<>();
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

//        MoveDirection[] movement = new MoveDirection[directions.length];
//        int ind = 0;
//        for (String direction : directions)
//        {
//            switch (direction)
//            {
//                case "f" -> {movement[ind] = MoveDirection.FORWARD; ind++;}
//                case "b" -> {movement[ind] = MoveDirection.BACKWARD; ind++;}
//                case "r" -> {movement[ind] = MoveDirection.RIGHT; ind++;}
//                case "l" -> {movement[ind] = MoveDirection.LEFT; ind++;}
//            }
//        }
//        return Arrays.copyOf(movement, ind);
    }
}