package dad.micv.model;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Web {

    private final StringProperty url = new SimpleStringProperty();

    public String getUrl() {
        return url.get();
    }

    public StringProperty urlProperty() {
        return url;
    }

    public void setUrl(String url) {
        this.url.set(url);
    }
}
