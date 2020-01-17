package view;

import custom.AlertCustom;
import javafx.animation.AnimationTimer;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.SnapshotParameters;
import javafx.scene.control.Alert;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import model.Manager;
import java.io.IOException;
import java.util.ArrayList;

public class JeuSolo {
    private double acceleration;
    private boolean gauche;
    private boolean droite;
    private boolean saut;
    private double y;

    @FXML
    private AnchorPane test;

    private ArrayList<Node> platforms = new ArrayList<>();

    private Stage stage;
    private Manager m;

    private AnimationTimer boucle;

    @FXML
    private Image img ;

    private Rectangle arrivee;

    public JeuSolo(Stage stage, Manager m) {
        this.stage = stage;
        this.m = m;
        img = new Image(m.getPartie().getPersonnage().getImage());
    }

    public void initialize() {
        acceleration = 2;
        y=0;
        arrivee = new Rectangle(m.getPartie().getCarte().getCoordArrivee()[0]+25, m.getPartie().getCarte().getCoordArrivee()[1],25,50);
        test.getChildren().add(arrivee);
        platforms = m.getPartie().getCarte().getListeBloc();
        stage.addEventHandler(KeyEvent.KEY_PRESSED, keyEvent -> {
            if (keyEvent.getCode() == KeyCode.Q) {
                gauche = true;
            }
            if (keyEvent.getCode() == KeyCode.D) {
                droite = true;
            }
            if (keyEvent.getCode() == KeyCode.Z) {
                saut = true;
            }
        });

        stage.addEventHandler(KeyEvent.KEY_RELEASED, keyEvent -> {
            if (keyEvent.getCode() == KeyCode.Q) {
                gauche = false;
            }
            if (keyEvent.getCode() == KeyCode.D) {
                droite = false;
            }
            if (keyEvent.getCode() == KeyCode.Z) {
                saut = false;
            }
        });

        for (Node e : platforms)
            test.getChildren().add(e);
        test.getChildren().add(m.getPartie().getCarte().getPerso().getRectangle());

        boucle = new AnimationTimer() {
            @Override
            public void handle(long arg0) {
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if (gauche) {
                    m.getPartie().avancerX(-acceleration);
                    ImageView iv = new ImageView(img);
                    iv.setScaleX(1);
                    SnapshotParameters params = new SnapshotParameters();
                    params.setFill(Color.TRANSPARENT);
                    Image imgRotated = iv.snapshot(params, null);
                    m.getPartie().getCarte().getPerso().getRectangle().setFill(new ImagePattern(imgRotated));
                }
                if (droite) {
                    m.getPartie().avancerX(acceleration);
                    ImageView iv = new ImageView(img);
                    iv.setScaleX(-1);
                    SnapshotParameters params = new SnapshotParameters();
                    params.setFill(Color.TRANSPARENT);
                    Image imgRotated = iv.snapshot(params, null);
                    ( m.getPartie().getCarte().getPerso().getRectangle()).setFill(new ImagePattern(imgRotated));
                }
                if (saut) {
                    if(m.getPartie().getPersonnage().getPeutSauter()) {
                        m.getPartie().getPersonnage().setPeutSauter(false);
                        m.getPartie().getPersonnage().setEnAir(true);
                        //enAir=true;
                        y=m.getPartie().getPersonnage().getCoordonneeY()-100;
                    }
                }
                if( m.getPartie().getPersonnage().getEnAir()==true){
                    sauter();
                }
                else {
                    gravite();
                }
                fin();
            }
        };
        boucle.start();

        stage.setOnCloseRequest(new EventHandler<WindowEvent>() {
            public void handle(WindowEvent we) {
                boucle.stop();
            }
        });
    }

    public void sauter() {
        if(m.getPartie().getPersonnage().getCoordonneeY() <= y) {
            m.getPartie().getPersonnage().setEnAir(false);
            return;
        }
        for (Node platform : platforms) {
            if (m.getPartie().getPersonnage().getRectangle().getBoundsInParent().intersects(platform.getBoundsInParent())) {
                if (m.getPartie().getPersonnage().getRectangle().getBoundsInParent().getMinY() == platform.getBoundsInParent().getMaxY()) {
                    m.getPartie().getPersonnage().setEnAir(false);
                    return;
                }

            }
        }
        m.getPartie().avancerY(acceleration);
    }

    public void gravite() {
        for (Node platform : platforms) {
            if (m.getPartie().getPersonnage().getRectangle().getBoundsInParent().intersects(platform.getBoundsInParent())) {
                if (m.getPartie().getPersonnage().getRectangle().getBoundsInParent().getMaxY() == platform.getBoundsInParent().getMinY()) {
                    m.getPartie().getPersonnage().setPeutSauter(true);
                    return;
                }
                if (m.getPartie().getPersonnage().getRectangle().getBoundsInParent().getMinY() == platform.getBoundsInParent().getMaxY()) {
                    m.getPartie().getPersonnage().setCoordonneeY(-acceleration);
                    return;
                }
            }
        }
        m.getPartie().avancerY(-acceleration);
    }

    public void fin() {
        if (m.getPartie().getPersonnage().getCoordonneeY() >= 600) {
            Alert a = new Alert(Alert.AlertType.INFORMATION, "Vous avez perdu");
            a.setTitle("Oups");
            a.setContentText("Vous avez perdu");
            Stage st = (Stage) a.getDialogPane().getScene().getWindow();
            st.getScene().getStylesheets().addAll(test.getScene().getStylesheets());
            a.setHeaderText("");
            st.getIcons().add(new Image("https://studio.code.org/media?u=https%3A%2F%2Fd30y9cdsu7xlg0.cloudfront.net%2Fpng%2F116547-200.png"));
            boucle.stop();
            stage.close();
            a.show();
        }
        if( arrivee.getBoundsInParent().intersects(m.getPartie().getPersonnage().getRectangle().getBoundsInParent())){
            try {
                boucle.stop();
                ChoixPseudo cont = new ChoixPseudo(m);
                FXMLLoader root = new FXMLLoader(getClass().getResource("/fxml/ChoixPseudo.fxml"));
                root.setController(cont);
                Scene oldScene = stage.getScene();
                Scene sc = new Scene(root.load(), oldScene.getWidth(), oldScene.getHeight());
                sc.getStylesheets().addAll(test.getScene().getStylesheets());
                stage.setScene(sc);
            } catch (IOException ioe) {
                ioe.printStackTrace();
                AlertCustom ab = new AlertCustom(Alert.AlertType.INFORMATION);
                ab.show();
                stage.close();
            }
        }
    }

}



