package model.Persistance;


import model.Resultat;

public interface IPersistanceResultat {

    public void sauvegarderResultat(Resultat r);
    public Resultat chargerResultat();
}
