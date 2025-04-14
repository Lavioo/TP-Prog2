import java.util.ArrayList;

public class Maps{
    ObjetJeu[][] maps;
    private int indexCarte = 0;
    public Maps(){
        char [][] cartes = LireMap.listeCartes.get(indexCarte);


        for (int y = 0; y < cartes.length; y++) {
            for (int x = 0; x < cartes[0].length; x++) {
                creerObjet(cartes[y][x], y, x);
            }
        }
    }

    private void creerObjet(char valeur, int y, int x){
        switch (valeur){
            case '#': new Mur("Mur", x, y, Etiquette.ALL);
            break;
            case 'J': new Joueur("Joueur", x, y, Etiquette.ALL);
            break;
            case 'C': new Clef("cle", x, y, Etiquette.ALL);
            break;
            case 'F': new Feu("Feu", x, y, Etiquette.ALL);
            break;
            case 'V': new PorteVerouille("PorteVerouille", x, y, Etiquette.ALL);
            break;
            case 'P': new PorteCondamnee("PorteCondamnee", x, y);
        }
    }

    private void mapsComplete(){
        if (LireMap.listeCartes.size() > indexCarte + 1){
            indexCarte++;
        }
    }

    public static void reload(){
        ArrayList<ObjetJeu> objets = GestionnaireObjetsJeu.obtenir().trouverObjetsJeu(Etiquette.ALL);
        for (ObjetJeu o : objets){
            o.remettreAPosInitiale();
        }
    }
}
