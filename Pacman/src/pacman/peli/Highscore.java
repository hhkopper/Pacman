package pacman.peli;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Highscore {

    private ArrayList<Integer> highscore;
    private File ennatyslista;
    private FileWriter kirjuri;

    public Highscore() throws IOException {
        this.highscore = new ArrayList<Integer>();
        this.highscore.add(0);

        this.ennatyslista = new File("ennatykset");
        this.kirjuri = new FileWriter(this.ennatyslista);
    }

    public boolean tarkistaOnkoEnnatys(int pisteet) {
        if (this.highscore.size() < 1) {
            return true;
        } else if (this.highscore.get(0) < pisteet) {
            return true;
        } else {
            return false;
        }
    }

    public void lisaaEnnatys(int pisteet) {
        if (this.highscore.get(0) < pisteet) {
            kirjaaEnnatys(pisteet);
        }
        poistaYlimaaraiset();
    }

    public String tulostaParas() throws FileNotFoundException {
        Scanner lukija = new Scanner(ennatyslista);
        String rivi = lukija.nextLine();
        return rivi;
    }

    private void kirjaaEnnatys(int pisteet) {
        try {
            kirjuri.write("" + pisteet);
            kirjuri.close();
        } catch (IOException ex) {
            Logger.getLogger(Highscore.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void poistaYlimaaraiset() {
        for (int i = 2; i < this.highscore.size(); i++) {
            this.highscore.remove(i);
        }
    }
}
