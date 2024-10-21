package agh.ics.oop.model;

public class Vector2d {
    private final int x;
    private final int y;

    Vector2d(int x, int y)
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

    String toString()
    {
        return "(" + x + ", " + y + ")";
    }

    boolean precedes(Vector2d other)
    {
        
    }
}
