package pacman.hahmot;

import java.util.Random;
import pacman.Suunta;
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
            if (alusta.getPeliruutu(this.x - 1, this.y).getRuudunTyyppi() == 0) {
                arvoUusiSuunta();
            }
        }

    }

    public void arvoUusiSuunta() {
        Random arpoja = new Random();

        int arpaluku = arpoja.nextInt(3);

        if (arpaluku == 0) {
            this.alkuSuunta = Suunta.ALAS;
        } else if (arpaluku == 1) {
            this.alkuSuunta = Suunta.YLOS;            
        } else if (arpaluku == 2) {
            this.alkuSuunta = Suunta.OIKEA;            
        } else if (arpaluku == 3) {
            this.alkuSuunta = Suunta.VASEN;
        }
    }

    public String toString() {
        return "(" + this.x + "," + this.y + ") Nimi: " + this.nimi + ", " + this.alkuSuunta;
    }
}
