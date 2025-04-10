import java.util.ArrayList;

public class Maps{
    ObjetJeu[][] maps;
    private int indexCarte = 0;
    public Maps(){
        char [][] cartes = LireMap.listeCartes.get(indexCarte);
        maps = new ObjetJeu[cartes[0].length][cartes.length];

        for (int y = 0; y < maps[0].length; y++) {
            for (int x = 0; x < maps.length; x++) {
                creerObjet(cartes[y][x], y, x);
            }
        }
    }

    private void creerObjet(char valeur, int y, int x){
        switch (valeur){
            case '#': maps[x][y] = new Mur("Mur", x, y, Etiquette.ALL);
            break;
            case 'J': maps[x][y] = new Joueur("Joueur", x, y, Etiquette.ALL);
            break;
            case 'C': maps[x][y] = new Cle("cle", x, y, Etiquette.ALL);
            break;
            case 'F': maps[x][y] = new Feu("Feu", x, y, Etiquette.ALL);
            break;
            case 'V': maps[x][y] = new PorteVerouille("PorteVerouille", x, y, Etiquette.ALL);
            break;
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
