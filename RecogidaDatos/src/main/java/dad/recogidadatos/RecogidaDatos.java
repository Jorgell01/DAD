package dad.recogidadatos;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javafx.scene.layout.VBox;

import java.io.File;
import java.nio.file.Files;
import java.io.IOException;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;


public class RecogidaDatos extends Application {

    private TextField nombreUser;
    private Label labelnombreUser;
    private TextField apellidoUser;
    private Label labelapellidoUser;
    private TextField edadUser;
    private Label labeledadUser;
    private Button botonGuardar;
    private Button botonLimpiar;

    @Override
    public void start(Stage stage) throws Exception {

        nombreUser = new TextField();
        nombreUser.setPromptText("Introduce tu nombre aquí");
        nombreUser.setPrefColumnCount(15);

        labelnombreUser = new Label("Nombre: ");

        apellidoUser = new TextField();
        apellidoUser.setPromptText("Introduce tu apellido aquí");
        apellidoUser.setPrefColumnCount(15);

        labelapellidoUser = new Label("Apellido: ");

        edadUser = new TextField();
        edadUser.setPromptText("Introduce tu edad aquí");
        edadUser.setPrefColumnCount(13);

        labeledadUser = new Label("Edad: ");

        botonGuardar = new Button();
        botonGuardar.setText("Guardar");
        botonGuardar.setDefaultButton(true);
        botonGuardar.setOnAction(actionEvent -> guardarDatos());

        botonLimpiar = new Button();
        botonLimpiar.setText("Limpiar");
        botonLimpiar.setOnAction(actionEvent -> limpiarDatos());


        HBox Hboxnombre = new HBox();
        Hboxnombre.setSpacing(5);
        Hboxnombre.setAlignment(Pos.CENTER);
        Hboxnombre.getChildren().addAll(labelnombreUser, nombreUser);

        HBox Hboxapellido = new HBox();
        Hboxapellido.setSpacing(5);
        Hboxapellido.setAlignment(Pos.CENTER);
        Hboxapellido.getChildren().addAll(labelapellidoUser, apellidoUser);

        HBox Hboxedad = new HBox();
        Hboxedad.setSpacing(5);
        Hboxedad.setAlignment(Pos.CENTER);
        Hboxedad.getChildren().addAll(labeledadUser, edadUser);

        HBox Hboxbotones = new HBox();
        Hboxbotones.setSpacing(5);
        Hboxbotones.setAlignment(Pos.CENTER);
        Hboxbotones.getChildren().addAll(botonGuardar, botonLimpiar);

        VBox root = new VBox();
        root.setStyle("-fx-background-color: #a569bd");
        root.setSpacing(5);
        root.setFillWidth(false);
        root.setAlignment(Pos.CENTER);
        root.getChildren().addAll(Hboxnombre, Hboxapellido, Hboxedad, Hboxbotones);

        Scene scene = new Scene(root, 500, 260);

        stage.setTitle("Registro Dato");
        stage.setScene(scene);
        stage.show();

    }

    private void guardarDatos() {
        Persona p = new Persona();
        p.setNombre(nombreUser.getText());
        p.setApellidos(apellidoUser.getText());
        p.setEdad(Integer.parseInt(edadUser.getText()));

        Gson gson = new GsonBuilder()
                .setPrettyPrinting()
                .create();
        String json = gson.toJson(p);

        File jsonFile = new File("datos.json");
        try {
            Files.writeString(jsonFile.toPath(), json);
        } catch (IOException e) {
            e.printStackTrace();
        }
        nombreUser.clear();
        apellidoUser.clear();
        edadUser.clear();
    }

    private void limpiarDatos () {
        nombreUser.clear();
        apellidoUser.clear();
        edadUser.clear();
    }
}
