package dad.bindings.observer;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.geometry.Pos;
import javafx.beans.binding.Bindings;

public class HelloBindings extends Application {

    private TextField nameText;
    private Label greetingsLabel;
    private CheckBox hasNameCheck;

    @Override
    public void start(Stage stage) {
        nameText = new TextField();
        nameText.setPromptText("Introduce el nombre");

        greetingsLabel = new Label();
        hasNameCheck = new CheckBox("¿Hay un nombre?");

        VBox root = new VBox(5);
        root.setFillWidth(true);
        root.setAlignment(Pos.CENTER);
        root.getChildren().addAll(nameText, greetingsLabel, hasNameCheck);

        Scene scene = new Scene(root, 640, 480);

        stage.setTitle("Hello Bindings");
        stage.setScene(scene);
        stage.show();

        greetingsLabel.textProperty().bind(
                Bindings.concat(
                        "!Hola ",
                        Bindings.when(nameText.textProperty().isEmpty())
                                .then("a todo el mundo")
                                .otherwise(nameText.textProperty()),
                        "¡"
                )
        );

        hasNameCheck.selectedProperty().bind(nameText.textProperty().isNotEmpty());
    }
}
