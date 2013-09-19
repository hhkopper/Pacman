package pacman.peli;

public class Pistelaskuri {

    private int pisteet;

    public Pistelaskuri() {
        pisteet = 0;
    }

    public int getPisteet() {
        return this.pisteet;
    }

    public void kasvata(int arvo) {
        pisteet = pisteet + arvo;
    }    
}
