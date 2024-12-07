package agh.ics.oop.presenter;

import agh.ics.oop.OptionsParser;
import agh.ics.oop.Simulation;
import agh.ics.oop.SimulationApp;
import agh.ics.oop.SimulationEngine;
import agh.ics.oop.model.*;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import java.io.IOException;
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
    @FXML
    private GridPane mapGrid = new GridPane();

    private int clickCounter = 0;
    private Boundary currentBoundary;
    public void setWorldMap(WorldMap map)
    {
        this.worldMap = map;
    }

    @FXML
    void onSimulationStartClicked()
    {
        infoLabel.setText("");
        try
        {
                if (clickCounter > 0) {
                    Platform.runLater(() -> {
                        try {
                            Stage newStage = new Stage();
                            SimulationApp simulationApp = new SimulationApp();
                            simulationApp.start(newStage); // Assuming `start` accepts a `Stage` argument
                        } catch (IOException | IncorrectPositionException e) {
                            e.printStackTrace();
                        }
                    });
                }
            GrassField map = new GrassField(10);
            this.setWorldMap(map);
            map.addMapChangeListener(this);

            verticalLayout.setAlignment(Pos.TOP_CENTER);
            verticalLayout.setSpacing(30);
            // building simulation
            List<Vector2d> animalPositions = List.of(new Vector2d(2, 2), new Vector2d(3, 3));
            Simulation simulation = new Simulation(animalPositions, OptionsParser.parse(textField.getText().split(" ")), worldMap);
            SimulationEngine simulationEngine = new SimulationEngine(List.of(simulation));
            simulationEngine.runAsync();
            synchronized (this)
            {
                clickCounter++;
            }
        } catch (IllegalArgumentException e)
        {
            e.printStackTrace();
        }
    }

    private void clearGrid()
    {
        mapGrid.setGridLinesVisible(false);
        mapGrid.getChildren().retainAll(mapGrid.getChildren().get(0)); // hack to retain visible grid lines
        mapGrid.getColumnConstraints().clear();
        mapGrid.getRowConstraints().clear();
    }

    void drawMap(WorldMap worldMap)
    {
        // getting the grid dimensions
        currentBoundary = worldMap.getCurrentBounds();
        Vector2d dimensions = currentBoundary.upperRightCorner().subtract(currentBoundary.lowerLeftCorner());
                        // map width                        // map height
        addElementsToGrid(dimensions.getX() + 1,dimensions.getY() + 1);
        verticalLayout.setAlignment(Pos.TOP_CENTER);
    }

    @Override
    public void mapChanged(WorldMap worldMap, String message)
    {
        Platform.runLater(() -> {
            clearGrid();
            moveDesc.setText(message);
            drawMap(worldMap);
            mapGrid.setAlignment(Pos.CENTER);
        });
    }

    public void addElementsToGrid(int width,int height)
    {
        // necesary for text
        int minX = currentBoundary.lowerLeftCorner().getX();
        int minY = currentBoundary.lowerLeftCorner().getY();

        Label label = new Label("y/x");
        // border
        GridPane.setHalignment(label, HPos.CENTER);
        mapGrid.add(label, 0, 0);
        mapGrid.getColumnConstraints().add(new ColumnConstraints(30));
        mapGrid.getRowConstraints().add(new RowConstraints(30));

        // columns
        for(int i = 0; i < width ; i++)
        {
            label = new Label(Integer.toString(i+minX));
            GridPane.setHalignment(label, HPos.CENTER);
            mapGrid.add(label,i+1,0);
            mapGrid.getColumnConstraints().add(new ColumnConstraints(30));

        }

        // rows
        for (int i = 0; i < height; i++)
        {
            label = new Label(Integer.toString(i+minY));
            GridPane.setHalignment(label, HPos.CENTER);
            mapGrid.add(label,0,i+1);
            mapGrid.getRowConstraints().add(new RowConstraints(30));
        }

        // elements such as animals and grass
        for(int x = 0; x < width; x++)
        {
            for (int y = 0; y < height; y++)
            {
                Vector2d currentPosition = new Vector2d(x+minX,y+minY);
                if(worldMap.isOccupied(currentPosition))
                {
                    label = new Label(worldMap.objectAt(currentPosition).toString());
                }
                else
                {
                    label = new Label(" ");
                }
                GridPane.setHalignment(label, HPos.CENTER);
                mapGrid.add(label,x+1,y+1);
            }
        }
        mapGrid.setGridLinesVisible(true);
    }
}
