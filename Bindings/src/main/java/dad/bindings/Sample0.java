package dad.bindings;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;

public class Sample0 {

    public static void main(String[] args) {

        DoubleProperty a = new SimpleDoubleProperty(10);

        DoubleProperty b = new SimpleDoubleProperty();
        b.addListener((observable, oldValue, newValue) -> {
            System.out.println("antes " + oldValue + " y ahora " + newValue);
        });
        b.bind(a.multiply(10));

        a.set(5);

        DoubleProperty c = new SimpleDoubleProperty();
        c.bind(b.subtract(15).multiply(a));

        
    }
}
