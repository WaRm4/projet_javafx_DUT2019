package model.Persistance;

import javafx.scene.Node;
import model.Carte;
import model.Personnage;
import model.Plateforme;
import java.io.*;
import java.util.ArrayList;

/**
 * ICarteTxt implemente IPersistanceCarte, c'est la classe qui gere la persistance d'une Carte dans un fichier Texte.
 */
public class ICarteTxt implements IPersistanceCarte {

    /**
     * Constructeur de ICarteTxt.
     */
    public ICarteTxt() {
    }

    /**
     * Charge une carte a partir d'un fichier .txt .
     * @return la carte chargee.
     */
    @Override
    public Carte chargerCarte(String nom, String imgPerso) {

        int tab[][] = new int[11][19];
        int i = 0, j = 0;
        String[] tab2;
        try {
            InputStream flux = new FileInputStream("ressource/Cartes/" + nom);
            InputStreamReader lecture = new InputStreamReader(flux);
            BufferedReader buff = new BufferedReader(lecture);
            String ligne;
            String separateur = " ";
            while ((ligne = buff.readLine()) != null) {
                tab2 = ligne.split(separateur);
                for (String coord : tab2) {
                    tab[i][j] = Integer.parseInt(coord);
                    j++;
                }
                i++;
                j = 0;
            }
            buff.close();
        } catch (IOException e) {
            System.out.println(e);
        }

        int proportion = 50;
        ArrayList<Node> platforms = new ArrayList();
        Personnage player = null;
        int[] coordArrivee = new int[2];
        for (i = 0; i < 19; i++) {
            for (j = 0; j < 11; j++) {
                if (tab[j][i] == 1) {
                    Plateforme platform = new Plateforme(i * proportion, j * proportion, proportion, proportion, "/images/brick.png");
                    platforms.add(platform.getRectangle());
                }
                if (tab[j][i] == 3) {
                    player = new Personnage(i * proportion, j * proportion, "Jean",proportion-5, proportion, imgPerso);
                }
                if(tab[j][i] == 2){
                    Plateforme platform = new Plateforme(i * proportion, j * proportion, proportion, proportion, "/images/plateforme.jpg");
                    platforms.add(platform.getRectangle());
                }
                if(tab[j][i] == 4){
                    Plateforme platform = new Plateforme(i * proportion, j * proportion, proportion, proportion, "/images/dep-arr.png");
                    platforms.add(platform.getRectangle());
                    coordArrivee[0] = i * proportion;
                    coordArrivee[1] = j * proportion;
                }
            }
        }

        Carte c = new Carte(nom, platforms, player, coordArrivee);
        return c;
    }
}
