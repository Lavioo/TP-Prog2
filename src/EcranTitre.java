import eko.EKOConsole;
import eko.EKOCouleur;
import eko.EKOTouche;

public class EcranTitre extends Ecran{

    private boolean[] toucheAppuye = new boolean[]{true, true}; //0 = espace, 1 = Echap, 2 = Enter ou fleche droite ou D

    public final static int DISTANCE_ENTRE_OPTIONS = 2;

    public EcranTitre(){
        chargerObjets();
    }

    @Override
    protected void chargerObjets() {
        int y = EKOConsole.hauteur()/2 - 6;
        listeObjetEcran.add(new Texte("@..@", y, true));
        y++;
        listeObjetEcran.add(new Texte("(----)", y, true));
        y++;
        listeObjetEcran.add(new Texte("( >__< )", y, true));
        y++;
        listeObjetEcran.add(new Texte("^^ ~~ ^^", y, true));
        y++;
        listeObjetEcran.add(new Texte("FROGGYRINTHE", y, EKOCouleur.VERT, true));

        y+=3;
        listeObjetEcran.add(new Curseur("curseur", 0, y));
        listeObjetEcran.add(new Texte("Jouer", y, true));

        y += DISTANCE_ENTRE_OPTIONS;

        listeObjetEcran.add(new Texte("Niveaux", y, true));

        y += DISTANCE_ENTRE_OPTIONS;

        listeObjetEcran.add(new Texte("Quitter", y, true));
    }

    @Override
    protected void mettreAJour(long deltaTemps) {
        if (toucheAppuye[0] || toucheAppuye[1])
            changerBool();

        if (!toucheAppuye[0] || !toucheAppuye[1])
            entreeUtilisateur();
    }

    @Override
    protected void setNouvelEcran() {
        Ecran.setEcranCourant(new Niveaux());
    }

    private void entreeUtilisateur(){

        if (EKOTouche.ECHAPPEMENT.estEnfoncee() && !toucheAppuye[1])
            System.exit(0);

        if (!toucheAppuye[0] && (EKOTouche.D.estEnfoncee() || EKOTouche.FLECHE_DROITE.estEnfoncee() || EKOTouche.ENTRER.estEnfoncee() || EKOTouche.ESPACE.estEnfoncee())){
            Son.jouerSon(SonNom.SELECT);
            switch (((Curseur)GestionnaireObjetsJeu.obtenir().trouverObjetJeu("curseur")).getPointeurPosition()){
                case JOUER ->{
                    effacerEcran();
                    Ecran.setEcranCourant(new Map(0));
                }
                case NIVEAUX -> {
                    effacerEcran();
                    setNouvelEcran();
                }
                case QUITTER -> System.exit(0);
            }
        }
    }

    private void changerBool(){
        if (!EKOTouche.ESPACE.estEnfoncee() && !EKOTouche.D.estEnfoncee() && !EKOTouche.FLECHE_DROITE.estEnfoncee() && !EKOTouche.ENTRER.estEnfoncee())
            toucheAppuye[0] = false;

        if (!EKOTouche.ECHAPPEMENT.estEnfoncee())
            toucheAppuye[1] = false;
    }
}
