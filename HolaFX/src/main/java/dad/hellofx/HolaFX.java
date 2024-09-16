package dad.hellofx;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class HolaFX extends Application {
    @Override
    public void start(Stage stage) throws Exception {

        Label saludoLabel = new Label();
        saludoLabel.setText("Aquí te manda el saludo :)");
        saludoLabel.setLayoutX(20); //coordenada x del label
        saludoLabel.setLayoutY(20); //coordenada y del label

        Button saludoBoton = new Button();
        saludoBoton.setText("Pulsa aquí pa ganar un iphone 16");
        saludoBoton.setLayoutX(20); //coordenada x del boton
        saludoBoton.setLayoutY(80); //coordenada y del boton
        saludoBoton.setOnAction(event -> stage.close()); //Si pulsas el boton cierra la ventana
        saludoBoton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                System.out.println("Me han pulsado");
            }
        });

        Pane root = new Pane();
        root.setStyle("-fx-background-color: cyan");
        root.getChildren().addAll(saludoLabel, saludoBoton);

        Scene scene = new Scene(root, 328, 280);

        stage.setScene(scene);
        stage.setTitle("HolaFX");
        stage.setResizable(false);
        stage.show();
    }
}
