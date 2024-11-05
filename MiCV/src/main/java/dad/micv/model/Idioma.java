package dad.micv.model;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Idioma extends Conocimiento {

    private final StringProperty certificacion = new SimpleStringProperty();

    public final String getCertificacion() {
        return this.certificacion.get();
    }

    public final void setCertificacion(final String certificacion) {
        this.certificacion.set(certificacion);
    }

    public final StringProperty certificacionProperty() {
        return this.certificacion;
    }

}
