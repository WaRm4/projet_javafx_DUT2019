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
    public void sauvegarderResultat(ListePartie lp);

    /**
     * Charge les resultats.
     * @return une liste de Resultat.
     */
    public ListePartie chargerResultat();
}
