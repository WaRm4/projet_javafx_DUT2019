package model;

import javafx.scene.Node;
import java.util.ArrayList;

/**
 * Partie est la classe representant la partie des que l'utilisateur commence a jouer.
 */
public class Partie {

    /**
     * Le personnage present dans la partie.
     */
    private Personnage perso;

    /**
     * Retourne une instance de Personnage, celui present dans la partie.
     * @return le personnage de la partie.
     */
    public Personnage getPersonnage() {
        return perso;
    }

    /**
     * Permet de changer le personnage de la partie.
     * @param perso le nouveau personnage.
     */
    public void setPerso(Personnage perso) {
        this.perso = perso;
    }

    /**
     * La carte (facile, moyen ou difficile) de la partie.
     */
    private Carte carte;

    /**
     * Retourne une instance de Carte, celle choisie par l'utilisateur.
     * @return la carte de la partie.
     */
    public Carte getCarte() {
        return carte;
    }

    /**
     * Met a jour la carte de la partie.
     * @param carte La nouvelle carte.
     */
    public void setCarte(Carte carte) {
        this.carte = carte;
        this.carte.setNom(this.difficulte);
    }

    /**
     * La difficulte associee a la partie (depend de la carte).
     */
    private String difficulte;

    /**
     * Retourne une chaine de caracteres qui est la difficulte de la partie.
     * @return la difficulte de la partie.
     */
    public String getDifficulte() {
        return difficulte;
    }

    /**
     * Permet de changer la difficulte de la partie
     * @param difficulte la chaine de caracteres definissant la difficulte.
     */
    public void setDifficulte(String difficulte) {
        this.difficulte = difficulte;
    }

    /**
     * La liste des blocs presents dans la carte.
     */
    private ArrayList<Node> platforms;

    /**
     * Permet de changer la liste des blocs.
     * @param platforms La nouvelle liste de blocs.
     */
    public void setPlatforms(ArrayList<Node> platforms) {
        this.platforms = platforms;
    }

    /**
     * Le constructeur d'une partie.
     * @param perso Le personnage de la partie.
     * @param carte La carte de base de la partie.
     */
    public Partie(Personnage perso, Carte carte) {
        this.carte = carte;
        this.difficulte = "facile";
        this.perso = perso;
    }

    /**
     * Methode pour faire avancer le personnage sur l'axe X.
     * @param x la valeur de l'avancement.
     */
    public void avancerX(double x) {
        for (Node platform : platforms) {
            x = perso.collisionX(platform, x);
        }
        perso.setCoordonneeX(x);
    }

    /**
     * Permet de faire avancer le personnage sur l'axe Y (sauter).
     * @param y la valeur de l'avancement.
     */
    public void avancerY(double y) {
        for (Node platform : platforms) {
            y = perso.collisionY(platform, y);
        }
        perso.setCoordonneeY(y);
    }
}
