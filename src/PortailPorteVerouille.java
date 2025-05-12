public class PortailPorteVerouille extends Portail{

    protected PortailPorteVerouille(String nom, int x, int y) {
        super(nom, x, y, Etiquette.PORTE);
        mapIndex = ((Map)Ecran.getEcranCourant()).getIndex() + 1;
    }

    @Override
    protected void mettreAJour() {

    }

    @Override
    protected void dessiner() {

    }
}
