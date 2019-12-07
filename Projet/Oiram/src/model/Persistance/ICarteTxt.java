package model.Persistance;

import model.Carte;

public class ICarteTxt implements IPersistanceCarte {

    private String nomCarte;

    public ICarteTxt(String nomCarte){
        this.nomCarte = nomCarte;
    }

    @Override
    public Carte chargerCarte() {
        return null;
    }
}
