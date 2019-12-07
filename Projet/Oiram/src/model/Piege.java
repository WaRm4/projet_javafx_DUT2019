package model;

public class Piege extends Block {
    private String image;

    public Piege(int coordonneeX, int coordonneeY, String image) {
        super(coordonneeX, coordonneeY);
        this.image = image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getImage() {
        return this.image;
    }
}
