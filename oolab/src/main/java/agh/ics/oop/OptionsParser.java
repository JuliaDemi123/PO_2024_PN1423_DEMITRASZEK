package agh.ics.oop;

import agh.ics.oop.model.MoveDirection;

import java.util.Arrays;

public class OptionsParser {
    public static MoveDirection[] getDirections(String[] directions)
    {
        MoveDirection[] movement = new MoveDirection[directions.length];
        int ind = 0;
        for (String direction : directions)
        {
            switch (direction)
            {
                case "f" -> {movement[ind] = MoveDirection.FORWARD; ind++;}
                case "b" -> {movement[ind] = MoveDirection.BACKWARD; ind++;}
                case "r" -> {movement[ind] = MoveDirection.RIGHT; ind++;}
                case "l" -> {movement[ind] = MoveDirection.LEFT; ind++;}
            }
        }
        return Arrays.copyOf(movement, ind);
    }
}