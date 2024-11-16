package agh.ics.oop.model;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class RandomPositionGenerator implements Iterable<Vector2d>
{
    protected final int maxWidth;
    protected final int maxHeight;
    protected final int grassCount;
    protected int count = 0;
    protected List<Integer> positions = new ArrayList<Integer>();

    public RandomPositionGenerator(int maxWidth, int maxHeight, int grassCount)
    {
        this.maxWidth = maxWidth;
        this.maxHeight = maxHeight;
        this.grassCount = grassCount;

        // gdyby maxWidth != maxHeight
        for ( int i = 0; i <= (maxWidth+1)*(maxHeight+1); i++ )
        {
            positions.add(i);
        }
    }

    @Override
    public Iterator<Vector2d> iterator() {
        return new RandomPositionIterator(this);
    }
}

