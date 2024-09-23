package dad.bindings.ui;

import javafx.application.Application;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class StageLocationApp  extends Application{

    private Label coordenadasLabel;
    private Label sizeLabel;

    @Override
    public void start(Stage stage) throws Exception {

        coordenadasLabel = new Label();
        sizeLabel = new Label();

        sizeLabel.textProperty().bind(stage.xProperty().asString().concat(", ").concat(stage.yProperty().asString()));

        stage.setTitle("Size and Location");
        stage.show();
    }

}
