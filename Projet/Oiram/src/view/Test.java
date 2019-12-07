package view;


import javafx.animation.AnimationTimer;
import javafx.fxml.FXML;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;


public class Test {

    private static boolean droite = false;
    private static boolean gauche = false;

    private static int TIMERSAUTVALUE = 23;
    private static double vMarche = 0.01d;

private int positionX;
    private int positionY;
    @FXML
    Canvas can;

    @FXML
    AnchorPane tes;
    private int[][] tab = { {0,0,0,0,0,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,0,0,0,0,0},
            {0,0,0,0,3,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,0,0,0,0,0},
            {0,0,0,0,1,1,1,1,0,0,0,0},
            {1,0,0,0,0,0,0,0,0,0,0,1},
            {1,1,0,0,0,0,0,0,0,0,1,1},
            {1,1,1,1,1,0,0,1,1,1,1,1} };

    @FXML
    private Image img = new Image("/view/p.png");

    @FXML
    GraphicsContext gc;

    public void initialize()
    {
        int i, j;
        gc = can.getGraphicsContext2D();
        for (i=0;i<12; i++) {
            for (j = 0; j < 8; j++) {
                if (tab[j][i] == 1) {
                    gc.fillRect(i * 50, j * 50, 50, 50);
                }
                if(tab[j][i] == 3){
                    gc.drawImage(img,i*50,j*50,50,50);
                    positionY=j*50;
                    positionX=i*50;
                }
            }
        }
        try{
        AnimationTimer boucle = new AnimationTimer() {
            @Override
            public void handle(long arg0) {


                //directions:
                if (droite) {
                    positionX=positionX+50;
                    gc.clearRect(positionX,positionY,50,50);
                    gc.drawImage(img,positionX,positionY,50,50);

                }

                if (gauche) {
                    positionX=positionX-50;
                    gc.clearRect(positionX,positionY,50,50);
                    gc.drawImage(img,positionX,positionY,50,50);
                }
            }

        };
        boucle.start();

        can.setOnKeyPressed(e-> {
            switch (e.getCode()) {

                case LEFT:
                    gauche = true;
                    break;
                case RIGHT:
                    droite = true;
                    break;

                default:
                    break;

            }
        });

        can.setOnKeyReleased(e-> {
            switch (e.getCode()) {

                case LEFT:
                    gauche = false;
                    break;
                case RIGHT:
                    droite = false;
                    break;

                default:
                    break;
            }
        });

        } catch (Exception e) {
            e.printStackTrace();
        }
    }




}
