package dad.misamigos;

import javafx.beans.Observable;
import javafx.beans.property.ListProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class RootController implements Initializable {

    //controllers

    private final FriendListController friendListController = new FriendListController();

    //model

    private final ListProperty<Friend> friends = new SimpleListProperty<>(FXCollections.observableArrayList(
            friend -> new Observable[] { friend.nameProperty(), friend.surnameProperty()} //indicamos que properties de cada bean son observables dentor de la lista
    ));

    private final ObjectProperty<Friend> selectFriend = new SimpleObjectProperty<>();

    //view

    @FXML
    private Button enemyButton;

    @FXML
    private Button friendButton;

    @FXML
    private ListView<Friend> friendList;

    @FXML
    private BorderPane root;

    @FXML
    private VBox emptyBox;

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
    public void initialize(URL location, ResourceBundle resources) {

        // bindings

        friendList.itemsProperty().bind(friends);
        selectFriend.bind(friendList.getSelectionModel().selectedItemProperty());
        enemyButton.disableProperty().bind(selectFriend.isNull());
        selectFriend.addListener(this::onSelectFriendChanged);
        friendListController.friendProperty().bind(selectFriend);

    }

    private void onSelectFriendChanged(ObservableValue<? extends Friend> o, Friend ov, Friend nv) {
        if (nv == null) {
            root.setCenter(emptyBox);
        } else {
            root.setCenter(friendListController.getRoot());
        }
    }

    public BorderPane getRoot() {
        return root;
    }

    @FXML
    void onEnemyAction(ActionEvent event) {

        friends.remove(selectFriend.get());

    }

    @FXML
    void onFriendAction(ActionEvent event) {

        Friend friend = new Friend();
        friend.setName("Nombre");
        friend.setSurname("Apellido");
        friends.add(friend);
        friendList.getSelectionModel().select(friend);

    }

    public ObservableList<Friend> getFriends() {
        return friends.get();
    }

    public ListProperty<Friend> friendsProperty() {
        return friends;
    }
}