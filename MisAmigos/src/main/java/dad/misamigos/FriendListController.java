package dad.misamigos;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class FriendListController implements Initializable {

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

    }

    public GridPane getRoot() {
        return root;
    }

    @FXML
    void onPhotoAction(ActionEvent event) {

    }

}

