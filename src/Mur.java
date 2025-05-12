import eko.EKOConsole;
import eko.EKOCouleur;

import java.util.ArrayList;

public class Mur extends ObjetJeu{

    protected final String CARACTERE = "█";

    private static final ArrayList<Position> positionsMur = new ArrayList<>();

    protected Mur(String nom, int x, int y) {
        super(nom, x, y);
        positionsMur.add(new Position(x, y));
    }

    protected Mur(String nom, int x, int y, Etiquette etiquette) {
        super(nom, x, y, etiquette);
        positionsMur.add(new Position(x, y));
    }

    @Override
    protected void mettreAJour() {

    }

    @Override
    protected void dessiner() {
        EKOConsole.afficher(position.x, position.y, CARACTERE, EKOCouleur.GRIS_FONCE);
    }

    public static void viderListeMur(){positionsMur.clear();}

    public static int getPositionMurLength(){
        return positionsMur.size();
    }

    public static Position getPositionsMur(int index) {
        return positionsMur.get(index);
    }

    @Override
    public void detruire(){
        super.detruire();
        for (Position p : positionsMur){
            if(p.x == this.position.x && p.y == this.position.y){
                positionsMur.remove(p);
                break;
            }
        }
    }
}
