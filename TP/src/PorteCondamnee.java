import eko.EKOChaine;
import eko.EKOConsole;
import eko.EKOCouleur;

public class PorteCondamnee extends ObjetsCollisions{

    private final EKOChaine caractere = new EKOChaine("\u2503", EKOCouleur.GRIS);

    protected PorteCondamnee(String nom, int x, int y) {
        super(nom, x, y);
    }


    @Override
    protected void mettreAJour(long deltaTemps) {

    }

    @Override
    protected void dessiner() {
     EKOConsole.afficher(position.x, position.y, caractere);
    }


}