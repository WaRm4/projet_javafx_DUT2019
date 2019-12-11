package custom;

import javafx.scene.control.Alert;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class AlertCustom extends Alert {
    public AlertCustom(AlertType alertType) {
        super(alertType);
        this.setTitle("Erreur chargement fenetre");
        this.setContentText("Probleme lors du chargement de la fenetre");
        Stage stage = (Stage) this.getDialogPane().getScene().getWindow();
        stage.getScene().getStylesheets().add("CSS/White");
        this.setHeaderText("");
        stage.getIcons().add(new Image("https://upload.wikimedia.org/wikipedia/commons/thumb/e/e5/OOjs_UI_icon_alert_destructive_black-darkred.svg/1138px-OOjs_UI_icon_alert_destructive_black-darkred.svg.png"));
    }
}
