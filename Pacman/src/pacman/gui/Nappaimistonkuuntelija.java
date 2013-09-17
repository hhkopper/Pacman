package pacman.gui;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import pacman.hahmot.Man;
import pacman.hahmot.Suunta;
import pacman.peli.Pacman;

public class Nappaimistonkuuntelija implements KeyListener {

    private Man pacman;
    private Pacman peli;

    public Nappaimistonkuuntelija(Man pacman, Pacman peli) {
        this.pacman = pacman;
        this.peli = peli;
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        Suunta vanhaSuunta = pacman.getSuunta();
        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            this.pacman.setSuunta(Suunta.VASEN);
            tarkistaOnkoSuunnassaSeina(vanhaSuunta);
        } else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            this.pacman.setSuunta(Suunta.OIKEA);
            tarkistaOnkoSuunnassaSeina(vanhaSuunta);
        } else if (e.getKeyCode() == KeyEvent.VK_UP) {
            this.pacman.setSuunta(Suunta.YLOS);
            tarkistaOnkoSuunnassaSeina(vanhaSuunta);
        } else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            this.pacman.setSuunta(Suunta.ALAS);
            tarkistaOnkoSuunnassaSeina(vanhaSuunta);
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }

    public void tarkistaOnkoSuunnassaSeina(Suunta suunta) {
        if (onkoSuunnassaSeina()) {
                this.pacman.setSuunta(suunta);
            }
    }
    public boolean onkoSuunnassaSeina() {
        Suunta suunta = pacman.getSuunta();
        int x = pacman.getX();
        int y = pacman.getY();

        if (peli.getAlusta().getPeliruutu(x + suunta.getX(), y + suunta.getY()).getRuudunTyyppi() == 0) {
            return true;
        } else {
            return false;
        }
    }
    
    
}
