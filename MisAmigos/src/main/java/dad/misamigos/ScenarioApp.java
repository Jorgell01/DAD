package dad.misamigos;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.hildan.fxgson.FxGson;

import java.io.File;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.time.LocalDate;

public class ScenarioApp extends Application {

    private final RootController rootController = new RootController();

    @Override
    public void init() throws Exception {
        // cargar los amigos desde el fichero json
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        primaryStage.setTitle("Mis Amigos");
        primaryStage.setScene(new Scene(rootController.getRoot()));
        primaryStage.show();
    }

    @Override
    public void stop() throws Exception {
        //guardar los amigos en el fichero json
        File friendsFile = new File("friends.json");
        Gson gson = FxGson.fullBuilder()
                .setPrettyPrinting()
                .registerTypeAdapter(LocalDate.class, new LocalDateAdapter())
                .create();
        String json = gson.toJson(rootController.getFriends());
        Files.writeString(friendsFile.toPath(), json, StandardCharsets.UTF_8);
        System.out.println("Cambios guardados en el fichero " + friendsFile);
    }
}
