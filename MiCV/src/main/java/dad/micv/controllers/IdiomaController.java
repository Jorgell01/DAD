package dad.micv.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.control.ComboBox;
import javafx.stage.Stage;

public class IdiomaController {

    @FXML
    private TextField denominacionField;

    @FXML
    private ComboBox<String> nivelCombo;

    @FXML
    private TextField certificacionField;

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
        // Lógica para guardar idioma
        stage.close();
    }
}
