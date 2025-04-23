import eko.EKOConsole;
import eko.EKOCouleur;

public class PorteCondamne extends Mur{

    protected final String CARACTERE;

    protected PorteCondamne(String nom, int x, int y) {
        super(nom, x, y);
        CARACTERE = setCARACTERE();

    }

    private String setCARACTERE(){
        for(int i = 0; i < Mur.getPositionMurLength(); i++){
            if(Mur.getPositionsMur(i).x == position.x && Mur.getPositionsMur(i).y == position.y - 1) {
                return "\u2503";
            }
            if(Mur.getPositionsMur(i).x == position.x - 1 && Mur.getPositionsMur(i).y == position.y) {
                return "\u2501";
            }
        }
        return  "\u2588";
    }


    @Override
    protected void dessiner(){
        EKOConsole.afficher(position.x, position.y, CARACTERE, EKOCouleur.GRIS_FONCE);
    }
}
