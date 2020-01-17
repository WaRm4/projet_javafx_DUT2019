package model.Persistance;

import model.ListePartie;
import model.Score;
import java.io.*;

/**
 * Classe implementant IpersistanceResultat qui permet de gerer les resultats stockes dans des fichiers Xml.
 */
public class IResultatTxt implements IPersistanceResultat {
    /**
     * Sauvegarde les resultats dans un fichier Xml.
     *
     * @param lp Le resultat a sauvegarder.
     */
    @Override
    public void sauvegarderResultat(ListePartie lp) {
        try {
            try (BufferedWriter out = new BufferedWriter(new FileWriter(new File("ressource/Resultats/resultats")))) {
                for(Score sc : lp.getLesParties())
                    out.write(sc.getPseudo() + " " + sc.getDifficulte() + "\n");
                
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Charge les resultats a partir d'un fichier Xml.
     *
     * @return le resultat charge.
     */
    @Override
    public ListePartie chargerResultat() {
        ListePartie lp = new ListePartie();
        String[] tab;
        try {
            BufferedReader in = new BufferedReader(new FileReader(new File("ressource/Resultats/resultats")));
            String ligne;
            String separateur = " ";
            while ((ligne = in.readLine()) != null) {
                tab = ligne.split(separateur);
                Score sc = new Score(tab[0], tab[1]);
                lp.addScore(sc);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return lp;
    }
}
