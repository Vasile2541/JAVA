import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class Main extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        AnchorPane container = FXMLLoader.load( getClass().getResource("fxml/view.fxml") );

        Scene scene = new Scene(container);
        stage.setScene( scene );
        stage.setTitle("JavaFX Simple calculator");
        stage.show();

    }
}
