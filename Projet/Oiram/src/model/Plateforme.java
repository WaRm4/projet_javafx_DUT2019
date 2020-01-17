package model;

import javafx.scene.image.Image;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;

/**
 * Plateforme est la classe representant une plateforme de la carte (un sol ou une plateforme en hauteur).
 */
public class Plateforme extends Bloc {

    /**
     * Rectangle representant la plateforme dans l'anchorPane.
     */
    private Rectangle rectangle;

    /**
     * Constructeur d'une plateforme.
     * @param coordonneeX
     *                  La coordonnee X de base de la plateforme (non modifiable).
     * @param coordonneeY
     *                  La coordonnee Y de base de la plateforme (non modifiable).
     * @param hauteur
     *                  La hauteur du rectangle representant la plateforme.
     * @param largeur
     *                  La largeur du rectangle representant la plateforme.
     * @param image
     *                  La chaine de caracteres qui correspond a l'image de la plateforme.
     */
    public Plateforme(double coordonneeX, double coordonneeY, int hauteur, int largeur, String image) {
        super(coordonneeX, coordonneeY, hauteur, largeur, image);
        rectangle = new Rectangle(super.hauteur, super.largeur);
        rectangle.setTranslateX(super.coordonneeX);
        rectangle.setTranslateY(super.coordonneeY);
        rectangle.setFill(new ImagePattern(new Image(super.image)));
    }

    /**
     * Retourne le rectangle qui represente la plateforme.
     * @return Rectangle.
     */
    public Rectangle getRectangle() {
        return rectangle;
    }
}
