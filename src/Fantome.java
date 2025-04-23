import eko.EKOChaine;
import eko.EKOConsole;
import eko.EKOCouleur;

public class Fantome extends Ennemis{

    private final EKOChaine CARACTERE = new EKOChaine("\uEEFE", EKOCouleur.GRIS_PALE);

    protected Fantome(String nom, int x, int y) {
        super(nom, x, y);
    }

    @Override
    protected void gererIntelligenceArtificielle() {

    }

    @Override
    protected void dessiner() {
        EKOConsole.afficher(position.x, position.y, CARACTERE);
    }
}
