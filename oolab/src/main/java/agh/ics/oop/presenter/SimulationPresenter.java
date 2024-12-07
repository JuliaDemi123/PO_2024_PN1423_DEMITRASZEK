package agh.ics.oop.presenter;

import agh.ics.oop.OptionsParser;
import agh.ics.oop.Simulation;
import agh.ics.oop.SimulationEngine;
import agh.ics.oop.model.*;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;

import java.util.List;

public class SimulationPresenter implements MapChangeListener
{
    private WorldMap worldMap;

    @FXML
    private Label infoLabel = new Label();
    @FXML
    private TextField textField = new TextField();
    @FXML
    private Button startButton = new Button();
    @FXML
    private Label moveDesc = new Label();
    @FXML
    private VBox verticalLayout = new VBox();

    public void setWorldMap(WorldMap map)
    {
        this.worldMap = map;
    }

    @FXML
    void onSimulationStartClicked()
    {
        try
        {
            RectangularMap map = new RectangularMap(10,10);
            this.setWorldMap(map);
            map.addMapChangeListener(this);

            // budowanie simulation
            List<Vector2d> animalPositions = List.of(new Vector2d(2, 2), new Vector2d(3, 3));
            Simulation simulation = new Simulation(animalPositions, OptionsParser.parse(textField.getText().split(" ")), worldMap);
            SimulationEngine simulationEngine = new SimulationEngine(List.of(simulation));
            simulationEngine.runAsync();

        } catch (IllegalArgumentException e)
        {
            e.printStackTrace();
        }
    }

    void drawMap(WorldMap worldMap)
    {
        verticalLayout.setAlignment(Pos.TOP_CENTER);
        infoLabel.setText(worldMap.toString());
    }

    @Override
    public void mapChanged(WorldMap worldMap, String message)
    {
        Platform.runLater(() -> {
            drawMap(worldMap);
            // ewentualny inny kod zmieniający kontrolki
        });
    }
}
