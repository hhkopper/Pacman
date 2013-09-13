package pacman.hahmot;

import java.util.ArrayList;
import java.util.Random;
import pacman.alusta.Pelialusta;

public class Haamu {

    private int x;
    private int y;
    private Suunta alkuSuunta;
    private String nimi;

    public Haamu(int x, int y, Suunta suunta, String nimi) {
        this.x = x;
        this.y = y;
        this.alkuSuunta = suunta;
        this.nimi = nimi;
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

//    Tarkistetaan suunta, tarkistetaan olisiko seuraava liike seinän päällä, jos on valitaan randomilla uusi suunta
//    ja kutsutaan uudestaan liiku metodia, jos seuraava liike ei ole seinän päällä liikutaan normaalisti.
//    
    public void liiku(Pelialusta alusta) {

        if (this.alkuSuunta == Suunta.ALAS) {
            if (alusta.getPeliruutu(this.x + 1, this.y).getRuudunTyyppi() == 0) {
                arvoUusiSuunta(alusta);
                liiku(alusta);
            }

            this.x = this.x + 1;
            alusta.getPeliruutu(x, y).setOnkoHaamu(true);
            alusta.getPeliruutu(x - 1, y).setOnkoHaamu(false);

        } else if (this.alkuSuunta == Suunta.YLOS) {
            if (alusta.getPeliruutu(x - 1, y).getRuudunTyyppi() == 0) {
                arvoUusiSuunta(alusta);
                liiku(alusta);
            }

            this.x = this.x - 1;
            alusta.getPeliruutu(x, x).setOnkoHaamu(true);
            alusta.getPeliruutu(x + 1, y).setOnkoHaamu(false);

        } else if (this.alkuSuunta == Suunta.OIKEA) {
            if (alusta.getPeliruutu(x, y + 1).getRuudunTyyppi() == 0) {
                arvoUusiSuunta(alusta);
                liiku(alusta);
            }

            this.y = this.y + 1;
            alusta.getPeliruutu(x, y).setOnkoHaamu(true);
            alusta.getPeliruutu(x, y - 1).setOnkoHaamu(false);

        } else if (this.alkuSuunta == Suunta.VASEN) {
            if (alusta.getPeliruutu(x, y - 1).getRuudunTyyppi() == 0) {
                arvoUusiSuunta(alusta);
                liiku(alusta);
            }

            this.y = this.y - 1;
            alusta.getPeliruutu(x, y).setOnkoHaamu(true);
            alusta.getPeliruutu(x, y+1).setOnkoHaamu(false);
        }

        liiku(alusta);

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
