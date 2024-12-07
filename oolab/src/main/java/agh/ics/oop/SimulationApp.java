package agh.ics.oop;

import agh.ics.oop.model.*;
import agh.ics.oop.presenter.SimulationPresenter;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class SimulationApp extends Application
{
    public void start(Stage primaryStage) throws IOException, IllegalArgumentException, IncorrectPositionException {
        primaryStage.show();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getClassLoader().getResource("simulation.fxml"));
        BorderPane viewRoot = loader.load();
        SimulationPresenter presenter = loader.getController();


        //
        RectangularMap map = new RectangularMap(5,5);
        map.addMapChangeListener(presenter); //
        List<Vector2d> animalPositions = List.of(new Vector2d(2,2));

        presenter.setWorldMap(map);

        List<String> inputParameters =  getParameters().getRaw();

        String[] params = inputParameters.toArray(new String[0]);
        List<MoveDirection> moveDirectionParameters = OptionsParser.parse(params);
        Simulation simulation = new Simulation(animalPositions,moveDirectionParameters,map);
        simulation.run();

        //
        configureStage(primaryStage, viewRoot);
    }

    // WIDOK <-> STAGE
    private void configureStage(Stage primaryStage, BorderPane viewRoot) {
        var scene = new Scene(viewRoot);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Simulation app");
        primaryStage.minWidthProperty().bind(viewRoot.minWidthProperty());
        primaryStage.minHeightProperty().bind(viewRoot.minHeightProperty());
        ///
    }
}
