import eko.EKOChaine;
import eko.EKOConsole;
import eko.EKOCouleur;

import java.util.Random;
import java.util.Stack;

public class Grenouille extends Ennemis{

    private final EKOChaine CARACTERE = new EKOChaine("\uEDF8", EKOCouleur.VERT);
    private Stack<LangueGrenouille> langues = new Stack<>();
    private int droitGauche = -1; //1 = droite, -1 = gauche
    private boolean retracte = false;

    protected Grenouille(String nom, int x, int y) {
        super(nom, x, y);
        for (int i = 0; i < Mur.getPositionMurLength(); i++) {
            if(Mur.getPositionsMur(i).x + 1 == position.x && Mur.getPositionsMur(i).y == position.y) {
                droitGauche = 1;
                break;
            }
        }
        if(droitGauche == -1){
            CARACTERE.retourner();
        }
    }

    @Override
    protected void gererIntelligenceArtificielle() {
        if(langues.size() <= new Random().nextInt(3, 5) && !retracte){
            if(!langues.isEmpty())
                langues.peek().changerCaractere(true);
            langues.push(new LangueGrenouille("langue", position.x + (droitGauche * (langues.size()+1)), position.y));
            if(droitGauche == -1){
                langues.peek().retournerCaractere();
            }
        }else {
            retracte = true;
        }

        if (retracte){
            langues.pop().detruire();
            if(!langues.isEmpty()) {
                langues.peek().changerCaractere(false);
                if (droitGauche == -1) {
                    langues.peek().retournerCaractere();
                }
            }
        }
        if(langues.isEmpty()){
            retracte = false;
        }
    }

    @Override
    protected void dessiner() {
        EKOConsole.afficher(position.x, position.y, CARACTERE);
    }

    @Override
    public void detruire() {
        while (!langues.isEmpty()){
            langues.pop().detruire();
        }
        super.detruire();
    }
}
