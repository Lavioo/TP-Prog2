import eko.EKOConsole;
import eko.EKOCouleur;
import eko.EKOTouche;

public class Curseur extends ObjetJeu{

    private PositionCurseur[] positions;
    private int positionCurseur;
    private int nbrFrameAnim;
    private boolean directionGauche;

    //0 = W ou fleche haut
    //1 = S ou fleche bas
    private final boolean[] toucheAppuye;

    protected Curseur(String nom, int x, int y) {
        super(nom, x, y);

        positionCurseur = 0;
        positions = new PositionCurseur[]{PositionCurseur.JOUER, PositionCurseur.NIVEAUX, PositionCurseur.QUITTER};

        nbrFrameAnim = 0;
        directionGauche = true;
        toucheAppuye = new boolean[]{true, true};
    }

    @Override
    protected void mettreAJour() {
        animation();
        if (toucheAppuye[0] || toucheAppuye[1])
            changerBool();

        if (!toucheAppuye[0] || !toucheAppuye[1])
            entreeUtilisateur();
    }

    private void animation(){
        nbrFrameAnim++;
        if (nbrFrameAnim > Temps.getTPS()/3) {
            position.x = directionGauche ? position.x-1 : position.x+1;
            directionGauche = !directionGauche;
            nbrFrameAnim = 0;
        }
    }

    private void changerBool(){
        if(!EKOTouche.W.estEnfoncee() && !EKOTouche.FLECHE_HAUT.estEnfoncee())
            toucheAppuye[0] = false;
        if(!EKOTouche.S.estEnfoncee() && !EKOTouche.FLECHE_BAS.estEnfoncee())
            toucheAppuye[1] = false;
    }

    private void entreeUtilisateur(){
        if(!toucheAppuye[0] && positionCurseur > 0 && (EKOTouche.W.estEnfoncee() || EKOTouche.FLECHE_HAUT.estEnfoncee())){

            Son.jouerSon(SonNom.CHANGE_SELECTION);

            toucheAppuye[0] = true;
            positionCurseur--;

            position.y -= EcranTitre.DISTANCE_ENTRE_OPTIONS;
        }

        if(!toucheAppuye[1] && positionCurseur < 2 && (EKOTouche.S.estEnfoncee() || EKOTouche.FLECHE_BAS.estEnfoncee())){

            Son.jouerSon(SonNom.CHANGE_SELECTION);

            toucheAppuye[1] = true;
            positionCurseur++;

            position.y += EcranTitre.DISTANCE_ENTRE_OPTIONS;
        }
    }

    public PositionCurseur getPointeurPosition(){
        return positions[positionCurseur];
    }

    @Override
    protected void dessiner() {
        EKOConsole.afficher(position.x, position.y, ">", EKOCouleur.BLANC);
    }
}
