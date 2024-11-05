package dad.micv.model;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Nacionalidad {

    private final StringProperty denominacion = new SimpleStringProperty();

    public final String getDenominacion() {
        return this.denominacion.get();
    }

    public final void setDenominacion(final String denominacion) {
        this.denominacion.set(denominacion);
    }

    public final StringProperty denominacionProperty() {
        return this.denominacion;
    }

}
