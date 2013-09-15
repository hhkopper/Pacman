package pacman.hahmot;

import java.util.ArrayList;
import java.util.Random;
import pacman.alusta.Pelialusta;

public class Haamu {

    private int x;
    private int y;
    private Suunta suunta;
    private String nimi;
    private String tyyppi;
    private Pelialusta alusta;

    public Haamu(int x, int y, Suunta suunta, String nimi, Pelialusta alusta) {
        this.x = x;
        this.y = y;
        this.suunta = suunta;
        this.nimi = nimi;
        this.tyyppi = "vahva";
        this.alusta = alusta;
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
        this.suunta = uusiSuunta;
    }

    public Suunta getSuunta() {
        return this.suunta;
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
     * Liiku metodi katsoo ensin, mikä on haamun suunta. 
     * Seuraavaksi metodi tarkistaa onko seuraava ruutu johon ollaan liikkumassa seinä. 
     * Jos ei ole, kutsutaan metodia joka varsinaisesti liikuttaa haamua eteenpäin. 
     * Jos seuraava ruutu olisi seinä, kutsutaan metodia, joka arpoo uuden suunnan
     * ja tämän jälkeen kutsuu uudestaan liiku metodia, että päästään
     * liikkumaan.
     */
    public void liiku() {

        if (this.suunta == Suunta.ALAS) {
            if (alusta.getPeliruutu(this.x + 1, this.y).getRuudunTyyppi() == 0) {
                arvoUusiSuunta();
                liiku();
            } else {
                liikuAlas();
            }
            
        } else if (this.suunta == Suunta.YLOS) {
            if (alusta.getPeliruutu(x - 1, y).getRuudunTyyppi() == 0) {
                arvoUusiSuunta();
                liiku();
            } else {
                liikuYlos();
            }
            
        } else if (this.suunta == Suunta.OIKEA) {
            if (alusta.getPeliruutu(x, y + 1).getRuudunTyyppi() == 0) {
                arvoUusiSuunta();
                liiku();
            } else {
                liikuOikea();
            }
            
        } else if (this.suunta == Suunta.VASEN) {
            if (alusta.getPeliruutu(x, y - 1).getRuudunTyyppi() == 0) {
                arvoUusiSuunta();
                liiku();
            } else {
                liikuVasen();
            }
            
        }
    }

    /**
     * Haamun koordinaatit muuttuu, kun haamu liikkuu. Pelialusta tietää mihin
     * ruutuun haamu liikkuu.
     *
     * @param alusta
     */
    public void liikuAlas() {
        this.x = this.x + 1;
        alusta.getPeliruutu(x, y).setOnkoHaamu(true);
        alusta.getPeliruutu(x - 1, y).setOnkoHaamu(false);
    }

    public void liikuYlos() {
        this.x = this.x - 1;
        alusta.getPeliruutu(x, y).setOnkoHaamu(true);
        alusta.getPeliruutu(x + 1, y).setOnkoHaamu(false);
    }

    public void liikuVasen() {
        this.y = this.y - 1;
        alusta.getPeliruutu(x, y).setOnkoHaamu(true);
        alusta.getPeliruutu(x, y + 1).setOnkoHaamu(false);
    }

    public void liikuOikea() {
        this.y = this.y + 1;
        alusta.getPeliruutu(x, y).setOnkoHaamu(true);
        alusta.getPeliruutu(x, y - 1).setOnkoHaamu(false);
    }

    public void arvoUusiSuunta() {

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
        this.suunta = mahdollisetSuunnat.get(arpaluku);        
    }
    
    public void palaaAlkuun() {
        alusta.getPeliruutu(x, y).setOnkoHaamu(false);
        this.x = 9;
        this.y = 9;
        alusta.getPeliruutu(x, y).setOnkoHaamu(true);
    }

    public String toString() {
        return "(" + this.x + "," + this.y + ") Nimi: " + this.nimi + ", " + this.suunta;
    }
}
