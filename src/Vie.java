import eko.EKOConsole;
import eko.EKOCouleur;

public class Vie extends ObjetJeu{

    public static final int POINTS_VIE_MAX = 5;
    private static int vieActuelle = POINTS_VIE_MAX;

    private static int essais = 0;

    protected Vie(String nom, int x, int y) {
        super(nom, x, y);
    }

    @Override
    protected void mettreAJour() {

    }

    @Override
    protected void dessiner() {
        for (int i = 0; i < POINTS_VIE_MAX; i++){
            if(i>vieActuelle - 1){
                EKOConsole.afficher(i+1, this.position.y, "\uF08A");
            }else {
                EKOConsole.afficher(i+1, this.position.y, "\uEC04", EKOCouleur.ROUGE);
            }
        }
    }

    public static void remplirVie(){vieActuelle = POINTS_VIE_MAX;}

    public static void perdrePointDeVie(Class<?> c){
        vieActuelle -= 1;

        if (c == Feu.class)
            Son.jouerSon(SonNom.CONTACT_FEU);
        if (c == Fantome.class)
            Son.jouerSon(SonNom.CONTACT_ENNEMI);

        if (vieActuelle < 1){
            defaite();
        }

    }

    private static void defaite(){
        essais++;
        remplirVie();
        Ecran.getEcranCourant().effacerEcran();
        Ecran.setEcranCourant(new EcranPerdu());
    }

    public static int getEssais() {
        return essais;
    }
}
