package dad.micv.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class TituloController {

    @FXML
    private TextField denominacionField;

    @FXML
    private TextField organizadorField;

    @FXML
    private DatePicker desdeDatePicker;

    @FXML
    private DatePicker hastaDatePicker;

    private Stage stage;

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    @FXML
    private void onCancel() {
        stage.close();
    }

    @FXML
    private void onCreate() {
        // Lógica para guardar el título
        stage.close();
    }
}
