package dad.bindings.observer;

public class ObserbableString extends  Observable<String> {

    private String value;

    public void setValue(String Value) {

        notifyAll(value);
        this.value = value;

    }


    public static void queEstaPasando(String value) {
        System.out.println("El valor de str ha cambiado a " + value);
    }

}
