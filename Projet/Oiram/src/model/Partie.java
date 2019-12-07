package model;

public class Partie {
    private Personnage p;
    private Carte c;
    private String nom;
    private String difficulte;
    private float temps;
    private int score;

    public Partie(Personnage p, Carte c, String nom, String difficulte) {
        this.p = p;
        this.c = c;
        this.nom = nom;
        this.difficulte = difficulte;
    }

    public void bouger() {
        p.setCoordonneeX(p.getCoordonneeX() + 1);
        p.setCoordonneeY(p.getCoordonneeY() + 1);
    }

    public Personnage getPersonnage() {
        return p;
    }

    public Carte getCarte() {
        return c;
    }

    public String getNom() {
        return nom;
    }

    public String getDifficulte() {
        return difficulte;
    }

    public float getTemps() {
        return temps;
    }

    public int getScore() {
        return score;
    }

    public void setTemps(float temps) {
        this.temps = temps;
    }

    public void setScore(int score) {
        this.score = score;
    }


}
