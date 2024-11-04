package agh.ics.oop.model;

public class Animal
{
    private MapDirection orientation;
    private Vector2d position;

    public Animal()
    {
        this.position = new Vector2d(2,2);
        this.orientation = MapDirection.NORTH;
    }

    public Animal(Vector2d position)
    {
        this.position = position;
        this.orientation = MapDirection.NORTH;
    }

    public String toString()
    {
        return position.toString() + " " + orientation.toString();
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

    public void move(MoveDirection direction)
    {
        switch (direction)
        {
            case RIGHT:
                orientation = orientation.next();
                break;
            case LEFT:
                orientation = orientation.previous();
                break;
            case FORWARD:
                position = newPosition( position.add(orientation.toUnitVector()) );
                break;
            case BACKWARD:
                position = newPosition( position.subtract(orientation.toUnitVector()) );
                break;
        }
    }

     private Vector2d newPosition(Vector2d newCoords)
    {
        return new Vector2d( Math.max(0,Math.min(newCoords.getX(),4)), Math.max(0,Math.min(newCoords.getY(),4)));
    }

}
