import eko.EKOConsole;
import eko.EKOCouleur;

public class Clef extends ObjetJeu implements Collisionnable{

    private static String caractere = "\uF084";

    protected Clef(String nom, int x, int y, Etiquette all) {
        super(nom, x, y);
    }

    @Override
    protected void mettreAJour(long deltaTemps) {

    }

    @Override
    protected void dessiner() {
        EKOConsole.afficher(position.x, position.y, caractere, EKOCouleur.JAUNE);
    }

    @Override
    public void gererCollisionAvec(ObjetJeu autre) {

    }
}
