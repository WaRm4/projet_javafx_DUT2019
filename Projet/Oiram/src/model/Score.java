package model;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 * Classe qui permet la serialisation des informations importantes d'une partie.
 */
public class Score {

    private final StringProperty pseudo = new SimpleStringProperty();
    public String getPseudo() { return pseudo.get(); }
    public StringProperty pseudoProperty() { return pseudo; }
    public void setPseudo(String pseudo) { this.pseudo.set(pseudo); }

    private final StringProperty difficulte = new SimpleStringProperty();
    public String getDifficulte() { return difficulte.get(); }
    public StringProperty difficulteProperty() { return difficulte; }
    public void setDifficulte(String difficulte) { this.difficulte.set(difficulte); }

    public Score(String pseudo, String difficulte) {
        this.pseudo.set(pseudo);
        this.difficulte.set(difficulte);
    }

}
