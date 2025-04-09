import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class LireMap {

    private static ArrayList<char[]> listeCartes = new ArrayList();



    public static void OuvrirMap() {
    String [] cheminFichiersMaps;

    File f = new File ("CartesDeJeu");

    cheminFichiersMaps = f.list();

    for (String chemin : cheminFichiersMaps) {
        FileInputStream fichier = ouvrirFichierLecture(chemin);
        Scanner lecteurFichier = new Scanner(fichier);
        convertirEnString(lecteurFichier);
        fermerFichier(fichier);


    }









}


private static ArrayList convertirEnString (Scanner lecteurFichier){
        String ligne;
        ArrayList<String> listeLigne = new ArrayList<>();


        while (lecteurFichier.hasNext()) {
           ligne = lecteurFichier.nextLine();
           listeLigne.add(ligne);

    }
return listeLigne;

}


private static void convertirEnTabChar (ArrayList<String> listeLigne) {

        for (int i = 0; i < listeLigne.size(); i++) {
            listeCartes.add((listeLigne.get(i).toCharArray()));
        }

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


