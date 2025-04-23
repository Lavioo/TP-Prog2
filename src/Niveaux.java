import eko.EKOTouche;

public class Niveaux extends Ecran{

    private boolean echapAppuye = true;

    @Override
    protected void chargerObjets() {

    }

    @Override
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
