public enum Directions {
    HAUT,
    BAS,
    DROITE,
    GAUCHE;

    public static Directions tourner90DegGauche(Directions dir){
        switch (dir){
            case DROITE -> {return HAUT;}
            case HAUT -> {return GAUCHE;}
            case GAUCHE -> {return BAS;}
            case BAS -> {return DROITE;}
        }
        return null;
    }
    public static Directions tourner90DegDroite(Directions dir){
        switch (dir){
            case DROITE -> {return BAS;}
            case HAUT -> {return DROITE;}
            case GAUCHE -> {return HAUT;}
            case BAS -> {return GAUCHE;}
        }
        return null;
    }
}
