package model;

import java.util.List;

public class Resultat {
    private List<Partie> listePartie;

    public Resultat(List<Partie> listePartie) {
        this.listePartie = listePartie;
    }

    public List<Partie> getListePartie() {
        return listePartie;
    }

    public boolean ajouterPartie(Partie p) {
        listePartie.add(p);
        return true;
    }
}
