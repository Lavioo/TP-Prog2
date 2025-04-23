import eko.EKOConsole;
import eko.EKOCouleur;
import eko.EKOTouche;

import java.util.Arrays;
import java.util.HashMap;

public class Joueur extends ObjetVivant implements Collisionnable{

    private final float[] positionFlotante;
    private Position dernierePosition;
    boolean toucheAppuye;

    /*
    *     0
    *   1   2
    *     3
    */
    private Boolean[] mursAdjacents;

    private float vitesse = 10;

    protected Joueur(String nom, int x, int y) {
        super(nom, x, y);
        positionFlotante = new float[]{position.x, position.y};
        toucheAppuye = true;
        mursAdjacents = new Boolean[4];
        dernierePosition = new Position(position.x, position.y);
    }

    @Override
    protected void mettreAJour() {

        mettreAJourMurAdjacents();

        if(toucheAppuye)
            changerBool();
        else
            entreeUtilisateur();
    }

    private void changerBool(){
        if(!EKOTouche.W.estEnfoncee() && !EKOTouche.A.estEnfoncee() && !EKOTouche.S.estEnfoncee() && !EKOTouche.D.estEnfoncee())
            toucheAppuye = false;
    }

    private void entreeUtilisateur(){

        if(EKOTouche.SHIFT_GAUCHE.estEnfoncee())
            vitesse = 20;
        else
            vitesse = 10;

        if(Boolean.FALSE.equals(mursAdjacents[0]) && (EKOTouche.W.estEnfoncee() || EKOTouche.FLECHE_HAUT.estEnfoncee())){
            positionFlotante[1] -= vitesse * Temps.deltaTemps/1_000_000_000f;
        }
        if(Boolean.FALSE.equals(mursAdjacents[3]) && (EKOTouche.S.estEnfoncee() || EKOTouche.FLECHE_BAS.estEnfoncee())){
            positionFlotante[1] += vitesse * Temps.deltaTemps/1_000_000_000f;
        }

        if(Boolean.FALSE.equals(mursAdjacents[1]) && (EKOTouche.A.estEnfoncee() || EKOTouche.FLECHE_GAUCHE.estEnfoncee())){
            positionFlotante[0] -= vitesse * Temps.deltaTemps/1_000_000_000f;
        }
        if(Boolean.FALSE.equals(mursAdjacents[2]) && (EKOTouche.D.estEnfoncee() || EKOTouche.FLECHE_DROITE.estEnfoncee())){
            positionFlotante[0] += vitesse * Temps.deltaTemps/1_000_000_000f;
        }

        dernierePosition.x = position.x;
        dernierePosition.y = position.y;

        position.x = (int)positionFlotante[0];
        position.y = (int)positionFlotante[1];
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
            positionFlotante[0] = position.x;
            positionFlotante[1] = position.y;
        }

        if (autre instanceof Collectible){
            ((Collectible) autre).ramasser();
        }

        if (autre instanceof Ennemis){
            for(ObjetJeu o : GestionnaireObjetsJeu.obtenir().trouverObjetsJeu(Etiquette.OBJET_VIVANT)){
                retournerPositionDepart();
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

    @Override
    public void retournerPositionDepart(){
        position.x = depart.x;
        position.y = depart.y;

        positionFlotante[0] = position.x;
        positionFlotante[1] = position.y;
    }
}
