package agh.ics.oop.model;

public enum MapDirection {
    NORTH,
    SOUTH,
    WEST,
    EAST;
    private static final Vector2d VectorNorth = new Vector2d(0,1);
    private static final Vector2d VectorSouth = new Vector2d(0,-1);
    private static final Vector2d VectorWest = new Vector2d(-1,0);
    private static final Vector2d VectorEast = new Vector2d(1,0);
    public String toString()
    {
        return switch (this) {
            case NORTH -> "Północ";
            case SOUTH -> "Południe";
            case WEST -> "Zachód";
            case EAST -> "Wschód";
        };
    }
    public MapDirection next()
    {
        return switch (this) {
            case NORTH -> EAST;
            case SOUTH -> WEST;
            case WEST -> NORTH;
            case EAST -> SOUTH;
        };
    }

    public MapDirection previous()
    {
        return switch (this) {
            case NORTH -> WEST;
            case SOUTH -> EAST;
            case WEST -> SOUTH;
            case EAST -> NORTH;
        };
    }

    public Vector2d toUnitVector()
    {
        return switch (this) {
            case NORTH -> VectorNorth;
            case SOUTH -> VectorSouth;
            case WEST -> VectorWest;
            case EAST -> VectorEast;
        };
    }
}
