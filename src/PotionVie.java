import eko.EKOConsole;
import eko.EKOCouleur;

public class PotionVie extends Collectible{

    protected PotionVie(String nom, int x, int y) {
        super(nom, x, y);
    }

    @Override
    public void ramasser() {
        Son.jouerSon(SonNom.POTION_VIE);

       this.detruire();
       Vie.remplirVie();
    }

    @Override
    protected void mettreAJour() {

    }

    @Override
    protected void dessiner() {
        EKOConsole.afficher(position.x, position.y, "\uF0C3", EKOCouleur.ROUGE);
    }
}
