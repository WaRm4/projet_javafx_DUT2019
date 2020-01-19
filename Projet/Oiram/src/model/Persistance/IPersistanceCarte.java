package model.Persistance;

import model.Carte;

/**
 * IpersistanceCarte est la classe qui gere la persistance des cartes.
 */
public interface IPersistanceCarte {

    /**
     * Methode permettant de charger une carte.
     * @return la carte chargee.
     */
    Carte chargerCarte(String nom, String imgPerso);
}
