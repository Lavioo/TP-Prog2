import eko.EKO;
import eko.EKOConsole;

public class Jeu {

    private static final int TPS = 20;
    private static final long MS_PAR_TRAME = 1000 / TPS;

    public static void init(){
        LireMap.OuvrirMap();
        EKO.initialiser("Froggyrinthe", 50, 15);
        loop();
    }

    private static void loop(){
        long tempsAttente;
        long maintenant;
        long deltaTemps;
        long dernierTemps = System.nanoTime();
        Maps carte = new Maps();
        while (true){
            EKOConsole.effacer();

            maintenant = System.nanoTime();
            deltaTemps = maintenant - dernierTemps;
            dernierTemps = maintenant;

            GestionnaireObjetsJeu.obtenir().mettreAJour(deltaTemps/1_000_000);
            GestionnaireObjetsJeu.obtenir().dessiner();

            EKOConsole.rendre();

            tempsAttente = MS_PAR_TRAME - (System.nanoTime() - dernierTemps) / 1_000_000;
            if (tempsAttente > 0){
                EKO.attendre(tempsAttente);
            }
        }
    }
}
