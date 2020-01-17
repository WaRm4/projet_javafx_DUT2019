package model;

/**
 * Bloc est la classe representant un bloc dans la carte.
 */
public abstract class Bloc {
    /**
     * Coordonnee X du bloc.
     */
    protected double coordonneeX;

    /**
     * Retourne un entier qui est la coordonnee X du bloc.
     * @return la coordonnee X du bloc.
     */
    public double getCoordonneeX() {
        return coordonneeX;
    }

    /**
     * Coordonnee Y du bloc.
     */
    protected double coordonneeY;
    /**
     * Retourne un entier qui est la coordonnee Y du bloc.
     * @return la coordonnee Y du bloc.
     */
    public double getCoordonneeY() {
        return coordonneeY;
    }

    /**
     * Hauteur du bloc.
     */
    protected int hauteur;

    /**
     * Largeur du bloc.
     */
    protected int largeur;

    /**
     * Chaine de caracteres de l'image du bloc.
     */
    protected String image;

    /**
     *
     * @param coordonneeX
     *                  La coordonnee X du bloc.
     * @param coordonneeY
     *                  La coordonnee Y du bloc.
     * @param hauteur
     *                  L'hauteur du bloc.
     * @param largeur
     *                  La largeur du bloc.
     * @param image
     *                  La chaine de caracteres represantant l'image du bloc.
     */
    public Bloc(double coordonneeX, double coordonneeY, int hauteur, int largeur, String image) {
        this.coordonneeX = coordonneeX;
        this.coordonneeY = coordonneeY;
        this.hauteur = hauteur;
        this.largeur = largeur;
        this.image = image;
    }
}
