package agh.ics.oop.model;
import java.util.Objects;

import static java.lang.Math.min;

public class Vector2d {
    private final int x;
    private final int y;

    public Vector2d(int x, int y)
    {
        this.x = x;
        this.y = y;
    }

    public int getX()
    {
        return x;
    }

    public int getY() {
        return y;
    }


    @Override
    public String toString()
     {
        return "(" + x + ", " + y + ")";
     }

    public boolean precedes(Vector2d other)
    {
        return x <= other.x && y <= other.y;
    }
    public boolean follows(Vector2d other)
    {
        return x >= other.x && y >= other.y;
    }

    public Vector2d add(Vector2d other)
    {
        return new Vector2d(x + other.x, y + other.y);
    }

    public Vector2d subtract(Vector2d other)
    {
        return new Vector2d(x - other.x, y - other.y);
    }

    public Vector2d upperRight(Vector2d other)
    {
        return new Vector2d(Math.max(x,other.x),Math.max(y,other.y)); // ?
    }

    public Vector2d lowerLeft(Vector2d other)
    {
        return new Vector2d(Math.min(x,other.x),Math.min(y,other.y));
    }

    public Vector2d opposite(Vector2d other)
    {
        return new Vector2d(-other.x, -other.y);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Vector2d vector2d)) return false;
        return x == vector2d.x && y == vector2d.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}
