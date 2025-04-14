import eko.EKO;
import eko.EKOConsole;
import eko.EKOCouleur;
import eko.EKOTouche;

public class TitreJeu extends Intro{



   protected TitreJeu(String nom, int x, int y) {
       super(nom, x, y);
       this.nom = "Jeu Méga On";
   }



   @Override
   public void dessiner () {

       int alhpa = 0;



       EKOConsole.afficher(x,y, nom);

       EKO.attendre(2000);

       for (int alpha = 0; alpha < 255; alpha += 2) {
           EKOConsole.afficher(x2, y + 6, continuer, EKOCouleur.GRIS_FONCE);
           EKOConsole.afficher(x2, y + 6, continuer, EKOCouleur.RVB(128, 128, 128, alpha));
           EKO.attendre(10);
           if (EKOTouche.ESPACE.estEnfoncee()) {
               break;
           }
       }

       while (!EKOTouche.ESPACE.estEnfoncee()) {
           EKO.attendre(100);
       }

       EKOConsole.effacer();



   }














}





