import eko.EKO;
import eko.EKOConsole;
import eko.EKOCouleur;
import eko.EKOTouche;

public class TitreJeu extends Intro {


    private boolean estEnfoncee;

    protected TitreJeu(String nom, int x, int y) {
        super(nom, x, y);
        this.nom = "Jeu Méga On";
        estEnfoncee = true;

    }


    @Override
    public void dessiner() {


        EKOConsole.afficher(x, y, nom);

        EKOConsole.afficher(x2, y + 6, continuer, EKOCouleur.GRIS_FONCE);


    }


    @Override
    protected void mettreAJour(long deltaTemp) {

        if (!EKOTouche.ESPACE.estEnfoncee() && estEnfoncee) {
            estEnfoncee = false;
        }

        if (EKOTouche.ESPACE.estEnfoncee() && !estEnfoncee) {

            Maps maps = new Maps();
            this.desactiver();

        }

    }
}





