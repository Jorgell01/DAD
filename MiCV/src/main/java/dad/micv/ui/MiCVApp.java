package dad.micv.ui;

import dad.micv.controllers.RootController;
import dad.micv.model.Telefono;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextInputDialog;
import javafx.stage.Stage;

import java.util.Optional;

public class MiCVApp extends Application {

        @Override
        public void start(Stage primaryStage) throws Exception {

//            TextInputDialog nameDialog = new TextInputDialog();
//            nameDialog.initOwner(primaryStage);
//            nameDialog.setHeaderText("Introduce tu nombre: ");
//            nameDialog.setContentText("Nombre: ");
//            nameDialog.showAndWait().ifPresent(System.out::println);

//            TelefonoDialog dialog = new TelefonoDialog();
//            Optional<Telefono> result = dialog.showAndWait();
//            if (result.isPresent()) {
//                Telefono telefono = result.get();
//                System.out.println(telefono.getNumero() + " - " + telefono.getTipo());
//            }

            RootController rootController = new RootController();
            primaryStage.setTitle("MiCV");
            Scene scene = new Scene(rootController.getRoot());
            primaryStage.setScene(scene);
            primaryStage.show();


        }
}
