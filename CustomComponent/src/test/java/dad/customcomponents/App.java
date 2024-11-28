package dad.customcomponents;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.SplitPane;
import javafx.stage.Stage;

public class App extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {

        ItemSwaper<String> swaper1 = new ItemSwaper<>();
        swaper1.setLeftTitle("Equipado");
        swaper1.setRightTitle("Inventario");
        swaper1.getLeftItems().addAll("Espada", "Escudo", "Casco", "Pocion");
        swaper1.getRightItems().addAll("Daga", "Arco", "Botas", "Pocion");

        ItemSwaper<Integer> swaper2 = new ItemSwaper<>();
        swaper2.setLeftTitle("Equipado");
        swaper2.setRightTitle("Inventario");
        swaper2.getLeftItems().addAll(1, 2, 3, 4);
        swaper2.getRightItems().addAll(5, 6, 7, 8);

        SplitPane split = new SplitPane();
        split.getItems().addAll(swaper1, swaper2);

        primaryStage.setTitle("ItemSwaper");
        primaryStage.setScene(new Scene(split, 640, 480));
        primaryStage.show();

    }
}
