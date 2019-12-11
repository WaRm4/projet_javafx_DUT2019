package view;

import custom.AlertCustom;
import javafx.animation.RotateTransition;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.media.AudioClip;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;


public class TestAnimation {

    @FXML
    AnchorPane test;
    @FXML
    ImageView img, img1;
    @FXML
    private TranslateTransition translateTransition, tt;
    @FXML
    private RotateTransition rotate;
    @FXML
    Button go;

    public void initialize() throws InterruptedException {
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

    public void play(ActionEvent actionEvent) {
        translateTransition.setToX(img.getX()-(test.getWidth()/2));
        tt.setToX(img1.getX()+(test.getWidth()/2));
        tt.setOnFinished( e->openN() );
        translateTransition.play();
        tt.play();
        go.setVisible(false);
    }

    private void openN()
    {
        try {
            FXMLLoader root = new FXMLLoader(getClass().getResource("/fxml/MainWindow.fxml"));
            Scene scene = new Scene(root.load());
            scene.getStylesheets().addAll(test.getScene().getStylesheets());
            Stage st = (Stage) test.getScene().getWindow();
            st.setScene(scene);
        } catch (IOException ioe) {
            AlertCustom a = new AlertCustom(Alert.AlertType.INFORMATION);
            a.show();
            ((Stage) test.getScene().getWindow()).close();
        }
    }

    private void testeuh()
    {
        String musicFile = "/Sons/Enregistrement.mp3";     // For example
        File f = new File(musicFile);
        Media sound = new Media(f.toURI().toString());
        MediaPlayer mediaPlayer = new MediaPlayer(sound);
        mediaPlayer.setAutoPlay(true);
        mediaPlayer.play();
    }


}
