import agh.ics.oop.model.MapDirection;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class MapDirectionTest
{
    @Test
    void testNext()
    {
        for (MapDirection direction : MapDirection.values())
        {
           switch (direction)
           {
               case NORTH -> assertEquals(direction.next(), MapDirection.EAST);
               case SOUTH -> assertEquals(direction.next(), MapDirection.WEST);
               case EAST -> assertEquals(direction.next(), MapDirection.SOUTH);
               case WEST -> assertEquals(direction.next(), MapDirection.NORTH);
           }
        }
    }

    @Test
    void testPrevious()
    {
        for (MapDirection direction : MapDirection.values())
        {
            switch (direction)
            {
                case NORTH -> assertEquals(direction.previous(), MapDirection.WEST);
                case SOUTH -> assertEquals(direction.previous(), MapDirection.EAST);
                case EAST -> assertEquals(direction.previous(), MapDirection.NORTH);
                case WEST -> assertEquals(direction.previous(), MapDirection.SOUTH);
            }
        }
    }
}
