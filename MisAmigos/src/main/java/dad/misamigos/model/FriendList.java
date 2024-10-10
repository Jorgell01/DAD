package dad.misamigos.model;

import javafx.beans.property.SimpleListProperty;
import javafx.collections.FXCollections;

public class FriendList extends SimpleListProperty<Friend> {
    public FriendList() {
        super(FXCollections.observableArrayList());
    }
}
