package model;

import javafx.scene.Node;
import java.util.ArrayList;

/**
 * Carte est la classe representant la carte du jeu.
 */
public class Carte {
    /**
     * Le nom de la carte.
     */
    private String nom;

    /**
     * Retourne une chaine de caracteres qui est le nom de la carte.
     * @return le nom de la carte.
     */
    public String getNom() {
        return this.nom;
    }

    /**
     *Permet de changer le nom de la carte.
     * @param nom
     *              Le nom de la carte.
     */
    public void setNom(String nom)
    {
        this.nom = nom;
    }

    /**
     * La liste des differents blocs presents dans la carte.
     */
    private ArrayList<Node> listeBloc;

    /**
     * Retourne une liste de Bloc.
     * @return la liste de blocs de la carte.
     */
    public ArrayList<Node> getListeBloc() {
        return listeBloc;
    }

    /**
     * Le personnage présent dans la carte.
     */
    private Personnage perso;

    /**
     * Permet de retourner le personnage present dans la carte.
     * @return le personnage.
     */
    public Personnage getPerso() {
        return perso;
    }

    /**
     * Les coordonnees du bloc d'arrivee dans un tableau.
     */
    private int[] coordArrivee;

    /**
     * Retourne les coordonnees du bloc d'arrivee.
     * @return un tableau d'entier : les coordonnees du bloc d'arrivee.
     */
    public int[] getCoordArrivee() {
        return coordArrivee;
    }

    /**
     *
     * @param nom
     *              Le nom de la carte.
     * @param listeBloc
     *              La liste de blocs de la carte.
     * @param p
     *              Le personnage.
     * @param coordArrivee
     *              Les coordonnees du bloc d'arrivee.
     */
    public Carte(String nom, ArrayList<Node> listeBloc, Personnage p, int[] coordArrivee ) {
        this.nom = nom;
        this.listeBloc = listeBloc;
        this.perso = p;
        this.coordArrivee = coordArrivee;
    }
}
