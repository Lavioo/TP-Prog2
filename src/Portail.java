public abstract class Portail extends ObjetJeu{

    protected int mapIndex;

    protected Portail(String nom, int x, int y) {
        super(nom, x, y);
    }

    protected void passerAMap(){
        Ecran.getEcranCourant().effacerEcran();
        Ecran.setEcranCourant(new Map(mapIndex));
    }

}
