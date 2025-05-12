import eko.EKOConsole;
import eko.EKOCouleur;

public class EditeurCurseur extends ObjetJeu{

    private int nbrFrame;
    private boolean flip;
    private int alpha;

    protected EditeurCurseur(String nom, int x, int y) {
        super(nom, x, y);

        nbrFrame = 0;
        flip = true;
        alpha = 255;
    }

    @Override
    protected void mettreAJour() {
        animation();
    }

    @Override
    protected void dessiner() {
        EKOConsole.afficher(this.position.x, this.position.y, "_", EKOCouleur.RVB(255, 255, 255, alpha));
    }

    private void animation(){
        nbrFrame++;
        if (nbrFrame > Temps.getTPS()/3) {
            nbrFrame = 0;
            if (flip){
                alpha = 0;
                flip = !flip;
            }
            else {
                alpha = 255;
                flip = !flip;
            }
        }
    }
}
