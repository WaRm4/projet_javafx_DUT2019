package model;

import model.Persistance.IPersistanceCarte;
import model.Persistance.IPersistanceResultat;

/**
 * Manager est la classe qui gere tout le jeu.
 */
public class Manager {
    /**
     * La partie du jeu.
     */
    private Partie partie;
    /**
     * Les resultats deja enregistres.
     */
    private Resultat resultat;
    /**
     * La persistance resultat pour charger les resultats et les enregistrer.
     */
    private IPersistanceResultat persR;
    /**
     * La persistance Carte pour charger la carte.
     */
    private IPersistanceCarte persC;

    /**
     * Constructeur du Manager.
     * @param iR
     *          La persistance du resultat.
     * @param iC
     *          La persistance de la carte.
     */
    public Manager(IPersistanceResultat iR, IPersistanceCarte iC){
        persR = iR;
        persC = iC;
        partie = new Partie(null, null);
    }

    /**
     * Methode qui permet de charger la carte.
     */
    public void chargerCarte(String img){
        Carte c = persC.chargerCarte(partie.getDifficulte(), img);
        partie.setCarte(c);
        partie.setPerso(c.getPerso());
        partie.setPlatforms(c.getListeBloc());
    }

    /**
     * Methode qui permet de charger les resultats.
     */
    public ListePartie chargerResultats(){
        return persR.chargerResultat();
    }

    /**
     * Methode qui permet de recuperer la carte.
     * @return partie
     */
    public Partie getPartie(){return partie;}

    /**
     * Methode qui permet de sauvegarder les resultats.
     * @param lp
     *              La liste des resultats.
     */
    public void sauvegarderResultat(ListePartie lp) {
        persR.sauvegarderResultat(lp);
    }

    /**
     * Ajoute une nouvelle partie aux resultats.
     * @param partie
     *          La nouvelle partie a ajouter.
     */
    public void ajouterPartie(Partie partie){
        resultat.ajouterPartie(partie);
    }
}
