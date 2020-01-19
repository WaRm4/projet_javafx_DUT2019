package model.Persistance;

import model.ListePartie;
import model.Score;
import java.io.*;
import java.net.URL;

/**
 * Classe implementant IpersistanceResultat qui permet de gerer les resultats stockes dans des fichiers texte.
 */
public class IResultatTxt implements IPersistanceResultat {
    /**
     * Sauvegarde les resultats dans un fichier texte.
     *
     * @param lp Le resultat a sauvegarder.
     */
    @Override
    public void sauvegarderResultat(ListePartie lp) {
        try {
            File fi =new File("resultats");
            boolean verif = fi.createNewFile();
            try (BufferedWriter out = new BufferedWriter(new FileWriter(fi))) {
                for(Score sc : lp.getLesParties())
                    out.write(sc.getPseudo() + " " + sc.getDifficulte() + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Charge les resultats a partir d'un fichier texte.
     *
     * @return le resultat charge.
     */
    @Override
    public ListePartie chargerResultat() {
        ListePartie lp = new ListePartie();
        String[] tab;
        InputStream flux;
        try {
            File fi =new File("resultats");
            if(!fi.exists()) {
                flux = getClass().getClassLoader().getResourceAsStream("Resultats/resultats");
                assert flux != null;
            }
            else {
                flux = new FileInputStream(fi);
            }
            InputStreamReader lecture = new InputStreamReader(flux);
            BufferedReader in = new BufferedReader(lecture);
            String ligne;
            String separateur = " ";
            while ((ligne = in.readLine()) != null) {
                tab = ligne.split(separateur);
                Score sc = new Score(tab[0], tab[1]);
                lp.addScore(sc);
            }
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return lp;
    }
}
