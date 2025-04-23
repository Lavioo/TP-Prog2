import eko.EKOConsole;

public class SalleNum extends Texte{

    protected SalleNum(int y, int index) {
        super("Salle ", 0, y);
        this.nom = this.nom + (index + 1);
        this.position.x = EKOConsole.largeur() - this.nom.length();
    }

}
