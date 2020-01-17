package launch;

import custom.AlertCustom;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import model.Manager;
import model.Persistance.ICarteTxt;
import model.Persistance.IResultatTxt;
import view.AnimationDebut;
import java.io.IOException;

/**
 * Classe "main" de l'application.
 */
public class Oiram extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        Manager m = new Manager(new IResultatTxt(), new ICarteTxt());
        try {
            FXMLLoader root = new FXMLLoader(getClass().getResource("/fxml/AnimationDebut.fxml"));
            AnimationDebut c = new AnimationDebut(m);
            root.setController(c);
            Scene scene = new Scene(root.load());
            scene.getStylesheets().add("CSS/White");
            primaryStage.centerOnScreen();
            primaryStage.setScene(scene);
            primaryStage.setTitle("Oiram");
            primaryStage.getIcons().add(new Image("/images/oiram.png"));
            primaryStage.show();
        } catch (IOException ioe) {
            AlertCustom a = new AlertCustom(Alert.AlertType.INFORMATION);
            a.showAndWait();
        }
    }
}
