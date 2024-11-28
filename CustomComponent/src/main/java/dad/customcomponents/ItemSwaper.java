// ItemSwaper.java
package dad.customcomponents;

import javafx.beans.property.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.GridPane;
import javafx.event.ActionEvent;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ItemSwaper<T> extends GridPane implements Initializable {

    // model
    private ListProperty<T> leftItems = new SimpleListProperty<>(FXCollections.observableArrayList());
    private ListProperty<T> rightItems = new SimpleListProperty<>(FXCollections.observableArrayList());
    private StringProperty leftTitle = new SimpleStringProperty();
    private StringProperty rightTitle = new SimpleStringProperty();
    private ObjectProperty<T> selectedLeft = new SimpleObjectProperty<>();
    private ObjectProperty<T> selectedRight = new SimpleObjectProperty<>();

    // view
    @FXML
    private Label leftLabel;

    @FXML
    private ListView<T> leftList;

    @FXML
    private Button moveAllLeftButton;

    @FXML
    private Button moveAllRightButton;

    @FXML
    private Button moveLeftButton;

    @FXML
    private Button moveRightButton;

    @FXML
    private Label rightLabel;

    @FXML
    private ListView<T> rightList;

    public ItemSwaper() {
        super();
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/ItemSwaperView.fxml"));
            loader.setController(this);
            loader.setRoot(this);
            loader.load();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        // Bindings
        leftList.itemsProperty().bind(leftItems);
        rightList.itemsProperty().bind(rightItems);
        leftLabel.textProperty().bind(leftTitle);
        rightLabel.textProperty().bind(rightTitle);
        selectedLeft.bind(leftList.getSelectionModel().selectedItemProperty());
        selectedRight.bind(rightList.getSelectionModel().selectedItemProperty());
    }

    @FXML
    void onLeftAction(ActionEvent event) {
        // Move selectedLeft to right
    }

    @FXML
    void onLeftAllAction(ActionEvent event) {
        // Move all left to right
    }

    @FXML
    void onRightAction(ActionEvent event) {
        // Move selectedRight to left
    }

    @FXML
    void onRightAllAction(ActionEvent event) {
        // Move all right to left
    }

    // Getters and Setters
    public ObservableList<T> getLeftItems() {
        return leftItems.get();
    }

    public ListProperty<T> leftItemsProperty() {
        return leftItems;
    }

    public void setLeftItems(ObservableList<T> leftItems) {
        this.leftItems.set(leftItems);
    }

    public ObservableList<T> getRightItems() {
        return rightItems.get();
    }

    public ListProperty<T> rightItemsProperty() {
        return rightItems;
    }

    public void setRightItems(ObservableList<T> rightItems) {
        this.rightItems.set(rightItems);
    }

    public String getLeftTitle() {
        return leftTitle.get();
    }

    public StringProperty leftTitleProperty() {
        return leftTitle;
    }

    public void setLeftTitle(String leftTitle) {
        this.leftTitle.set(leftTitle);
    }

    public String getRightTitle() {
        return rightTitle.get();
    }

    public StringProperty rightTitleProperty() {
        return rightTitle;
    }

    public void setRightTitle(String rightTitle) {
        this.rightTitle.set(rightTitle);
    }
}