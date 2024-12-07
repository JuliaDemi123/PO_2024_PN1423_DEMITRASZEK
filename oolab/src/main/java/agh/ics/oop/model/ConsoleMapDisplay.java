package agh.ics.oop.model;

public class ConsoleMapDisplay implements MapChangeListener {
    private int numberOfChanges = 0;

    @Override
    public synchronized void mapChanged(WorldMap worldMap, String message) {
            System.out.println(message);
            System.out.println(worldMap.toString());
            numberOfChanges++;
            System.out.println("Number of operations: " + numberOfChanges);
            System.out.println("Map id: " + worldMap.getId());
    }
}

