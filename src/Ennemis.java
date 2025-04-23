public abstract class Ennemis extends ObjetVivant{
    protected Ennemis(String nom, int x, int y) {
        super(nom, x, y);
    }

    @Override
    protected void mettreAJour() {
        gererIntelligenceArtificielle();
    }

    protected abstract void gererIntelligenceArtificielle();
}
