import eko.EKO;

public class Jeu {

    private static final int LARGEUR = 40;
    private static final int HAUTEUR = LARGEUR / 2;
    private static final String TITRE = "Froggyrinthe";



    public static void init(){
        ChargerCheminsMaps.remplirCheminsMaps();
        Son.chargerSons();

        EKO.initialiser(TITRE, LARGEUR, HAUTEUR);
        Ecran.setEcranCourant(new EcranDeveloppeurs());

        Son.jouerSon(SonNom.MUSIQUE_BOUCLE, true);
        loop();
    }

    private static void loop(){

        while(true){
            Temps.Chrono();

            GestionnaireObjetsJeu.obtenir().mettreAJour(Temps.deltaTemps / 1_000_000);
            GestionnaireObjetsJeu.obtenir().dessiner();

            if (Temps.getTempsAttente() >  0){
                EKO.attendre(Temps.tempsAttente);
            }

        }

    }
}
