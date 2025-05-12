import eko.EKOChaine;
import eko.EKOConsole;
import eko.EKOCouleur;

public class LangueGrenouille extends Ennemis{

    private EKOChaine caractere = new EKOChaine("\u257C", EKOCouleur.VERT);

    protected LangueGrenouille(String nom, int x, int y) {
        super(nom, x, y);
    }

    @Override
    protected void gererIntelligenceArtificielle() {

    }

    @Override
    protected void dessiner() {
        EKOConsole.afficher(position.x, position.y, caractere);
    }

    public void changerCaractere(boolean tire){
        if(tire)
            caractere = new EKOChaine("\u2500", EKOCouleur.VERT);
        else
            caractere = new EKOChaine("\u257C", EKOCouleur.VERT);
    }

    public void retournerCaractere(){
        caractere.retourner();
    }

    @Override
    public void retournerPositionDepart() {
        this.detruire();
    }
}
