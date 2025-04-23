import eko.EKOChaine;
import eko.EKOConsole;
import eko.EKOCouleur;

import java.util.Random;

public class Feu extends Ennemis{

    private final Random rand = new Random();

    private final EKOChaine CARACTERE;

    protected Feu(String nom, int x, int y) {
        super(nom, x, y);
        CARACTERE = new EKOChaine("\uE3BF", EKOCouleur.RVB(255, rand.nextInt(60, 180), 0));
    }

    @Override
    protected void gererIntelligenceArtificielle() {
        if(rand.nextBoolean())
            CARACTERE.retourner();
    }

    @Override
    protected void dessiner() {
        EKOConsole.afficher(position.x, position.y, CARACTERE);
    }
}
