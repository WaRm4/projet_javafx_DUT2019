package view;

import custom.AlertCustom;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import model.Manager;

import java.io.IOException;

public class MenuJeu {

    @FXML
    private HBox menuJouer;

    private Manager manager;

    public void ouvrirSolo(ActionEvent actionEvent) {
        Stage st = (Stage) menuJouer.getScene().getWindow();
        try {
            FXMLLoader root = new FXMLLoader(getClass().getResource("/fxml/ChoixPerso.fxml"));
            ChoixPerso choix = new ChoixPerso(manager);
            root.setController(choix);
            Scene oldScene = menuJouer.getScene();
            Scene sc = new Scene(root.load(), oldScene.getWidth(), oldScene.getHeight());
            sc.getStylesheets().addAll(oldScene.getStylesheets());
            st.setScene(sc);
        } catch (IOException ioe) {
            AlertCustom a = new AlertCustom(Alert.AlertType.INFORMATION);
            a.showAndWait();
            st.close();
        }
    }

    public void retour(ActionEvent actionEvent) {
        Stage st = (Stage) menuJouer.getScene().getWindow();
        try {
            FXMLLoader root = new FXMLLoader(getClass().getResource("/fxml/MenuPrincipal.fxml"));
            MenuPrincipal menuP = new MenuPrincipal(manager);
            root.setController(menuP);
            Scene oldScene = menuJouer.getScene();
            Scene sc = new Scene(root.load(), oldScene.getWidth(), oldScene.getHeight());
            sc.getStylesheets().addAll(oldScene.getStylesheets());
            st.setScene(sc);
        } catch (IOException ioe) {
            AlertCustom a = new AlertCustom(Alert.AlertType.INFORMATION);
            a.showAndWait();
            st.close();
        }
    }

    public MenuJeu(Manager m) {
        this.manager = m;
    }

}
