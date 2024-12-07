package agh.ics.oop;

import java.util.ArrayList;
import java.util.concurrent.CountDownLatch;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class SimulationEngine
{
    private final List<Simulation> simulationList;
    private final List<Thread> threads = new ArrayList<>();
    private final ExecutorService threadPool = Executors.newFixedThreadPool(4);

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
        for (Simulation simulation : simulationList)
        {
            Thread simulationThread = new Thread(simulation);
            threads.add(simulationThread);
            threads.getLast().start();
        }
    }

    public void runAsyncInThreadPool()
    {
        for (Simulation simulation : simulationList)
        {
        threadPool.submit(simulation);
        }
    }


    public void awaitSimulationsEnd()
    {
        try {
            for (Thread thread : threads)
            {
                thread.join(); // program nie zakonczy sie gdy glowny watek skonczy prace tylko pozostale do niego dolacza
            }
            threadPool.shutdown();
            if (!threadPool.awaitTermination(10, TimeUnit.SECONDS))
            {
                threadPool.shutdownNow();
            }
        }
        catch (InterruptedException e) { e.printStackTrace(); }
    }

}
