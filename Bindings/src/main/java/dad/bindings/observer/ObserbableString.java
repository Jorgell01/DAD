package dad.bindings.observer;

public class ObserbableString extends Observable<String> {

    private String value;

    public ObserbableString(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
        notifyAll(value); // Notificamos a todos los observadores el nuevo valor
    }
}
