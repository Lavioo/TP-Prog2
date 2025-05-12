import eko.EKOConsole;
import eko.EKOTouche;

import java.util.Stack;

public class EditeurMap extends Ecran {

    private ObjetJeu[][] tableauObjet = new ObjetJeu[EKOConsole.largeur()][EKOConsole.hauteur()];
    private EditeurCurseur curseur;
    private StringBuilder map;
    private int nbrFrame;

    public EditeurMap() {
        chargerObjets();
        map = new StringBuilder();
        nbrFrame = 0;
    }

    @Override
    protected void chargerObjets() {
        curseur = new EditeurCurseur("curseurNiveau ", 0, 0);
        listeObjetEcran.add(curseur);
    }

    @Override
    protected void mettreAJour(long deltaTemps) {
        if(nbrFrame % (Temps.getTPS() / 10) == 0)
            inputUtilisateur();

        nbrFrame++;
    }

    @Override
    protected void setNouvelEcran() {

    }


    private void inputUtilisateur() {
        if (EKOTouche.EFFACER.estEnfoncee()) {
        }

        if ((EKOTouche.SHIFT_GAUCHE.estEnfoncee() || EKOTouche.SHIFT_DROIT.estEnfoncee()) && EKOTouche.TROIS.estEnfoncee()) {
            tableauObjet[curseur.position.x][curseur.position.y] = new Mur("mur", curseur.position.x, curseur.position.y);
            listeObjetEcran.add(tableauObjet[curseur.position.x][curseur.position.y]);
            map.append('#');
            curseur.position.x++;
        }
        if (EKOTouche.ENTRER.estEnfoncee()) {
            listeObjetEcran.add(new Texte("\n", curseur.position.x, curseur.position.y));
            map.append('\n');
            curseur.position.x = 0;
            curseur.position.y++;
        }

        if (EKOTouche.P.estEnfoncee()){
            tableauObjet[curseur.position.x][curseur.position.y] = new Joueur("joueur", curseur.position.x, curseur.position.y);
            listeObjetEcran.add(tableauObjet[curseur.position.x][curseur.position.y]);
            map.append('J');
            curseur.position.x++;
        }

        if (EKOTouche.FLECHE_HAUT.estEnfoncee())
            curseur.position.y = Math.max(0, curseur.position.y - 1);
        if (EKOTouche.FLECHE_BAS.estEnfoncee())
            curseur.position.y = Math.min(EKOConsole.hauteur(), curseur.position.y + 1);

        if (EKOTouche.FLECHE_DROITE.estEnfoncee())
            curseur.position.x = Math.min(EKOConsole.largeur(), curseur.position.x + 1);
        if (EKOTouche.FLECHE_GAUCHE.estEnfoncee())
            curseur.position.x = Math.max(0, curseur.position.x - 1);
    }
}

