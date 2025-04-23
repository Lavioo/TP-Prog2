import eko.EKOConsole;
import eko.EKOCouleur;
import eko.EKOTouche;

public class EcranDeveloppeurs extends Ecran{

    boolean espaceAppuye = true;
    boolean echapAppuye = true;

    public EcranDeveloppeurs(){
        chargerObjets();
    }

    @Override
    protected void chargerObjets() {
        listeObjetEcran.add(new Texte("Développé par Vincent & Thierry", EKOConsole.hauteur()/2, EKOCouleur.GRIS_PALE, true));
    }

    @Override
    protected void mettreAJour(long deltaTemps) {
        if (espaceAppuye || echapAppuye)
            changerBool();

        if (!echapAppuye || !espaceAppuye)
            entreeUtilisateur();
    }

    private void entreeUtilisateur(){
        if (EKOTouche.ESPACE.estEnfoncee() && !espaceAppuye){
            effacerEcran();
            setNouvelEcran();
        }

        if (EKOTouche.ECHAPPEMENT.estEnfoncee() && !echapAppuye)
            System.exit(0);
    }

    private void changerBool(){
        if (!EKOTouche.ESPACE.estEnfoncee())
            espaceAppuye = false;

        if (!EKOTouche.ECHAPPEMENT.estEnfoncee())
            echapAppuye = false;
    }

    protected void setNouvelEcran(){
        Ecran.setEcranCourant(new EcranTitre());
    }
}
