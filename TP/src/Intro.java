import eko.EKOAudio;
import eko.EKOConsole;
import eko.EKOCouleur;
import eko.EKOSon;

public class Intro extends ObjetJeu {

    protected int x;
    protected int y;
    protected int x2;
    protected final EKOSon trameSonore;
    protected final String continuer;

    protected Intro(String nom, int x, int y) {
        super(nom, x, y);
        this.x = ( EKOConsole.largeur() - nom.length() ) / 2;
        this.y = ( EKOConsole.hauteur() ) / 2;
        this.trameSonore = EKOAudio.charger("Audios\\EBK Jaaybo - Fck Everybody (Free Maxx) [Official Music Video].wav");
        this.continuer = "Appuyer sur ESPACE pour continuer";
        this.x2 = ( EKOConsole.largeur() - continuer.length() ) / 2;
        EKOConsole.couleurFond(EKOCouleur.NOIR);
        EKOConsole.couleurTexte(EKOCouleur.GRIS_PALE);
    }

    @Override
    protected void mettreAJour(long deltaTemps) {

    }



    @Override
    protected void dessiner() {

    }

    public void jouerTrameSonore() {

        EKOAudio.jouer(trameSonore);

    }


}

