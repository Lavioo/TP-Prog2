public abstract class Portail extends ObjetJeu{

    protected int mapIndex;

    protected Portail(String nom, int x, int y) {
        super(nom, x, y);
    }
    protected Portail(String nom, int x, int y, Etiquette etiquette) {
        super(nom, x, y, etiquette);
    }

    protected void passerAMap(){
        Ecran.getEcranCourant().effacerEcran();
        Ecran.setEcranCourant(new Map(mapIndex));
    }

}
