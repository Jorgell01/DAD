package dad.micv.ui;

import dad.micv.model.Telefono;
import javafx.application.Application;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextInputDialog;
import javafx.stage.Stage;

import java.util.Optional;

public class MiCVApp extends Application {

        @Override
        public void start(Stage pirmaryStage) throws Exception {

//            TextInputDialog nameDialog = new TextInputDialog();
//            nameDialog.initOwner(primaryStage);
//            nameDialog.setHeaderText("Introduce tu nombre: ");
//            nameDialog.setContentText("Nombre: ");
//            nameDialog.showAndWait().ifPresent(System.out::println);

            TelefonoDialog dialog = new TelefonoDialog();
            Optional<Telefono> result = dialog.showAndWait();
            if (result.isPresent()) {
                Telefono telefono = result.get();
                System.out.println(telefono.getNumero() + " - " + telefono.getTipo());
            }
        }


}
