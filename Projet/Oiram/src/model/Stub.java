package model;

/**
 * Classe permettant de tester nos classe (ici elle cree plusieurs faux scores).
 */
public class Stub {
    public static ListePartie genererPromotion() {
        ListePartie retour = new ListePartie();
        retour.addScore(new Score("CLAUDE", "facile"));
        retour.addScore(new Score("JEAN", "facile"));
        retour.addScore(new Score("KILLIAN",  "facile"));
        retour.addScore(new Score("TOM",  "facile"));
        retour.addScore(new Score("ROMAIN",  "facile"));
        retour.addScore(new Score("ALEXANDRE",  "facile"));
        retour.addScore(new Score("REKLAWYKS",  "facile"));

        return retour;
    }
}
