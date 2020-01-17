package view;

import custom.AlertCustom;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import model.Manager;

import java.io.IOException;

public class ChoixPseudo {
    @FXML
    private TextField ttfield;
    @FXML
    private BorderPane BdP;

    Manager manager;

    public ChoixPseudo(Manager m) {
        this.manager = m;
    }

    public void valider(ActionEvent actionEvent) {
        manager.getPartie().getPersonnage().setNom(ttfield.getText());

        Stage stage = (Stage) BdP.getScene().getWindow();
        try {
            FXMLLoader root = new FXMLLoader(getClass().getResource("/fxml/Fin.fxml"));
            Fin fn = new Fin(manager ,manager.getPartie());
            root.setController(fn);
            Scene oldScene = BdP.getScene();
            Scene sc = new Scene(root.load(), oldScene.getWidth(), oldScene.getHeight());
            sc.getStylesheets().addAll(oldScene.getStylesheets());
            stage.setScene(sc);
        } catch (
                IOException ioe) {
            ioe.printStackTrace();
            AlertCustom ab = new AlertCustom(Alert.AlertType.INFORMATION);
            ab.show();
            stage.close();
        }
    }

}
