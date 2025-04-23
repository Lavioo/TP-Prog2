import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;

public class ChargerCheminsMaps {

    private static final ArrayList<String> cheminsFichiers = new ArrayList<>();

    private static int nbrMaps;

    public static void remplirCheminsMaps(){

        File f = new File("Maps");

        try {
            String[] chemins = f.list();

            if (cheminsFichiers.isEmpty() && chemins != null)
                cheminsFichiers.addAll(Arrays.asList(chemins));
            else {
                for (int i = 0; i < Math.min(chemins.length, cheminsFichiers.size()); i++) {
                    if (!cheminsFichiers.get(i).equals(chemins[i])) {
                        cheminsFichiers.add(i, chemins[i]);
                    }
                }

            }

            while (cheminsFichiers.size() > chemins.length){
                cheminsFichiers.removeLast();
            }

        }catch (NullPointerException e){
            System.out.println("Le fichier 'Maps' n'existe pas.");
            System.exit(0);
        }

        nbrMaps = cheminsFichiers.size();
    }

    public static int getNbrMaps() {
        return nbrMaps;
    }

    public static String getMap(int index){
        try {
            return cheminsFichiers.get(index);
        }catch (IndexOutOfBoundsException e){
            System.out.println("La map demander n'existe pas");
        }

        return null;
    }
}
