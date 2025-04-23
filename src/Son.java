import eko.EKOAudio;
import eko.EKOSon;

import java.io.File;
import java.util.ArrayList;

public class Son {

    private static ArrayList<EKOSon> sons;
    private static String[] chemins;

    public static void chargerSons(){
        sons = new ArrayList<>();

        File f = new File("Audio");

        try {
            chemins = f.list();

            assert chemins != null;
            for (String str : chemins){
                sons.add(EKOAudio.charger("Audio\\" + str));
            }

        }catch (NullPointerException e){
            System.out.println("Le son n'a pas pu etre charge");
        }
    }

    public static void jouerSon(SonNom nom){
        EKOAudio.jouer(sons.get(nom.getIndex()));
    }

    public static void jouerSon(SonNom nom, boolean boucle){
        EKOAudio.jouer(sons.get(nom.getIndex()), boucle);
    }

    public static int getIndexChemins(String nom){
        for (int i = 0; i < chemins.length; i++){
            String str = chemins[i];
            if(str.equals(nom))
                return i;
        }

        return 0;
    }
}
