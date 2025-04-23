public enum SonNom {
    POTION_VIE("41529__jamius__potiondrinklong.wav"),
    VICTOIRE("404358__kagateni__success_cut.wav"),
    CLE("CollectKey.wav"),
    IMPACT("553518__newlocknew__pop-down-impact_49lrsmltprcssng_cut.wav"),
    CONTACT_ENNEMI("651625__martcraft__fail_cut.wav"),
    MUSIQUE_BOUCLE("685349__zhr__exploration-music-loop_low.wav"),
    CHANGE_SELECTION("ChangeSelection.wav"),
    SELECT("Select.wav"),
    CONTACT_FEU("ContactFeu.wav");

    private final int index;

    private SonNom(String path){
        this.index = Son.getIndexChemins(path);
    }
    public int getIndex(){return index;}
}
