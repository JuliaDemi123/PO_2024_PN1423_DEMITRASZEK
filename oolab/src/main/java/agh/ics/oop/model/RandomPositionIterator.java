package agh.ics.oop.model;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Random;

public class RandomPositionIterator implements Iterator<Vector2d>
{
    private final RandomPositionGenerator randomPositionGenerator;
    private final Random random = new Random();
    public RandomPositionIterator(RandomPositionGenerator randomPositionGenerator)
    {
        this.randomPositionGenerator = randomPositionGenerator;
    }
    @Override
    public boolean hasNext()
    {
        return randomPositionGenerator.count < randomPositionGenerator.getGrassCount();
    }

    @Override
    public Vector2d next()
    {
        Vector2d newPosition = generateNewPosition();
        randomPositionGenerator.count++;
        return newPosition;
    }

    private Vector2d generateNewPosition()
    {
        int position = randomPositionGenerator.positions.get(random.nextInt(randomPositionGenerator.positions.size()-randomPositionGenerator.getGrassCount()));

        int randomXPosition = (int)position/(randomPositionGenerator.getMaxWidth()+1);
        int randomYPosition = position%(randomPositionGenerator.getMaxHeight()+1);

        Vector2d newPosition = new Vector2d(randomXPosition, randomYPosition);

        int valToBeSwitched = randomPositionGenerator.positions.get(randomPositionGenerator.positions.size() - 1 - randomPositionGenerator.count);

        randomPositionGenerator.positions.set(position,valToBeSwitched);
        return newPosition;

    }

}