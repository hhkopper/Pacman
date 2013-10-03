package pacman.peli;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import pacman.gui.Kayttoliittyma;

public class Highscore {

    private File ennatyslista;
    private FileWriter kirjuri;
    private Scanner lukija;
    private Kayttoliittyma kayttis;

    public Highscore(Kayttoliittyma kayttis) {
        this.ennatyslista = new File("ennatykset");
        this.kayttis = kayttis;
        try {
            this.kirjuri = new FileWriter(ennatyslista);
            this.lukija = new Scanner(ennatyslista);
        } catch (IOException ex) {
            kayttis.virheilmoitus("Scannerin ja fileWriterin luomisessa tapahtui virhe");
        }
    }

    public boolean tarkistaOnkoEnnatys(int pisteet) {
        if (!lukija.hasNextInt()) {
            return true;
        } else if (tulostaParas() < pisteet) {
            return true;
        } else {
            return false;
        }
    }

    public int tulostaParas() {
        if (!lukija.hasNextInt()) {
            return 0;
        } else {
            int luku = lukija.nextInt();
            return luku;
        }
    }

    public void kirjaaEnnatys(int pisteet) {
        try {
            kirjuri.write(Integer.toString(pisteet));
            kirjuri.close();
        } catch (IOException ex) {
            kayttis.virheilmoitus("Ennatyksen kirjauksessa tapahtui virhe.");
        }
    }
}
