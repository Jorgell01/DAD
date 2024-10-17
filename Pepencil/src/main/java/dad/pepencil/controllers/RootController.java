package dad.pepencil.controllers;

import javafx.beans.property.MapProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleMapProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.FileChooser;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class RootController implements Initializable {

    //model

    private ObjectProperty<Tab>  selectedTab = new SimpleObjectProperty<>();

    //logic

    private MapProperty<Tab, EditorController> controllers = new SimpleMapProperty(FXCollections.observableHashMap());

    //view

    @FXML
    private TabPane editionTabPane;

    @FXML
    private BorderPane root;

    public RootController() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/RootView.fxml"));
            loader.setController(this);
            loader.load();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
        public void initialize(URL url, ResourceBundle resourceBundle) {

        // eliminar las pestañas default
        editionTabPane.getTabs().clear();

        newFile();

        // bindings

        selectedTab.bind(editionTabPane.getSelectionModel().selectedItemProperty());

    }

    public BorderPane getRoot() {
        return root;
    }

    @FXML
    void onCloseAction(ActionEvent event) {

    }

    @FXML
    void onCloseAllAction(ActionEvent event) {

    }

    @FXML
    void onCopyAction(ActionEvent event) {

        Tab selectedTab= editionTabPane.getSelectionModel().getSelectedItem();
        EditorController controller = controllers.get(selectedTab);
        controller.copy();

    }

    @FXML
    void onCutAction(ActionEvent event) {
        controllers.get(selectedTab.get()).cut();
    }

    @FXML
    void onDoAction(ActionEvent event) {

        Tab selectedTab= editionTabPane.getSelectionModel().getSelectedItem();
        EditorController controller = controllers.get(selectedTab);
        controller.redo();

    }

    @FXML
    void onExitAction(ActionEvent event) {

    }

    @FXML
    void onNewAction(ActionEvent event) {

        newFile();

    }

    private EditorController newFile() {
        EditorController editorController = new EditorController();

        Tab newTab = new Tab();
        newTab.setContent(editorController.getRoot());
        newTab.textProperty().bind(editorController.nameProperty());

        editionTabPane.getTabs().add(newTab);
        controllers.put(newTab, editorController);
        editionTabPane.getSelectionModel().select(newTab);  // seleccionamos la pestaña que acabamos de añadir

        return editorController;
    }

    @FXML
    void onOpenAction(ActionEvent event) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Todos los archivos (*.*)", "*.*"));
        File file = fileChooser.showOpenDialog(getRoot().getScene().getWindow());
        if (file != null) {
            EditorController controller = newFile();
            controller.setFile(file);
        }
        fileChooser.setTitle("Open File");
    }

    @FXML
    void onPasteAction(ActionEvent event) {

        Tab selectedTab= editionTabPane.getSelectionModel().getSelectedItem();
        EditorController controller = controllers.get(selectedTab);
        controller.paste();

    }

    @FXML
    void onSaveAction(ActionEvent event) {

    }

    @FXML
    void onSaveAsAction(ActionEvent event) {

    }

    @FXML
    void onUndoAction(ActionEvent event) {

        Tab selectedTab= editionTabPane.getSelectionModel().getSelectedItem();
        EditorController controller = controllers.get(selectedTab);
        controller.undo();

    }

}
