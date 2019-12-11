package launch;

import custom.AlertCustom;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;


public class Oiram extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws IOException {

        //try {
            Parent root = FXMLLoader.load(getClass().getResource("/fxml/TestAnimation.fxml"));
            Scene scene = new Scene(root);
            primaryStage.setScene(scene);
            primaryStage.setTitle("Oiram");
            primaryStage.getIcons().add(new Image("/images/oiram.png"));
            primaryStage.show();
        /*} catch (IOException ioe) {
            AlertCustom a = new AlertCustom(Alert.AlertType.INFORMATION);
            a.showAndWait();
        }*/
    }
}
