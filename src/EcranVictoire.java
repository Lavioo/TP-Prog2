import eko.EKOConsole;
import eko.EKOCouleur;
import eko.EKOTouche;

public class EcranVictoire extends Ecran{

    private boolean[] toucheAppuye = new boolean[]{true, true};

    public EcranVictoire(){
        chargerObjets();
    }

    @Override
    protected void chargerObjets() {
        listeObjetEcran.add(new Texte("Vous avez gagner!", EKOConsole.hauteur() / 2 , EKOCouleur.JAUNE, true));
        listeObjetEcran.add(new Texte("Ça vous aura pris " + (Vie.getEssais() + 1) + " essais", EKOConsole.hauteur() / 2 + 1 , EKOCouleur.BLEU, true));
    }

    @Override
    protected void mettreAJour(long deltaTemps) {
        if (toucheAppuye[0] || toucheAppuye[1])
            changerBool();

        if (!toucheAppuye[0] || !toucheAppuye[1])
            entreeUtilisateur();
    }

    private void entreeUtilisateur(){

        if (EKOTouche.ECHAPPEMENT.estEnfoncee() || EKOTouche.ESPACE.estEnfoncee() || EKOTouche.ENTRER.estEnfoncee()) {
            setNouvelEcran();
        }
    }

    private void changerBool(){
        if (!EKOTouche.ESPACE.estEnfoncee() && !EKOTouche.D.estEnfoncee() && !EKOTouche.FLECHE_DROITE.estEnfoncee() && !EKOTouche.ENTRER.estEnfoncee())
            toucheAppuye[0] = false;

        if (!EKOTouche.ECHAPPEMENT.estEnfoncee())
            toucheAppuye[1] = false;
    }

    @Override
    protected void setNouvelEcran() {
        this.effacerEcran();
        Ecran.getEcranCourant().effacerEcran();
        Ecran.setEcranCourant(new EcranTitre());
    }
}
