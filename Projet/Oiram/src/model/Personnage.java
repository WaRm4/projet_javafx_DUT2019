package model;

import javafx.scene.Node;
import javafx.scene.SnapshotParameters;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;


/**
 * Personnage est la classe representant le personnage present dans la partie.
 */
public class Personnage extends Bloc {
    /**
     * Le nom du personnage, autrement dit : votre pseudo.
     */
    private String nom;

    /**
     * Booleen permettant de savoir si le personnage peut sauter.
     */
    private boolean peutSauter;

    /**
     * Definit si le personnage peut sauter ou non.
     * @param peutSauter la valeur du booleen.
     */
    public void setPeutSauter(boolean peutSauter) {
        this.peutSauter = peutSauter;
    }

    /**
     * Retourne la valeur du booleen pour savoir si le personnage peut sauter.
     * @return booleen.
     */
    public boolean getPeutSauter(){
        return peutSauter;
    }

    /**
     * Booleen permettant de savoir si le personnage est en l'air.
     */
    private boolean enAir;

    /**
     * Definit si le personnage est en l'air.
     * @param enAir la valeur du booleen.
     */
    public void setEnAir(boolean enAir) {
        this.enAir = enAir;
    }

    /**
     * Retourne la valeur du booleen pour savoir si le personnage est en l'air.
     * @return booleen.
     */
    public boolean getEnAir(){
        return enAir;
    }

    /**
     * Retourne une chaine de carcatères, qui est le nom du personnage.
     * @return le nom du personnage.
     */
    public String getnom() {
        return this.nom;
    }

    /**
     * Met à jour le nom du personnage (le pseudo)
     * @param nom
     *              Le nouveau pseudo.
     */
    public void setNom(String nom){
        this.nom = nom;
    }

    /**
     * Met a jour la position X du personnage.
     * @param coordonneeX
     *                  La nouvelle coordonnee X du personnage.
     */
    public void setCoordonneeX(double coordonneeX) {
        super.coordonneeX += coordonneeX;
        rectangle.setTranslateX(super.coordonneeX);
    }

    /**
     * Met a jour la coordonnee Y du personnage.
     * @param coordonneeY
     *                  La nouvelle coordonnee Y du personnage.
     */
    public void setCoordonneeY(double coordonneeY) {
        super.coordonneeY -= coordonneeY;
        rectangle.setTranslateY(super.coordonneeY);
    }

    /**
     * Methode qui verifie si le personnage est en collision avec un autre objet de la carte (sur l'axe X).
     * @param plateforme l'objet en question.
     * @param x la nouvelle valeur du personnage (avant qu'il se deplace).
     * @return double : nouvelle valeur pour la position du personnage.
     */
    public double collisionX(Node plateforme, double x)
    {
        if(rectangle.getBoundsInParent().intersects(plateforme.getBoundsInParent())){
            if (rectangle.getBoundsInParent().getMaxX() == plateforme.getBoundsInParent().getMinX()+1 && x <= 0) {
                return x;
            }
            if (rectangle.getBoundsInParent().getMinX() == plateforme.getBoundsInParent().getMaxX() && x >= 0) {
                return x;
            }
            if(rectangle.getBoundsInParent().getMaxY() == plateforme.getBoundsInParent().getMinY() || rectangle.getBoundsInParent().getMinY() == plateforme.getBoundsInParent().getMaxY()) {
                return x;
            }
            return 0;
        }
        return x;
    }

    /**
     * Methode qui verifie si le personnage est en collision avec un autre objet de la carte (sur l'axe Y).
     * @param plateforme l'objet en question.
     * @param y la nouvelle valeur du personnage (avant qu'il se deplace).
     * @return double : nouvelle valeur pour la position du personnage.
     */
    public double collisionY(Node plateforme, double y)
    {
        if(rectangle.getBoundsInParent().intersects(plateforme.getBoundsInParent())){
            if(rectangle.getBoundsInParent().getMinY() == plateforme.getBoundsInParent().getMaxY()) {
                y = 0;
            }
        }
        return y;
    }

    /**
     * Rectangle representant le personnage dans l'anchorPane.
     */
    private Rectangle rectangle;

    /**
     * Retourne le rectangle representant le personnage.
     * @return Rectangle.
     */
    public Rectangle getRectangle() {
        return rectangle;
    }

    /**
     * Retourne le lien de l'image du personnage.
     * @return lien de l'image.
     */
    public String getImage(){
        return super.image;
    }

    /**
     * Constructeur d'un personnage.
     * @param coordonneeX
     *                  La coordonnee X de base du personnage.
     * @param coordonneeY
     *                  La coordonnee Y de base du personnage.
     * @param nom
     *                  Le nom du personnage.
     * @param hauteur
     *                  La hauteur du rectangle representant le personnage.
     * @param largeur
     *                  La largeur du rectangle representant le personnage.
     * @param image
     *                  La chaine de caracteres qui correspond a l'image du personnage.
     */
    public Personnage(double coordonneeX, double coordonneeY, String nom, int hauteur, int largeur, String image) {
        super(coordonneeX, coordonneeY, hauteur, largeur, image);
        this.nom = nom;
        rectangle = new Rectangle(super.hauteur, super.largeur);
        rectangle.setTranslateX(super.coordonneeX);
        rectangle.setTranslateY(super.coordonneeY);
        super.image = image;
        ImageView iv = new ImageView(super.image);
        iv.setScaleX(-1);
        SnapshotParameters params = new SnapshotParameters();
        params.setFill(Color.TRANSPARENT);
        Image imgRotated = iv.snapshot(params, null);
        rectangle.setFill(new ImagePattern(imgRotated));
        peutSauter = true;
        enAir=false;
    }
}
