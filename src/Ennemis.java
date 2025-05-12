public abstract class Ennemis extends ObjetVivant{

    private long tempsEcoule = 0;

    protected Ennemis(String nom, int x, int y) {
        super(nom, x, y);
        vitesse = 100050000;
    }

    @Override
    protected void mettreAJour() {
        tempsEcoule += Temps.deltaTemps;
        if(tempsEcoule > vitesse) {
            gererIntelligenceArtificielle();
            tempsEcoule -= (long) vitesse;
        }
    }

    protected abstract void gererIntelligenceArtificielle();
}
