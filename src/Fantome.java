import eko.EKOChaine;
import eko.EKOConsole;
import eko.EKOCouleur;

import java.util.Random;

public class Fantome extends Ennemis{

    private final EKOChaine CARACTERE = new EKOChaine("\uEEFE", EKOCouleur.GRIS_PALE);
    private final boolean HORIZONTAL = new Random().nextBoolean();
    private int droiteOuBas = -1; //-1 si vers la gauche et 1 si vers la droite pareille pour le haut et le bas

    protected Fantome(String nom, int x, int y) {
        super(nom, x, y);
    }

    @Override
    protected void gererIntelligenceArtificielle() {
            for (int i = 0; i < Mur.getPositionMurLength(); i++){
                if (HORIZONTAL){
                    if (Mur.getPositionsMur(i).y == position.y && Mur.getPositionsMur(i).x == position.x + droiteOuBas)
                        droiteOuBas = -droiteOuBas;
                }else{
                    if (Mur.getPositionsMur(i).x == position.x && Mur.getPositionsMur(i).y == position.y + droiteOuBas)
                        droiteOuBas = -droiteOuBas;
                }

            }

            if(HORIZONTAL) {
                position.x += droiteOuBas;
            }else{
                position.y += droiteOuBas;
            }
    }

    @Override
    protected void dessiner() {
        EKOConsole.afficher(position.x, position.y, CARACTERE);
    }
}
