package dad.micv.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.TableView;
import javafx.stage.Stage;

public class ContactoController {

    @FXML
    private TableView<String> telefonosTable;

    @FXML
    private TableView<String> emailsTable;

    @FXML
    private TableView<String> websTable;

    private Stage stage;

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    @FXML
    private void onAddTelefono() {
        // Lógica para agregar teléfono
    }

    @FXML
    private void onDeleteTelefono() {
        // Lógica para eliminar teléfono
    }

    @FXML
    private void onAddEmail() {
        // Lógica para agregar email
    }

    @FXML
    private void onDeleteEmail() {
        // Lógica para eliminar email
    }

    @FXML
    private void onAddWeb() {
        // Lógica para agregar web
    }

    @FXML
    private void onDeleteWeb() {
        // Lógica para eliminar web
    }
}
