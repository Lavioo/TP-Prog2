import eko.EKOConsole;
import eko.EKOCouleur;

public class PorteVerouille extends PorteCondamne{
    protected PorteVerouille(String nom, int x, int y) {
        super(nom, x, y);
    }

    @Override
    protected void dessiner() {
        EKOConsole.afficher(position.x, position.y, CARACTERE, EKOCouleur.BLEU);
    }

}
