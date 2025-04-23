import java.util.ArrayList;

public abstract class Ecran{

    private static Ecran ecranCourant;
    protected ArrayList<ObjetJeu> listeObjetEcran = new ArrayList<>();

    public Ecran(){
    }

    public static Ecran getEcranCourant() {return ecranCourant;}
    public static void setEcranCourant(Ecran nouvelEcran){ecranCourant = nouvelEcran;}

    protected void effacerEcran(){
        for(ObjetJeu o : listeObjetEcran){
            o.detruire();
        }
    }
    protected abstract void chargerObjets();
    protected abstract void mettreAJour(long deltaTemps);
    protected abstract void setNouvelEcran();
}
