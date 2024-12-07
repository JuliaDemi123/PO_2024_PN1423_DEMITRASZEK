package agh.ics.oop.presenter;

import agh.ics.oop.model.MapChangeListener;
import agh.ics.oop.model.WorldMap;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;

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

    void onSimulationStartClicked()
    {

    }

    void drawMap(WorldMap worldMap)
    {
        verticalLayout.setAlignment(Pos.TOP_CENTER);
        infoLabel.setText(worldMap.toString()); // ??
    }

    @Override
    public void mapChanged(WorldMap worldMap, String message) {
        drawMap(worldMap);
    }
}
