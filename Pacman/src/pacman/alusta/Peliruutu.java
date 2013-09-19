package pacman.alusta;

public class Peliruutu {

    private int x;
    private int y;
    private int ruudunTyyppi;
    private boolean onkoMan;
    private boolean onkoHaamu;
    private boolean onkoPistepallo;
    private boolean onkoHedelma;

    public Peliruutu(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }

    //jos ruutu on polku se on 1, jos seinä on 0 
    public void setRuudunTyyppi(int uusiTyyppi) {
        this.ruudunTyyppi = uusiTyyppi;
    }

    public int getRuudunTyyppi() {
        return this.ruudunTyyppi;
    }

    public void setOnkoMan(boolean arvo) {
        this.onkoMan = arvo;
    }

    public boolean getOnkoMan() {
        return this.onkoMan;
    }

    public void setOnkoHaamu(boolean arvo) {
        this.onkoHaamu = arvo;
    }

    public boolean getOnkoHaamu() {
        return this.onkoHaamu;
    }
    
    public void setOnkoHedelma(boolean arvo) {
        this.onkoHedelma = arvo;
    }
    
    public boolean getOnkoHedelma() {
        return this.onkoHedelma;
    }

    public void setOnkoPistepallo(boolean arvo) {
        this.onkoPistepallo = arvo;
    }
    
    public boolean getOnkoPistepallo() {
        return this.onkoPistepallo;
    }

    @Override
    public String toString() {
        return "(" + this.x + "," + this.y + "), onko man: " + this.onkoMan + ", onko haamu: " + this.onkoHaamu + ", ruuduntyyppi: " + this.ruudunTyyppi;
    }
}
