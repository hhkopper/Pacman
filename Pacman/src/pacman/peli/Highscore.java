package pacman.peli;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import pacman.gui.Kayttoliittyma;

/**
 * Highscore luokka käsittelee pelin piste-ennätykseen liittyvät toiminnot.
 *
 * @author Hanna
 */
public class Highscore {

    /**
     * Tiedosto, joka sisältää parhaimman pistemäärän.
     */
    private File ennatyslista;
    /**
     * FileWriter, joka kirjaa uuden ennätyksen tiedostoon.
     */
    private FileWriter kirjuri;
    /**
     * Scanner, joka lukee parhaimman pistemäärän tiedostosta.
     */
    private Scanner lukija;
    /**
     * Kayttoliittyman kautta päästään käsiksi tarvittavaan virheilmoitukseen.
     */
    private Kayttoliittyma kayttis;
    /**
     * Kertoo parhaimman pistemäärän
     */
    private int paras;

    /**
     * Konstruktorissa luodaan ennätystiedosto ja annetaan muuttujille
     * tarvittavat arvot.
     *
     * @param kayttis kayttoliittyma, jonka kautta päästään käsiksi virheilmoitukseen.
     */
    public Highscore(Kayttoliittyma kayttis) {
        this.ennatyslista = new File("ennatykset");
        this.kayttis = kayttis;
        this.paras = 0;

    }

    /**
     * Tarkistetaan onko parametrina annetut pisteet uusi ennätys.
     * Jos tiedostossa ei ole vielä mitään palautetaan true, jolloin uusi pistemäärä on uusi ennätys.
     * Jos taas aiempi paras pistemäärä on pienempä kuin uusi pistemäärä on tehty ennätys.
     * Muulloin palautetaan false.
     * 
     * @param pisteet
     * @return
     */
    public boolean tarkistaOnkoEnnatys(int pisteet) {
        try {
            this.lukija = new Scanner(ennatyslista);
        } catch (FileNotFoundException ex) {
            kayttis.virheilmoitus("Scannerin luonnissa tapahtui virhe.");
        }
        if (!lukija.hasNextInt()) {
            return true;
        } else if (tamanHetkinenEnnatys() < pisteet) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Tulostetaan tämän hetkinen paras pistemäärä.
     * Jos tiedostossa ei ole mitään palautetaan nolla, muulloin lukija hakee tiedostosta seuraavan int arvon
     * ja asettaa tämän parhaan arvoksi ja tulostaa haetun arvon.
     * 
     * @return
     */
    public int tamanHetkinenEnnatys() {
        if (!lukija.hasNextInt()) {
            return 0;
        } else {
            int luku = lukija.nextInt();
            paras = luku;
            return luku;
        }
    }

    /**
     * FileWriter kirjoittaa uudet pisteet ennätystiedostoon.
     * @param pisteet pelaajan pistemäärä, joka on todettu uudeksi ennätykseksi.
     */
    public void kirjaaEnnatys(int pisteet) {
        try {
            this.kirjuri = new FileWriter(ennatyslista);
            kirjuri.write(Integer.toString(pisteet));
            kirjuri.close();
        } catch (IOException ex) {
            kayttis.virheilmoitus("Ennätyksen kirjauksessa tapahtui virhe.");
        }
    }

    public int getParas() {
        return this.paras;
    }
}
