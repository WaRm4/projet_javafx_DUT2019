package model;

import java.util.List;

/**
 * Resultat est la classe regroupant les differents resultats des parties.
 */
public class Resultat {
    /**
     * Liste des differentes parties effectuees.
     */
    private List<Partie> listePartie;

    /**
     * Constructeur de Resultat.
     * @param setListePartie
     *                      La liste de parties deja presentes.
     */
    public Resultat(List<Partie> setListePartie) {
        this.listePartie = setListePartie;
    }

    /**
     * Retourne une List de Partie.
     * @return la liste des parties.
     */
    public List<Partie> getListePartie() {
        return listePartie;
    }

    /**
     * Ajoute une nouvelle partie a la liste.
     * @param p
     *          La partie a ajouter.
     */
    public void ajouterPartie(Partie p) {
        listePartie.add(p);
    }
}
