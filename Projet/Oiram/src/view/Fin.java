package view;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import model.ListePartie;
import model.Manager;
import model.Partie;
import model.Score;

public class Fin {
    @FXML
    private Label tpseudo;
    @FXML
    private Label tdifficults;
    @FXML
    private ListView<Score> laListe;
    @FXML
    private BorderPane bordP;

    private Manager manager;
    private ListePartie laListePartie;
    ObservableList<String> list = FXCollections.observableArrayList();

    public Fin(Manager m ,Partie p){
        this.manager = m;
        Score sc = new Score(p.getPersonnage().getnom(), p.getDifficulte());
        laListePartie = manager.chargerResultats();
        laListePartie.addScore(sc);
        manager.sauvegarderResultat(laListePartie);
    }

    @FXML
    public void initialize() {
        laListe.itemsProperty().bind(laListePartie.lesPartiesProperty());

        laListe.setCellFactory(__ ->
                new ListCell<Score>(){
                    @Override
                    protected void updateItem(Score item, boolean empty) {
                        super.updateItem(item, empty);
                        if (!empty) {
                            tpseudo.textProperty().bind(item.pseudoProperty());
                            tdifficults.textProperty().bind(item.difficulteProperty());
                            textProperty().bind(item.pseudoProperty());
                        } else {
                            tpseudo.textProperty().unbind();
                            tpseudo.setText("");
                            tdifficults.textProperty().unbind();
                            tdifficults.setText("");
                            textProperty().unbind();
                            setText("");
                        }
                    }
                }
        );
    }

    public void quitter(ActionEvent actionEvent) {
        Platform.exit();
    }

    public void rejouer(ActionEvent actionEvent) {
        ((Stage)bordP.getScene().getWindow()).close();
    }
}
