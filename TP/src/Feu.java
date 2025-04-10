import eko.EKOChaine;
import eko.EKOConsole;
import eko.EKOCouleur;

import java.util.Random;

public class Feu extends Ennemis{

    private Random rand = new Random();;
    private EKOChaine caractere = new EKOChaine("\uE3BF", EKOCouleur.RVB(Math.max(rand.nextInt(256), 200), rand.nextInt(170), 0));

    protected Feu(String nom, int x, int y, Etiquette all) {
        super(nom, x, y);
    }

    @Override
    protected void mettreAJour(long deltaTemps) {
        if(rand.nextBoolean()){
            caractere.retourner();
        }
    }

    @Override
    protected void dessiner() {
        EKOConsole.afficher(position.x, position.y, caractere);
    }
}
