package agh.ics.oop.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TextMap implements WorldMap<String,Integer>, MoveValidator<Integer>
{
    // mapa nie ma gornej granicy
    private final List<String> strings = new ArrayList<>();
    private final Map<String,Integer> stringToIndex = new HashMap<>();

    @Override
    public boolean place (String text)
    {
        strings.add(text);
        stringToIndex.put(text, strings.size()-1);
        return true;
    }

    @Override
    public void move(String text, MoveDirection direction)
    {
        Integer index = stringToIndex.get(text);
        Integer nextIndex;
        if (direction == MoveDirection.LEFT || direction == MoveDirection.BACKWARD)
        {
            nextIndex = index - 1;
        }
        else
        {
            nextIndex = index + 1;
        }

        if (canMoveTo(nextIndex))
        {
            String swappedText = strings.get(nextIndex);
            strings.set(nextIndex, text);
            strings.set(index, swappedText);
            stringToIndex.put(text, nextIndex);
            stringToIndex.put(swappedText, index);
        }

    }

    @Override
    public boolean isOccupied(Integer index)
    {
        return canMoveTo(index);
    }

    @Override
    public String objectAt(Integer index)
    {
        return isOccupied(index) ? strings.get(index) : null;
    }

    @Override
    public boolean canMoveTo(Integer index)
    {
        return index >= 0 && index < strings.size();
    }


    @Override
    public String toString() { return strings.toString(); }

    private Integer getStringToIndex(String text)
    {
        return stringToIndex.get(text);
    }

}
