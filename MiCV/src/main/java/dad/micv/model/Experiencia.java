package dad.micv.model;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Experiencia {
    private final StringProperty desde = new SimpleStringProperty();
    private final StringProperty hasta = new SimpleStringProperty();
    private final StringProperty denominacion = new SimpleStringProperty();
    private final StringProperty empleador = new SimpleStringProperty();

    public String getDesde() {
        return desde.get();
    }

    public StringProperty desdeProperty() {
        return desde;
    }

    public void setDesde(String desde) {
        this.desde.set(desde);
    }

    public String getHasta() {
        return hasta.get();
    }

    public StringProperty hastaProperty() {
        return hasta;
    }

    public void setHasta(String hasta) {
        this.hasta.set(hasta);
    }

    public String getDenominacion() {
        return denominacion.get();
    }

    public StringProperty denominacionProperty() {
        return denominacion;
    }

    public void setDenominacion(String denominacion) {
        this.denominacion.set(denominacion);
    }

    public String getEmpleador() {
        return empleador.get();
    }

    public StringProperty empleadorProperty() {
        return empleador;
    }

    public void setEmpleador(String empleador) {
        this.empleador.set(empleador);
    }
}
