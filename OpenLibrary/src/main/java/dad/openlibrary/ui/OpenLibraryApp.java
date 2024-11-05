package dad.openlibrary.ui;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class OpenLibraryApp extends Application {

    private RootController rootController = new RootController();

    @Override
    public void start(Stage primaryStage) throws Exception {
        RootController rootController = new RootController();

        primaryStage.setTitle("OpenLibrary");
        primaryStage.setScene(new Scene(RootController.getRoot()));
        primaryStage.show();
    }

}
