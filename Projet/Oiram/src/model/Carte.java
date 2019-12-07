package model;

import java.util.List;

public class Carte {
    private String nom;
    private List<Block> listeBlock;

    public Carte(String nom, List<Block> listeBlock) {
        this.nom = nom;
        this.listeBlock = listeBlock;
    }

    public String getNom() {
        return this.nom;
    }

    public List<Block> getListeBlock() {
        return listeBlock;
    }

    public void changerCouleurPlateforme(String couleur) {
        for(Block b : listeBlock){
            if(b.getClass() == Plateforme.class)
                ((Plateforme)b).setCouleur(couleur);
        }
    }
}
