package agh.ics.oop.model;

import java.util.Objects;

public class Animal
{
    private MapDirection orientation;
    private Vector2d position;


    public Animal(Vector2d position)
    {
        this.position = position;
        this.orientation = MapDirection.NORTH;
    }

    public Animal()
    {
        this( new Vector2d(2,2) );
    }

    public String toString()
    {
        return orientation.toString();
    }

    public boolean isAt(Vector2d position)
    {
        return this.position.equals(position);
    }

    public Vector2d getPosition()
    {
        return position;
    }

    public MapDirection getOrientation()
    {
        return orientation;
    }

    public void move(MoveDirection direction,MoveValidator validator)
    {
        Vector2d newPosition;
        switch (direction)
        {
            case RIGHT:
                orientation = orientation.next();
                break;
            case LEFT:
                orientation = orientation.previous();
                break;
            case FORWARD:
                 newPosition = position.add(orientation.toUnitVector());
                if (validator.canMoveTo(newPosition))
                {
                    position = newPosition;
                }
                break;
            case BACKWARD:
                 newPosition = position.subtract(orientation.toUnitVector()); // ?
                if (validator.canMoveTo(newPosition))
                {
                    position = newPosition;
                }
                break;
        }
    }

}
