
import eko.EKOTouche;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Map extends Ecran{

    private int index;
    private final int POSITION_UI_Y = 0;

    private boolean echapAppuye;

    protected Map(int index){
        this.index = index;
        echapAppuye = true;
        chargerObjets();
    }

    @Override
    protected void chargerObjets() {
        listeObjetEcran.add(new Vie("vie",1, POSITION_UI_Y));
        listeObjetEcran.add(new SalleNum(POSITION_UI_Y, this.index));

        Path p = Paths.get("Maps\\" + ChargerCheminsMaps.getMap(this.index));

        try {
              creerObjets(Files.readString(p).toLowerCase());
        }catch (IOException e){
            this.effacerEcran();
            Ecran.setEcranCourant(new EcranVictoire());
        }
    }

    @Override
    protected void mettreAJour(long deltaTemps) {
        if (echapAppuye){
            if(!EKOTouche.ECHAPPEMENT.estEnfoncee())
                echapAppuye = false;
        }

        if (!echapAppuye)
            entreeUtilisateur();
    }

    private void entreeUtilisateur(){
        if (EKOTouche.ECHAPPEMENT.estEnfoncee() && !echapAppuye) {
            effacerEcran();
            setNouvelEcran();
        }
    }

    @Override
    protected void setNouvelEcran() {
        Ecran.setEcranCourant(new Niveaux());
    }

    private void creerObjets(String maps){
        int y = POSITION_UI_Y + 1;
        int x = 0;

        for (char c : maps.toCharArray()) {
            switch (c) {
                case '#' -> listeObjetEcran.add(new Mur("Mur", x, y));
                case '\n' -> {
                    y++;
                    x = -1;
                }
                case 'j' -> listeObjetEcran.add(new Joueur("joueur", x, y));
                case 'v' -> listeObjetEcran.add(new PotionVie("potionV", x, y));
                case '+' -> listeObjetEcran.add(new PorteCondamne("porteC", x, y));
                case '-' -> listeObjetEcran.add(new PorteVerouille("porteV", x, y));
                case 'c' -> listeObjetEcran.add(new Cle("cle", x, y));
                case 'f' -> listeObjetEcran.add(new Feu("feu", x, y));
                case '@' -> listeObjetEcran.add(new Fantome("boo", x, y));
                case '&' -> listeObjetEcran.add(new Squelette("sql", x, y));
                case 'g' -> listeObjetEcran.add(new Grenouille("gre", x, y));
                case 'i' -> listeObjetEcran.add(new Insecte("ins", x, y));
            }
            x++;
        }
    }

    @Override
    protected void effacerEcran(){
        for(ObjetJeu o : listeObjetEcran){
            o.detruire();
        }
        Mur.viderListeMur();
    }

    public int getIndex() {
        return this.index;
    }

    public void cleRamasser(){
        Position posPorte = null;
        for(ObjetJeu o : listeObjetEcran){
            if (o instanceof PorteVerouille){
                posPorte = o.position;
                o.detruire();
                break;
            }
        }

        listeObjetEcran.add(new PortailPorteVerouille("portailV", posPorte.x, posPorte.y));
    }
}
