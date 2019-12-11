package view;

import custom.AlertCustom;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;

public class MainWindow {
    @FXML
    GridPane menuDebut;

    public void menuStart(ActionEvent actionEvent) {
        try {
            MenuJeu mj = new MenuJeu("Bonjour");
            FXMLLoader root = new FXMLLoader(getClass().getResource("/fxml/MenuJeu.fxml"));
            root.setController(mj);
            Scene sc = new Scene(root.load());
            sc.getStylesheets().addAll(menuDebut.getScene().getStylesheets());
            Stage st = (Stage) menuDebut.getScene().getWindow();
            st.setScene(sc);
        } catch (IOException ioe) {
            AlertCustom a = new AlertCustom(Alert.AlertType.INFORMATION);
            a.showAndWait();
            ((Stage) menuDebut.getScene().getWindow()).close();
        }
    }

    public void menuOptions(ActionEvent actionEvent) {
        try {
            Menu m = new Menu();
            FXMLLoader root = new FXMLLoader(getClass().getResource("/fxml/Menu.fxml"));
            root.setController(m);
            Scene sc = new Scene(root.load());
            sc.getStylesheets().addAll(menuDebut.getScene().getStylesheets());
            Stage st = (Stage) menuDebut.getScene().getWindow();
            st.setScene(sc);
        } catch (IOException ioe) {
            AlertCustom a = new AlertCustom(Alert.AlertType.INFORMATION);
            a.showAndWait();
            ((Stage) menuDebut.getScene().getWindow()).close();
        }
    }

    public void MenuQuit(ActionEvent actionEvent) {
        Stage stage = (Stage) menuDebut.getScene().getWindow();
        stage.close();
    }

}
