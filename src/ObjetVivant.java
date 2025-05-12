public abstract class ObjetVivant extends ObjetJeu{

    protected final Position depart;
    protected float vitesse = 15;

    protected ObjetVivant(String nom, int x, int y) {
        super(nom, x, y, Etiquette.OBJET_VIVANT);
        depart = new Position(x, y);
    }

    public void retournerPositionDepart(){
        position.x = depart.x;
        position.y = depart.y;
    }
}
