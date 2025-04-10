import eko.EKOConsole;
import eko.EKOCouleur;
import eko.EKOTouche;

import java.util.ArrayList;

public class Joueur extends ObjetVivant{

    private static String caractere = "\uF4FF";
    private int []dernierePosition;

    protected Joueur(String nom, int x, int y, Etiquette all) {
        super(nom, x, y);
    }

    @Override
    protected void mettreAJour(long deltaTemps) {
        dernierePosition = new int[]{position.x, position.y};
        entreUtilisateur();
    }

    @Override
    protected void dessiner() {
        EKOConsole.afficher(position.x, position.y, caractere, EKOCouleur.JAUNE);
    }

    @Override
    public void gererCollisionAvec(ObjetJeu autre){
        if (autre instanceof Mur || autre instanceof PorteVerouille){
            position.x = dernierePosition[0];
            position.y = dernierePosition[1];
        }
        if (autre instanceof Cle){
            autre.desactiver();
            GestionnaireObjetsJeu.obtenir().trouverObjetJeu("PorteVerouille").desactiver();
        }
        if (autre instanceof Ennemis){
            Maps.reload();
        }
    }

    private void entreUtilisateur(){
        if (EKOTouche.W.estEnfoncee() || EKOTouche.FLECHE_HAUT.estEnfoncee()){
            position.y--;
        }
        if (EKOTouche.S.estEnfoncee() || EKOTouche.FLECHE_BAS.estEnfoncee()){
            position.y++;
        }
        if (EKOTouche.A.estEnfoncee() || EKOTouche.FLECHE_GAUCHE.estEnfoncee()){
            position.x--;
        }
        if (EKOTouche.D.estEnfoncee() || EKOTouche.FLECHE_DROITE.estEnfoncee()){
            position.x++;
        }
    }
}
