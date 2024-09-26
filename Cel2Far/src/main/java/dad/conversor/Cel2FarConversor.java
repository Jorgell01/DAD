package dad.conversor;

import javafx.application.Application;
import javafx.beans.binding.DoubleExpression;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.converter.NumberStringConverter;
import org.w3c.dom.Text;

public class Cel2FarConversor extends Application {

    //view

    private TextField celsiusText, fahrenheitText;

    //model

    private DoubleProperty celcius = new SimpleDoubleProperty();

    @Override
    public void start (Stage primaryStage) throws Exception {

        celsiusText = new TextField();
        celsiusText.setPrefColumnCount(5);

        fahrenheitText = new TextField();
        fahrenheitText.setPrefColumnCount(5);
        fahrenheitText.setEditable(false);


        HBox celciusBox = new HBox(5, new Label("Celcius"), celsiusText);
        celciusBox.setAlignment(Pos.BASELINE_CENTER);

        HBox fahrenheitBox = new HBox(5, new Label("Fahrenheit"), fahrenheitText);
        celciusBox.setAlignment(Pos.BASELINE_CENTER);


        VBox root = new VBox(5, celciusBox, fahrenheitBox);
        root.setAlignment(Pos.CENTER);
        root.setFillWidth(false);

        Scene scene = new Scene(root, 320, 200);

        primaryStage.setTitle("Celcius to Fahrenheit");
        primaryStage.setScene(scene);
        primaryStage.show();

        // bindings

        celsiusText.textProperty().bindBidirectional(celcius, new NumberStringConverter());

        celcius.addListener((o, ov, nv) -> {
            System.out.println("Celcius vale " + nv);
        });

        // (C x 9/5) + 32

        DoubleExpression cel2far = celcius.multiply(9.0 / 5.0).add(32);

        fahrenheitText.textProperty().bind(cel2far.asString());

    }
}
