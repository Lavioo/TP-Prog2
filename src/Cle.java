import eko.EKOConsole;
import eko.EKOCouleur;

public class Cle extends Collectible{

    protected Cle(String nom, int x, int y) {
        super(nom, x, y);
    }

    @Override
    public void ramasser() {
        Son.jouerSon(SonNom.CLE);
        ((Map)Ecran.getEcranCourant()).cleRamasser();
        detruire();
    }

    @Override
    protected void mettreAJour() {

    }

    @Override
    protected void dessiner() {
        EKOConsole.afficher(position.x, position.y, "\uF084", EKOCouleur.JAUNE);
    }
}
