package pacman.hahmot;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Random;
import pacman.alusta.Pelialusta;

public class Haamu {

    private int y;
    private int x;
    private Suunta suunta;
    private String tyyppi;
    private String nimi;
    private Pelialusta alusta;
    private ArrayList<Suunta> mahdollisetSuunnat = new ArrayList<Suunta>();

    public Haamu(int x, int y, Suunta suunta, String nimi, Pelialusta alusta) {
        this.y = y;
        this.x = x;
        this.suunta = suunta;
        this.tyyppi = "vahva";
        this.nimi = nimi;
        this.alusta = alusta;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getY() {
        return this.y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getX() {
        return this.x;
    }

    public String getNimi() {
        return this.nimi;
    }
    

    public void setSuunta(Suunta uusiSuunta) {
        this.suunta = uusiSuunta;
    }

    public Suunta getSuunta() {
        return this.suunta;
    }
    
    public ArrayList<Suunta> getSuuntaLista() {
        return this.mahdollisetSuunnat;
    }

    public void setTyyppi(String tyyppi) {
        this.tyyppi = tyyppi;
    }

    public String getTyyppi() {
        return this.tyyppi;
    }

    public void luoHaamuAlustalle() {
        alusta.getPeliruutu(x, y).setOnkoHaamu(true);
    }

    /**
     * Liiku metodi katsoo ensin, mikä on haamun suunta. Seuraavaksi metodi
     * tarkistaa onko seuraava ruutu johon ollaan liikkumassa seinä. Jos ei ole,
     * kutsutaan metodia joka varsinaisesti liikuttaa haamua eteenpäin. Jos
     * seuraava ruutu olisi seinä, kutsutaan metodia, joka arpoo uuden suunnan
     * ja tämän jälkeen kutsuu uudestaan liiku metodia, että päästään
     * liikkumaan.
     */
    public void liiku() {
        if (alusta.getPeliruutu(x + this.suunta.getX(), y + this.suunta.getY()).getRuudunTyyppi() == 0) {
            arvoUusiSuunta();
            liikuSuunta();
        } else if (katsoVoikoLiikkuaSivuille()) {
            arvoUusiSuunta();
            liikuSuunta();
        } else {
            liikuSuunta();
        }
    }

    public void liikuSuunta() {

        this.y = this.y + suunta.getY();
        this.x = this.x + suunta.getX();
        alusta.getPeliruutu(x, y).setOnkoHaamu(true);
        alusta.getPeliruutu(x - suunta.getX(), y - suunta.getY()).setOnkoHaamu(false);
    }

    public void arvoUusiSuunta() {

        mahdollisetSuunnat = new ArrayList<Suunta>();

        for (Suunta s : Suunta.values()) {
            if (alusta.getPeliruutu(x + s.getX(), y + s.getY()).getRuudunTyyppi() == 1) {
                mahdollisetSuunnat.add(s);
            }
        }

        Random arpoja = new Random();
        int arpaluku = arpoja.nextInt(mahdollisetSuunnat.size());
        this.suunta = mahdollisetSuunnat.get(arpaluku);
    }

    public void palaaAlkuun() {
        alusta.getPeliruutu(x, y).setOnkoHaamu(false);
        this.y = 9;
        this.x = 9;
        alusta.getPeliruutu(x, y).setOnkoHaamu(true);
    }

    public String toString() {
        return "(" + this.x + "," + this.y + ") Nimi: " + this.nimi + ", " + this.suunta;
    }

    public boolean katsoVoikoLiikkuaSivuille() {
        if (suunta == Suunta.VASEN || suunta == Suunta.OIKEA) {
            if (alusta.getPeliruutu(x, y - 1).getRuudunTyyppi() == 1 || alusta.getPeliruutu(x, y + 1).getRuudunTyyppi() == 1) {
                return true;
            }
        } else if (suunta == Suunta.ALAS || suunta == Suunta.YLOS) {
            if (alusta.getPeliruutu(x - 1, y).getRuudunTyyppi() == 1 || alusta.getPeliruutu(x + 1, y).getRuudunTyyppi() == 1) {
                return true;
            }
        }

        return false;



    }
}
