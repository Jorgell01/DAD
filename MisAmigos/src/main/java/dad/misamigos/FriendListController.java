package dad.misamigos;

import javafx.beans.binding.Bindings;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.stage.FileChooser;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class FriendListController implements Initializable {

    private static final Image NO_PHOTO = new Image("/images/pacman_icon.png");

    //model

    private final ObjectProperty<Friend> friend = new SimpleObjectProperty<>();

    //View

    @FXML
    private ImageView ImageView;

    @FXML
    private Button Listener;

    @FXML
    private TextField apellidoText;

    @FXML
    private DatePicker birthDate;

    @FXML
    private TextField emailText;

    @FXML
    private TextField nombreText;

    @FXML
    private TextField phoneNumberText;

    @FXML
    private GridPane root;

    public FriendListController() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/FriendView.fxml"));
            loader.setController(this);
            loader.load();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        friend.addListener(this::onFriendChanged);

    }

    private void onFriendChanged(ObservableValue<? extends Friend> o, Friend ov, Friend nv) {

        if (ov != null) {

            nombreText.textProperty().unbindBidirectional(ov.nameProperty());
            apellidoText.textProperty().unbindBidirectional(ov.surnameProperty());
            birthDate.valueProperty().unbindBidirectional(ov.birthDateProperty());
            emailText.textProperty().unbindBidirectional(ov.emailProperty());
            phoneNumberText.textProperty().unbindBidirectional(ov.phoneNumberProperty());
            ImageView.imageProperty().unbind();

        }

        if (nv != null) {

            nombreText.textProperty().bindBidirectional(nv.nameProperty());
            apellidoText.textProperty().bindBidirectional(nv.surnameProperty());
            birthDate.valueProperty().bindBidirectional(nv.birthDateProperty());
            emailText.textProperty().bindBidirectional(nv.emailProperty());
            phoneNumberText.textProperty().bindBidirectional(nv.phoneNumberProperty());
            ImageView.imageProperty().bind(
                    Bindings.when(nv.photoProperty().isNull())
                            .then(new Image("/images/pacman_icon.png"))
                            .otherwise(nv.photoProperty())
            );

        }

    }

    public GridPane getRoot() {
        return root;
    }

    @FXML
    void onPhotoAction(ActionEvent event) {

        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Seleccionar foto");
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Imagen", "*.jpeg", "*.png", "*.jpg"));
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Todos los archivos", "*.*"));
        File imageFile = fileChooser.showOpenDialog(getRoot().getScene().getWindow());
        if (imageFile != null) {
            Image photo = new Image(imageFile.toURI().toString());
            friend.get().setPhoto(photo);
        }

    }

    public Friend getFriend() {
        return friend.get();
    }

    public ObjectProperty<Friend> friendProperty() {
        return friend;
    }

    public void setFriend(Friend friend) {
        this.friend.set(friend);
    }
}

