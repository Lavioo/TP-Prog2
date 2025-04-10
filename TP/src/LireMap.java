import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class LireMap {


    public static ArrayList<char[][]> listeCartes = new ArrayList<>();



    public static void OuvrirMap() {
    String [] cheminFichiersMaps;

    File f = new File ("CartesDeJeu");

    cheminFichiersMaps = f.list();
        for (String chemin : cheminFichiersMaps) {
            FileInputStream fichier = ouvrirFichierLecture("CartesDeJeu\\"+chemin);
            Scanner lecteurFichier = new Scanner(fichier);
            convertirEnTabChar(convertirEnString(lecteurFichier));
            fermerFichier(fichier);
        }
    }


private static ArrayList<String> convertirEnString (Scanner lecteurFichier){
        String ligne;
        ArrayList<String> listeLigne = new ArrayList<>();


        while (lecteurFichier.hasNext()) {
           ligne = lecteurFichier.nextLine();
           listeLigne.add(ligne);

    }
return listeLigne;

}


private static void convertirEnTabChar (ArrayList<String> listeLigne) {
        char[][] cartes = new char[listeLigne.size()][];
        for (int i = 0; i < listeLigne.size(); i++) {
            cartes[i] = listeLigne.get(i).toCharArray();
        }
        listeCartes.add(cartes);
}



private static FileInputStream ouvrirFichierLecture(String nomFichier) {
    FileInputStream fichier = null;
    try {
        fichier = new FileInputStream(nomFichier);
    } catch (FileNotFoundException ex) {
        System.out.println("Erreur d’ouverture de fichier");
    }
    return fichier;
}

private static void fermerFichier(Closeable fichier) {
    try {
        fichier.close();
    } catch (IOException ex) {
        System.out.println("Erreur de fermeture de fichier");
    }
}
}


