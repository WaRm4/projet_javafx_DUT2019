package view;

import custom.AlertCustom;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import model.Manager;

import java.io.IOException;

public class MenuPrincipal {
    @FXML
    GridPane menuDebut;

    private Manager manager;

    public MenuPrincipal(Manager m)
    {
        this.manager = m;
    }


    public void menuStart(ActionEvent actionEvent) {
        try {
            Stage st = (Stage) menuDebut.getScene().getWindow();
            MenuJeu mj = new MenuJeu(manager);
            FXMLLoader root = new FXMLLoader(getClass().getResource("/fxml/MenuJeu.fxml"));
            Scene oldScene = st.getScene();
            root.setController(mj);
            Scene sc = new Scene(root.load(), oldScene.getWidth(), oldScene.getHeight());
            sc.getStylesheets().addAll(menuDebut.getScene().getStylesheets());
            st.setScene(sc);
        } catch (IOException ioe) {
            AlertCustom a = new AlertCustom(Alert.AlertType.INFORMATION);
            a.showAndWait();
            ((Stage) menuDebut.getScene().getWindow()).close();
        }
    }

    public void menuOptions(ActionEvent actionEvent) throws IOException {
        try {
            Menu m = new Menu(manager);
            FXMLLoader root = new FXMLLoader(getClass().getResource("/fxml/Menu.fxml"));
            root.setController(m);
            Stage st = (Stage) menuDebut.getScene().getWindow();
            Scene oldScene = st.getScene();
            Scene sc = new Scene(root.load(), oldScene.getWidth(), oldScene.getHeight());
            sc.getStylesheets().addAll(menuDebut.getScene().getStylesheets());
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

