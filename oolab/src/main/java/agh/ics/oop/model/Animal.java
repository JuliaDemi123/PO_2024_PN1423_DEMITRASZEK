package agh.ics.oop.model;

public class Animal
{
    private MapDirection direction;
    private Vector2d position;

    public Animal()
    {
        this.position = new Vector2d(2,2);
        this.direction = MapDirection.NORTH;
    }

    public Animal(Vector2d position)
    {
        this.position = position;
        this.direction = MapDirection.NORTH;
    }
    public String toString()
    {
        return position.toString() + " " + direction.toString();
    }

    public boolean isAt(Vector2d position)
    {
        return this.position.equals(position);
    }
}
