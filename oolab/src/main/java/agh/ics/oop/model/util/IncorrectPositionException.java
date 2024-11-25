package agh.ics.oop.model.util;

import agh.ics.oop.model.Vector2d;

// wstawiony do util, gdyż nie stanowi o
// podstawowej funkcjonalnosci programu
public class IncorrectPositionException extends Exception
{
    public IncorrectPositionException(Vector2d position)
    {
        super("Position " + position + " is not correct");
    }
}
