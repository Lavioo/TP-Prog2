import eko.EKOConsole;
import eko.EKOCouleur;

public class Mur extends ObjetJeu{

    private String caractere = "\u2588";

    protected Mur(String nom, int x, int y, Etiquette all) {
        super(nom, x, y);
    }

    @Override
    protected void mettreAJour(long deltaTemps) {

    }

    @Override
    protected void dessiner() {
        EKOConsole.afficher(position.x, position.y, caractere, EKOCouleur.GRIS_FONCE);
    }
}
