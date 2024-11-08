package dad.micv.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.MenuBar;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.layout.BorderPane;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class RootController implements Initializable {

    @FXML
    private TabPane containerTabPane;

    @FXML
    private BorderPane root;

    @FXML
    private MenuBar shortsMenuBar;

    public RootController() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/RootController.fxml"));
            loader.setController(this);
            loader.load();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Tab personalTab = new Tab("Personal");
        Tab contactoTab = new Tab("Contacto");
        Tab formacionTab = new Tab("Formación");
        Tab experienciaTab = new Tab("Experiencia");
        Tab conocimientosTab = new Tab("Conocimientos");
    }

    @FXML
    void onExitAction(ActionEvent event) {

    }

    @FXML
    void onNewAction(ActionEvent event) {

    }

    @FXML
    void onOpenAction(ActionEvent event) {

    }

    @FXML
    void onSaveAction(ActionEvent event) {

    }

    @FXML
    void onSaveAsAction(ActionEvent event) {

    }

    public BorderPane getRoot() {
        return root;
    }

}

