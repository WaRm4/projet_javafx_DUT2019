package view;

import custom.AlertCustom;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ToggleButton;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import model.Manager;

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
    GridPane menuOptions;

    private Manager manager;

    public Menu(Manager m)
    {
        this.manager = m;
    }

    public void toggleOptions(ActionEvent actionEvent) {
        if (choisirLangue.getText() != "English")
            choisirLangue.setText("English");
        else
            choisirLangue.setText("Français");
    }

    public void validerClique(ActionEvent actionEvent) {
        try {
            MenuPrincipal m = new MenuPrincipal(manager);
            FXMLLoader root = new FXMLLoader(getClass().getResource("/fxml/MenuPrincipal.fxml"));
            root.setController(m);
            Stage st = (Stage) menuOptions.getScene().getWindow();
            Scene oldScene = st.getScene();
            Scene scene = new Scene(root.load(), oldScene.getWidth(), oldScene.getHeight());
            scene.getStylesheets().addAll(menuOptions.getScene().getStylesheets());
            st.setScene(scene);
        } catch (IOException ioe) {
            AlertCustom a = new AlertCustom(Alert.AlertType.INFORMATION);
            a.showAndWait();
            ((Stage) menuOptions.getScene().getWindow()).close();
        }
    }

    public void difficileSelected(ActionEvent actionEvent) {
        manager.getPartie().setDifficulte("difficile");
        moyen.setSelected(false);
        facile.setSelected(false);
    }

    public void moyenSelected(ActionEvent actionEvent) {
        manager.getPartie().setDifficulte("moyen");
        facile.setSelected(false);
        difficile.setSelected(false);
    }

    public void facileSelected(ActionEvent actionEvent) {
        manager.getPartie().setDifficulte("facile");
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
