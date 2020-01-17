package view;

import custom.AlertCustom;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import model.Manager;

import java.io.IOException;

public class ChoixPerso {

    @FXML
    private BorderPane BdP;

    private Manager manager;

    public ChoixPerso(Manager m){
        this.manager = m;
    }

    public void choixPerso(ActionEvent actionEvent) {
        Button b = (Button) actionEvent.getSource();
        if(b.getId().equals("b1")){
            manager.chargerCarte("/images/oiram.png");
        }
        if(b.getId().equals("b2")){
            manager.chargerCarte("/images/oiram2.png");
        }
        if(b.getId().equals("b3")){
            manager.chargerCarte("/images/oiram3.png");
        }
        Stage st = new Stage();
        try {
            st.centerOnScreen();
            FXMLLoader root = new FXMLLoader(getClass().getResource("/fxml/JeuSolo.fxml"));
            JeuSolo jeuSolo = new JeuSolo(st, manager);
            root.setController(jeuSolo);
            Scene oldScene = BdP.getScene();
            st.setTitle("Oiram");
            st.getIcons().add(new Image("/images/oiram.png"));
            Scene sc = new Scene(root.load(), oldScene.getWidth(), oldScene.getHeight());
            sc.getStylesheets().addAll(oldScene.getStylesheets());
            st.setScene(sc);
            st.show();
        } catch (IOException ioe) {
            AlertCustom a = new AlertCustom(Alert.AlertType.INFORMATION);
            a.showAndWait();
            st.close();
        }
    }

    public void retour(ActionEvent actionEvent) {
        Stage st = (Stage) BdP.getScene().getWindow();
        try {
            FXMLLoader root = new FXMLLoader(getClass().getResource("/fxml/MenuPrincipal.fxml"));
            MenuPrincipal menuP = new MenuPrincipal(manager);
            root.setController(menuP);
            Scene oldScene = BdP.getScene();
            Scene sc = new Scene(root.load(), oldScene.getWidth(), oldScene.getHeight());
            sc.getStylesheets().addAll(oldScene.getStylesheets());
            st.setScene(sc);
        } catch (IOException ioe) {
            AlertCustom a = new AlertCustom(Alert.AlertType.INFORMATION);
            a.showAndWait();
            st.close();
        }
    }
}
