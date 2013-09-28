package pacman.peli;

import java.util.ArrayList;

public class Highscore {

    private ArrayList<Ennatys> highscore;

    public Highscore() {
        this.highscore = new ArrayList<Ennatys>();
        this.highscore.add(new Ennatys("XXX ", 000));
    }

    public boolean tarkistaOnkoEnnatys(int pisteet) {
        if(this.highscore.size() < 1) {
            return true;
        } else if (this.highscore.get(0).getPisteet() < pisteet) {
            return true;
        } else {
            return false;
        }
    }

    public Ennatys tulostaEnnatys(String nimi, int pisteet) {
        Ennatys ennatys = new Ennatys(nimi, pisteet);
        this.highscore.add(0, ennatys);
        return this.highscore.get(0);
    }
}
