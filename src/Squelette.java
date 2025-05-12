import eko.EKOChaine;
import eko.EKOConsole;
import eko.EKOCouleur;
import eko.EKOTouche;

public class Squelette extends Ennemis implements Collisionnable{

    private final EKOChaine CARACTERE = new EKOChaine("\uEE15", EKOCouleur.GRIS_PALE);
    private Position dernierePosition;

    /*
     *     0
     *   1   2
     *     3
     */
    private Boolean[] mursAdjacents;

    protected Squelette(String nom, int x, int y) {
        super(nom, x, y);
        mursAdjacents = new Boolean[4];
        dernierePosition = new Position(position.x, position.y);
        vitesse = 150000000;
    }

    @Override
    protected void gererIntelligenceArtificielle() {
        mettreAJourMurAdjacent();
        ObjetJeu joueur = GestionnaireObjetsJeu.obtenir().trouverObjetJeu("joueur");

        if(Boolean.FALSE.equals(mursAdjacents[2]) && position.x < joueur.getX()){
            position.x++;
        }
        if(Boolean.FALSE.equals(mursAdjacents[1]) && position.x > joueur.getX()){
            position.x--;
        }

        if(Boolean.FALSE.equals(mursAdjacents[0]) && position.y > joueur.getY()){
            position.y--;
        }
        if(Boolean.FALSE.equals(mursAdjacents[3]) && position.y < joueur.getY()){
            position.y++;
        }

        dernierePosition.x = position.x;
        dernierePosition.y = position.y;

    }

    private void mettreAJourMurAdjacent(){
        for (int i = 0; i < mursAdjacents.length; i++){
            mursAdjacents[i] = false;
            for(int j = 0; j < Mur.getPositionMurLength(); j++){
                if(egalePositionMur(j, i)) {
                    mursAdjacents[i] = true;
                    break;
                }
            }
        }
    }

    private boolean egalePositionMur(int index, int offset){
        int offsetX = 0;
        int offsetY = 0;

        switch (offset){
            case 0 -> offsetY = -1;
            case 1 -> offsetX = -1;
            case 2 -> offsetX = 1;
            case 3 -> offsetY = 1;
        }
        if(Mur.getPositionsMur(index).x == position.x + offsetX && Mur.getPositionsMur(index).y == position.y + offsetY)
            return true;
        return false;
    }

    @Override
    protected void dessiner() {
        EKOConsole.afficher(position.x, position.y, CARACTERE);
    }

    @Override
    public void gererCollisionAvec(ObjetJeu autre) {
        if (autre instanceof Mur){
            position.x = dernierePosition.x;
            position.y = dernierePosition.y;
        }
    }
}
