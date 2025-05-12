import eko.EKOTouche;

public class Parametres extends Ecran{

    private boolean echapAppuye = true;

    public Parametres(){
        chargerObjets();
    }

    @Override
    protected void chargerObjets() {
        listeObjetEcran.add(new Texte("Difficulté: ☒☐", 0, 0));
    }

    protected void mettreAJour(long deltaTemps) {
        if (echapAppuye){
            if(!EKOTouche.ECHAPPEMENT.estEnfoncee())
                echapAppuye = false;
        }

        if (!echapAppuye)
            entreeUtilisateur();
    }

    private void entreeUtilisateur(){
        if (EKOTouche.ECHAPPEMENT.estEnfoncee() && !echapAppuye) {
            effacerEcran();
            Ecran.setEcranCourant(new EcranTitre());
        }
    }

    @Override
    protected void setNouvelEcran() {

    }
}
