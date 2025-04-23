public class Temps {
    private static final int TPS = 60;
    private static final long MS_PAR_TRAME = 1000 / TPS;

    private static long dernierTemps = System.nanoTime();

    public static long tempsAttente;
    public static long deltaTemps;

    public static void Chrono(){
        long maintenant = System.nanoTime();
        deltaTemps = maintenant - dernierTemps;
        dernierTemps = maintenant;
    }

    public static long getTempsAttente() {
        tempsAttente = MS_PAR_TRAME - (System.nanoTime() - dernierTemps) / 1_000_000;

        return tempsAttente;
    }

    public static int getTPS() {
        return TPS;
    }
}
