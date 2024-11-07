package dad.micv.model;

import com.google.gson.Gson;
import dad.micv.model.adapter.LocalDateAdapter;
import javafx.beans.property.ListProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.ObservableList;
import org.hildan.fxgson.FxGson;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.time.LocalDate;

public class CV {

    private static final Gson GSON = FxGson.fullBuilder()
            .setPrettyPrinting()
            .registerTypeAdapter(LocalDate.class, new LocalDateAdapter())
            .create();

    private final ObjectProperty<Personal> personal = new SimpleObjectProperty<>();
    private final ObjectProperty<Contacto> contacto = new SimpleObjectProperty<>();
    private final ListProperty<Conocimiento> conocimientos = new SimpleListProperty<>();
    private final ListProperty<Experiencia> experiencias = new SimpleListProperty<>();
    private final ListProperty<Titulo> formacion = new SimpleListProperty<>();

    public CV() {
        personal.set(new Personal());
        contacto.set(new Contacto());
    }

    public Personal getPersonal() {
        return personal.get();
    }

    public ObjectProperty<Personal> personalProperty() {
        return personal;
    }

    public void setPersonal(Personal personal) {
        this.personal.set(personal);
    }

    public Contacto getContacto() {
        return contacto.get();
    }

    public ObjectProperty<Contacto> contactoProperty() {
        return contacto;
    }

    public void setContacto(Contacto contacto) {
        this.contacto.set(contacto);
    }

    public ObservableList<Conocimiento> getConocimientos() {
        return conocimientos.get();
    }

    public ListProperty<Conocimiento> conocimientosProperty() {
        return conocimientos;
    }

    public void setConocimientos(ObservableList<Conocimiento> conocimientos) {
        this.conocimientos.set(conocimientos);
    }

    public ObservableList<Experiencia> getExperiencias() {
        return experiencias.get();
    }

    public ListProperty<Experiencia> experienciasProperty() {
        return experiencias;
    }

    public void setExperiencias(ObservableList<Experiencia> experiencias) {
        this.experiencias.set(experiencias);
    }

    public ObservableList<Titulo> getFormacion() {
        return formacion.get();
    }

    public ListProperty<Titulo> formacionProperty() {
        return formacion;
    }

    public void setFormacion(ObservableList<Titulo> formacion) {
        this.formacion.set(formacion);
    }

    public void save(File cvFile) throws IOException {
        Files.writeString(
                cvFile.toPath(),
                GSON.toJson(this),
                StandardCharsets.UTF_8
        );
    }

    public static CV load(File cvFile) throws IOException {
        String json = Files.readString(cvFile.toPath(), StandardCharsets.UTF_8);
        return GSON.fromJson(json, CV.class);
    }
}
