package pacman.peli;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.Timer;
import pacman.alusta.Pelialusta;
import pacman.alusta.Peliruutu;
import pacman.gui.Paivitettava;
import pacman.hahmot.Haamu;
import pacman.hahmot.Man;
import pacman.hahmot.Suunta;

/**
 *
 * Pacman luokan avulla säädellään pelin kulkua ja luokka sisältää pelin
 * kannalta olennaiset toiminnot.
 *
 * @author Hanna
 */
public class Pacman extends Timer implements ActionListener {

    private Man man;
    private Pelialusta alusta;
    /**
     * ArrayList, joka sisältää kaikki kentällä olevat haamut.
     */
    private ArrayList<Haamu> haamut;
    private Pistelaskuri laskuri;
    /**
     * Arpojaa käytetään arpomaan uusi hedelmänpaikka
     */
    private Random arpoja = new Random();
    /**
     * Kaikki mahdolliset peliruudut johon voi asettaa hedelman.
     */
    private ArrayList<Peliruutu> hedelmanPaikat;
    private Paivitettava paivitettava;
    /**
     * Kertoo missä ruudussa hedelma sijaitsee
     */
    private Peliruutu hedelmanPaikka;
    /**
     * Boolean arvo kertoo pelin tilan, että jatkuuko se (true) vai ei (false) jos man voittaa tai kuolee.
     */
    private boolean jatkuu;
    /**
     * Boolean arvo kertoo onko peli voitettu (true) vai hävitty (false).
     */
    private boolean tilanne;
    private Highscore highscore;

    /**
     * Konstruktorissa luodaan pelialusta ja kaikki komponentit sille, luodaan myös pistelaskuri ja highscore
     */
    public Pacman() {
        super(1000, null);
        alusta = new Pelialusta(19, 21);
        alusta.luoPelialusta();
        man = new Man(9, 11, Suunta.OIKEA, alusta);
        man.luoManAlustalle();
        haamut = new ArrayList<Haamu>();
        this.luoHaamut();
        laskuri = new Pistelaskuri();
        this.hedelmanPaikat = new ArrayList<Peliruutu>();
        this.jatkuu = true;
        this.tilanne = false;
        this.highscore = new Highscore();

        addActionListener(this);
        setInitialDelay(2000);
    }

    public Man getMan() {
        return this.man;
    }

    public Pelialusta getAlusta() {
        return this.alusta;
    }

    public Pistelaskuri getLaskuri() {
        return this.laskuri;
    }

    public ArrayList<Haamu> getHaamuLista() {
        return this.haamut;
    }

    public int getPisteet() {
        return laskuri.getPisteet();
    }

    public boolean getTilanne() {
        return this.tilanne;
    }

    public boolean getJatkuu() {
        return this.jatkuu;
    }

    public Highscore getHighscore() {
        return this.highscore;
    }

    public Peliruutu getHedelmanPaikka() {
        return this.hedelmanPaikka;
    }

    public ArrayList<Peliruutu> getHedelmanPaikat() {
        return this.hedelmanPaikat;
    }    
    
    /**
     * Luodaan haamut pelialustalle omaan karsinaan.
     */
    public void luoHaamut() {
        Haamu red = new Haamu(8, 9, Suunta.YLOS, "red", alusta);
        Haamu green = new Haamu(9, 9, Suunta.YLOS, "green", alusta);
        Haamu cyan = new Haamu(10, 9, Suunta.YLOS, "cyan", alusta);
        Haamu magenta = new Haamu(9, 8, Suunta.YLOS, "magenta", alusta);

        haamut.add(red);
        haamut.add(green);
        haamut.add(cyan);
        haamut.add(magenta);
    }

    /**
     * Asetetaan haamujen tyypiksi heikko, jolloin man pystyy syömään haamuja.
     */
    public void heikennaHaamut() {
        for (Haamu haamu : haamut) {
            haamu.setTyyppi("heikko");
            haamu.setHeikkous(30);
        }
    }

    private void haamuHeikostaVahvaksi(Haamu haamu) {
        if (haamu.getTyyppi().equals("heikko")) {
            if (haamu.getHeikkous() == 0) {
                haamu.setTyyppi("vahva");
            } else {
                haamu.vahennaHeikkous();
            }
        }
    }
    
    /**
     * Man syö pistepallon kentältä ja kasvatetaan pistemäärää.
     */
    public void manSyoPistepallo() {
        if (alusta.getPeliruutu(man.getX(), man.getY()).getOnkoPallo()) {
            alusta.getPeliruutu(man.getX(), man.getY()).setOnkoPallo(false);
            laskuri.kasvata(20);
        } else if (alusta.getPeliruutu(man.getX(), man.getY()).getOnkoExtraPallo()) {
            alusta.getPeliruutu(man.getX(), man.getY()).setOnkoExtraPallo(false);
            laskuri.kasvata(50);
            heikennaHaamut();
        }
    }

