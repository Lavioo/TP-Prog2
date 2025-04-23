import eko.EKOConsole;
import eko.EKOCouleur;

public class Texte extends ObjetJeu{

    private EKOCouleur couleurTexte;

    protected Texte(String texte, int x, int y, EKOCouleur couleurTexte) {
        super(texte, x, y);
        this.couleurTexte = couleurTexte;
    }

    protected Texte(String texte, int y, EKOCouleur couleurTexte, boolean centre) {
        super(texte, (EKOConsole.largeur()/2) - (texte.length()/2), y);
        this.couleurTexte = couleurTexte;
    }

    protected Texte(String texte, int y, boolean centre) {
        super(texte, (EKOConsole.largeur()/2) - (texte.length()/2), y);
        this.couleurTexte = EKOCouleur.BLANC;
    }

    protected Texte(String texte, int x, int y) {
        super(texte, x, y);
        this.couleurTexte = EKOCouleur.BLANC;
    }

    @Override
    protected void mettreAJour() {

    }

    @Override
    protected void dessiner() {
        EKOConsole.afficher(position.x, position.y, nom, couleurTexte);
    }
}
