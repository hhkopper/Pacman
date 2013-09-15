package pacman.hahmot;

import java.util.ArrayList;
import java.util.Random;
import pacman.alusta.Pelialusta;

public class Haamu {

    private int x;
    private int y;
    private Suunta alkuSuunta;
    private String nimi;
    String tyyppi;

    public Haamu(int x, int y, Suunta suunta, String nimi) {
        this.x = x;
        this.y = y;
        this.alkuSuunta = suunta;
        this.nimi = nimi;
        this.tyyppi = "vahva";
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getX() {
        return this.x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getY() {
        return this.y;
    }

    public String getNimi() {
        return this.nimi;
    }

    public void setAlkuSuunta(Suunta uusiSuunta) {
        this.alkuSuunta = uusiSuunta;
    }

    public Suunta getSuunta() {
        return this.alkuSuunta;
    }

    public void luoHaamuAlustalle(Pelialusta alusta) {
        alusta.getPeliruutu(x, y).setOnkoHaamu(true);
    }

    /**
     * Liiku metodi katsoo ensin, mikä on haamun suunta. 
     * Seuraavaksi metodi tarkistaa onko seuraava ruutu johon ollaan liikkumassa seinä. 
     * Jos ei ole, kutsutaan metodia joka varsinaisesti liikuttaa haamua eteenpäin. 
     * Jos seuraava ruutu olisi seinä, kutsutaan metodia, joka arpoo uuden suunnan
     * ja tämän jälkeen kutsuu uudestaan liiku metodia, että päästään
     * liikkumaan.
     */
    public void liiku(Pelialusta alusta) {

        if (this.alkuSuunta == Suunta.ALAS) {
            if (alusta.getPeliruutu(this.x + 1, this.y).getRuudunTyyppi() == 0) {
                arvoUusiSuunta(alusta);
                liiku(alusta);
            }
            liikuAlas(alusta);
        } else if (this.alkuSuunta == Suunta.YLOS) {
            if (alusta.getPeliruutu(x - 1, y).getRuudunTyyppi() == 0) {
                arvoUusiSuunta(alusta);
                liiku(alusta);
            }
            liikuYlos(alusta);
        } else if (this.alkuSuunta == Suunta.OIKEA) {
            if (alusta.getPeliruutu(x, y + 1).getRuudunTyyppi() == 0) {
                arvoUusiSuunta(alusta);
                liiku(alusta);
            }
            liikuOikea(alusta);
        } else if (this.alkuSuunta == Suunta.VASEN) {
            if (alusta.getPeliruutu(x, y - 1).getRuudunTyyppi() == 0) {
                arvoUusiSuunta(alusta);
                liiku(alusta);
            }
            liikuVasen(alusta);
        }
    }

    /**
     * Haamun koordinaatit muuttuu, kun haamu liikkuu. Pelialusta tietää mihin
     * ruutuun haamu liikkuu.
     *
     * @param alusta
     */
    public void liikuAlas(Pelialusta alusta) {
        this.x = this.x + 1;
        alusta.getPeliruutu(x, y).setOnkoHaamu(true);
        alusta.getPeliruutu(x - 1, y).setOnkoHaamu(false);
    }

    public void liikuYlos(Pelialusta alusta) {
        this.x = this.x - 1;
        alusta.getPeliruutu(x, y).setOnkoHaamu(true);
        alusta.getPeliruutu(x + 1, y).setOnkoHaamu(false);
    }

    public void liikuVasen(Pelialusta alusta) {
        this.y = this.y - 1;
        alusta.getPeliruutu(x, y).setOnkoHaamu(true);
        alusta.getPeliruutu(x, y + 1).setOnkoHaamu(false);
    }

    public void liikuOikea(Pelialusta alusta) {
        this.y = this.y + 1;
        alusta.getPeliruutu(x, y).setOnkoHaamu(true);
        alusta.getPeliruutu(x, y - 1).setOnkoHaamu(false);
    }

    public void arvoUusiSuunta(Pelialusta alusta) {

        ArrayList<Suunta> mahdollisetSuunnat = new ArrayList<Suunta>();

        if (alusta.getPeliruutu(x, y + 1).getRuudunTyyppi() == 1) {
            mahdollisetSuunnat.add(Suunta.OIKEA);
        }
        if (alusta.getPeliruutu(x + 1, y).getRuudunTyyppi() == 1) {
            mahdollisetSuunnat.add(Suunta.ALAS);
        }
        if (alusta.getPeliruutu(x, y - 1).getRuudunTyyppi() == 1) {
            mahdollisetSuunnat.add(Suunta.VASEN);
        }
        if (alusta.getPeliruutu(x - 1, y).getRuudunTyyppi() == 1) {
            mahdollisetSuunnat.add(Suunta.YLOS);
        }

        Random arpoja = new Random();

        int arpaluku = arpoja.nextInt(mahdollisetSuunnat.size() - 1);

        this.alkuSuunta = mahdollisetSuunnat.get(arpaluku);
    }

    public String toString() {
        return "(" + this.x + "," + this.y + ") Nimi: " + this.nimi + ", " + this.alkuSuunta;
    }
}
