import eko.*;

public class Auteurs extends Intro {






    protected Auteurs(String nom, int x, int y) {
        super(nom, x, y);
        this.nom = "Thierry Bédard & Vincent Robert";
        trameSonore = EKOAudio.charger("Audios\\EBK Jaaybo - Fck Everybody (Free Maxx) [Official Music Video].wav");
        EKOAudio.jouer(trameSonore, true);
        EKOConsole.couleurFond(EKOCouleur.NOIR);
        EKOConsole.couleurTexte(EKOCouleur.GRIS_PALE);


    }


    @Override
    public void dessiner() {


        EKOConsole.afficher(x, y, nom);


        EKOConsole.afficher(x2, y + 6, continuer, EKOCouleur.GRIS_FONCE);


    }


    @Override
    protected void mettreAJour(long deltaTemps) {

        if (EKOTouche.ESPACE.estEnfoncee()) {

            TitreJeu titre = new TitreJeu("Jeu Méga On", 50, 15);
            this.desactiver();
        }

    }


}
