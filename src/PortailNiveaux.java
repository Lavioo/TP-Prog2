import java.util.Random;

public class PortailNiveaux extends Portail{

    private final float[] HUE = new float[3];
    private final boolean[] DIMINUER_HUE = {true, true, true};
    private final Random rand = new Random();
    private final float vitesseHue =  10;

    protected PortailNiveaux(String nom, int x, int y) {
        super(nom, x, y);
        for(float i : HUE){
            i = rand.nextInt(255);
        }
    }

    @Override
    protected void mettreAJour() {
        for(int i = 0; i < HUE.length; i++){
            if(DIMINUER_HUE[i]){
                HUE[i] -= vitesseHue * (Temps.deltaTemps/1_000_000_000f);
            }
        }
    }

    @Override
    protected void dessiner() {

    }
}
