package model;

public class Plateforme extends Block {
    private String couleur;

    public Plateforme(int coordonneeX, int coordonneeY, String couleur) {
        super(coordonneeX, coordonneeY);
        this.couleur = couleur;
    }

    public String getCouleur() {
        return couleur;
    }

    public void setCouleur(String couleur) {
        this.couleur = couleur;
    }
}
