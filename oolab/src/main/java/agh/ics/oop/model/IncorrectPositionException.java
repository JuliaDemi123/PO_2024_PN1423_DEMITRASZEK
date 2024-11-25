package agh.ics.oop.model;

// wstawiony do util, gdyż nie stanowi o
// podstawowej funkcjonalnosci programu
public class IncorrectPositionException extends Exception
{
    public IncorrectPositionException(Vector2d position)
    {
        super("Position " + position + " is not correct");
    }
}
