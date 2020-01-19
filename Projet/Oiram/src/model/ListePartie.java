package model;

import javafx.beans.property.ListProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 * ListePartie est la classe qui permet l'affichage binde pour la vue de fin.
 */
public class ListePartie {

    /**
     * Liste qui contient les scores.
     */
    private ObservableList<Score> lesPartiesObs = FXCollections.observableArrayList();

    private final ListProperty<Score> lesParties = new SimpleListProperty<>(lesPartiesObs);
    public ObservableList<Score> getLesParties() {return lesParties.get();}
    public void setLesParties(ObservableList<Score> value) {lesParties.set(value);}
    public ListProperty<Score> lesPartiesProperty() {return lesParties;}

    /**
     * Methode pour ajouter un score a la liste de parties enregistrees.
     * @param sc le score a ajouter.
     */
    public void addScore(Score sc) {
        lesPartiesObs.add(sc);
    }
}
