package model.Persistance;

import model.ListePartie;

/**
 * Interface qui gere la persistance pour les Resultats.
 */
public interface IPersistanceResultat {

    /**
     * Sauvegarde les resultats.
     * @param lp
     *          Liste des resultats a sauvegarder.
     */
    void sauvegarderResultat(ListePartie lp);

    /**
     * Charge les resultats.
     * @return une liste de Resultat.
     */
    ListePartie chargerResultat();
}
