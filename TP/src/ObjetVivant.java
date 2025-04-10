public abstract class ObjetVivant extends ObjetJeu implements Collisionnable{
    protected ObjetVivant(String nom, int x, int y) {
        super(nom, x, y);
    }

    @Override
    protected void mettreAJour(long deltaTemps) {

    }

    @Override
    protected void dessiner() {

    }

    @Override
    public void gererCollisionAvec(ObjetJeu autre) {

    }
}
