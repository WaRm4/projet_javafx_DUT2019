package view;

import custom.AlertCustom;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;

public class MenuJeu {
    private String i;

    @FXML
    private HBox menuJouer;

    public void ouvrirSolo(ActionEvent actionEvent) {
        try {
            FXMLLoader root = new FXMLLoader(getClass().getResource("/fxml/Test.fxml"));
            Scene sc = new Scene(root.load());
            Stage st = (Stage) menuJouer.getScene().getWindow();
            st.setScene(sc);
        } catch (IOException ioe) {
            AlertCustom a = new AlertCustom(Alert.AlertType.INFORMATION);
            a.showAndWait();
            ((Stage) menuJouer.getScene().getWindow()).close();
        }
    }

    public void ouvrirDuo(ActionEvent actionEvent) {
        try {
            FXMLLoader root = new FXMLLoader(getClass().getResource("/fxml/TEstJeuAnchor.fxml"));
            Scene sc = new Scene(root.load());
            Stage st = new Stage();
            st.initModality(Modality.APPLICATION_MODAL);
            st.setScene(sc);
            st.show();
        } catch (IOException ioe) {
            AlertCustom a = new AlertCustom(Alert.AlertType.INFORMATION);
            a.showAndWait();
            ((Stage) menuJouer.getScene().getWindow()).close();
        }
    }

    public MenuJeu(String i) {
        this.i = i;
    }

    public void ouvrir1v1(ActionEvent actionEvent) {
        Button b = (Button) actionEvent.getSource();
        b.setText(i);
    }

    public void initialize() {

    }

}
