import eko.*;

public abstract class Intro extends ObjetJeu {

    protected int x;
    protected int y;
    protected int x2;
    protected static EKOSon trameSonore;
    protected final String continuer;

    protected Intro(String nom, int x, int y) {
        super(nom, x, y);
        this.x = ( EKOConsole.largeur() - nom.length() ) / 2;
        this.y = ( EKOConsole.hauteur() ) / 2;
        this.continuer = "Appuyer sur ESPACE pour continuer";
        this.x2 = ( EKOConsole.largeur() - continuer.length() ) / 2;

    }

    @Override
    protected abstract void mettreAJour(long deltaTemps);


    @Override
    protected void dessiner() {

    }








}

