public abstract class Collectible extends ObjetJeu{

    protected Collectible(String nom, int x, int y) {
        super(nom, x, y, Etiquette.COLLECTIBLE);
    }

    public abstract void ramasser();
}
