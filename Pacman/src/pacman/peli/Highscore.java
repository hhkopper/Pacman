package pacman.peli;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class Highscore {

    private ArrayList<Ennatys> highscore;
    private File ennatyslista;

    public Highscore() {
        this.highscore = new ArrayList<Ennatys>();
        this.highscore.add(new Ennatys("XXX ", 000));
        this.ennatyslista = new File("ennatykset");
    }

    public boolean tarkistaOnkoEnnatys(int pisteet) {
        if (this.highscore.size() < 1) {
            return true;
        } else if (this.highscore.get(0).getPisteet() < pisteet) {
            return true;
        } else {
            return false;
        }
    }

    public void lisaaEnnatys(String nimi, int pisteet) {
        Ennatys ennatys = new Ennatys(nimi, pisteet);
        this.highscore.add(0, ennatys);
    }

    public String tulostaParas() {
        return this.highscore.get(0).toString();
    }

    public void kirjaaEnnatys() {
//        Scanner lukija = new Scanner(new File());
//        lukija.
    
    }
}
