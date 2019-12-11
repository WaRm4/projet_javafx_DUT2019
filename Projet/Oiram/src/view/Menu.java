package view;

import custom.AlertCustom;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ToggleButton;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.IOException;

public class Menu {

    @FXML
    ToggleButton choisirLangue;
    @FXML
    CheckBox facile;
    @FXML
    CheckBox moyen;
    @FXML
    CheckBox difficile;
    @FXML
    CheckBox checkDefaut;
    @FXML
    BorderPane menuOptions;


    public void toggleOptions(ActionEvent actionEvent) {
        if (choisirLangue.getText() != "English")
            choisirLangue.setText("English");
        else
            choisirLangue.setText("Français");
    }

    public void validerClique(ActionEvent actionEvent) {
        try {
            MainWindow m = new MainWindow();
            FXMLLoader root = new FXMLLoader(getClass().getResource("/fxml/MainWindow.fxml"));
            Scene scene = new Scene(root.load());
            scene.getStylesheets().addAll(menuOptions.getScene().getStylesheets());
            Stage st = (Stage) menuOptions.getScene().getWindow();
            st.setScene(scene);
        } catch (IOException ioe) {
            AlertCustom a = new AlertCustom(Alert.AlertType.INFORMATION);
            a.showAndWait();
            ((Stage) menuOptions.getScene().getWindow()).close();
        }
    }

    public void difficileSelected(ActionEvent actionEvent) {
        moyen.setSelected(false);
        facile.setSelected(false);
    }

    public void moyenSelected(ActionEvent actionEvent) {
        facile.setSelected(false);
        difficile.setSelected(false);
    }

    public void facileSelected(ActionEvent actionEvent) {
        moyen.setSelected(false);
        difficile.setSelected(false);
    }

    public void ThemeBlanc(ActionEvent actionEvent) {
        menuOptions.getScene().getStylesheets().clear();
        menuOptions.getScene().getStylesheets().add("CSS/White");
        checkDefaut.setSelected(false);
    }

    public void ThemeSombre(ActionEvent actionEvent) {
        menuOptions.getScene().getStylesheets().clear();
        menuOptions.getScene().getStylesheets().add("CSS/darkTheme");
        checkDefaut.setSelected(false);
    }

    public void checkDefault(ActionEvent actionEvent) {
        menuOptions.getScene().getStylesheets().clear();
    }

}
