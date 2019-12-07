package view;

import javafx.animation.AnimationTimer;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.TouchEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Modality;
import javafx.stage.Stage;

import javax.swing.plaf.basic.BasicSplitPaneUI;
import java.io.IOException;
import java.util.HashMap;

public class TEstJeuAnchor {
    private int positionX;
    private int positionY;

    private boolean gauche;
    private boolean droite;

    @FXML
    AnchorPane test;

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

    private Node createBlock(int x, int y, int w, int h, Color color){
        Rectangle block = new Rectangle(w, h);
        block.setTranslateX(x);
        block.setTranslateY(y);
        block.setFill(color);
        test.getChildren().add(block);
        return block;
    }

    private Node player;

    public void initialize() throws IOException {
       /* FXMLLoader root = new FXMLLoader(getClass().getResource("/fxml/TEstJeuAnchor.fxml") );
        Scene sc = new Scene(root.load());
        Stage st =new Stage();
        //st.initModality(Modality.APPLICATION_MODAL);
        st.setScene(sc);
        st.show();
        //faire la fenetre en modale*/

        test.addEventHandler(KeyEvent.KEY_PRESSED,new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent keyEvent) {
                if(keyEvent.getCode()== KeyCode.Q){
                    gauche=true;
                }
                if(keyEvent.getCode()==KeyCode.D){
                    droite=true;
                }
            }
        });

        test.addEventHandler(KeyEvent.KEY_RELEASED,new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent keyEvent) {
                if(keyEvent.getCode()==KeyCode.Q){
                    gauche=false;
                }
                if(keyEvent.getCode()==KeyCode.D){
                    droite=false;
                }
            }
        });

        int i, j;
        for (i=0;i<12; i++) {
            for (j = 0; j < 8; j++) {
                if (tab[j][i] == 1) {
                    Node platform = createBlock(i * 50, j * 50, 50, 50, Color.RED);
                }
                if (tab[j][i] == 3) {
                    player = createBlock(i * 50, j * 50, 50, 50, Color.BLUE);
                    positionY = j * 50;
                    positionX = i * 50;
                }
            }
        }


        AnimationTimer boucle = new AnimationTimer() {
            @Override
            public void handle(long arg0) {
                if(gauche){
                    positionX = positionX - 1;
                    player.setTranslateX(positionX);
                }
                if(droite){
                    positionX = positionX + 1;
                    player.setTranslateX(positionX);
                }
            }

        };
        boucle.start();


    }
}


