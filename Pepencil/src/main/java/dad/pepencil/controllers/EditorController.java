package dad.pepencil.controllers;

import javafx.beans.Observable;
import javafx.beans.binding.Bindings;
import javafx.beans.property.*;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.TextArea;
import javafx.scene.layout.AnchorPane;

import java.beans.BeanInfo;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.util.ResourceBundle;

public class EditorController implements Initializable {

    // model

    private final ObjectProperty<File> file = new SimpleObjectProperty<>();
    private final ReadOnlyStringWrapper name = new ReadOnlyStringWrapper("Untitled");
    private final StringProperty content = new SimpleStringProperty();
    private final BooleanProperty hasChanges = new SimpleBooleanProperty();

    @FXML
    private TextArea editArea;

    @FXML
    private AnchorPane root;

    public EditorController() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/EditorView.fxml"));
            loader.setController(this);
            loader.load();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        // bindings

        file.addListener(this::onFileChanged);

        editArea.textProperty().bindBidirectional(content);

        content.addListener(this::onContentChanged);

        name.bind(Bindings.createStringBinding(this::updateName, file, hasChanges));


    }

    public AnchorPane getRoot() {
        return root;
    }

    //listeners

    public void onContentChanged(Observable o, String ov, String nv) {
        hasChanges.set(true);
    }

    private String updateName() {
        return (file.get() == null ? "Untitled" : file.get().getName()) + (hasChanges.get() ? "*" : "");
    }

    private void onFileChanged(Observable o, File ov, File nv) {
        if (nv != null) {
            open();
        }
    }

    public void open() {
        try {
            this.content.set(Files.readString(file.get().toPath()));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void cut() {
        editArea.cut();
    }

    public void copy() {
        editArea.copy();
    }

    public void redo() {
        editArea.redo();
    }

    public void paste() {
        editArea.paste();
    }

    public void undo() {
        editArea.undo();
    }

    // getter & setter


    public File getFile() {
        return file.get();
    }

    public ObjectProperty<File> fileProperty() {
        return file;
    }

    public void setFile(File file) {
        this.file.set(file);
    }

    public String getName() {
        return name.get();
    }

    public ReadOnlyStringProperty nameProperty() {
        return name.getReadOnlyProperty();
    }
}
