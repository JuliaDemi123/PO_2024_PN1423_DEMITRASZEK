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
                orientation = switch (orientation)
                {
                    case NORTH -> MapDirection.EAST;
                    case SOUTH -> MapDirection.WEST;
                    case WEST -> MapDirection.NORTH;
                    case EAST -> MapDirection.SOUTH;
                };
                break;
            case LEFT:
                orientation = switch (orientation)
                {
                    case NORTH -> MapDirection.WEST;
                    case SOUTH -> MapDirection.EAST;
                    case WEST -> MapDirection.SOUTH;
                    case EAST -> MapDirection.NORTH;
                };
                break;
            case FORWARD:
                position = newCoordinates(orientation);
                break;
            case BACKWARD:
                position = newCoordinates(orientation);
                break;
        }
    }

     private Vector2d newCoordinates(MapDirection direction)
    {
        Vector2d newCoords = position.add(direction.toUnitVector());
        return new Vector2d( Math.max(0,Math.min(newCoords.getX(),4)), Math.max(0,Math.min(newCoords.getY(),4)));
    }

}
