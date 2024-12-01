package agh.ics.oop;

import java.util.ArrayList;
import java.util.concurrent.CountDownLatch;
import java.util.List;

public class SimulationEngine
{
    private final List<Simulation> simulationList;
    private final List<Thread> threads = new ArrayList<>();
    private CountDownLatch latch;

    public SimulationEngine(List<Simulation> simulationList)
    {
        this.simulationList = simulationList;
    }

    public void runSync()
    {
        for(Simulation simulation : simulationList)
        {
            simulation.run();
        }
    }

    public void runAsync()
    {
        latch = new CountDownLatch(simulationList.size());
        for (Simulation simulation : simulationList)
        {
            try
            {
                Thread simulationThread = new Thread(simulation);
                threads.add(simulationThread);
                threads.getLast().start();
                latch.countDown();
            } catch (Exception e)
            {
                System.out.println("An error with a threads creation");
            }
            latch.countDown();
        }
    }

    public void awaitSimulationsEnd()
    {
        try {
            if (latch != null) {
                latch.await(); // Czeka na zakończenie wszystkich symulacji
            }
        }
        catch (InterruptedException e) { e.printStackTrace(); }
    }

}
