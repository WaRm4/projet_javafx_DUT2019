package model;

import java.io.ObjectOutputStream;
import java.io.Serializable;

public class Personnage extends Block implements Serializable { //pour le serialisation. (voir java)
    private String nom;
    private ObjectOutputStream o; // ca sera pour la serialisation.

    public Personnage(int coordonneeX, int coordonneeY, String nom) {
        super(coordonneeX, coordonneeY);
        this.nom = nom;
    }

    public String getnom() {
        return this.nom;
    }

    public void setCoordonneeX(int coordonneeX) {
        this.coordonneeX = coordonneeX;
    }

    public void setCoordonneeY(int coordonneeY) {
        this.coordonneeY = coordonneeY;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

}