    /**
     * Katsotaan kuoleeko haamu tai man, kun ne osuvat samaan ruutuun.
     */
    public void kuoleekoHaamuTaiMan() {
        for (Haamu haamu : haamut) {
            if (alusta.getPeliruutu(haamu.getX(), haamu.getY()).getOnkoMan()) {
                if (haamu.getTyyppi().equals("heikko")) {
                    haamu.palaaAlkuun();
                    haamu.setTyyppi("vahva");
                    laskuri.kasvata(80);
                } else {
                    man.palaaAlkuun();
                    man.vahennaElama();
                }
            }
        }
    }

    /**
     * Kun kaikki haamut ovat poistuneet karsinastaan asetetaan karsinan
     * suuaukolle seinä, etteivät haamut mene sinne takaisin. Seinä kuitenkin
     * lähtee pois, kun haamu palaa lähtöpaikkaan etteivät haamut jää jumiin.
     * Tarkistetaan myös, että man ei ole karsinassa.
     */
    public void asetaSeina() {
        for (int y = 8; y < 11; y++) {
            for (int x = 8; x < 11; x++) {
                if (alusta.getPeliruutu(x, y).getOnkoHaamu() || alusta.getPeliruutu(x, y).getOnkoMan()) {
                    alusta.getPeliruutu(9, 8).setRuudunTyyppi(3);
                    return;
                }
            }
        }
        alusta.getPeliruutu(9, 8).setRuudunTyyppi(0);
    }

    /**
     * Etsitään sopivata paikat hedelmälle, minkä jälkeen arvotaan hedelmälle uudet koordinaatit.
     */
    public void arvoHedelma() {
        etsiHedelmanPaikat();
        int luku = arpoja.nextInt(this.hedelmanPaikat.size());
        this.hedelmanPaikka = this.hedelmanPaikat.get(luku);
    }

    /**
     * Käydään pelikenttä läpi ja katsotaan kaikki mahdolliset paikat mihin
     * hedelmän voisi asettaa. Paikaksi käy sellainen, jossa ei ole enää
     * pistepalloa.
     */
    public void etsiHedelmanPaikat() {
        for (int y = 0; y < alusta.getKorkeus(); y++) {
            for (int x = 0; x < alusta.getLeveys(); x++) {
                if (onkoHedelmanPaikka(x, y)) {
                    Peliruutu ruutu = new Peliruutu(x, y);
                    this.hedelmanPaikat.add(ruutu);
                }
            }
        }
    }

    private boolean onkoHedelmanPaikka(int x, int y) {
        return alusta.getPeliruutu(x, y).getRuudunTyyppi() == 1 && !alusta.getPeliruutu(x, y).getOnkoPallo() && !alusta.getPeliruutu(x, y).getOnkoExtraPallo();
    }

    /**
     * Katsotaan ovatko hedelmä ja man samassa ruudussa.
     *
     * @return palauttaa boolean arvon
     */
    public boolean manOsuuHedelmaan() {
        if (man.getX() == this.hedelmanPaikka.getX() && man.getY() == this.hedelmanPaikka.getY()) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Katsotaan onko hedelmä jo kentällä.
     *
     * @return palauttaa boolean arvon
     */
    public boolean onkoHedelmaAlustalla() {
        if (this.hedelmanPaikka != null) {
            return true;
        } else {
            return false;
        }
    }

    /*
     * Kun pisteet ylittävät 400 ja kentällä ei vielä ole hedelmää arvotaan ensimmainen hedelmä.
     * Jatkossa, kun kentällä on hedelmä, arvotaan uusi vasta, kun man osuu hedelmään ja saa tästä 100 pistettä.
     */
    private void luoHedelma() {
        if (laskuri.getPisteet() > 400) {
            if (onkoHedelmaAlustalla()) {
                if (manOsuuHedelmaan()) {
                    laskuri.kasvata(100);
                    arvoHedelma();
                }
            } else {
                arvoHedelma();
            }
        }
    }

    /**
     * Käydään kenttä läpi ja katsotaan onko jälellä enää pistepalloja. Jos
     * pistepallot on kaikki kerätty, jatkuu arvo asetetaan falseksi ja tilanne
     * asetetaan trueksi, joka tarkoittaa, että peli päättyy ja peli on
     * voitettu.
     */
    public void paattyykoPeli() {
        for (int y = 0; y < alusta.getKorkeus(); y++) {
            for (int x = 0; x < alusta.getLeveys(); x++) {
                if (alusta.getPeliruutu(x, y).getOnkoPallo() || alusta.getPeliruutu(x, y).getOnkoExtraPallo()) {
                    return;
                }
            }
        }
        this.jatkuu = false;
        this.tilanne = true;
    }

    public void setPaivitettava(Paivitettava paivitettava) {
        this.paivitettava = paivitettava;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        for (Haamu haamu : haamut) {
            haamu.liiku();
            haamuHeikostaVahvaksi(haamu);
        }
        kuoleekoHaamuTaiMan();
        this.man.liiku();
        kuoleekoHaamuTaiMan();
        manSyoPistepallo();

        luoHedelma();
        asetaSeina();
        paattyykoPeli();
        if (man.getElamat() == 0) {
            jatkuu = false;
        }

        if (!jatkuu) {
            this.stop();
        }
        this.paivitettava.paivita();
        setDelay(300);
    }
}
