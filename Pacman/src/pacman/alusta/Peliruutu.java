
package pacman.alusta;

public class Peliruutu {
    private int x;
    private int y;
    private int ruudunTyyppi;
    
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
    
    
   //jos ruutu on polku se on true, jos seinä on false 
    public int getRuudunTyyppi() {
        return this.ruudunTyyppi;
    }
    
    public void setRuudunTyyppi(int uusiTyyppi) {
        this.ruudunTyyppi = uusiTyyppi;
    }
    
    @Override
    public String toString() {
        return "(" + this.x + "," + this.y + ")";
    }
    
}
