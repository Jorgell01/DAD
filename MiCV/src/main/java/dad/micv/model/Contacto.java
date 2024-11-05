package dad.micv.model;

import javafx.beans.property.ListProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.collections.FXCollections;

public class Contacto {

    //Contacto Lista de Telefono, Email y Web
    private final ListProperty<Telefono> telefonos = new SimpleListProperty<>(FXCollections.observableArrayList());
    private final ListProperty<Email> emails = new SimpleListProperty<>(FXCollections.observableArrayList());
    private final ListProperty<Web> webs = new SimpleListProperty<>(FXCollections.observableArrayList());

    public final ListProperty<Telefono> telefonosProperty() {
        return this.telefonos;
    }

    public final javafx.collections.ObservableList<dad.micv.model.Telefono> getTelefonos() {
        return this.telefonosProperty().get();
    }

    public final void setTelefonos(final javafx.collections.ObservableList<dad.micv.model.Telefono> telefonos) {
        this.telefonosProperty().set(telefonos);
    }

    public final ListProperty<Email> emailsProperty() {
        return this.emails;
    }

    public final javafx.collections.ObservableList<dad.micv.model.Email> getEmails() {
        return this.emailsProperty().get();
    }

    public final void setEmails(final javafx.collections.ObservableList<dad.micv.model.Email> emails) {
        this.emailsProperty().set(emails);
    }

    public final ListProperty<Web> websProperty() {
        return this.webs;
    }

    public final javafx.collections.ObservableList<dad.micv.model.Web> getWebs() {
        return this.websProperty().get();
    }

    public final void setWebs(final javafx.collections.ObservableList<dad.micv.model.Web> webs) {
        this.websProperty().set(webs);
    }

}
