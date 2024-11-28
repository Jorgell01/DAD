package dad.micv.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class ConocimientoController {

    @FXML
    private TextField denominacionField;

    @FXML
    private ComboBox<String> nivelCombo;

    private Stage stage;

    @FXML
    public void initialize() {
        // Inicializar ComboBox de niveles
        nivelCombo.getItems().addAll("Básico", "Medio", "Avanzado");
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    @FXML
    private void onCancel() {
        stage.close();
    }

    @FXML
    private void onCreate() {
        // Lógica para guardar el conocimiento
        stage.close();
    }
}

