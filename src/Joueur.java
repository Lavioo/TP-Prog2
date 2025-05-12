import eko.EKOConsole;
import eko.EKOCouleur;
import eko.EKOTouche;

import java.util.Arrays;
import java.util.HashMap;

public class Joueur extends ObjetVivant implements Collisionnable{

    private Position dernierePosition;
    private boolean toucheAppuye;
    private long vitesse = 100050000;
    private long tempEcoule = 0;

    /*
    *     0
    *   1   2
    *     3
    */
    private Boolean[] mursAdjacents;

    protected Joueur(String nom, int x, int y) {
        super(nom, x, y);
        toucheAppuye = true;
        mursAdjacents = new Boolean[4];
        dernierePosition = new Position(position.x, position.y);
    }

    @Override
    protected void mettreAJour() {
        tempEcoule+=Temps.deltaTemps;

        if(tempEcoule > vitesse) {

            mettreAJourMurAdjacents();

            if (toucheAppuye)
                changerBool();
            else
                entreeUtilisateur();

            tempEcoule -= vitesse;
        }
    }

    private void changerBool(){
        if(!EKOTouche.W.estEnfoncee() && !EKOTouche.A.estEnfoncee() && !EKOTouche.S.estEnfoncee() && !EKOTouche.D.estEnfoncee())
            toucheAppuye = false;
    }

    private void entreeUtilisateur(){
        dernierePosition.x = position.x;
        dernierePosition.y = position.y;

        if(EKOTouche.SHIFT_GAUCHE.estEnfoncee())
            vitesse = 85000000;
        else
            vitesse = 100500000;

        if(Boolean.FALSE.equals(mursAdjacents[0]) && (EKOTouche.W.estEnfoncee() || EKOTouche.FLECHE_HAUT.estEnfoncee())){
            position.y --;
        }
        if(Boolean.FALSE.equals(mursAdjacents[3]) && (EKOTouche.S.estEnfoncee() || EKOTouche.FLECHE_BAS.estEnfoncee())){
            position.y ++;
        }

        if(Boolean.FALSE.equals(mursAdjacents[1]) && (EKOTouche.A.estEnfoncee() || EKOTouche.FLECHE_GAUCHE.estEnfoncee())){
            position.x --;
        }
        if(Boolean.FALSE.equals(mursAdjacents[2]) && (EKOTouche.D.estEnfoncee() || EKOTouche.FLECHE_DROITE.estEnfoncee())){
            position.x ++;
        }
    }

    private void mettreAJourMurAdjacents(){
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

    @Override
    protected void dessiner() {
        EKOConsole.afficher(position.x, position.y, "\uF4FF", EKOCouleur.VERT);
    }

    @Override
    public void gererCollisionAvec(ObjetJeu autre) {

        if (autre instanceof Mur){
            position.x = dernierePosition.x;
            position.y = dernierePosition.y;
        }

        if (autre instanceof Collectible){
            ((Collectible) autre).ramasser();
        }

        if (autre instanceof Ennemis){
            for(ObjetJeu o : GestionnaireObjetsJeu.obtenir().trouverObjetsJeu(Etiquette.OBJET_VIVANT)){
                ((ObjetVivant)o).retournerPositionDepart();
            }
            Vie.perdrePointDeVie(autre.getClass());
        }

        if (autre instanceof Portail){
            ((Portail) autre).passerAMap();
        }
    }

    public boolean egalePositionMur(int index, int offset){
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
}
