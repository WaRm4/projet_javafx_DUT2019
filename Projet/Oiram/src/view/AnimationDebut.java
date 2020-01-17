package view;

import custom.AlertCustom;
import javafx.animation.RotateTransition;
import javafx.animation.TranslateTransition;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.Duration;
import model.Manager;
import java.io.IOException;

public class AnimationDebut {

    @FXML
    AnchorPane test;
    @FXML
    ImageView img, img1;
    @FXML
    private TranslateTransition translateTransition, tt;
    @FXML
    private RotateTransition rotate;
    @FXML
    Label labelClick;

    private Manager manager;

    public AnimationDebut(Manager m)
    {
        this.manager = m;
    }

    public void initialize() {
        img.setOnMouseClicked((MouseEvent event) -> {
            if (event.getButton().equals(MouseButton.PRIMARY)) {
                this.play();
            }
        });
        img1.setOnMouseClicked((MouseEvent event) -> {
            if (event.getButton().equals(MouseButton.PRIMARY)) {
                this.play();
            }
        });

        translateTransition = new TranslateTransition(Duration.millis(1000), img);
        translateTransition.setFromX(img.getX());
        //translateTransition.setCycleCount(2);
        //translateTransition.setAutoReverse(true);

        tt = new TranslateTransition(Duration.millis(1000), img1);
        tt.setFromX(img1.getX());

        rotate = new RotateTransition(Duration.millis(3000), img);
        rotate.setByAngle(180f);
        rotate.setCycleCount(4);
        rotate.setAutoReverse(true);
    }

    private void play() {
        translateTransition.setToX(img.getX() - (test.getWidth() / 2));
        tt.setToX(img1.getX() + (test.getWidth() / 2));
        tt.setOnFinished(e -> openN());
        translateTransition.play();
        tt.play();
        labelClick.setVisible(false);
    }

    private void openN() {
        try {
            FXMLLoader root = new FXMLLoader(getClass().getResource("/fxml/MenuPrincipal.fxml"));
            MenuPrincipal c = new MenuPrincipal(manager);
            root .setController(c);
            Stage st = (Stage) test.getScene().getWindow();
            Scene oldscene = st.getScene();
            Scene scene = new Scene(root.load(), oldscene.getWidth(), oldscene.getHeight());
            scene.getStylesheets().addAll(test.getScene().getStylesheets());
            st.setScene(scene);

        } catch (IOException ioe) {
            AlertCustom a = new AlertCustom(Alert.AlertType.INFORMATION);
            a.show();
            ((Stage) test.getScene().getWindow()).close();
        }
    }

}
