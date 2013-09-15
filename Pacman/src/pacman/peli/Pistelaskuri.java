package pacman.peli;

public class Pistelaskuri {

    private int pisteet;

    Pistelaskuri() {
    }

    public int getPisteet() {
        return this.pisteet;
    }

    public void kasvata(int arvo) {
        pisteet = pisteet + arvo;
    }
}
