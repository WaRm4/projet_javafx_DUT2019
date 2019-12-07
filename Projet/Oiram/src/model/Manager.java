package model;

import model.Persistance.IPersistanceCarte;
import model.Persistance.IPersistanceResultat;

public class Manager {
    private Partie p;
    private Resultat r;
    private IPersistanceResultat persR;
    private IPersistanceCarte persC;

    public Manager(IPersistanceResultat iR, IPersistanceCarte iC){
        persR = iR;
        persC = iC;
        r = persR.chargerResultat();
        Carte c = persC.chargerCarte();
        p = new Partie(null, c, null, null);
    }

    public Carte chargerCarte(){
        return persC.chargerCarte();
    }

    public Resultat chargerResultat(){
        return persR.chargerResultat();
    }

    public void sauvegarderResultat(Resultat resultat) {
        persR.sauvegarderResultat(resultat);
    }

    public void changerCouleurPlateforme(String couleur){
        p.getCarte().changerCouleurPlateforme(couleur);
    }

    public void bouger(){
        p.bouger();
    }

    public void ajouterPartie(Partie p){
        r.ajouterPartie(p);
    }
}
