package agh.ics.oop.model;

// --do 11-- Dodaj do interfejsu metodę getElements(), która zwróci kolekcję wszystkich elementów na mapie.
// Dopisz brakujące implementacje tej metody wykorzystując przygotowaną hierarchię klas tak, by nie powtarzać kodu.
//
// zwracac niemodyfikowalna liste

public class Grass implements WorldElement
{
    private final Vector2d position;
    public Grass(Vector2d position)
    {
        this.position = position;
    }

    @Override
    public Vector2d getPosition()
    {
        return position;
    }

    @Override
    public String toString()
    {
        return "*";
    }
}
