package dad.escenarioMVC;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.util.converter.NumberStringConverter;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ModificarController implements Initializable {

    // View con los atributos creados en SceneBuilder

    private IntegerProperty value = new SimpleIntegerProperty();
    private IntegerProperty temp = new SimpleIntegerProperty();

    @FXML
    private VBox root;

    @FXML
    private Label valueLabel;

    @FXML
    private TextField valueText;

    // instanciar los siguientes atributos
    ModificarController() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/ModificarView.fxml"));
            loader.setController(this);
            loader.load();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        value.addListener((o, ov, nv) -> {
            System.out.println("value ha cambiado " + getValue());
        });
        valueText.textProperty().bindBidirectional(temp, new NumberStringConverter());
    }

    // devuelve la raiz del scene graph de la vista del controlador
    public VBox getRoot() {
        return root;
    }

    @FXML
    private void onSetAction(ActionEvent e) {
        System.out.println("Establecer");
        setValue(temp.get());
    }

    @FXML
    private void onIncrementAction(ActionEvent event) {
        System.out.println("Incrementar");
    }

    @FXML
    private void onDecrementAction(ActionEvent event) {
        System.out.println("Disminuir");
    }

    public int getValue() {
        return value.get();
    }

    public void setValue(int newValue) {
        value.set(newValue);
    }

    public IntegerProperty valueProperty() {
        return value;
    }
}
