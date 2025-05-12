import eko.EKOChaine;
import eko.EKOConsole;
import eko.EKOCouleur;

import java.util.ArrayList;

public class Insecte extends Ennemis implements Collisionnable{

    private final EKOChaine CARACTERE = new EKOChaine("\uF188", EKOCouleur.MAGENTA);
    private Directions directionActuelle = Directions.DROITE;
    private Position dernierePos;

    protected Insecte(String nom, int x, int y) {
        super(nom, x, y);
    }

    @Override
    protected void gererIntelligenceArtificielle() {
        bouger();
    }

    private void bouger(){
        dernierePos = new Position(position.x, position.y);

        Position droite = null;
        Position enFace = null;
        Position gauche = null;
        Position basGauche = null;
        Position basDroite = null;
        Position hautGauche = null;
        Position hautDroite = null;

        switch (directionActuelle){
            case DROITE ->{
                droite = new Position(position.x, position.y + 1);
                gauche = new Position(position.x, position.y - 1);
                enFace = new Position(position.x + 1, position.y);
                basGauche = new Position(position.x - 1, position.y - 1);
                basDroite = new Position(position.x - 1, position.y + 1);
                hautGauche = new Position(position.x + 1, position.y - 1);
                hautDroite = new Position(position.x + 1, position.y + 1);
            }
            case GAUCHE -> {
                droite = new Position(position.x, position.y - 1);
                gauche = new Position(position.x, position.y + 1);
                enFace = new Position(position.x - 1, position.y);
                basGauche = new Position(position.x + 1, position.y + 1);
                basDroite = new Position(position.x + 1, position.y - 1);
                hautGauche = new Position(position.x - 1, position.y + 1);
                hautDroite = new Position(position.x - 1, position.y - 1);
            }
            case HAUT ->{
                droite = new Position(position.x + 1, position.y);
                gauche = new Position(position.x - 1, position.y);
                enFace = new Position(position.x, position.y - 1);
                basGauche = new Position(position.x - 1, position.y + 1);
                basDroite = new Position(position.x + 1, position.y + 1);
                hautGauche = new Position(position.x - 1, position.y - 1);
                hautDroite = new Position(position.x + 1, position.y - 1);
            }
            case BAS ->{
                droite = new Position(position.x - 1, position.y);
                gauche = new Position(position.x + 1, position.y);
                enFace = new Position(position.x, position.y + 1);
                basGauche = new Position(position.x + 1, position.y - 1);
                basDroite = new Position(position.x - 1, position.y - 1);
                hautGauche = new Position(position.x + 1, position.y + 1);
                hautDroite = new Position(position.x - 1, position.y + 1);
            }
        }

        if(estMur(droite) && !estMur(enFace)){
            
        } else if (estMur(droite) && estMur(enFace)) {
            directionActuelle = Directions.tourner90DegGauche(directionActuelle);
        } else if (estMur(basDroite) && !estMur(droite)) {
            directionActuelle = Directions.tourner90DegDroite(directionActuelle);
        }else if(estMur(gauche) && !estMur(enFace)){

        }else if(estMur(gauche) && estMur(enFace)){
            directionActuelle = Directions.tourner90DegDroite(directionActuelle);
        } else if (estMur(basGauche) && !estMur(gauche)) {
            directionActuelle = Directions.tourner90DegGauche(directionActuelle);
        }

        if(estPorte(hautDroite) || estPorte(enFace)){
            directionActuelle = Directions.tourner90DegGauche(Directions.tourner90DegGauche(directionActuelle));
        }else if(estPorte(hautGauche) || estPorte(enFace)){
            directionActuelle = Directions.tourner90DegGauche(Directions.tourner90DegGauche(directionActuelle));
        }

        switch (directionActuelle){
            case GAUCHE -> position.x--;
            case DROITE -> position.x++;
            case HAUT -> position.y --;
            case BAS -> position.y++;
        }
    }

    private boolean estMur(Position pos) {
        for (int i = 0; i < Mur.getPositionMurLength(); i++) {
            if (Mur.getPositionsMur(i).x == pos.x && Mur.getPositionsMur(i).y == pos.y) {
                return true;
            }
        }
        return false;
    }

    private boolean estPorte(Position pos) {
        ArrayList<ObjetJeu> p = GestionnaireObjetsJeu.obtenir().trouverObjetsJeu(Etiquette.PORTE);
        for(ObjetJeu o : p){
            if (pos.x == o.getX() && pos.y == o.getY()){
                return true;
            }
        }
        return false;
    }

    @Override
    protected void dessiner() {
        EKOConsole.afficher(position.x, position.y, CARACTERE);
    }

    @Override
    public void gererCollisionAvec(ObjetJeu autre) {
        if(autre instanceof Mur){
            position.x = dernierePos.x;
            position.y = dernierePos.y;
        }
    }

    public void retournerPositionDepart(){
        position.x = depart.x;
        position.y = depart.y;
        directionActuelle = Directions.DROITE;
    }
}
