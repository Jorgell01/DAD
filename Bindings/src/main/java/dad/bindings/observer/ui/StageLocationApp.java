package dad.bindings.observer.ui;

import javafx.stage.Stage;
import dad.bindings.observer.ObserbableString;

public class StageLocationApp {

    private Stage stage;
    private ObserbableString observableCoordinates;

    public StageLocationApp(Stage stage, ObserbableString observableCoordinates) {
        this.stage = stage;
        this.observableCoordinates = observableCoordinates;
    }

    public void start() {
        stage.xProperty().addListener((obs, oldVal, newVal) -> updateCoordinates());
        stage.yProperty().addListener((obs, oldVal, newVal) -> updateCoordinates());
    }

    private void updateCoordinates() {
        String coordinates = String.format("%.0f, %.0f", stage.getX(), stage.getY());
        observableCoordinates.setValue(coordinates); // Actualizamos las coordenadas observables
    }
}
