import eko.EKOChaine;
import eko.EKOConsole;
import eko.EKOCouleur;

public class PorteVerouille extends ObjetJeu{

    private EKOChaine caractere = new EKOChaine("\u2503", EKOCouleur.CYAN);

    protected PorteVerouille(String nom, int x, int y, Etiquette all) {
        super(nom, x, y);
    }

    @Override
    protected void mettreAJour(long deltaTemps) {

    }

    @Override
    protected void dessiner() {
        EKOConsole.afficher(position.x, position.y, caractere);
    }

    public void deverouiller(){
        this.detruire();
    }
}
